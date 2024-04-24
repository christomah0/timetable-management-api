package com.ihm.timetablemanagement.services;

import java.util.List;

public interface BusinessServiceInterface <T, ID> {
    // find all data
    List<T> findAll();

    // save one registration
    void save(T object);

    // find by id one registration
    T findById(ID object);

    // delete by id a registration
    void deleteById(ID object);
}
