package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Pacient extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -4467704788003760961L;

    private Integer uzivatelIdUzivatel;
    private Integer rust;
    private Integer hmotnost;
    private LocalDateTime datumNarozeni;
    private Integer nemocnicniPokojIdMistnost;
    private String adresa;

    public Integer getUzivatelIdUzivatel() {
        return uzivatelIdUzivatel;
    }

    public Pacient setUzivatelIdUzivatel(Integer uzivatelIdUzivatel) {
        this.uzivatelIdUzivatel = uzivatelIdUzivatel;
        return this;
    }

    public Integer getRust() {
        return rust;
    }

    public Pacient setRust(Integer rust) {
        this.rust = rust;
        return this;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }

    public Pacient setHmotnost(Integer hmotnost) {
        this.hmotnost = hmotnost;
        return this;
    }

    public LocalDateTime getDatumNarozeni() {
        return datumNarozeni;
    }

    public Pacient setDatumNarozeni(LocalDateTime datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
        return this;
    }

    public Integer getNemocnicniPokojIdMistnost() {
        return nemocnicniPokojIdMistnost;
    }

    public Pacient setNemocnicniPokojIdMistnost(Integer nemocnicniPokojIdMistnost) {
        this.nemocnicniPokojIdMistnost = nemocnicniPokojIdMistnost;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public Pacient setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }
}
