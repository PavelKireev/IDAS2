package com.idas2.zdravotnisystem.form.pojistovna;

public class PojistovnaUpdateForm {

    private Integer id;
    private String nazev;
    private String adresa;
    private String telCislo;

    public Integer getId() {
        return id;
    }

    public PojistovnaUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public PojistovnaUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public PojistovnaUpdateForm setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public PojistovnaUpdateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }
}
