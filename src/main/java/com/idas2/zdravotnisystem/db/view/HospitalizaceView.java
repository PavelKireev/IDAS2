package com.idas2.zdravotnisystem.db.view;

import com.idas2.zdravotnisystem.util.Selectable;
import com.idas2.zdravotnisystem.util.TimeUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDateTime;

public class HospitalizaceView implements Selectable {

    private Integer id;

    private String pacientJmeno;
    private String pacientPrijmeni;

    private Date hospitalozaceOd;
    private Date hospitalizaceDo;

    private String duvod;
    private String stavPacienta;
    private String pokojCislo;

    public Integer getId() {
        return id;
    }

    public HospitalizaceView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPacientJmeno() {
        return pacientJmeno;
    }

    public HospitalizaceView setPacientJmeno(String pacientJmeno) {
        this.pacientJmeno = pacientJmeno;
        return this;
    }

    public String getPacientPrijmeni() {
        return pacientPrijmeni;
    }

    public HospitalizaceView setPacientPrijmeni(String pacientPrijmeni) {
        this.pacientPrijmeni = pacientPrijmeni;
        return this;
    }

    public Date getHospitalozaceOd() {
        return hospitalozaceOd;
    }

    public HospitalizaceView setHospitalozaceOd(Date hospitalozaceOd) {
        this.hospitalozaceOd = hospitalozaceOd;
        return this;
    }

    public Date getHospitalizaceDo() {
        return hospitalizaceDo;
    }

    public HospitalizaceView setHospitalizaceDo(Date hospitalizaceDo) {
        this.hospitalizaceDo = hospitalizaceDo;
        return this;
    }

    public String getDuvod() {
        return duvod;
    }

    public HospitalizaceView setDuvod(String duvod) {
        this.duvod = duvod;
        return this;
    }

    public String getStavPacienta() {
        return stavPacienta;
    }

    public HospitalizaceView setStavPacienta(String stavPacienta) {
        this.stavPacienta = stavPacienta;
        return this;
    }

    public String getPokojCislo() {
        return pokojCislo;
    }

    public HospitalizaceView setPokojCislo(String pokojCislo) {
        this.pokojCislo = pokojCislo;
        return this;
    }

    @Override
    public String getSelectorId() {
        return getId().toString();
    }

    @Override
    public String getSelectorTitle() {
        return String.format("%s %s", getPacientJmeno(), getPacientPrijmeni());
    }
}
