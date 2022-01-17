package com.idas2.zdravotnisystem.service.form;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.entity.Pojisteni;
import com.idas2.zdravotnisystem.db.entity.User;
import com.idas2.zdravotnisystem.db.entity.ZdravortniKarta;
import com.idas2.zdravotnisystem.db.repository.*;
import com.idas2.zdravotnisystem.db.view.PacientView;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientInfoForm;
import com.idas2.zdravotnisystem.form.uzivatel.pacient.PacientSignUpForm;
import com.idas2.zdravotnisystem.util.TimeUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class PacientFormServiceImpl implements PacientFormService {

    private final PasswordEncoder encoder;
    private final PacientRepository pacientRepository;
    private final UzivatelRepository uzivatelRepository;
    private final PojisteniRepository pojisteniRepository;
    private final HospitalizaceRepository hospitalizaceRepository;
    private final ZdravotniKartaRepository zdravotniKartaRepository;

    @Autowired
    public PacientFormServiceImpl(
        PasswordEncoder encoder,
        PacientRepository pacientRepository,
        UzivatelRepository uzivatelRepository,
        PojisteniRepository pojisteniRepository,
        HospitalizaceRepository hospitalizaceRepository,
        ZdravotniKartaRepository zdravotniKartaRepository
    ) {
        this.encoder = encoder;
        this.pacientRepository = pacientRepository;
        this.uzivatelRepository = uzivatelRepository;
        this.pojisteniRepository = pojisteniRepository;
        this.hospitalizaceRepository = hospitalizaceRepository;
        this.zdravotniKartaRepository = zdravotniKartaRepository;
    }


    @NotNull
    @Override
    public PacientInfoForm buildInfoFormFromView(
        @NotNull PacientInfoForm target,
        @NotNull PacientView source
    ) {
        return target
            .setAdresa(source.getAdresa())
            .setTelCislo(source.getTelCislo());
    }

    @Override
    public @NotNull PacientInfoForm buildInfoFormFromView(
        @NotNull PacientView source
    ) {
        return buildInfoFormFromView(new PacientInfoForm(), source);
    }

    @Override
    public void updateProfileInfo(
        @NotNull String userUuid,
        @NotNull PacientInfoForm form
    ) {
        User user =
            uzivatelRepository.findByUuid(userUuid)
                .setAdresa(form.getAdresa())
                .setTelCislo(form.getTelCislo());

        uzivatelRepository.update(user);
    }


    @Override
    public void updateInfoPaient(
        @NotNull Integer pacientId,
        @NotNull PacientInfoForm pacientInfoForm
    ) {
        PacientView view =
            pacientRepository.getPacientViewByUzivatelId(pacientId);

        view
            .setAdresa(pacientInfoForm.getAdresa())
            .setTelCislo(pacientInfoForm.getTelCislo());

        pacientRepository.updateByView(view);
    }

    @Override
    public void signUp(
        @NotNull PacientSignUpForm form
    ) {
        PacientView view = new PacientView();

        view
            .setEmail(form.getEmail())
            .setPassword(encoder.encode(form.getHeslo()))
            .setJmeno(form.getJmeno())
            .setPrijmeni(form.getPrijmeni())
            .setTelCislo(form.getTelCislo())
            .setAdresa(form.getAdresa())
            .setHmotnost(form.getHmotnost())
            .setRust(form.getRust())
            .setDatumNarozeni(
                Date.valueOf(
                    TimeUtil.fromStringSqlLocalDate(form.getDatumNarozeni())
                )
            );

        pacientRepository.updateByView(view);

        User user = uzivatelRepository.findByEmail(view.getEmail());

        ZdravortniKarta zdravortniKarta = new ZdravortniKarta();

        Hospitalizace hospitalizace = new Hospitalizace();

        hospitalizace
            .setDuvod("Neznamy")
            .setStavPacienta("Neznamy")
            .setPacientUzivatelIdUzivatel(user.getId())
            .setHospitalizaceOd(Date.valueOf(LocalDate.now()))
            .setHospitalizaceDo(Date.valueOf(LocalDate.now()));

        hospitalizaceRepository.saveFromEntity(hospitalizace);

        zdravortniKarta
            .setKartaOd(LocalDate.now().plusDays(1))
            .setKartaDo(LocalDate.now().plusYears(2L))
            .setPacientUzivatelIdUzivatel(user.getId());

        zdravotniKartaRepository.updateByEntity(zdravortniKarta);

        ZdravortniKarta karta = zdravotniKartaRepository.findByPacientId(user.getId());

        Pojisteni pojisteni = new Pojisteni();

        pojisteni
            .setCisloKarty("Nezname")
            .setCisloSmlouvy("Nezname")
            .setPojistnaCastka(0)
            .setPojisteniOd(LocalDate.now())
            .setPojisteniDo(LocalDate.now().plusYears(1))
            .setPojistovnaIdPojistovna(1)
            .setZdravotniKartaIdKarta(karta.getId());

        pojisteniRepository.updateByEntity(pojisteni);

    }


}
