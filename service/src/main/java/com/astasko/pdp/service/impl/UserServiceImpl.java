package com.astasko.pdp.service.impl;

import com.astasko.pdp.domain.model.User;
import com.astasko.pdp.repository.api.UserRepository;
import com.astasko.pdp.service.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(Long id) {
        return userRepository.read(id);
    }

    @Override
    public Long add(User user) {
        return userRepository.create(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }
}
