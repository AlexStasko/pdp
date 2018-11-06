package com.astasko.pdp.repository.api;

public interface Repository<T, I> {

    T read(I id);

    I create(T entity);

    void delete(I id);

    void update(T entity);
}
