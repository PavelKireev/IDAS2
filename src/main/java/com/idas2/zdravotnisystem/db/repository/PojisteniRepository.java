package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import org.jetbrains.annotations.NotNull;

public interface PojisteniRepository {

    Pojisteni findByZdravorniKartaId(
        @NotNull Integer zdravotniKartaId
    );

    void updateByEntity(Pojisteni pojisteni);
}
