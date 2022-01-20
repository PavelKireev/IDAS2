package com.idas2.zdravotnisystem.form.uzivatel.admin;

public class AdminCreateForm {

    private String email;
    private String heslo;
    private String hesloPotvrzeni;

    private String jmeno;
    private String prijmeni;

    private String telCislo;

    public String getEmail() {
        return email;
    }

    public AdminCreateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public AdminCreateForm setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }

    public String getHesloPotvrzeni() {
        return hesloPotvrzeni;
    }

    public AdminCreateForm setHesloPotvrzeni(String hesloPotvrzeni) {
        this.hesloPotvrzeni = hesloPotvrzeni;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public AdminCreateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public AdminCreateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public AdminCreateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }
}
