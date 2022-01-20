package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class AdministratorView {

    private Integer id;
    private String uuid;

    private String email;
    private String heslo;

    private String jmeno;
    private String prijmeni;

    private String telCislo;

    private Integer obrazekIdObrazek;
    private byte[] obrazekData;
    private String obrazekNazev;
    private String obrazekPripona;
    private Date obrazekDatum;

    public Integer getId() {
        return id;
    }

    public AdministratorView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public AdministratorView setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AdministratorView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public AdministratorView setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public AdministratorView setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public AdministratorView setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public AdministratorView setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public Integer getObrazekIdObrazek() {
        return obrazekIdObrazek;
    }

    public AdministratorView setObrazekIdObrazek(Integer obrazekIdObrazek) {
        this.obrazekIdObrazek = obrazekIdObrazek;
        return this;
    }

    public byte[] getObrazekData() {
        return obrazekData;
    }

    public AdministratorView setObrazekData(byte[] obrazekData) {
        this.obrazekData = obrazekData;
        return this;
    }

    public String getObrazekNazev() {
        return obrazekNazev;
    }

    public AdministratorView setObrazekNazev(String obrazekNazev) {
        this.obrazekNazev = obrazekNazev;
        return this;
    }

    public String getObrazekPripona() {
        return obrazekPripona;
    }

    public AdministratorView setObrazekPripona(String obrazekPripona) {
        this.obrazekPripona = obrazekPripona;
        return this;
    }

    public Date getObrazekDatum() {
        return obrazekDatum;
    }

    public AdministratorView setObrazekDatum(Date obrazekDatum) {
        this.obrazekDatum = obrazekDatum;
        return this;
    }
}
