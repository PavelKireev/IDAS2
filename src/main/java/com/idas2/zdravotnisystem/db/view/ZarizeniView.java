package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class ZarizeniView {

    private Integer id;
    private String nazev;
    private String znacka;
    private Date datumVyroby;
    private Boolean jeFunkcni;

    private Integer idMistnost;
    private Integer ordinaceCislo;
    private String ordinaceNazev;

    private Integer idTypZarizeni;
    private String typZarizeniNazev;

    public Integer getId() {
        return id;
    }

    public ZarizeniView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public ZarizeniView setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getZnacka() {
        return znacka;
    }

    public ZarizeniView setZnacka(String znacka) {
        this.znacka = znacka;
        return this;
    }

    public Date getDatumVyroby() {
        return datumVyroby;
    }

    public ZarizeniView setDatumVyroby(Date datumVyroby) {
        this.datumVyroby = datumVyroby;
        return this;
    }

    public Boolean getJeFunkcni() {
        return jeFunkcni;
    }

    public ZarizeniView setJeFunkcni(Boolean jeFunkcni) {
        this.jeFunkcni = jeFunkcni;
        return this;
    }

    public Integer getIdMistnost() {
        return idMistnost;
    }

    public ZarizeniView setIdMistnost(Integer idMistnost) {
        this.idMistnost = idMistnost;
        return this;
    }

    public Integer getOrdinaceCislo() {
        return ordinaceCislo;
    }

    public ZarizeniView setOrdinaceCislo(Integer ordinaceCislo) {
        this.ordinaceCislo = ordinaceCislo;
        return this;
    }

    public String getOrdinaceNazev() {
        return ordinaceNazev;
    }

    public ZarizeniView setOrdinaceNazev(String ordinaceNazev) {
        this.ordinaceNazev = ordinaceNazev;
        return this;
    }

    public Integer getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ZarizeniView setIdTypZarizeni(Integer idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }

    public String getTypZarizeniNazev() {
        return typZarizeniNazev;
    }

    public ZarizeniView setTypZarizeniNazev(String typZarizeniNazev) {
        this.typZarizeniNazev = typZarizeniNazev;
        return this;
    }
}
