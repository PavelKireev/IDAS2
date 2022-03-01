package com.idas2.zdravotnisystem.form.zarizeni;

public class ZarizeniUpdateForm {

    private Integer id;
    private String nazev;
    private String znacka;
    private String datumVyroby;
    private String jeFunkcni;
    private Integer idMistnost;
    private Integer idTypZarizeni;

    public Integer getId() {
        return id;
    }

    public ZarizeniUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public ZarizeniUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getZnacka() {
        return znacka;
    }

    public ZarizeniUpdateForm setZnacka(String znacka) {
        this.znacka = znacka;
        return this;
    }

    public String getDatumVyroby() {
        return datumVyroby;
    }

    public ZarizeniUpdateForm setDatumVyroby(String datumVyroby) {
        this.datumVyroby = datumVyroby;
        return this;
    }

    public String getJeFunkcni() {
        return jeFunkcni;
    }

    public ZarizeniUpdateForm setJeFunkcni(String jeFunkcni) {
        this.jeFunkcni = jeFunkcni;
        return this;
    }

    public Integer getIdMistnost() {
        return idMistnost;
    }

    public ZarizeniUpdateForm setIdMistnost(Integer idMistnost) {
        this.idMistnost = idMistnost;
        return this;
    }

    public Integer getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ZarizeniUpdateForm setIdTypZarizeni(Integer idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }
}
