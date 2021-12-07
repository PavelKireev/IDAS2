package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Obrazek;
import com.idas2.zdravotnisystem.db.entity.User;
import org.jetbrains.annotations.NotNull;

public interface ObrazekRepository extends CrudRepository<Obrazek>{

    @NotNull Integer upload(
        @NotNull User user,
        @NotNull byte[] obrazek
    );
}
