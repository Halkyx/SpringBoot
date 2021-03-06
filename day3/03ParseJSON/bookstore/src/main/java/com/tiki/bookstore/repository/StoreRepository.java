package com.tiki.bookstore.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class StoreRepository<T> {

    protected List<T> collections = new ArrayList<>();

    public abstract List<T> getAll();

    public abstract Optional<T> get(int id);

    public abstract void add(T t);

    public abstract void update(T t);

    public abstract void deleteByID(int id);

    public abstract void delete(T t);

}
