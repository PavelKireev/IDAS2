package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.TypZarizeni;
import com.idas2.zdravotnisystem.db.repository.TypZarizeniRepository;
import com.idas2.zdravotnisystem.db.repository.ZarizeniRepository;
import com.idas2.zdravotnisystem.db.view.ZarizeniView;
import com.idas2.zdravotnisystem.form.zarizeni.TypZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.TypZarizeniUpdateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniCreateForm;
import com.idas2.zdravotnisystem.form.zarizeni.ZarizeniUpdateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;


@Service
public class ZarizeniFormServiceImpl implements ZarizeniFormService {

    private final ZarizeniRepository zarizeniRepository;
    private final TypZarizeniRepository typZarizeniRepository;

    @Autowired
    public ZarizeniFormServiceImpl(
        ZarizeniRepository zarizeniRepository,
        TypZarizeniRepository typZarizeniRepository
    ) {
        this.zarizeniRepository = zarizeniRepository;
        this.typZarizeniRepository = typZarizeniRepository;
    }

    @Override
    public void create(@NotNull ZarizeniCreateForm form) {

        ZarizeniView view = new ZarizeniView();

        Boolean jeFunkcni =
            Objects.nonNull(form.getJeFunkcni()) && form.getJeFunkcni().equals("on");

        view
            .setNazev(form.getNazev())
            .setZnacka(form.getZnacka())
            .setDatumVyroby(Date.valueOf(form.getDatumVyroby()))
            .setJeFunkcni(jeFunkcni)
            .setIdMistnost(form.getIdMistnost())
            .setIdTypZarizeni(form.getIdTypZarizeni());


        zarizeniRepository.saveFromView(view);
    }

    @Override
    public @NotNull ZarizeniUpdateForm buildUpdateForm(@NotNull ZarizeniView view) {

        String jeFunkcni = view.getJeFunkcni() ? "on" : "";

        return new ZarizeniUpdateForm()
            .setId(view.getId())
            .setNazev(view.getNazev())
            .setZnacka(view.getZnacka())
            .setDatumVyroby(view.getDatumVyroby().toString())
            .setJeFunkcni(jeFunkcni)
            .setIdMistnost(view.getIdMistnost())
            .setIdTypZarizeni(view.getIdTypZarizeni());
    }

    @Override
    public void update(@NotNull ZarizeniUpdateForm form) {
        ZarizeniView view = new ZarizeniView();

        Boolean jeFunkcni =
            Objects.nonNull(form.getJeFunkcni()) && form.getJeFunkcni().equals("on");

        view
            .setId(form.getId())
            .setNazev(form.getNazev())
            .setZnacka(form.getZnacka())
            .setDatumVyroby(Date.valueOf(form.getDatumVyroby()))
            .setJeFunkcni(jeFunkcni)
            .setIdMistnost(form.getIdMistnost())
            .setIdTypZarizeni(form.getIdTypZarizeni());


        zarizeniRepository.saveFromView(view);
    }

    @Override
    public void createTyp(@NotNull TypZarizeniCreateForm form) {

        TypZarizeni entity = new TypZarizeni();

        entity
            .setNazev(form.getNazev())
            .setCilenePouziti(form.getCilenePouziti())
            .setPopis(form.getPopis());

        typZarizeniRepository.save(entity);
    }

    @Override
    public @NotNull TypZarizeniUpdateForm buildUpdateTypForm(
        @NotNull TypZarizeni typZarizeni
    ) {
        return new TypZarizeniUpdateForm()
            .setNazev(typZarizeni.getNazev())
            .setCilenePouziti(typZarizeni.getCilenePouziti())
            .setPopis(typZarizeni.getPopis());
    }

    @Override
    public void updateTyp(@NotNull TypZarizeniUpdateForm form) {
        TypZarizeni entity = new TypZarizeni();

        entity
            .setNazev(form.getNazev())
            .setCilenePouziti(form.getCilenePouziti())
            .setPopis(form.getPopis())
            .setId(form.getId());

        typZarizeniRepository.save(entity);
    }
}
