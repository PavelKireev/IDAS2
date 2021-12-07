package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class Ordinace extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -8110224127642192368L;

    private String nazev;
    private String cislo;
    private String plocha;
    private Boolean jeVProvozu;

    public String getNazev() {
        return nazev;
    }

    public Ordinace setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public Ordinace setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public Ordinace setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Boolean getJeVProvozu() {
        return jeVProvozu;
    }

    public Ordinace setJeVProvozu(Boolean jeVProvozu) {
        this.jeVProvozu = jeVProvozu;
        return this;
    }
}
