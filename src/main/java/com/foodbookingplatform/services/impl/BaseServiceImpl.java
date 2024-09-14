package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.services.BaseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract  class BaseServiceImpl<E, R, T> implements BaseService<R, T> {
    private final JpaRepository<E, Long> repository;
    private final ModelMapper modelMapper;

    public BaseServiceImpl(JpaRepository<E, Long> repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public T add(R request) {
        E entity = modelMapper.map(request, (Class<E>) request.getClass());
        E savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, (Class<T>) request.getClass());
    }

    @Override
    public T get(Long id) {
        E entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id));
        T response = modelMapper.map(entity, (Class<T>) this.getClass());
//        T newResponse = null;
//        T response = modelMapper.map(entity, (Class<T>) newResponse.getClass());
        return response;
    }

    @Override
    public List<T> getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<E> pageResult = repository.findAll(pageable);
        return pageResult.getContent().stream().map(entity -> modelMapper.map(entity, (Class<T>) entity.getClass())).toList();
    }

    @Override
    public List<T> search(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        return List.of();
    }

    @Override
    public T update(R request) {
        return null;
    }

    @Override
    public void delete(long id) {
        E entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id));
        if (entity != null) {
            repository.delete(entity);
        }
    }
}
