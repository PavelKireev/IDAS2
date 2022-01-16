package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class ZaznamView {

    private Integer id;

    private String titul;
    private String text;
    private Date datumVytvareni;

    private String jmeno;
    private String prijmeni;

    private Integer hospitalizaceIdHospitalizace;
    private Integer lekarUzivatelIdUzivatel;

    public Integer getId() {
        return id;
    }

    public ZaznamView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitul() {
        return titul;
    }

    public ZaznamView setTitul(String titul) {
        this.titul = titul;
        return this;
    }

    public String getText() {
        return text;
    }

    public ZaznamView setText(String text) {
        this.text = text;
        return this;
    }

    public Date getDatumVytvareni() {
        return datumVytvareni;
    }

    public ZaznamView setDatumVytvareni(Date datumVytvareni) {
        this.datumVytvareni = datumVytvareni;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public ZaznamView setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public ZaznamView setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public Integer getHospitalizaceIdHospitalizace() {
        return hospitalizaceIdHospitalizace;
    }

    public ZaznamView setHospitalizaceIdHospitalizace(Integer hospitalizaceIdHospitalizace) {
        this.hospitalizaceIdHospitalizace = hospitalizaceIdHospitalizace;
        return this;
    }

    public Integer getLekarUzivatelIdUzivatel() {
        return lekarUzivatelIdUzivatel;
    }

    public ZaznamView setLekarUzivatelIdUzivatel(Integer lekarUzivatelIdUzivatel) {
        this.lekarUzivatelIdUzivatel = lekarUzivatelIdUzivatel;
        return this;
    }
}
