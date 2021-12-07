package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class Specializace extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = 843597610035439659L;

    private String nazev;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public Specializace setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public Specializace setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
