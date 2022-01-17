package com.idas2.zdravotnisystem.form.mistnost.ordinace;

public class OrdinaceUpdateForm {

    private Integer id;
    private String nazev;
    private String cislo;
    private String plocha;
    private String jeVProvozu;

    public Integer getId() {
        return id;
    }

    public OrdinaceUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public OrdinaceUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public OrdinaceUpdateForm setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public OrdinaceUpdateForm setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public String getJeVProvozu() {
        return jeVProvozu;
    }

    public OrdinaceUpdateForm setJeVProvozu(String jeVProvozu) {
        this.jeVProvozu = jeVProvozu;
        return this;
    }
}
