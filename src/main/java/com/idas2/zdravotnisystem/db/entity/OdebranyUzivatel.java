package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity
public class OdebranyUzivatel extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -5105227579305835746L;

    private String email;
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private String text;

    public String getEmail() {
        return email;
    }

    public OdebranyUzivatel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public OdebranyUzivatel setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public OdebranyUzivatel setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public OdebranyUzivatel setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public String getText() {
        return text;
    }

    public OdebranyUzivatel setText(String text) {
        this.text = text;
        return this;
    }
}
