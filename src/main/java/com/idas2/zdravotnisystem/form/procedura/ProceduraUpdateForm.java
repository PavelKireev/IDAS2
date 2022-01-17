package com.idas2.zdravotnisystem.form.procedura;

public class ProceduraUpdateForm {

    private Integer id;
    private String datum;
    private String popis;
    private String hospitalizace;
    private String idTypProcedury;
    private String idZarizeni;
    private String idLekar;

    public Integer getId() {
        return id;
    }

    public ProceduraUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDatum() {
        return datum;
    }

    public ProceduraUpdateForm setDatum(String datum) {
        this.datum = datum;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public ProceduraUpdateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }

    public String getHospitalizace() {
        return hospitalizace;
    }

    public ProceduraUpdateForm setHospitalizace(String hospitalizace) {
        this.hospitalizace = hospitalizace;
        return this;
    }

    public String getIdTypProcedury() {
        return idTypProcedury;
    }

    public ProceduraUpdateForm setIdTypProcedury(String idTypProcedury) {
        this.idTypProcedury = idTypProcedury;
        return this;
    }

    public String getIdZarizeni() {
        return idZarizeni;
    }

    public ProceduraUpdateForm setIdZarizeni(String idZarizeni) {
        this.idZarizeni = idZarizeni;
        return this;
    }

    public String getIdLekar() {
        return idLekar;
    }

    public ProceduraUpdateForm setIdLekar(String idLekar) {
        this.idLekar = idLekar;
        return this;
    }
}
