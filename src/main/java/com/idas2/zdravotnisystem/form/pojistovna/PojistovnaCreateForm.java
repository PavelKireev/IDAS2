package com.idas2.zdravotnisystem.form.pojistovna;

public class PojistovnaCreateForm {

    private String nazev;
    private String adresa;
    private String telCislo;

    public String getNazev() {
        return nazev;
    }

    public PojistovnaCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public PojistovnaCreateForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public PojistovnaCreateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }
}
