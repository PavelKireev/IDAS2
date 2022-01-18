package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.entity.Log;
import com.idas2.zdravotnisystem.db.view.LogTabulkyView;
import com.idas2.zdravotnisystem.db.view.LogUzivatelView;

import java.util.List;

public interface LogRepository {

    List<Log> findAll();

    List<LogTabulkyView> findAllTableLog();

    List<LogUzivatelView> findAllUserLog();
}
