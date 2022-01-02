package com.idas2.zdravotnisystem.form;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.entity.TypZarizeni;

import java.time.LocalDate;

public class ProceduraCreateForm {

    private LocalDate datum;
    private String popis;
    private Integer hospitalizace;
    private Integer idTypProcedury;
    private Integer idTypZarizeni;
    private Integer idLekar;

    public LocalDate getDatum() {
        return datum;
    }

    public ProceduraCreateForm setDatum(LocalDate datum) {
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

    public Integer getHospitalizace() {
        return hospitalizace;
    }

    public ProceduraCreateForm setHospitalizace(Integer hospitalizace) {
        this.hospitalizace = hospitalizace;
        return this;
    }

    public Integer getIdTypProcedury() {
        return idTypProcedury;
    }

    public ProceduraCreateForm setIdTypProcedury(Integer idTypProcedury) {
        this.idTypProcedury = idTypProcedury;
        return this;
    }

    public Integer getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ProceduraCreateForm setIdTypZarizeni(Integer idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }

    public Integer getIdLekar() {
        return idLekar;
    }

    public ProceduraCreateForm setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
        return this;
    }

}
