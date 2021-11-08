package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity(name = "UZIVATEL")
public class User extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -3370171534784395231L;

    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private String adresa;

    private String email;
    private String password;

    public String getJmeno() {
        return jmeno;
    }

    public User setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public User setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public User setTelCislo(String tel_cislo) {
        this.telCislo = tel_cislo;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public User setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
