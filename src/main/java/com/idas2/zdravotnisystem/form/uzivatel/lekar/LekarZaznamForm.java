package com.idas2.zdravotnisystem.form.uzivatel.lekar;

public class LekarZaznamForm {

    private String id;
    private String titul;
    private String text;
    private Integer idHospitalizace;
    private Integer idLekar;

    public String getId() {
        return id;
    }

    public LekarZaznamForm setId(String id) {
        this.id = id;
        return this;
    }

    public String getTitul() {
        return titul;
    }

    public LekarZaznamForm setTitul(String titul) {
        this.titul = titul;
        return this;
    }

    public String getText() {
        return text;
    }

    public LekarZaznamForm setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getIdHospitalizace() {
        return idHospitalizace;
    }

    public LekarZaznamForm setIdHospitalizace(Integer idHospitalizace) {
        this.idHospitalizace = idHospitalizace;
        return this;
    }

    public Integer getIdLekar() {
        return idLekar;
    }

    public LekarZaznamForm setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
        return this;
    }
}
