package com.idas2.zdravotnisystem.form.zarizeni;

public class ZarizeniCreateForm {

    private String nazev;
    private String znacka;
    private String datumVyroby;
    private String jeFunkcni;
    private Integer idMistnost;
    private Integer idTypZarizeni;

    public String getNazev() {
        return nazev;
    }

    public ZarizeniCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getZnacka() {
        return znacka;
    }

    public ZarizeniCreateForm setZnacka(String znacka) {
        this.znacka = znacka;
        return this;
    }

    public String getDatumVyroby() {
        return datumVyroby;
    }

    public ZarizeniCreateForm setDatumVyroby(String datumVyroby) {
        this.datumVyroby = datumVyroby;
        return this;
    }

    public String getJeFunkcni() {
        return jeFunkcni;
    }

    public ZarizeniCreateForm setJeFunkcni(String jeFunkcni) {
        this.jeFunkcni = jeFunkcni;
        return this;
    }

    public Integer getIdMistnost() {
        return idMistnost;
    }

    public ZarizeniCreateForm setIdMistnost(Integer idMistnost) {
        this.idMistnost = idMistnost;
        return this;
    }

    public Integer getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ZarizeniCreateForm setIdTypZarizeni(Integer idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }
}
