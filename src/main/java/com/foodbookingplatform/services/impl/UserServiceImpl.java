package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.entities.SystemBlog;
import com.foodbookingplatform.models.entities.User;
import com.foodbookingplatform.models.enums.EntityStatus;
import com.foodbookingplatform.models.exception.MotherLoveApiException;
import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.models.payload.dto.systemblog.SystemBlogResponse;
import com.foodbookingplatform.models.payload.dto.user.UserRequest;
import com.foodbookingplatform.models.payload.dto.user.UserResponse;
import com.foodbookingplatform.repositories.UserRepository;
import com.foodbookingplatform.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public Page<UserResponse> getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> mapper.map(user, UserResponse.class));
    }

    //Implement sau
    @Override
    public Page<UserResponse> search(int pageNo, int pageSize, String sortBy, String sortDir, String keyword) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage.map(user -> mapper.map(user, UserResponse.class));
    }

    @Override
    public UserResponse getInfoById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse updateInfo(UserRequest request) {
        User existed = userRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", request.getId()));
        if(!existed.getStatus().equals(EntityStatus.DISABLED)) {
            mapper.map(request, existed);
            return mapper.map(userRepository.save(existed), UserResponse.class);
        } else throw new MotherLoveApiException(HttpStatus.BAD_REQUEST, "Unable to update information due to its unavailability!");
    }

    @Override
    public UserResponse deleteUser(Long id) {
        User existed = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        existed.setStatus(EntityStatus.DISABLED);
        return mapper.map(userRepository.save(existed), UserResponse.class);
    }
}
