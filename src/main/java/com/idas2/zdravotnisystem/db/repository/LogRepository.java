package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Log;

import java.util.List;

public interface LogRepository extends CrudRepository<Log> {

    List<Log> findAll();
}
