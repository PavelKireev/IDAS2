package com.idas2.zdravotnisystem.db.view;

import com.idas2.zdravotnisystem.util.Selectable;

public class KancelarView implements Selectable {

    private Integer id;

    private String nazev;
    private Integer cislo;

    private String plocha;
    private Boolean jeObsazena;

    public Integer getId() {
        return id;
    }

    public KancelarView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public KancelarView setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public Integer getCislo() {
        return cislo;
    }

    public KancelarView setCislo(Integer cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public KancelarView setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Boolean getJeObsazena() {
        return jeObsazena;
    }

    public KancelarView setJeObsazena(Boolean jeObsazena) {
        this.jeObsazena = jeObsazena;
        return this;
    }

    @Override
    public String getSelectorId() {
        return getId().toString();
    }

    @Override
    public String getSelectorTitle() {
        return String.format("%s %s", getCislo(), getNazev());
    }
}
