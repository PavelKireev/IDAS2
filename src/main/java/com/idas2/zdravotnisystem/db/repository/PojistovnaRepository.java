package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Pojistovna;

import java.util.List;

public interface PojistovnaRepository extends CrudRepository<Pojistovna> {
    List<Pojistovna> findAll();
}
