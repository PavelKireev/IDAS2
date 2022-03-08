package com.idas2.zdravotnisystem.form.specializace;

public class SpecializaceCreateForm {

    private String nazev;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public SpecializaceCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public SpecializaceCreateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
