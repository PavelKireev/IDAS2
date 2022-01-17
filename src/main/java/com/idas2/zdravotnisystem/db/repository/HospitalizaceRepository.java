package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.view.HospitalizaceView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface HospitalizaceRepository {

    @Nullable HospitalizaceView findOne(Integer id);

    void saveFromEntity(
        Hospitalizace entity
    );

    List<HospitalizaceView> findAllByPacientId(
        @NotNull Integer pacientId
    );

    List<HospitalizaceView> findAllByLekarId(
        @NotNull Integer lekarId
    );

    List<HospitalizaceView> findAll();

    void delete(Integer id);
}
