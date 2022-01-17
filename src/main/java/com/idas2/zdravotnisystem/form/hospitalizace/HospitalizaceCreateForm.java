package com.idas2.zdravotnisystem.form.hospitalizace;

public class HospitalizaceCreateForm {

    private String duvod;
    private String stavPacienta;
    private String hospitalizaceOd;
    private String hospitalizaceDo;
    private Integer pacientUzivatelIdUzivatel;

    public String getDuvod() {
        return duvod;
    }

    public HospitalizaceCreateForm setDuvod(String duvod) {
        this.duvod = duvod;
        return this;
    }

    public String getStavPacienta() {
        return stavPacienta;
    }

    public HospitalizaceCreateForm setStavPacienta(String stavPacienta) {
        this.stavPacienta = stavPacienta;
        return this;
    }

    public String getHospitalizaceOd() {
        return hospitalizaceOd;
    }

    public HospitalizaceCreateForm setHospitalizaceOd(String hospitalizaceOd) {
        this.hospitalizaceOd = hospitalizaceOd;
        return this;
    }

    public String getHospitalizaceDo() {
        return hospitalizaceDo;
    }

    public HospitalizaceCreateForm setHospitalizaceDo(String hospitalizaceDo) {
        this.hospitalizaceDo = hospitalizaceDo;
        return this;
    }

    public Integer getPacientUzivatelIdUzivatel() {
        return pacientUzivatelIdUzivatel;
    }

    public HospitalizaceCreateForm setPacientUzivatelIdUzivatel(Integer pacientUzivatelIdUzivatel) {
        this.pacientUzivatelIdUzivatel = pacientUzivatelIdUzivatel;
        return this;
    }
}
