package com.astasko.pdp.domain.model.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDate;

public class StoredEntity {

    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String createdByUser;
    private String updatedByUser;
    private int version;

    private StoredEntity(StoredEntityBuilder builder) {
        this.createdDate = builder.createdDate;
        this.updatedDate = builder.updatedDate;
        this.createdByUser = builder.createdByUser;
        this.updatedByUser = builder.updatedByUser;
        this.version = builder.version;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getUpdatedByUser() {
        return updatedByUser;
    }

    public void setUpdatedByUser(String updatedByUser) {
        this.updatedByUser = updatedByUser;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoredEntity that = (StoredEntity) o;
        return new EqualsBuilder()
                .append(version, that.version)
                .append(createdDate, that.createdDate)
                .append(updatedDate, that.updatedDate)
                .append(createdByUser, that.createdByUser)
                .append(updatedByUser, that.updatedByUser)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(createdDate)
                .append(updatedDate)
                .append(createdByUser)
                .append(updatedByUser)
                .append(version)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("createdDate", createdDate)
                .append("updatedDate", updatedDate)
                .append("createdByUser", createdByUser)
                .append("updatedByUser", updatedByUser)
                .append("version", version)
                .toString();
    }


    public static final class StoredEntityBuilder {
        private LocalDate createdDate;
        private LocalDate updatedDate;
        private String createdByUser;
        private String updatedByUser;
        private int version;

        public StoredEntityBuilder withCreatedDate(LocalDate createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public StoredEntityBuilder withUpdatedDate(LocalDate updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public StoredEntityBuilder withCreatedByUser(String createdByUser) {
            this.createdByUser = createdByUser;
            return this;
        }

        public StoredEntityBuilder withUpdatedByUser(String updatedByUser) {
            this.updatedByUser = updatedByUser;
            return this;
        }

        public StoredEntityBuilder withVersion(int version) {
            this.version = version;
            return this;
        }

        public StoredEntity build() {
            return new StoredEntity(this);
        }
    }
}
