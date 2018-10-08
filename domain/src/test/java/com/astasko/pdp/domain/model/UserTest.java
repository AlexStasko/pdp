package com.astasko.pdp.domain.model;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Assertions;

class UserTest {

    @Test
    void testUser() {
        Assertions.assertPojoMethodsFor(User.class).areWellImplemented();
    }
}
