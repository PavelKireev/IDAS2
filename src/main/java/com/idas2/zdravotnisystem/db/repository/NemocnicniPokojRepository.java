package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.NemocnicniPokoj;
import com.idas2.zdravotnisystem.db.view.NemocnicniPokojView;

import java.util.List;

public interface NemocnicniPokojRepository extends CrudRepository<NemocnicniPokoj> {

    List<NemocnicniPokojView> findAll();

}
