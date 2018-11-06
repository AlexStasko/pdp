package com.astasko.pdp.service.api;

import com.astasko.pdp.domain.model.User;

public interface UserService extends Service<User, Long> {

    @Override
    User get(Long id);

    @Override
    Long add(User user);

    @Override
    void delete(Long id);

    @Override
    void update(User user);
}
