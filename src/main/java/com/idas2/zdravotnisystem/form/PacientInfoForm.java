package com.idas2.zdravotnisystem.form;

public class PacientInfoForm {

    private String telCislo;
    private String adresa;

    public String getTelCislo() {
        return telCislo;
    }

    public PacientInfoForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public PacientInfoForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }
}
