package com.idas2.zdravotnisystem.db.entity.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;

@MappedSuperclass
public abstract class UUIDableTimedEntity<T extends Serializable>
        extends TimedEntity<T> implements UUIDable {

    private static final long serialVersionUID = -6648133784811363447L;

    @Override
    @PrePersist
    public void prePersist() {
        super.prePersist();
        setUuid(generateUUID());
    }

    protected String uuid;

    public String getUuid() {
        return uuid;
    }

    public UUIDableTimedEntity<T> setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

}
