package com.idas2.zdravotnisystem.db.repository;

import com.idas2.zdravotnisystem.db.view.KancelarView;

import java.util.List;

public interface KancelarRepository {

    List<KancelarView> findAllView();
}
