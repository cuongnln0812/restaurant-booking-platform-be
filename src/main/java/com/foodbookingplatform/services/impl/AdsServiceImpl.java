package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Ads;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.ads.AdsRequest;
import com.foodbookingplatform.models.payload.dto.ads.AdsResponse;
import com.foodbookingplatform.repositories.AdsRepository;
import com.foodbookingplatform.services.AdsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdsServiceImpl extends BaseServiceImpl<Ads, AdsRequest, AdsResponse> implements AdsService {

    private final AdsRepository adsRepository;
    private final ModelMapper mapper;

    public AdsServiceImpl(AdsRepository adsRepository, ModelMapper mapper) {
        super(adsRepository, mapper, Ads.class, AdsRequest.class, AdsResponse.class);
        this.adsRepository = adsRepository;
        this.mapper = mapper;
    }

    @Override
    public AdsResponse update(AdsRequest adsRequest) {
        Ads ads = adsRepository.findById(adsRequest.getId()).orElseThrow(() -> new ResourceNotFoundException("Ads", "id", adsRequest.getId()));
        if (ads != null) {
            Ads updatedAds = mapper.map(adsRequest, Ads.class);
            return mapper.map(adsRepository.save(updatedAds), AdsResponse.class);
        }
        return null;
    }
}
