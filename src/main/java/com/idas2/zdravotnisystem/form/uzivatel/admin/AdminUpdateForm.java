package com.idas2.zdravotnisystem.form.uzivatel.admin;

public class AdminUpdateForm {

    private Integer id;

    private String email;

    private String jmeno;
    private String prijmeni;

    private String telCislo;

    public Integer getId() {
        return id;
    }

    public AdminUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AdminUpdateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public AdminUpdateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public AdminUpdateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public AdminUpdateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }
}
