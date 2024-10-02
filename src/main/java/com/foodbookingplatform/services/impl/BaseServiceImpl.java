package com.foodbookingplatform.services.impl;

import com.foodbookingplatform.models.exception.ResourceNotFoundException;
import com.foodbookingplatform.services.BaseService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract  class BaseServiceImpl<E, R, T> implements BaseService<R, T> {
    private final JpaRepository<E, Long> repository;
    private final ModelMapper modelMapper;
    private final Class<E> entityClass;
    private final Class<R> requestClass;
    private final Class<T> responseClass;

    public BaseServiceImpl(JpaRepository<E, Long> repository, ModelMapper modelMapper, Class<E> entityClass, Class<R> requestClass, Class<T> responseClass) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.entityClass = entityClass;
        this.requestClass = requestClass;
        this.responseClass = responseClass;
    }

    @Override
    public T add(R request) {
        E entity = modelMapper.map(request, entityClass);
        E savedEntity = repository.save(entity);
        return modelMapper.map(savedEntity, responseClass);
    }

    @Override
    public T get(Long id) {
        E entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity", "id", id));
        T response = modelMapper.map(entity, responseClass);
        return response;
    }

    @Override
    public Page<T> getAll(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<E> pageResult = repository.findAll(pageable);
        return pageResult.map(entity -> modelMapper.map(entity, responseClass));
    }

    @Override
    public Page<T> search(int pageNo, int pageSize, String sortBy, String sortDir, String searchText) {
        return Page.empty();
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
