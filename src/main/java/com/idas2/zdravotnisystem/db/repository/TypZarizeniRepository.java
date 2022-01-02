package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;

import java.util.List;

public interface TypZarizeniRepository extends CrudRepository<TypZarizeni> {
    List<TypZarizeni> findAll();
}
