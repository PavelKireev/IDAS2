package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Administrator;
import com.idas2.zdravotnisystem.db.view.AdministratorView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdministratorRepository {

    List<AdministratorView> findAllView();
}
