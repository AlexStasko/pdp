package com.astasko.pdp.service.api;

public interface Service<T, I> {

    T get(I id);

    I add(T entity);

    void delete(I id);

    void update(T entity);

}
