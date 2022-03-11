package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class ZdravotniKarta extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -4953939557759873994L;

    private LocalDate datumVytvareni;
    private LocalDate kartaOd;
    private LocalDate kartaDo;
    private Integer pacientUzivatelIdUzivatel;

    public LocalDate getDatumVytvareni() {
        return datumVytvareni;
    }

    public ZdravotniKarta setDatumVytvareni(LocalDate datumVytvareni) {
        this.datumVytvareni = datumVytvareni;
        return this;
    }

    public LocalDate getKartaOd() {
        return kartaOd;
    }

    public ZdravotniKarta setKartaOd(LocalDate kartaOd) {
        this.kartaOd = kartaOd;
        return this;
    }

    public LocalDate getKartaDo() {
        return kartaDo;
    }

    public ZdravotniKarta setKartaDo(LocalDate kartaDo) {
        this.kartaDo = kartaDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public ZdravotniKarta setPacientUzivatelIdUzivatel(Integer pacientUzivatelIdUzivatel) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }
}
