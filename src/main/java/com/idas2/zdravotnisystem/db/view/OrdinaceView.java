package com.idas2.zdravotnisystem.db.view;

public class OrdinaceView {

    private Integer id;
    private String nazev;
    private Integer cislo;
    private String plocha;
    private Boolean jeVProvozu;

    public Integer getId() {
        return id;
    }

    public OrdinaceView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public OrdinaceView setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public Integer getCislo() {
        return cislo;
    }

    public OrdinaceView setCislo(Integer cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public OrdinaceView setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public Boolean getJeVProvozu() {
        return jeVProvozu;
    }

    public OrdinaceView setJeVProvozu(Boolean jeVProvozu) {
        this.jeVProvozu = jeVProvozu;
        return this;
    }
}
