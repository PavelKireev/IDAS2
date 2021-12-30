package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;
import com.idas2.zdravotnisystem.util.Selectable;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Hospitalizace extends UUIDableTimedEntity<Integer> implements Selectable {

    private static final long serialVersionUID = 2250538799447888193L;

    private String duvod;
    private String stavPacienta;
    private LocalDateTime hospitalizaceOd;
    private LocalDateTime hospitalizaceDo;
    private Integer pacientUzivatelIdUzivatel;

    public String getDuvod() {
        return duvod;
    }

    public Hospitalizace setDuvod(String duvod) {
        this.duvod = duvod;
        return this;
    }

    public String getStavPacienta() {
        return stavPacienta;
    }

    public Hospitalizace setStavPacienta(String stavPacienta) {
        this.stavPacienta = stavPacienta;
        return this;
    }

    public LocalDateTime getHospitalizaceOd() {
        return hospitalizaceOd;
    }

    public Hospitalizace setHospitalizaceOd(LocalDateTime hospitalizaceOd) {
        this.hospitalizaceOd = hospitalizaceOd;
        return this;
    }

    public LocalDateTime getHospitalizaceDo() {
        return hospitalizaceDo;
    }

    public Hospitalizace setHospitalizaceDo(LocalDateTime hospitalizaceDo) {
        this.hospitalizaceDo = hospitalizaceDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public Hospitalizace setPacientUzivatelIdUzivatel(Integer pacientUzivatelIdUzivatel) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }

    @Override
    public String getSelectorId() {
        return getId().toString();
    }

    @Override
    public String getSelectorTitle() {
        return getDuvod();
    }
}
