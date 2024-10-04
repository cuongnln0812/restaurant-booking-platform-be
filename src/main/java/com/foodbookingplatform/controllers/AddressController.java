package com.foodbookingplatform.controllers;

import com.foodbookingplatform.models.payload.dto.address.AddressRequest;
import com.foodbookingplatform.models.payload.dto.address.AddressResponse;
import com.foodbookingplatform.services.AddressService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bear Authentication")
public class AddressController {
    
    private final AddressService addressService;

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public ResponseEntity<List<AddressResponse>> getAllByUser(
    ) {
        return ResponseEntity.ok(addressService.getAllByUser());
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @GetMapping("{id}")
    public ResponseEntity<AddressResponse> getAddressDetail(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.findById(id));
    }

    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATE")
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<AddressResponse> createAddress(@RequestBody @Valid AddressRequest request) {
        AddressResponse response = addressService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @PutMapping("default/{id}")
    public ResponseEntity<AddressResponse> setDefault(@PathVariable Long id){
        return ResponseEntity.ok(addressService.setDefault(id));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @PutMapping
    public ResponseEntity<AddressResponse> updateAddress(@RequestBody @Valid AddressRequest request) {
        return ResponseEntity.ok(addressService.update(request));
    }

    @ApiResponse(responseCode = "200", description = "Http Status 200 OK")
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.delete(id));
    }
}
