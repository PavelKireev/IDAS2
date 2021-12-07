package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class NemocnicniPokoj extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = 6456212599042658317L;

    private String nazev;
    private String cislo;
    private String plocha;
    private Integer kapacita;
    private Integer pocetPacientu;

    public String getNazev() {
        return nazev;
    }

    public NemocnicniPokoj setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public NemocnicniPokoj setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public NemocnicniPokoj setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Integer getKapacita() {
        return kapacita;
    }

    public NemocnicniPokoj setKapacita(Integer kapacita) {
        this.kapacita = kapacita;
        return this;
    }

    public Integer getPocetPacientu() {
        return pocetPacientu;
    }

    public NemocnicniPokoj setPocetPacientu(Integer pocetPacientu) {
        this.pocetPacientu = pocetPacientu;
        return this;
    }
}
