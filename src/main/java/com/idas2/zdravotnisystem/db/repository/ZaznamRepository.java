package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Zaznam;
import com.idas2.zdravotnisystem.db.view.ZaznamView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ZaznamRepository {

    void delete(@NotNull Integer id);

    List<ZaznamView> findAllByHospitalizaceId(
        @NotNull Integer hospitalizaceId
    );

    void saveFromView(
        @NotNull ZaznamView zaznamView
    );

}
