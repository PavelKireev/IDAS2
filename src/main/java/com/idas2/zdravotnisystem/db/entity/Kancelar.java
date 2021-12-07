package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class Kancelar extends UUIDableTimedEntity<Integer> {

    private String nazev;
    private String cislo;
    private String plocha;
    private Boolean jeObsazena;

    public String getNazev() {
        return nazev;
    }

    public Kancelar setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public Kancelar setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public Kancelar setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Boolean getJeObsazena() {
        return jeObsazena;
    }

    public Kancelar setJeObsazena(Boolean jeObsazena) {
        this.jeObsazena = jeObsazena;
        return this;
    }
}
