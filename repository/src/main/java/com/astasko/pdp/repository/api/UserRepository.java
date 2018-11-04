package com.astasko.pdp.repository.api;

import com.astasko.pdp.domain.model.User;

public interface UserRepository extends Repository<User, Long> {

    @Override
    User read(Long id);

    @Override
    Long create(User entity);

    @Override
    void delete(Long id);

    @Override
    void update(User entity);
}
