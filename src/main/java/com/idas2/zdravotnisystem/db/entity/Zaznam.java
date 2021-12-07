package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class Zaznam extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = 5328938767647000364L;

    private String titul;
    private String text;

    private Integer typZaznamuIdTypZaznamu;
    private Integer hospitalizaceIdHospitalizace;
    private Integer lekarUzivatelIdUzivatel;

    public String getTitul() {
        return titul;
    }

    public Zaznam setTitul(String titul) {
        this.titul = titul;
        return this;
    }

    public String getText() {
        return text;
    }

    public Zaznam setText(String text) {
        this.text = text;
        return this;
    }

    public Integer getTypZaznamuIdTypZaznamu() {
        return typZaznamuIdTypZaznamu;
    }

    public Zaznam setTypZaznamuIdTypZaznamu(Integer typZaznamuIdTypZaznamu) {
        this.typZaznamuIdTypZaznamu = typZaznamuIdTypZaznamu;
        return this;
    }

    public Integer getHospitalizaceIdHospitalizace() {
        return hospitalizaceIdHospitalizace;
    }

    public Zaznam setHospitalizaceIdHospitalizace(Integer hospitalizaceIdHospitalizace) {
        this.hospitalizaceIdHospitalizace = hospitalizaceIdHospitalizace;
        return this;
    }

    public Integer getLekarUzivatelIdUzivatel() {
        return lekarUzivatelIdUzivatel;
    }

    public Zaznam setLekarUzivatelIdUzivatel(Integer lekarUzivatelIdUzivatel) {
        this.lekarUzivatelIdUzivatel = lekarUzivatelIdUzivatel;
        return this;
    }
}
