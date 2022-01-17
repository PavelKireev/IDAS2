package com.idas2.zdravotnisystem.db.repository.impl;

import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.db.view.KancelarView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KancelarRepositoryImpl
    extends AbstractCrudRepository
    implements KancelarRepository {

    @Override
    public List<KancelarView> findAllView() {
        return null;
    }
}
