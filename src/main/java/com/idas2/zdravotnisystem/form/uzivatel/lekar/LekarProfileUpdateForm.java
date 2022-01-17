package com.idas2.zdravotnisystem.form.uzivatel.lekar;

public class LekarProfileUpdateForm {

    private String email;
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private byte[] obrazek;
    private Integer plat;
    private String kancelarNazev;
    private String kancelarCislo;
    private String specializaceNazev;

    public String getEmail() {
        return email;
    }

    public LekarProfileUpdateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public LekarProfileUpdateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LekarProfileUpdateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public LekarProfileUpdateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public byte[] getObrazek() {
        return obrazek;
    }

    public LekarProfileUpdateForm setObrazek(byte[] obrazek) {
        this.obrazek = obrazek;
        return this;
    }

    public Integer getPlat() {
        return plat;
    }

    public LekarProfileUpdateForm setPlat(Integer plat) {
        this.plat = plat;
        return this;
    }

    public String getKancelarNazev() {
        return kancelarNazev;
    }

    public LekarProfileUpdateForm setKancelarNazev(String kancelarNazev) {
        this.kancelarNazev = kancelarNazev;
        return this;
    }

    public String getKancelarCislo() {
        return kancelarCislo;
    }

    public LekarProfileUpdateForm setKancelarCislo(String kancelarCislo) {
        this.kancelarCislo = kancelarCislo;
        return this;
    }

    public String getSpecializaceNazev() {
        return specializaceNazev;
    }

    public LekarProfileUpdateForm setSpecializaceNazev(String specializaceNazev) {
        this.specializaceNazev = specializaceNazev;
        return this;
    }
}
