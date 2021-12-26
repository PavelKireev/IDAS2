package com.idas2.zdravotnisystem.db.view;

import com.idas2.zdravotnisystem.util.TimeUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class HospitalizaceView {

    private Integer id;

    private String hospitalozaceOd;
    private String hospitalizaceDo;

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

    public String getHospitalozaceOd() {
        return hospitalozaceOd;
    }

    public HospitalizaceView setHospitalozaceOd(String hospitalozaceOd) {
        this.hospitalozaceOd = hospitalozaceOd;
        return this;
    }

    public String getHospitalizaceDo() {
        return hospitalizaceDo;
    }

    public HospitalizaceView setHospitalizaceDo(String hospitalizaceDo) {
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
}
