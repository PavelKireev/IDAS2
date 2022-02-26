package com.idas2.zdravotnisystem.form.hospitalizace;

import java.time.LocalDate;

public class HospitalizaceUpdateForm {

    private Integer id;
    private String duvod;
    private String stavPacienta;
    private LocalDate hospitalizaceOd;
    private LocalDate hospitalizaceDo;
    private Integer pacientUzivatelIdUzivatel;

    public Integer getId() {
        return id;
    }

    public HospitalizaceUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDuvod() {
        return duvod;
    }

    public HospitalizaceUpdateForm setDuvod(String duvod) {
        this.duvod = duvod;
        return this;
    }

    public String getStavPacienta() {
        return stavPacienta;
    }

    public HospitalizaceUpdateForm setStavPacienta(String stavPacienta) {
        this.stavPacienta = stavPacienta;
        return this;
    }

    public LocalDate getHospitalizaceOd() {
        return hospitalizaceOd;
    }

    public HospitalizaceUpdateForm setHospitalizaceOd(LocalDate hospitalizaceOd) {
        this.hospitalizaceOd = hospitalizaceOd;
        return this;
    }

    public LocalDate getHospitalizaceDo() {
        return hospitalizaceDo;
    }

    public HospitalizaceUpdateForm setHospitalizaceDo(LocalDate hospitalizaceDo) {
        this.hospitalizaceDo = hospitalizaceDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public HospitalizaceUpdateForm setPacientUzivatelIdUzivatel(Integer pacientUzivatelIdUzivatel) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }
}
