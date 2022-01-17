package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Ordinace;

import java.util.List;

public interface OrdinaceRepository {

    List<Ordinace> findAll();
    void saveFromEntity(Ordinace entity);
}
