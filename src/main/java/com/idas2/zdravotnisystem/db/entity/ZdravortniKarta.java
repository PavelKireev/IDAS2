package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class ZdravortniKarta extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -4953939557759873994L;

    private LocalDate datumVytvareni;
    private LocalDate kartaOd;
    private LocalDate kartaDo;
    private Integer pacientUzivatelIdUzivatel;

    public LocalDate getDatumVytvareni() {
        return datumVytvareni;
    }

    public ZdravortniKarta setDatumVytvareni(LocalDate datumVytvareni) {
        this.datumVytvareni = datumVytvareni;
        return this;
    }

    public LocalDate getKartaOd() {
        return kartaOd;
    }

    public ZdravortniKarta setKartaOd(LocalDate kartaOd) {
        this.kartaOd = kartaOd;
        return this;
    }

    public LocalDate getKartaDo() {
        return kartaDo;
    }

    public ZdravortniKarta setKartaDo(LocalDate kartaDo) {
        this.kartaDo = kartaDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public ZdravortniKarta setPacientUzivatelIdUzivatel(Integer pacientUzivatelIdUzivatel) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }
}
