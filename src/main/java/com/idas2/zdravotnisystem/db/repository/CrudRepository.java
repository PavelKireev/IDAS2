package com.idas2.zdravotnisystem.db.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CrudRepository<T> {

    @Nullable
    T getOne(Integer id);

    @NotNull
    Integer create(@NotNull T entity);

    @Nullable
    T update(@NotNull T entity);

    void delete(@NotNull Integer id);

    void delete(@NotNull T entity);

}

