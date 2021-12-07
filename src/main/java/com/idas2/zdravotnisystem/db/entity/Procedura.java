package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Procedura extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -5809540429135141537L;

    private LocalDateTime datum;
    private String popis;
    private Integer typProceduryIdTypProcedury;
    private Integer zarizeniIdZarizeni;
    private Integer hospitalozaceIdHospitalizace;
    private Integer lekarUzivatelIdUzivatel;

    public LocalDateTime getDatum() {
        return datum;
    }

    public Procedura setDatum(LocalDateTime datum) {
        this.datum = datum;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public Procedura setPopis(String popis) {
        this.popis = popis;
        return this;
    }

    public Integer getTypProceduryIdTypProcedury() {
        return typProceduryIdTypProcedury;
    }

    public Procedura setTypProceduryIdTypProcedury(Integer typProceduryIdTypProcedury) {
        this.typProceduryIdTypProcedury = typProceduryIdTypProcedury;
        return this;
    }

    public Integer getZarizeniIdZarizeni() {
        return zarizeniIdZarizeni;
    }

    public Procedura setZarizeniIdZarizeni(Integer zarizeniIdZarizeni) {
        this.zarizeniIdZarizeni = zarizeniIdZarizeni;
        return this;
    }

    public Integer getHospitalozaceIdHospitalizace() {
        return hospitalozaceIdHospitalizace;
    }

    public Procedura setHospitalozaceIdHospitalizace(Integer hospitalozaceIdHospitalizace) {
        this.hospitalozaceIdHospitalizace = hospitalozaceIdHospitalizace;
        return this;
    }

    public Integer getLekarUzivatelIdUzivatel() {
        return lekarUzivatelIdUzivatel;
    }

    public Procedura setLekarUzivatelIdUzivatel(Integer lekarUzivatelIdUzivatel) {
        this.lekarUzivatelIdUzivatel = lekarUzivatelIdUzivatel;
        return this;
    }
}
