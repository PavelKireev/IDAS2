package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class LogUzivatelView {

    private String text;
    private String tabulka;
    private String telCislo;
    private String prijmeni;
    private String jmeno;
    private String email;
    private String stav;
    private Integer idStav;
    private String akce;
    private Date datum;
    private Integer id;

    public String getText() {
        return text;
    }

    public LogUzivatelView setText(String text) {
        this.text = text;
        return this;
    }

    public String getTabulka() {
        return tabulka;
    }

    public LogUzivatelView setTabulka(String tabulka) {
        this.tabulka = tabulka;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public LogUzivatelView setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LogUzivatelView setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public LogUzivatelView setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LogUzivatelView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStav() {
        return stav;
    }

    public LogUzivatelView setStav(String stav) {
        this.stav = stav;
        return this;
    }

    public Integer getIdStav() {
        return idStav;
    }

    public LogUzivatelView setIdStav(Integer idStav) {
        this.idStav = idStav;
        return this;
    }

    public String getAkce() {
        return akce;
    }

    public LogUzivatelView setAkce(String akce) {
        this.akce = akce;
        return this;
    }

    public Date getDatum() {
        return datum;
    }

    public LogUzivatelView setDatum(Date datum) {
        this.datum = datum;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public LogUzivatelView setId(Integer id) {
        this.id = id;
        return this;
    }
}
