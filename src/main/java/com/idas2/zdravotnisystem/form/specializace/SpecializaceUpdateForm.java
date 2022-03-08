package com.idas2.zdravotnisystem.form.specializace;

public class SpecializaceUpdateForm {

    private Integer id;
    private String nazev;
    private String popis;

    public Integer getId() {
        return id;
    }

    public SpecializaceUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public SpecializaceUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public SpecializaceUpdateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
