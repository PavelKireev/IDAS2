package com.idas2.zdravotnisystem.form.uzivatel.pacient;

public class PacientSignUpForm {

    private String email;
    private String heslo;
    private String confirmHeslo;

    private String jmeno;
    private String prijmeni;

    private String adresa;
    private String telCislo;

    private Integer rust;
    private Integer hmotnost;

    private String datumNarozeni;

    public String getEmail() {
        return email;
    }

    public PacientSignUpForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public PacientSignUpForm setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getAdresa() {
        return adresa;
    }

    public PacientSignUpForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public PacientSignUpForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public PacientSignUpForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public PacientSignUpForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public Integer getRust() {
        return rust;
    }

    public PacientSignUpForm setRust(Integer rust) {
        this.rust = rust;
        return this;
    }

    public String getConfirmHeslo() {
        return confirmHeslo;
    }

    public PacientSignUpForm setConfirmHeslo(String confirmHeslo) {
        this.confirmHeslo = confirmHeslo;
        return this;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }

    public PacientSignUpForm setHmotnost(Integer hmotnost) {
        this.hmotnost = hmotnost;
        return this;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public PacientSignUpForm setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
        return this;
    }
}
