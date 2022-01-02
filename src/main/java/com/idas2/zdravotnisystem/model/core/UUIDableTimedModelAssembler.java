package com.idas2.zdravotnisystem.model.core;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import java.util.Objects;

public abstract class UUIDableTimedModelAssembler <T extends UUIDableTimedEntity, D extends IdentifiableModel<? extends IdentifiableModel>>
        extends IdentifiableModelAssembler<T, D> {

    public UUIDableTimedModelAssembler(Class<D> resourceType) {
        super(resourceType);
    }

    protected D createUUIDableResourceWithId(T entity) {
        Objects.requireNonNull(entity, "Entity must not be null");
        Objects.requireNonNull(entity.getUuid(), "Entity UUID must not be null");
        D instance = this.instantiateModel();
        instance.setId(entity.getUuid());
        return instance;
    }
}
