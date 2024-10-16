package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.constants.AppConstants;
import com.foodbookingplatform.models.entities.*;
import com.foodbookingplatform.models.enums.AdsType;
import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.enums.OfferStatus;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.exception.RestaurantBookingException;
import com.foodbookingplatform.models.payload.dto.category.CategoryResponse;
import com.foodbookingplatform.models.payload.dto.location.LocationRequest;
import com.foodbookingplatform.models.payload.dto.location.LocationResponse;
import com.foodbookingplatform.models.payload.dto.location.LocationResponseLazy;
import com.foodbookingplatform.models.payload.dto.tag.TagResponse;
import com.foodbookingplatform.models.payload.dto.workinghour.WorkingHourResponse;
import com.foodbookingplatform.repositories.*;
import com.foodbookingplatform.services.LocationService;
import com.foodbookingplatform.utils.GenericSpecification;
import com.foodbookingplatform.utils.GeoHashGeneration;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final LocationCategoryRepository locationCategoryRepository;
    private final LocationTagRepository locationTagRepository;
    private final WorkingHourRepository workingHourRepository;
    private final AdsRegistrationRepository adsRegistrationRepository;
    private final ModelMapper mapper;

    @Override
    public LocationResponse addLocation(LocationRequest locationRequest) {
        Location savedLocation = validate(locationRequest);
        return mapToResponse(savedLocation);
    }

    @Override
    public LocationResponse getLocation(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
        return mapToResponse(location);
    }

    @Override
    public Page<LocationResponseLazy> getAllLocations(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Location> locationPage = locationRepository.findAll(pageable);
        return locationPage.map(this::mapToResponseLazy);
    }

    @Override
    public Page<LocationResponseLazy> searchAllLocations(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams, double latitude, double longitude, boolean searchNearBy) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Specification<Location> specification = specification(searchParams);


        List<Location> locationList = locationRepository.findAll(specification);
        if(searchNearBy){
            String geoHashCode = GeoHashGeneration.getGeoHashCode(latitude, longitude, 4);
            List<LocationResponseLazy> locationNearSorted = locationList.stream()
                    .filter(location -> location.getGeoHashCode().startsWith(geoHashCode))
                    .sorted((location1, location2) -> {
                        int levelComparison = Integer.compare(location2.getOnSuggest(), location1.getOnSuggest());
                        if (levelComparison != 0) {
                            return levelComparison;
                        }else {
                            double distance1 = calculateDistance(location1.getLatitude(), location1.getLongitude(), latitude, longitude);
                            double distance2 = calculateDistance(location2.getLatitude(), location2.getLongitude(), latitude, longitude);

                            return Double.compare(distance1, distance2);
                        }
                    })
                    .map(location -> {
                        LocationResponseLazy response = mapToResponseLazy(location);
                        double distance = calculateDistance(response.getLatitude(), response.getLongitude(), latitude, longitude);
                        response.setDistance(formatDistance(distance));
                        return response;
                    })
                    .toList();
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), locationNearSorted.size());
            List<LocationResponseLazy> pagedLocationNearSorted = locationNearSorted.subList(start, end);

            return new PageImpl<>(pagedLocationNearSorted, pageable, locationNearSorted.size());
        }
        List<LocationResponseLazy> locationResponseLazyList = locationList.stream().map(this::mapToResponseLazy).toList();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), locationResponseLazyList.size());
        List<LocationResponseLazy> pagedLocationNearSorted = locationResponseLazyList.subList(start, end);

        return new PageImpl<>(pagedLocationNearSorted, pageable, locationResponseLazyList.size());
    }

    @Override
    public LocationResponse updateLocation(LocationRequest locationRequest) {
        Location updatedLocation = validate(locationRequest);
        return mapToResponse(updatedLocation);
    }

    @Override
    public void deleteLocation(long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
        location.setStatus(EntityStatus.DISABLED);
        locationRepository.save(location);
    }

    @Override
    public Page<LocationResponseLazy> getLocationsWithBannerAds(int pageNo, int pageSize, AdsType adsType) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Location> locationList = locationRepository.findAll();
        List<AdsRegistration> adsRegistrationList;

        if(adsType.equals(AdsType.BANNER)){
            adsRegistrationList = adsRegistrationRepository.findByAds_TypeAndStatus(AdsType.BANNER, OfferStatus.ACTIVE);
        }else{
            adsRegistrationList = adsRegistrationRepository.findByAds_TypeAndStatus(AdsType.FLASH_SALE, OfferStatus.ACTIVE);
        }

        List<Location> locationsWithAds;
        List<Location> locationsWithoutAds = new ArrayList<>(locationList);

        if(adsRegistrationList == null){
            List<LocationResponseLazy> locationRandomList = getRandomLocations(locationsWithoutAds)
                    .stream().map(this::mapToResponseLazy).toList();

            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), locationRandomList.size());
            List<LocationResponseLazy> pagedLocationRandomSorted = locationRandomList.subList(start, end);

            return new PageImpl<>(pagedLocationRandomSorted, pageable, locationRandomList.size());
        }else {
            adsRegistrationList.forEach(adsRegistration -> locationsWithoutAds.removeIf(location -> location.getId().equals(adsRegistration.getLocation().getId())));

            locationsWithAds = adsRegistrationList.stream()
                    .sorted((loc1, loc2) -> {
                        int levelComparison;
                        if (adsType.equals(AdsType.BANNER)){
                            levelComparison = Integer.compare(loc2.getLocation().getOnBanner(), loc1.getLocation().getOnBanner());
                        } else {
                            levelComparison = Integer.compare(loc2.getLocation().getOnSale(), loc1.getLocation().getOnSale());
                        }

                        if (levelComparison != 0) {
                            return levelComparison;
                        }

                        LocalDateTime now = LocalDateTime.now();
                        long remainingTimeLoc1 = Duration.between(now, loc1.getExpireDate()).toSeconds();
                        long remainingTimeLoc2 = Duration.between(now, loc2.getExpireDate()).toSeconds();

                        return Long.compare(remainingTimeLoc2, remainingTimeLoc1);
                    })
                    .map(AdsRegistration::getLocation)
                    .toList();

            List<Location> locationRandomList = getRandomLocations(locationsWithoutAds);
            List<Location> combinedLocations = new ArrayList<>(locationsWithAds);
            combinedLocations.addAll(locationRandomList);

            List<LocationResponseLazy> locationResponseLazyList = combinedLocations.stream()
                    .map(this::mapToResponseLazy)
                    .toList();

            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), locationResponseLazyList.size());
            List<LocationResponseLazy> pagedLocationResponseLazySorted = locationResponseLazyList.subList(start, end);

            return new PageImpl<>(pagedLocationResponseLazySorted, pageable, locationResponseLazyList.size());
        }
    }

    @Override
    public Page<LocationResponseLazy> getLocationsRecommend(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Location> locationList = locationRepository.findAll();

        List<LocationResponseLazy> locationsRecommend = locationList.stream()
                    .sorted((loc1, loc2) -> {
                        int ratingComparison;
                        ratingComparison = Integer.compare(loc2.getRating(), loc1.getRating());

                        if (ratingComparison != 0) {
                            return ratingComparison;
                        }

                        return Long.compare(loc2.getView(), loc1.getView());
                    })
                    .map(this::mapToResponseLazy)
                    .toList();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), locationsRecommend.size());
        List<LocationResponseLazy> pagedLocationRecommendSorted = locationsRecommend.subList(start, end);

        return new PageImpl<>(pagedLocationRecommendSorted, pageable, locationsRecommend.size());
    }

    @Override
    public Page<LocationResponseLazy> getLocationsWithTag(int pageNo, int pageSize, String sortBy, String sortDir, String tagName) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Specification<Location> specification = GenericSpecification.rightJoinFieldContains("locationTags", "tag", "name", tagName);

        Page<Location> locationList = locationRepository.findAll(specification, pageable);

        return locationList.map(this::mapToResponseLazy);
    }

    private Specification<Location> specification(Map<String, Object> searchParams) {
        List<Specification<Location>> specs = new ArrayList<>();

        searchParams.forEach((key, value) -> {
            switch (key) {
                case "status" -> specs.add(GenericSpecification.fieldIn(key, (Collection<?>) value));
                case "searchText" ->
                        specs.add(Specification.where(GenericSpecification.<Location>fieldContains("name", (String) value))
                                .or(GenericSpecification.joinFieldContains("brand", "name", (String) value))
                                .or(GenericSpecification.leftJoinFieldContains("locationCategories", "category", "name", (String) value))
                                .or(GenericSpecification.rightJoinFieldContains("locationCategories", "category", "name", (String) value))
                                .or(GenericSpecification.leftJoinFieldContains("locationTags", "tag", "name", (String) value))
                                .or(GenericSpecification.rightJoinFieldContains("locationTags", "tag", "name", (String) value)));
            }
        });

        return specs.stream().reduce(Specification.where(null), Specification::and);
    }


    public Location validate(LocationRequest locationRequest) {
        Location location;
        String geoHashCode = GeoHashGeneration.getGeoHashCode(locationRequest.getLatitude(), locationRequest.getLongitude(), 9);

        if (locationRequest.getId() != 0) {
            location = locationRepository.findById(locationRequest.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Location", "id", locationRequest.getId()));
            BeanUtils.copyProperties(locationRequest, location, "user", "brand");
        } else {
            location = mapper.map(locationRequest, Location.class);
        }

        User user = userRepository.findById(locationRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", locationRequest.getUserId()));
        if (!user.getRole().getName().equals(AppConstants.ROLE_LOCATION)) {
            throw new RestaurantBookingException(HttpStatus.BAD_REQUEST, "User does not belong to role LOCATION_ADMIN");
        }

        Brand brand = brandRepository.findById(locationRequest.getBrandId())
                .orElseThrow(() -> new ResourceNotFoundException("Brand", "id", locationRequest.getBrandId()));

        location.setGeoHashCode(geoHashCode);
        location.setUser(user);
        location.setBrand(brand);
        Location savedLocation = locationRepository.save(location);



        if (!locationRequest.getCategoryId().isEmpty()) {
            // Lấy hết LocationCategory hiện có từ DB
            List<LocationCategory> currentLocationCategories = locationCategoryRepository.findByLocation(savedLocation);

            // Danh sách CategoryId hiện có trong LocationCategory
            List<Long> existingCategoryIds = currentLocationCategories.stream()
                    .map(lc -> lc.getCategory().getId())
                    .toList();

            // Xóa các Category không có trong danh sách từ Request
            List<LocationCategory> categoriesToRemove = currentLocationCategories.stream()
                    .filter(lc -> !locationRequest.getCategoryId().contains(lc.getCategory().getId()))
                    .toList();
            locationCategoryRepository.deleteAll(categoriesToRemove);

            // Thêm các Category mới
            List<LocationCategory> newLocationCategories = locationRequest.getCategoryId().stream()
                    .filter(categoryId -> !existingCategoryIds.contains(categoryId)) // Lọc các category mới cần thêm
                    .map(categoryId -> {
                        Category category = categoryRepository.findById(categoryId)
                                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));
                        LocationCategory locationCategory = new LocationCategory();
                        locationCategory.setLocation(savedLocation);
                        locationCategory.setCategory(category);
                        return locationCategory;
                    })
                    .toList();
            locationCategoryRepository.saveAll(newLocationCategories);
        }

        if (!locationRequest.getTagId().isEmpty()) {
            // Lấy hết LocationTag hiện có từ DB
            List<LocationTag> currentLocationTags = locationTagRepository.findByLocation(savedLocation);

            // Danh sách TagId hiện có trong LocationTag
            List<Long> existingTagIds = currentLocationTags.stream()
                    .map(lt -> lt.getTag().getId())
                    .toList();

            // Xóa các Tag không có trong danh sách từ Request
            List<LocationTag> tagsToRemove = currentLocationTags.stream()
                    .filter(lt -> !locationRequest.getTagId().contains(lt.getTag().getId()))
                    .toList();
            locationTagRepository.deleteAll(tagsToRemove);

            // Thêm các Tag mới
            List<LocationTag> newLocationTags = locationRequest.getTagId().stream()
                    .filter(tagId -> !existingTagIds.contains(tagId)) // Lọc các tag mới cần thêm
                    .map(tagId -> {
                        Tag tag = tagRepository.findById(tagId)
                                .orElseThrow(() -> new ResourceNotFoundException("Tag", "id", tagId));
                        LocationTag locationTag = new LocationTag();
                        locationTag.setLocation(savedLocation);
                        locationTag.setTag(tag);
                        return locationTag;
                    })
                    .toList();
            locationTagRepository.saveAll(newLocationTags);
        }
        return savedLocation;
    }

    private List<Location> getRandomLocations(List<Location> locationRandomList) {

        if (locationRandomList.isEmpty()) {
            throw new ResourceNotFoundException("Location", "any", "No locations found.");
        }

        Collections.shuffle(locationRandomList);

        return locationRandomList;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow((lat1 - lat2), 2) + Math.pow((lon1 - lon2), 2)) * 100;
    }

    private String formatDistance(double distanceInKm) {
        if (distanceInKm < 1) {
            return String.format("%.0fm", distanceInKm * 1000);
        }
        return String.format("%.2fkm", distanceInKm);
    }

    private LocationResponse mapToResponse(Location location){
        List<Category> categories = locationCategoryRepository.findCategoriesByLocationId(location.getId());
        List<Tag> tags = locationTagRepository.findTagsByLocationId(location.getId());
        List<WorkingHour> workingHours = workingHourRepository.findByLocation_Id(location.getId());

        LocationResponse locationResponse = mapper.map(location, LocationResponse.class);
        locationResponse.setCategory(categories.stream().map(category -> mapper.map(category, CategoryResponse.class)).toList());
        locationResponse.setTag(tags.stream().map(tag -> mapper.map(tag, TagResponse.class)).toList());
        locationResponse.setWorkingHour(workingHours.stream().map(workingHour -> mapper.map(workingHour, WorkingHourResponse.class)).toList());
        return locationResponse;
    }

    private LocationResponseLazy mapToResponseLazy(Location location){
        List<Category> categories = locationCategoryRepository.findCategoriesByLocationId(location.getId());
        List<Tag> tags = locationTagRepository.findTagsByLocationId(location.getId());
        LocationResponseLazy locationResponse = mapper.map(location, LocationResponseLazy.class);
        locationResponse.setCategoryName(categories.stream().map(Category::getName).toList());
        locationResponse.setTagName(tags.stream().map(Tag::getName).toList());
        return locationResponse;
    }
}
