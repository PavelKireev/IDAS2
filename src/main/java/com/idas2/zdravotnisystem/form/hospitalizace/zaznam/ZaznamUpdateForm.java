package com.idas2.zdravotnisystem.form.hospitalizace.zaznam;

import java.time.LocalDate;

public class ZaznamUpdateForm {

    private Integer id;
    private String titul;
    private String text;
    private Integer idHospitalizace;
    private Integer idLekar;
    private LocalDate datumVytvareni;

    public Integer getId() {
        return id;
    }

    public ZaznamUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitul() {
        return titul;
    }

    public ZaznamUpdateForm setTitul(String titul) {
        this.titul = titul;
        return this;
    }

    public String getText() {
        return text;
    }

    public ZaznamUpdateForm setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getIdHospitalizace() {
        return idHospitalizace;
    }

    public ZaznamUpdateForm setIdHospitalizace(Integer idHospitalizace) {
        this.idHospitalizace = idHospitalizace;
        return this;
    }

    public Integer getIdLekar() {
        return idLekar;
    }

    public ZaznamUpdateForm setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
        return this;
    }

    public LocalDate getDatumVytvareni() {
        return datumVytvareni;
    }

    public ZaznamUpdateForm setDatumVytvareni(LocalDate datumVytvareni) {
        this.datumVytvareni = datumVytvareni;
        return this;
    }
}
