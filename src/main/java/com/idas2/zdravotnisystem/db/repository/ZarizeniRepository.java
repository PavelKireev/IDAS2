package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Zarizeni;

import java.util.List;

public interface ZarizeniRepository extends CrudRepository<Zarizeni> {
    List<Zarizeni> findAll();
}
