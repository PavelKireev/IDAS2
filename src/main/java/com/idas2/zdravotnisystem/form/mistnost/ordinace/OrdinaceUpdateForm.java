package com.idas2.zdravotnisystem.form.mistnost.ordinace;

public class OrdinaceUpdateForm {

    private Integer id;
    private String nazev;
    private Integer cislo;
    private String plocha;
    private Boolean jeVProvozu;

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

    public Integer getCislo() {
        return cislo;
    }

    public OrdinaceUpdateForm setCislo(Integer cislo) {
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

    public Boolean getJeVProvozu() {
        return jeVProvozu;
    }

    public OrdinaceUpdateForm setJeVProvozu(Boolean jeVProvozu) {
        this.jeVProvozu = jeVProvozu;
        return this;
    }
}
