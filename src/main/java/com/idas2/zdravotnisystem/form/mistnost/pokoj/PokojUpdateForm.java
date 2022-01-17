package com.idas2.zdravotnisystem.form.mistnost.pokoj;

public class PokojUpdateForm {

    private Integer id;
    private String nazev;
    private String cislo;
    private String plocha;
    private Integer kapacite;
    private Integer pocetPacientu;

    public Integer getId() {
        return id;
    }

    public PokojUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public PokojUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public PokojUpdateForm setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public PokojUpdateForm setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Integer getKapacite() {
        return kapacite;
    }

    public PokojUpdateForm setKapacite(Integer kapacite) {
        this.kapacite = kapacite;
        return this;
    }

    public Integer getPocetPacientu() {
        return pocetPacientu;
    }

    public PokojUpdateForm setPocetPacientu(Integer pocetPacientu) {
        this.pocetPacientu = pocetPacientu;
        return this;
    }
}
