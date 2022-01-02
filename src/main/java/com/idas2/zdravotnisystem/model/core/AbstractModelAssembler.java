package com.idas2.zdravotnisystem.model.core;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import java.util.*;

public abstract class AbstractModelAssembler<T, D extends RepresentationModel<?>>
        implements RepresentationModelAssembler<T, D> {

    private final Class<D> modelType;

    public AbstractModelAssembler(Class<D> modelType) {
        this.modelType = modelType;
    }

    public List<D> toModels(Iterable<T> entities) {
        Objects.requireNonNull(entities, "Entities must not be null!");
        List<D> result = new ArrayList<>();

        for (T entity : entities) {
            result.add(this.toModel(entity));
        }

        return result;
    }

    public Set<D> toSetModels(Iterable<T> entities) {
        Objects.requireNonNull(entities, "Entities must not be null!");
        Set<D> result = new HashSet<>();

        for (T entity : entities) {
            result.add(this.toModel(entity));
        }

        return result;
    }

    public PagedModel<D> toPagedModel(Page<T> page) {
        List<D> list = toModels(page.getContent());
        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
                page.getSize(), page.getNumber(), page.getTotalElements(), page.getTotalPages());
        return PagedModel.of(list, metadata);
    }

    D instantiateModel() {
        return BeanUtils.instantiateClass(this.modelType);
    }
}
