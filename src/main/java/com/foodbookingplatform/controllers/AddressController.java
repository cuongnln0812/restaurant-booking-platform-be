package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.payload.dto.address.AddressRequest;
import com.foodbookingplatform.models.payload.dto.address.AddressResponse;
import com.foodbookingplatform.services.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    
    private final AddressService addressService;
    
    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllByUser(
    ) {
        return ResponseEntity.ok(addressService.getAllByUser());
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressResponse> getAddressDetail(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody @Valid AddressRequest request) {
        AddressResponse response = addressService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("default/{id}")
    public ResponseEntity<AddressResponse> setDefault(@PathVariable Long id){
        return ResponseEntity.ok(addressService.setDefault(id));
    }

    @PutMapping
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody @Valid AddressRequest request) {
        return ResponseEntity.ok(addressService.update(request));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.delete(id));
    }
}
