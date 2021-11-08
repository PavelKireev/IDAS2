package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;

@Entity(name = "UZIVATEL")
public class User extends UUIDableTimedEntity {

    private String jmeno;
    private String prijmeni;

    private String email;
    private String heslo;

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

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public User setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }
}
