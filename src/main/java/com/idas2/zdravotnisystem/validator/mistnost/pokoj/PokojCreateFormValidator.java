package com.idas2.zdravotnisystem.validator.mistnost.pokoj;

import com.idas2.zdravotnisystem.db.entity.NemocnicniPokoj;
import com.idas2.zdravotnisystem.db.repository.NemocnicniPokojRepository;
import com.idas2.zdravotnisystem.form.mistnost.pokoj.PokojCreateForm;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class PokojCreateFormValidator implements Validator {

    private final NemocnicniPokojRepository pokojRepository;

    @Autowired
    public PokojCreateFormValidator(
        NemocnicniPokojRepository pokojRepository
    ) {
        this.pokojRepository = pokojRepository;
    }

    @Override
    public boolean supports(@NotNull Class<?> aClass) {
        return PokojCreateForm.class.isAssignableFrom(aClass)
            || NemocnicniPokoj.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(@NotNull Object o, @NotNull Errors errors) {
        @NotNull PokojCreateForm form = (PokojCreateForm) o;

        if (Objects.isNull(form.getNazev()) || form.getNazev().isEmpty())
            errors.rejectValue("nazev", "", "Nazev nesmi byt prazdny!");

        if (Objects.isNull(form.getCislo()) || form.getCislo().isEmpty())
            errors.rejectValue("cislo", "", "Cislo nesmi byt prazdne!");

        try {
            Integer.parseInt(form.getCislo());

            if (Objects.nonNull(pokojRepository.findByCislo(Integer.parseInt(form.getCislo()))))
                errors.rejectValue("cislo", "", "Zadane cislo pokoje jiz se pouziva");

        } catch (NumberFormatException ex) {
            errors.rejectValue("cislo", "", "Nespravny format!");
        }

        try {
            Integer.parseInt(form.getPlocha());
        } catch (NumberFormatException ex) {
            errors.rejectValue("plocha", "", "Nespravny format!");
        }

        if (Objects.isNull(form.getKapacita()) || form.getKapacita() <= 0)
            errors.rejectValue("kapacita", "", "Kapacita nesmi byt prazdna!");

        if (Objects.isNull(form.getPlocha()) ||
            Integer.parseInt(form.getPlocha()) <= 0 ||
            form.getPlocha().isEmpty()
        ) errors.rejectValue(
            "plocha",
            "",
            "Plocha nesmi byt prazdna anebo mensi nez 1!"
        );

    }

}
