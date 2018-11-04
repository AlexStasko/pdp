package com.astasko.pdp.repository.impl;

import com.astasko.pdp.domain.model.User;
import com.astasko.pdp.repository.api.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User read(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM user WHERE id = ?;",
                (resultSet, i) -> new User.UserBuilder()
                        .withId(resultSet.getLong("id"))
                        .withFirstName(resultSet.getString("firstName"))
                        .withLastName(resultSet.getString("lastName"))
                        .withEmail(resultSet.getString("email"))
                        .withPassword(resultSet.getString("password"))
                        .build(),
                id);
    }

    @Override
    public Long create(User entity) {
        // TODO: remove random with generated key.
        Random rnd = new Random();
        Long id = rnd.nextLong();
        jdbcTemplate.update("INSERT INTO user(id, firstname, lastname, email, password) VALUES(?, ?, ?, ?, ?)",
                id, entity.getFirstName(), entity.getLastName(), entity.getEmail(), entity.getPassword());
        return id;
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE user SET firstName = ?, lastName = ?, email = ?, password = ? WHERE id = ?",
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getId());
    }
}
