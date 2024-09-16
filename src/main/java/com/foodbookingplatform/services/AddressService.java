package com.foodbookingplatform.services;

import com.foodbookingplatform.models.payload.dto.address.AddressRequest;
import com.foodbookingplatform.models.payload.dto.address.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAllByUser();
    AddressResponse setDefault(Long id);
    AddressResponse create(AddressRequest blog);
    AddressResponse update(AddressRequest blog);
    AddressResponse findById(Long id);
    String delete(Long id);
}
