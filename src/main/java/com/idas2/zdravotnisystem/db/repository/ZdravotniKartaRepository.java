package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import org.jetbrains.annotations.NotNull;

public interface ZdravotniKartaRepository extends CrudRepository<ZdravortniKarta> {
    ZdravortniKarta findByPacientId(
        @NotNull Integer pacientId
    );
}
