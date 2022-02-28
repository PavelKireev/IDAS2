package com.idas2.zdravotnisystem.form.procedura.typ;

public class ProceduraTypCreateForm {

    private String nazev;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public ProceduraTypCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public ProceduraTypCreateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
