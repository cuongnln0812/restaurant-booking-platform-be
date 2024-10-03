package com.foodbookingplatform.services;

import org.springframework.data.domain.Page;

public interface BaseService<R, T> {
    T add(R request);
    T get(Long id);
    Page<T> getAll(int pageNo, int pageSize, String sortBy, String sortDir);
    Page<T> search(int pageNo, int pageSize, String sortBy, String sortDir, String searchText);
    T update(R request);
    void delete(long id);
}
