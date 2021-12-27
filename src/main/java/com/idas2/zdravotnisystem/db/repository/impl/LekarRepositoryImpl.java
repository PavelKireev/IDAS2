package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.entity.Lekar;
import com.idas2.zdravotnisystem.db.repository.LekarRepository;
import com.idas2.zdravotnisystem.db.view.LekarView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class LekarRepositoryImpl implements LekarRepository {

    @Override
    public @Nullable Lekar getOne(Integer id) {
        return null;
    }

    @Override
    public @NotNull Integer create(@NotNull Lekar entity) {
        return null;
    }

    @Override
    public @Nullable Lekar update(@NotNull Lekar entity) {
        return null;
    }

    @Override
    public void delete(@NotNull Integer id) {

    }

    @Override
    public void delete(@NotNull Lekar entity) {
    }


    @Override
    public @NotNull LekarView getViewById(@NotNull Integer id) {
        return null;
    }
}
