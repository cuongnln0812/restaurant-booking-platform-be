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
    public Page<LocationResponse> getAllLocations(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Location> locationPage = locationRepository.findAll(pageable);
        return locationPage.map(this::mapToResponse);
    }

    @Override
    public Page<LocationResponseLazy> searchAllLocations(int pageNo, int pageSize, String sortBy, String sortDir, Map<String, Object> searchParams, double latitude, double longitude, boolean isNear) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Specification<Location> specification = specification(searchParams);

        List<Location> locationList = locationRepository.findAll(specification);
        if(isNear){
            String geoHashCode = GeoHashGeneration.getGeoHashCode(latitude, longitude, 4);
            List<LocationResponseLazy> locationNearSorted = locationList.stream()
                    .filter(location -> location.getGeoHashCode().startsWith(geoHashCode))
                    .sorted((location1, location2) -> {
                        double distance1 = calculateDistance(location1.getLatitude(), location1.getLongitude(), latitude, longitude);
                        double distance2 = calculateDistance(location2.getLatitude(), location2.getLongitude(), latitude, longitude);

                        return Double.compare(distance1, distance2);
                    })
                    .map(location -> {
                        LocationResponseLazy response = mapper.map(location, LocationResponseLazy.class);
                        double distance = calculateDistance(response.getLatitude(), response.getLongitude(), latitude, longitude);
                        response.setDistance(formatDistance(distance));
                        return response;
                    })
                    .toList();

            return new PageImpl<>(locationNearSorted, pageable, locationNearSorted.size());
        }
        List<LocationResponseLazy> locationResponseLazyList = locationList.stream().map(location -> mapper.map(location, LocationResponseLazy.class)).toList();
        return new PageImpl<>(locationResponseLazyList, pageable, locationList.size());
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
    public Page<LocationResponseLazy> getLocationsWithBannerAds(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<AdsRegistration> adsRegistrations = adsRegistrationRepository.findByAds_TypeAndStatus(AdsType.BANNER, OfferStatus.ACTIVE, pageable);

        // Không có Location đăng kí Ads BANNER
        if (adsRegistrations.isEmpty()) {
            return getRandomLocations(pageable).map(location -> mapper.map(location, LocationResponseLazy.class));
        }

        // Sắp xếp danh sách theo level của Ads, nếu cùng level thì sắp xếp theo thời gian quảng cáo còn lại của location
        List<LocationResponseLazy> sortedLocation = adsRegistrations.getContent().stream()
                .sorted((ad1, ad2) -> {
                    int levelComparison = Integer.compare(ad2.getLocation().getOnBanner(), ad1.getLocation().getOnBanner());
                    if (levelComparison != 0) {
                        return levelComparison;
                    }

                    LocalDateTime now = LocalDateTime.now();
                    long remainingTimeAd1 = Duration.between(now, ad1.getExpireDate()).getSeconds();
                    long remainingTimeAd2 = Duration.between(now, ad2.getExpireDate()).getSeconds();

                    return Long.compare(remainingTimeAd2, remainingTimeAd1);
                })
                .map(adsRegistration -> mapper.map(adsRegistration.getLocation(), LocationResponseLazy.class))
                .toList();

//        List<LocationResponseLazy> sortedLocations = sortedLocation.stream()
//                .map(adsRegistration -> mapper.map(adsRegistration.getLocation(), LocationResponseLazy.class))
//                .toList();

        return new PageImpl<>(sortedLocation, pageable, sortedLocation.size());
    }

    private Specification<Location> specification(Map<String, Object> searchParams){
        List<Specification<Location>> specs = new ArrayList<>();

        searchParams.forEach((key, value) -> {
            switch (key) {
                case "status" -> specs.add(GenericSpecification.fieldIn(key, (Collection<?>) value));
                case "name" -> specs.add(GenericSpecification.fieldContains(key, (String) value));
                case "brandName" -> specs.add(GenericSpecification.joinFieldContains("brand", "name", (String) value));
                case "categoryName" ->
                        specs.add(GenericSpecification.joinFieldInThroughMultipleJoins("locationCategories", "category", "name", (Collection<?>) value));
                case "tagName" ->
                        specs.add(GenericSpecification.joinFieldInThroughMultipleJoins("locationTags", "tag", "name", (Collection<?>) value));
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

    //
    private Page<Location> getRandomLocations(Pageable pageable) {
        Page<Location> locationsPage = locationRepository.findAll(pageable);

        if (!locationsPage.hasContent()) {
            throw new ResourceNotFoundException("Location", "any", "No locations found.");
        }

        List<Location> allLocations = new ArrayList<>(locationsPage.getContent());
        Collections.shuffle(allLocations);

        return new PageImpl<>(allLocations, pageable, locationsPage.getTotalElements());
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
}
