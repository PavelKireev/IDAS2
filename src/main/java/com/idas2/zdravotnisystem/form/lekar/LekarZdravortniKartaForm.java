package com.idas2.zdravotnisystem.form.lekar;

import java.time.LocalDate;

public class LekarZdravortniKartaForm {

    private LocalDate kartaOd;
    private LocalDate kartaDo;
    private Integer pacientUzivatelIdUzivatel;

    public LocalDate getKartaOd() {
        return kartaOd;
    }

    public LekarZdravortniKartaForm setKartaOd(LocalDate kartaOd) {
        this.kartaOd = kartaOd;
        return this;
    }

    public LocalDate getKartaDo() {
        return kartaDo;
    }

    public LekarZdravortniKartaForm setKartaDo(LocalDate kartaDo) {
        this.kartaDo = kartaDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public LekarZdravortniKartaForm setPacientUzivatelIdUzivatel(
        Integer pacientUzivatelIdUzivatel
    ) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }
}
