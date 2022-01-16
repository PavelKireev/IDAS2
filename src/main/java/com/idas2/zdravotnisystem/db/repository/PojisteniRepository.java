package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import org.jetbrains.annotations.NotNull;

public interface PojisteniRepository extends CrudRepository<Pojisteni> {

    Pojisteni findByZdravorniKartaId(
        @NotNull Integer zdravotniKartaId
    );

    void updateByEntity(Pojisteni pojisteni);
}
