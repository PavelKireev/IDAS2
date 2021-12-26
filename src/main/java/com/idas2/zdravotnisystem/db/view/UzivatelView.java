package com.idas2.zdravotnisystem.db.view;

public class UzivatelView {

    private Integer id;
    private String uuid;
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private String adresa;

    private String email;
    private String password;

    private Integer obrazekIdObrazek;

    public String getUuid() {
        return uuid;
    }

    public UzivatelView setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    private String role;

    public Integer getId() {
        return id;
    }

    public UzivatelView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public UzivatelView setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public UzivatelView setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public UzivatelView setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public UzivatelView setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UzivatelView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UzivatelView setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getObrazekIdObrazek() {
        return obrazekIdObrazek;
    }

    public UzivatelView setObrazekIdObrazek(Integer obrazekIdObrazek) {
        this.obrazekIdObrazek = obrazekIdObrazek;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UzivatelView setRole(String role) {
        this.role = role;
        return this;
    }
}
