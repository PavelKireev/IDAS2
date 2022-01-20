package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Specializace;

import java.util.List;

public interface SpecializaceRepository {

    List<Specializace> findAll();
}
