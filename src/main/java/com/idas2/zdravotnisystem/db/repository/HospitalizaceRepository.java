package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface HospitalizaceRepository extends CrudRepository<Hospitalizace> {

    List<HospitalizaceView> findAllByPacientId(
        @NotNull Integer pacientId
    );

    List<HospitalizaceView> findAllByLekarId(
        @NotNull Integer lekarId
    );

    List<HospitalizaceView> findAll();
}
