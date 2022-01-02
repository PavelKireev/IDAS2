package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.sql.Date;

@Entity
public class Log extends UUIDableTimedEntity<Integer> {

    private String akce;
    private String tabulka;
    private Date datum;
    private String text;
    private Integer uzivatelIdUzivatel;
    private Integer odebranyIdOdebranyUzivatel;
    private Integer primarniKlic;

    public String getAkce() {
        return akce;
    }

    public Log setAkce(String akce) {
        this.akce = akce;
        return this;
    }

    public String getTabulka() {
        return tabulka;
    }

    public Log setTabulka(String tabulka) {
        this.tabulka = tabulka;
        return this;
    }

    public String getText() {
        return text;
    }

    public Log setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getUzivatelIdUzivatel() {
        return uzivatelIdUzivatel;
    }

    public Log setUzivatelIdUzivatel(Integer uzivatelIdUzivatel) {
        this.uzivatelIdUzivatel = uzivatelIdUzivatel;
        return this;
    }

    public Integer getOdebranyIdOdebranyUzivatel() {
        return odebranyIdOdebranyUzivatel;
    }

    public Log setOdebranyIdOdebranyUzivatel(Integer odebranyIdOdebranyUzivatel) {
        this.odebranyIdOdebranyUzivatel = odebranyIdOdebranyUzivatel;
        return this;
    }

    public Integer getPrimarniKlic() {
        return primarniKlic;
    }

    public Log setPrimarniKlic(Integer primarniKlic) {
        this.primarniKlic = primarniKlic;
        return this;
    }

    public Date getDatum() {
        return datum;
    }

    public Log setDatum(Date datum) {
        this.datum = datum;
        return this;
    }
}
