package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.ZdravotniKarta;
import org.jetbrains.annotations.NotNull;

public interface ZdravotniKartaRepository {

    ZdravotniKarta findByPacientId(
        @NotNull Integer pacientId
    );

    void updateByEntity(
        @NotNull ZdravotniKarta zdravotniKarta
    );
}
