package com.idas2.zdravotnisystem.form.hospitalizace.zaznam;

public class ZaznamCreateForm {

    private String titul;
    private String text;
    private Integer idHospitalizace;
    private Integer idLekar;

    public String getTitul() {
        return titul;
    }

    public ZaznamCreateForm setTitul(String titul) {
        this.titul = titul;
        return this;
    }

    public String getText() {
        return text;
    }

    public ZaznamCreateForm setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getIdHospitalizace() {
        return idHospitalizace;
    }

    public ZaznamCreateForm setIdHospitalizace(Integer idHospitalizace) {
        this.idHospitalizace = idHospitalizace;
        return this;
    }

    public Integer getIdLekar() {
        return idLekar;
    }

    public ZaznamCreateForm setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
        return this;
    }
}
