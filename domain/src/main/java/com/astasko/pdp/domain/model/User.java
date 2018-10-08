package com.astasko.pdp.domain.model;

import com.astasko.pdp.domain.model.common.BaseEntity;
import com.astasko.pdp.domain.model.common.StoredEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User extends BaseEntity<Long> {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private StoredEntity storedEntity;

    private User(UserBuilder builder) {
        this.setId(builder.id);
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.storedEntity = builder.storedEntity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StoredEntity getStoredEntity() {
        return storedEntity;
    }

    public void setStoredEntity(StoredEntity storedEntity) {
        this.storedEntity = storedEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(user))
                .append(firstName, user.firstName)
                .append(lastName, user.lastName)
                .append(password, user.password)
                .append(email, user.email)
                .append(storedEntity, user.storedEntity)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(firstName)
                .append(lastName)
                .append(password)
                .append(email)
                .append(storedEntity)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .appendSuper(super.toString())
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("password", password)
                .append("email", email)
                .append("storedEntity", storedEntity)
                .toString();
    }

    public static final class UserBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;
        private StoredEntity storedEntity;

        private UserBuilder() {
            id = null;
            firstName = null;
            lastName = null;
            password = null;
            email = null;
            storedEntity = null;
        }

        public UserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withStoredEntity(StoredEntity storedEntity) {
            this.storedEntity = storedEntity;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
