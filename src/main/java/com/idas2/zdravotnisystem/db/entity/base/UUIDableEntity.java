package com.idas2.zdravotnisystem.db.entity.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;

@MappedSuperclass
public abstract class UUIDableEntity<T extends Serializable>
        extends BaseEntity<T> implements UUIDable {

    private static final long serialVersionUID = 4816652291725802746L;

    @PrePersist
    public void prePersist() {
        setUuid(generateUUID());
    }

    protected String uuid;

    public String getUuid() {
        return uuid;
    }

    public UUIDableEntity<T> setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }
}
