package com.idas2.zdravotnisystem.form.procedura.typ;

public class ProceduraTypUpdateForm {

    private Integer id;
    private String nazev;
    private String popis;

    public Integer getId() {
        return id;
    }

    public ProceduraTypUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public ProceduraTypUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public ProceduraTypUpdateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }
}
