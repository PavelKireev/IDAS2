package com.idas2.zdravotnisystem.form.lekar;

public class LerkarPacientUpdateForm {

    private String email;

    private String jmeno;
    private String prijmeni;

    private String adresa;
    private String telCislo;

    private Integer rust;
    private Integer hmotnost;

    private String datumNarozeni;



    public String getJmeno() {
        return jmeno;
    }

    public LerkarPacientUpdateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LerkarPacientUpdateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LerkarPacientUpdateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public LerkarPacientUpdateForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public LerkarPacientUpdateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public Integer getRust() {
        return rust;
    }

    public LerkarPacientUpdateForm setRust(Integer rust) {
        this.rust = rust;
        return this;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }

    public LerkarPacientUpdateForm setHmotnost(Integer hmotnost) {
        this.hmotnost = hmotnost;
        return this;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public LerkarPacientUpdateForm setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
        return this;
    }
}
