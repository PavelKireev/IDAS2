package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Procedura;
import com.idas2.zdravotnisystem.db.view.ProceduraView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProceduraRepository{

    List<ProceduraView> getProceduraViewListByUserIdBeforeNow(
        @NotNull Integer userId
    );

    List<ProceduraView> getProceduraViewListByUserIdAfterNow(
        @NotNull Integer userId
    );

    List<ProceduraView> getProceduraViewListByLekarIdBeforeNow(
        @NotNull Integer lekarId
    );

    List<ProceduraView> getProceduraViewListByLekarIdAfterNow(
        @NotNull Integer lekarId
    );

    @NotNull
    List<ProceduraView> findAll();

    @NotNull
    ProceduraView findOne(Integer id);

    void saveFromView(ProceduraView view);

    void deleteByUuid(@NotNull String uuid);

    void delete(@NotNull Integer id);
}
