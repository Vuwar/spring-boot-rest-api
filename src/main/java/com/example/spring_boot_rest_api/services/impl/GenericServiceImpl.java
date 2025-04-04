package com.example.spring_boot_rest_api.services.impl;

import com.example.spring_boot_rest_api.services.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericServiceImpl<T,ID> implements GenericService<T,ID> {

    protected final JpaRepository<T, ID> repository;

    public GenericServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public T update(ID id, T entity) {
        if (repository.existsById(id)) {
            return repository.save(entity);
        } else {
            throw new RuntimeException("Entity with ID " + id + " not found.");
        }
    }
}
