package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface HospitalizaceRepository extends CrudRepository<Hospitalizace> {

    @Nullable HospitalizaceView findOne(Integer id);

    void saveByEntity(
        Hospitalizace entity
    );

    List<HospitalizaceView> findAllByPacientId(
        @NotNull Integer pacientId
    );

    List<HospitalizaceView> findAllByLekarId(
        @NotNull Integer lekarId
    );

    List<HospitalizaceView> findAll();
}
