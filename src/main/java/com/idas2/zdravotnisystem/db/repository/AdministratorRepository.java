package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.AdministratorView;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorRepository {

    AdministratorView findById(Integer id);
    List<AdministratorView> findAllView();
    void saveFromView(@NotNull AdministratorView view);
}
