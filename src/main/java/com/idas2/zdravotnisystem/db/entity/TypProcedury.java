package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;
import com.idas2.zdravotnisystem.util.Selectable;

import javax.persistence.Entity;

@Entity
public class TypProcedury extends UUIDableTimedEntity<Integer> implements Selectable {

    private static final long serialVersionUID = 4154302640366233948L;

    private String nazev;
    private String popis;

    public String getNazev() {
        return nazev;
    }

    public TypProcedury setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public TypProcedury setPopis(String popis) {
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
