package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity(name = "OBRAZEK")
public class Obrazek extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = 1964617825893362988L;

    private byte[] data;
    private String nazev;
    private String pripona;
    private LocalDate datum;


    public byte[] getData() {
        return data;
    }

    public Obrazek setData(byte[] data) {
        this.data = data;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public Obrazek setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPripona() {
        return pripona;
    }

    public Obrazek setPripona(String pripona) {
        this.pripona = pripona;
        return this;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Obrazek setDatum(LocalDate datum) {
        this.datum = datum;
        return this;
    }
}
