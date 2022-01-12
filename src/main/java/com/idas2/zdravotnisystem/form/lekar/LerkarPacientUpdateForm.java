package com.idas2.zdravotnisystem.form.lekar;

public class LerkarPacientUpdateForm {

    private String jmeno;
    private String prijmeni;

    private String email;
    private String adresa;

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
}
