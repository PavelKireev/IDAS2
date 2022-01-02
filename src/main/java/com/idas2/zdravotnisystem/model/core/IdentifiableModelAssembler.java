package com.idas2.zdravotnisystem.model.core;

import com.idas2.zdravotnisystem.db.entity.base.BaseEntity;

import java.util.Objects;

public abstract class IdentifiableModelAssembler<T extends BaseEntity, D extends IdentifiableModel<? extends IdentifiableModel>>
        extends AbstractModelAssembler<T, D> {

    protected IdentifiableModelAssembler(Class<D> modelType) {
        super(modelType);
    }

    protected D createModelWithId(T entity) {
        Objects.requireNonNull(entity, "Entity must not be null");
        Objects.requireNonNull(entity.getId(), "Entity Id must not be null");
        D instance = this.instantiateModel();
        instance.setId(
            Objects.isNull(entity.getId()) ? null :  entity.getId().toString()
        );
        return instance;
    }
}
