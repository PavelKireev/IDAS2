package com.idas2.zdravotnisystem.form.uzivatel.lekar;

public class LekarZdravortniKartaForm {

    private String kartaOd;
    private String kartaDo;
    private Integer pacientUzivatelIdUzivatel;

    public String getKartaOd() {
        return kartaOd;
    }

    public LekarZdravortniKartaForm setKartaOd(String kartaOd) {
        this.kartaOd = kartaOd;
        return this;
    }

    public String getKartaDo() {
        return kartaDo;
    }

    public LekarZdravortniKartaForm setKartaDo(String kartaDo) {
        this.kartaDo = kartaDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public LekarZdravortniKartaForm setPacientUzivatelIdUzivatel(Integer pacientUzivatelIdUzivatel) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }
}
