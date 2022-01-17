package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.repository.KancelarRepository;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarCreateForm;
import com.idas2.zdravotnisystem.form.mistnost.kancelar.KancelarUpdateForm;

public class KancelarFormServiceImpl implements KancelarFormService {

    private final KancelarRepository kancelarRepository;

    public KancelarFormServiceImpl(
        KancelarRepository kancelarRepository
    ) {
        this.kancelarRepository = kancelarRepository;
    }


    @Override
    public void create(KancelarCreateForm form) {

    }

    @Override
    public void update(KancelarUpdateForm form) {

    }
}
