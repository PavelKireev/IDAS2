package com.idas2.zdravotnisystem.form.mistnost.ordinace;

public class OrdinaceCreateForm {

    private String nazev;
    private String cislo;
    private String plocha;
    private String jeVProvozu;

    public String getNazev() {
        return nazev;
    }

    public OrdinaceCreateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getCislo() {
        return cislo;
    }

    public OrdinaceCreateForm setCislo(String cislo) {
        this.cislo = cislo;
        return this;
    }

    public String getPlocha() {
        return plocha;
    }

    public OrdinaceCreateForm setPlocha(String plocha) {
        this.plocha = plocha;
        return this;
    }

    public String getJeVProvozu() {
        return jeVProvozu;
    }

    public OrdinaceCreateForm setJeVProvozu(String jeVProvozu) {
        this.jeVProvozu = jeVProvozu;
        return this;
    }
}
