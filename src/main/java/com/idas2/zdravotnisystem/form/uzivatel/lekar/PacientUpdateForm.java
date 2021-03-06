package com.idas2.zdravotnisystem.form.uzivatel.lekar;

public class PacientUpdateForm {

    private String email;

    private String jmeno;
    private String prijmeni;

    private String adresa;
    private String telCislo;

    private Integer rust;
    private Integer hmotnost;

    private String datumNarozeni;

    private Integer idPokoj;



    public String getJmeno() {
        return jmeno;
    }

    public PacientUpdateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public PacientUpdateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PacientUpdateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public PacientUpdateForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public PacientUpdateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public Integer getRust() {
        return rust;
    }

    public PacientUpdateForm setRust(Integer rust) {
        this.rust = rust;
        return this;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }

    public PacientUpdateForm setHmotnost(Integer hmotnost) {
        this.hmotnost = hmotnost;
        return this;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public PacientUpdateForm setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
        return this;
    }

    public Integer getIdPokoj() {
        return idPokoj;
    }

    public PacientUpdateForm setIdPokoj(Integer idPokoj) {
        this.idPokoj = idPokoj;
        return this;
    }
}
