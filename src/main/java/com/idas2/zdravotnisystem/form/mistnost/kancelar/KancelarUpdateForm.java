package com.idas2.zdravotnisystem.form.mistnost.kancelar;

public class KancelarUpdateForm {

    private Integer id;
    private String nazev;
    private Integer cislo;
    private String plocha;
    private Boolean jeObsazena;

    public Integer getId() {
        return id;
    }

    public KancelarUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public KancelarUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public Integer getCislo() {
        return cislo;
    }

    public KancelarUpdateForm setCislo(Integer cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public KancelarUpdateForm setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Boolean getJeObsazena() {
        return jeObsazena;
    }

    public KancelarUpdateForm setJeObsazena(Boolean jeObsazena) {
        this.jeObsazena = jeObsazena;
        return this;
    }
}
