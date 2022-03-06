package com.idas2.zdravotnisystem.form.zarizeni;

public class TypZarizeniUpdateForm {

    private Integer id;
    private String nazev;
    private String cilenePouziti;
    private String popis;

    public Integer getId() {
        return id;
    }

    public TypZarizeniUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public TypZarizeniUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCilenePouziti() {
        return cilenePouziti;
    }

    public TypZarizeniUpdateForm setCilenePouziti(String cilenePouziti) {
        this.cilenePouziti = cilenePouziti;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public TypZarizeniUpdateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
