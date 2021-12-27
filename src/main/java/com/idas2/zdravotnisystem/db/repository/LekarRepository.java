package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Lekar;
import com.idas2.zdravotnisystem.db.view.LekarView;
import org.jetbrains.annotations.NotNull;

public interface LekarRepository extends CrudRepository<Lekar> {

    @NotNull
    LekarView getViewById(
        @NotNull Integer id
    );
}
