package com.idas2.zdravotnisystem.form;

import com.idas2.zdravotnisystem.db.entity.Hospitalizace;
import com.idas2.zdravotnisystem.db.entity.TypProcedury;
import com.idas2.zdravotnisystem.db.entity.TypZarizeni;

import java.time.LocalDateTime;

public class ProceduraCreateForm {

    private LocalDateTime localDateTime;
    private String popis;
    private TypProcedury idTypProcedury;
    private TypZarizeni idTypZarizeni;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public ProceduraCreateForm setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public ProceduraCreateForm setPopis(String popis) {
        this.popis = popis;
        return this;
    }

    public TypProcedury getIdTypProcedury() {
        return idTypProcedury;
    }

    public ProceduraCreateForm setIdTypProcedury(TypProcedury idTypProcedury) {
        this.idTypProcedury = idTypProcedury;
        return this;
    }

    public TypZarizeni getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ProceduraCreateForm setIdTypZarizeni(TypZarizeni idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }

    public Hospitalizace getHospitalizace() {
        return hospitalizace;
    }

    public ProceduraCreateForm setHospitalizace(Hospitalizace hospitalizace) {
        this.hospitalizace = hospitalizace;
        return this;
    }

    private Hospitalizace hospitalizace;

}
