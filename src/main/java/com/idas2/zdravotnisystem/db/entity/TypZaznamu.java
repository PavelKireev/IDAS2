package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableEntity;

import javax.persistence.Entity;

@Entity
public class TypZaznamu extends UUIDableEntity<Integer> {

    private static final long serialVersionUID = -47868262181974978L;

    private String nazev;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public TypZaznamu setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public TypZaznamu setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
