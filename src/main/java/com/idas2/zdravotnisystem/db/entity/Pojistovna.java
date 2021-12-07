package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class Pojistovna extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -2379914720466367824L;

    private String nazev;
    private String adresa;
    private String telCislo;

    public String getNazev() {
        return nazev;
    }

    public Pojistovna setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public Pojistovna setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public Pojistovna setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }
}
