package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.Address;
import com.foodbookingplatform.models.entities.User;

import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.address.AddressRequest;
import com.foodbookingplatform.models.payload.dto.address.AddressResponse;
import com.foodbookingplatform.repositories.AddressRepository;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public List<AddressResponse> getAllByUser() {
        List<Address> addresses = getListByUsername();
        return addresses.stream().map(address -> mapper.map(address, AddressResponse.class)).toList();
    }

    @Override
    public AddressResponse setDefault(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "Id", id));
        if(!address.isDefault()) {
            List<Address> addresses = getListByUsername();
            addresses.forEach(a -> {
                if (a.isDefault()) {
                    a.setDefault(false);
                    addressRepository.save(a);
                }
            });
            address.setDefault(true);
            addressRepository.save(address);
        }
        return mapper.map(address, AddressResponse.class);
    }


    @Override
    @Transactional
    public AddressResponse create(AddressRequest addressRequest) {
        Address newAddress = mapper.map(addressRequest, Address.class);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        newAddress.setDefault(currentUser.getAddresses().isEmpty());

        newAddress.setUser(currentUser);
        Address saved = addressRepository.save(newAddress);
        return mapper.map(saved, AddressResponse.class);
    }

    @Override
    @Transactional
    public AddressResponse update(AddressRequest addressRequest) {
        Address existed = addressRepository.findById(addressRequest.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Address", "Id", addressRequest.getId()));
        mapper.map(addressRequest, existed);
        return mapper.map(addressRepository.save(existed), AddressResponse.class);
    }

    @Override
    public AddressResponse findById(Long id) {
        Address existedBlog = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "Id", id));
        return mapper.map(existedBlog, AddressResponse.class);
    }

    @Override
    @Transactional
    public String delete(Long id) {
        Address existed = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "Id", id));
        addressRepository.delete(existed);
        return "Address is deleted!";
    }

    private List<Address> getListByUsername(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return addressRepository.findAllByUserUserName(username);
    }
}
