package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.repository.PacientRepository;
import com.idas2.zdravotnisystem.db.repository.PojisteniRepository;
import com.idas2.zdravotnisystem.db.repository.ZdravotniKartaRepository;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarKartaUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarPacientUpdateForm;
import com.idas2.zdravotnisystem.form.uzivatel.lekar.LekarPojisteniForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class LekarPacientFormServiceImpl implements LekarPacientFormService {

    private final PacientRepository pacientRepository;
    private final PojisteniRepository pojisteniRepository;
    private final ZdravotniKartaRepository kartaRepository;

    @Autowired
    public LekarPacientFormServiceImpl(
        PacientRepository pacientRepository,
        PojisteniRepository pojisteniRepository,
        ZdravotniKartaRepository kartaRepository
    ) {
        this.pacientRepository = pacientRepository;
        this.pojisteniRepository = pojisteniRepository;
        this.kartaRepository = kartaRepository;
    }

    @Override
    public @NotNull LekarKartaUpdateForm buildKartaForm(
        @NotNull ZdravortniKarta source,
        @NotNull LekarKartaUpdateForm target
    ) {
        return target
            .setPlatnostOd(source.getKartaOd().toString())
            .setPlatnostDo(source.getKartaDo().toString());
    }

    @Override
    public void updateKartaForm(
        @NotNull Integer pacientId,
        @NotNull LekarKartaUpdateForm source
    ) {
        ZdravortniKarta karta = kartaRepository.findByPacientId(pacientId);

        karta
            .setKartaOd(Date.valueOf(source.getPlatnostOd()).toLocalDate())
            .setKartaDo(Date.valueOf(source.getPlatnostDo()).toLocalDate());

        kartaRepository.updateByEntity(karta);
    }

    @Override
    public @NotNull LekarPojisteniForm buildPojisteniForm(
        @NotNull Pojisteni source,
        @NotNull LekarPojisteniForm target
    ) {
        return target
            .setCisloKarty(source.getCisloKarty())
            .setCisloSmlouvy(source.getCisloSmlouvy())
            .setPojistnaCastka(source.getPojistnaCastka())
            .setPojisteniOd(source.getPojisteniOd().toString())
            .setPojisteniDo(source.getPojisteniDo().toString())
            .setPojistovnaIdPojistovna(source.getPojistovnaIdPojistovna())
            .setZdravotniKartaIdKarta(source.getZdravotniKartaIdKarta());

    }

    @Override
    public @NotNull void updatePojisteniForm(
        @NotNull Integer zdravotniKartaId,
        @NotNull LekarPojisteniForm source
    ) {
        Pojisteni pojisteni =
            pojisteniRepository.findByZdravorniKartaId(zdravotniKartaId);

        pojisteni
            .setCisloKarty(source.getCisloKarty())
            .setCisloSmlouvy(source.getCisloSmlouvy())
            .setPojistnaCastka(source.getPojistnaCastka())
            .setPojisteniOd(Date.valueOf(source.getPojisteniOd()).toLocalDate())
            .setPojisteniDo(Date.valueOf(source.getPojisteniDo()).toLocalDate())
            .setPojistovnaIdPojistovna(source.getPojistovnaIdPojistovna())
            .setZdravotniKartaIdKarta(source.getZdravotniKartaIdKarta());

        pojisteniRepository.updateByEntity(pojisteni);
    }

    @Override
    public @NotNull LekarPacientUpdateForm buildPacientForm(
        @NotNull PacientView source,
        @NotNull LekarPacientUpdateForm target
    ) {
        return target
            .setEmail(source.getEmail())
            .setJmeno(source.getJmeno())
            .setPrijmeni(source.getPrijmeni())
            .setAdresa(source.getAdresa())
            .setTelCislo(source.getTelCislo())
            .setRust(source.getRust())
            .setHmotnost(source.getHmotnost())
            .setIdPokoj(source.getPokojIdMistnost())
            .setDatumNarozeni(source.getDatumNarozeni().toLocalDate().toString());

    }

    @Override
    public @NotNull void updatePacientForm(
        @NotNull Integer pacientId,
        @NotNull LekarPacientUpdateForm source
    ) {
        PacientView pacientView =
            pacientRepository.getPacientViewByUzivatelId(pacientId);

        pacientView
            .setJmeno(source.getJmeno())
            .setPrijmeni(source.getPrijmeni())
            .setEmail(source.getEmail())
            .setRust(source.getRust())
            .setHmotnost(source.getHmotnost())
            .setDatumNarozeni(Date.valueOf(source.getDatumNarozeni()))
            .setAdresa(source.getAdresa())
            .setTelCislo(source.getTelCislo())
            .setPokojIdMistnost(source.getIdPokoj());

        pacientRepository.updateByView(pacientView);
    }
}
