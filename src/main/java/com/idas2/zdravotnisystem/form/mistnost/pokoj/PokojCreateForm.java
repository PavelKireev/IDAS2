package com.idas2.zdravotnisystem.form.mistnost.pokoj;

public class PokojCreateForm {

    private String nazev;
    private String cislo;
    private String plocha;
    private Integer kapacita;
    private Integer pocetPacientu;

    public String getNazev() {
        return nazev;
    }

    public PokojCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public PokojCreateForm setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public PokojCreateForm setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Integer getKapacita() {
        return kapacita;
    }

    public PokojCreateForm setKapacita(Integer kapacita) {
        this.kapacita = kapacita;
        return this;
    }

    public Integer getPocetPacientu() {
        return pocetPacientu;
    }

    public PokojCreateForm setPocetPacientu(Integer pocetPacientu) {
        this.pocetPacientu = pocetPacientu;
        return this;
    }
}
