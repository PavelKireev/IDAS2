package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Zarizeni extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -1182832341277995623L;

    private String nazev;
    private String znacka;
    private LocalDateTime datumVyroby;
    private Boolean jeFunkcni;

    private Integer ordinaceIdMistnost;
    private Integer typZarizeniIdTypZarizeni;

    public String getNazev() {
        return nazev;
    }

    public Zarizeni setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getZnacka() {
        return znacka;
    }

    public Zarizeni setZnacka(String znacka) {
        this.znacka = znacka;
        return this;
    }

    public LocalDateTime getDatumVyroby() {
        return datumVyroby;
    }

    public Zarizeni setDatumVyroby(LocalDateTime datumVyroby) {
        this.datumVyroby = datumVyroby;
        return this;
    }

    public Boolean getJeFunkcni() {
        return jeFunkcni;
    }

    public Zarizeni setJeFunkcni(Boolean jeFunkcni) {
        this.jeFunkcni = jeFunkcni;
        return this;
    }

    public Integer getOrdinaceIdMistnost() {
        return ordinaceIdMistnost;
    }

    public Zarizeni setOrdinaceIdMistnost(Integer ordinaceIdMistnost) {
        this.ordinaceIdMistnost = ordinaceIdMistnost;
        return this;
    }

    public Integer getTypZarizeniIdTypZarizeni() {
        return typZarizeniIdTypZarizeni;
    }

    public Zarizeni setTypZarizeniIdTypZarizeni(Integer typZarizeniIdTypZarizeni) {
        this.typZarizeniIdTypZarizeni = typZarizeniIdTypZarizeni;
        return this;
    }
}
