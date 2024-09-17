package com.foodbookingplatform.services;

import java.util.List;

public interface BaseService<R, T> {
    T add(R request);
    T get(Long id);
    List<T> getAll(int pageNo, int pageSize, String sortBy, String sortDir);
    List<T> search(int pageNo, int pageSize, String sortBy, String sortDir, String searchText);
    T update(R request);
    void delete(long id);
}
