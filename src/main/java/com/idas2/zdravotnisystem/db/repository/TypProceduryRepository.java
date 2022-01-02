package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.TypProcedury;

import java.util.List;

public interface TypProceduryRepository{

    List<TypProcedury> findAll();
}
