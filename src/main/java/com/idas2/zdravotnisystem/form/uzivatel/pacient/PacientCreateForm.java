package com.idas2.zdravotnisystem.form.uzivatel.pacient;

import java.sql.Date;

public class PacientCreateForm {

    private String email;
    private String heslo;
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private String adresa;
    private byte[] obrazek;
    private Integer rust;
    private Integer hmotnost;
    private Date datumNarozeni;
    private Integer idOtec;
    private Integer idMatka;

    public String getEmail() {
        return email;
    }

    public PacientCreateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public PacientCreateForm setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public PacientCreateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public PacientCreateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public PacientCreateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public PacientCreateForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public byte[] getObrazek() {
        return obrazek;
    }

    public PacientCreateForm setObrazek(byte[] obrazek) {
        this.obrazek = obrazek;
        return this;
    }

    public Integer getRust() {
        return rust;
    }

    public PacientCreateForm setRust(Integer rust) {
        this.rust = rust;
        return this;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }

    public PacientCreateForm setHmotnost(Integer hmotnost) {
        this.hmotnost = hmotnost;
        return this;
    }

    public Date getDatumNarozeni() {
        return datumNarozeni;
    }

    public PacientCreateForm setDatumNarozeni(Date datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
        return this;
    }

    public Integer getIdOtec() {
        return idOtec;
    }

    public PacientCreateForm setIdOtec(Integer idOtec) {
        this.idOtec = idOtec;
        return this;
    }

    public Integer getIdMatka() {
        return idMatka;
    }

    public PacientCreateForm setIdMatka(Integer idMatka) {
        this.idMatka = idMatka;
        return this;
    }
}
