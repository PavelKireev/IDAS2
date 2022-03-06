package com.idas2.zdravotnisystem.form.zarizeni;

public class TypZarizeniCreateForm {

    private String nazev;
    private String cilenePouziti;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public TypZarizeniCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCilenePouziti() {
        return cilenePouziti;
    }

    public TypZarizeniCreateForm setCilenePouziti(String cilenePouziti) {
        this.cilenePouziti = cilenePouziti;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public TypZarizeniCreateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
