package com.idas2.zdravotnisystem.db.view;

import com.idas2.zdravotnisystem.util.Selectable;

public class NemocnicniPokojView implements Selectable {

    private Integer id;
    private Integer pocetPacientu;
    private Integer kapacita;
    private String plocha;
    private Integer cislo;
    private String nazev;

    public Integer getId() {
        return id;
    }

    public NemocnicniPokojView setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getPocetPacientu() {
        return pocetPacientu;
    }

    public NemocnicniPokojView setPocetPacientu(Integer pocetPacientu) {
        this.pocetPacientu = pocetPacientu;
        return this;
    }

    public Integer getKapacita() {
        return kapacita;
    }

    public NemocnicniPokojView setKapacita(Integer kapacita) {
        this.kapacita = kapacita;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public NemocnicniPokojView setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Integer getCislo() {
        return cislo;
    }

    public NemocnicniPokojView setCislo(Integer cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public NemocnicniPokojView setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    @Override
    public String getSelectorId() {
        return getId().toString();
    }

    @Override
    public String getSelectorTitle() {
        return String.format("%s %s", getCislo(), getNazev());
    }
}
