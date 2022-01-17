package com.idas2.zdravotnisystem.form.mistnost.kancelar;

public class KancelarCreateForm {

    private String nazev;
    private Integer cislo;
    private String plocha;
    private String jeObsazena;

    public String getNazev() {
        return nazev;
    }

    public KancelarCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public Integer getCislo() {
        return cislo;
    }

    public KancelarCreateForm setCislo(Integer cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public KancelarCreateForm setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public String getJeObsazena() {
        return jeObsazena;
    }

    public KancelarCreateForm setJeObsazena(String jeObsazena) {
        this.jeObsazena = jeObsazena;
        return this;
    }
}
