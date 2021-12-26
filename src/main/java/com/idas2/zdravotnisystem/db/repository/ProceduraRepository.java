package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.ProceduraView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProceduraRepository {

    List<ProceduraView> getProceduraViewListByUserIdBeforeNow(
        @NotNull Integer userId
    );

    List<ProceduraView> getProceduraViewListByUserIdAfterNow(
        @NotNull Integer userId
    );

}
