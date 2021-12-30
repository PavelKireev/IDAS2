package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableEntity;
import com.idas2.zdravotnisystem.util.Selectable;

import javax.persistence.Entity;

@Entity
public class TypZarizeni extends UUIDableEntity<Integer> implements Selectable {

    private static final long serialVersionUID = -4312497881495843951L;

    private String nazev;
    private String cilenePouziti;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public TypZarizeni setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCilenePouziti() {
        return cilenePouziti;
    }

    public TypZarizeni setCilenePouziti(String cilenePouziti) {
        this.cilenePouziti = cilenePouziti;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public TypZarizeni setPopis(String popis) {
        this.popis = popis;
        return this;
    }

    @Override
    public String getSelectorId() {
        return getId().toString();
    }

    @Override
    public String getSelectorTitle() {
        return getNazev();
    }
}
