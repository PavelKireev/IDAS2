package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class ZdravortniKarta extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -4953939557759873994L;

    private LocalDateTime datumVytvareni;
    private LocalDateTime kartaOd;
    private LocalDateTime kartaDo;
    private Integer pacientUzivatelIdUzivatel;

    public LocalDateTime getDatumVytvareni() {
        return datumVytvareni;
    }

    public ZdravortniKarta setDatumVytvareni(LocalDateTime datumVytvareni) {
        this.datumVytvareni = datumVytvareni;
        return this;
    }

    public LocalDateTime getKartaOd() {
        return kartaOd;
    }

    public ZdravortniKarta setKartaOd(LocalDateTime kartaOd) {
        this.kartaOd = kartaOd;
        return this;
    }

    public LocalDateTime getKartaDo() {
        return kartaDo;
    }

    public ZdravortniKarta setKartaDo(LocalDateTime kartaDo) {
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
