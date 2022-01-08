package com.idas2.zdravotnisystem.form;

public class ProceduraCreateForm {

    private String datum;
    private String popis;
    private String hospitalizace;
    private String idTypProcedury;
    private String idTypZarizeni;
    private String idLekar;

    public String getDatum() {
        return datum;
    }

    public ProceduraCreateForm setDatum(String datum) {
        this.datum = datum;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public ProceduraCreateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }

    public String getHospitalizace() {
        return hospitalizace;
    }

    public ProceduraCreateForm setHospitalizace(String hospitalizace) {
        this.hospitalizace = hospitalizace;
        return this;
    }

    public String getIdTypProcedury() {
        return idTypProcedury;
    }

    public ProceduraCreateForm setIdTypProcedury(String idTypProcedury) {
        this.idTypProcedury = idTypProcedury;
        return this;
    }

    public String getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ProceduraCreateForm setIdTypZarizeni(String idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }

    public String getIdLekar() {
        return idLekar;
    }

    public ProceduraCreateForm setIdLekar(String idLekar) {
        this.idLekar = idLekar;
        return this;
    }
}
