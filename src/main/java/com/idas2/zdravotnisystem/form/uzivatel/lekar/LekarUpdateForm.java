package com.idas2.zdravotnisystem.form.uzivatel.lekar;

public class LekarUpdateForm {

    private Integer id;

    private String email;
    private String heslo;
    private String hesloPotvrzeni;

    private String jmeno;
    private String prijmeni;

    private String telCislo;

    private byte[] obrazek;
    private String nazev;
    private String pripona;

    private Integer plat;
    private Integer idKancelar;
    private Integer idSpecializace;

    public Integer getId() {
        return id;
    }

    public LekarUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LekarUpdateForm setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public LekarUpdateForm setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }

    public String getHesloPotvrzeni() {
        return hesloPotvrzeni;
    }

    public LekarUpdateForm setHesloPotvrzeni(String hesloPotvrzeni) {
        this.hesloPotvrzeni = hesloPotvrzeni;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public LekarUpdateForm setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LekarUpdateForm setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public LekarUpdateForm setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public byte[] getObrazek() {
        return obrazek;
    }

    public LekarUpdateForm setObrazek(byte[] obrazek) {
        this.obrazek = obrazek;
        return this;
    }

    public String getNazev() {
        return nazev;
    }

    public LekarUpdateForm setNazev(String nazev) {
        this.nazev = nazev;
        return this;
    }

    public String getPripona() {
        return pripona;
    }

    public LekarUpdateForm setPripona(String pripona) {
        this.pripona = pripona;
        return this;
    }

    public Integer getPlat() {
        return plat;
    }

    public LekarUpdateForm setPlat(Integer plat) {
        this.plat = plat;
        return this;
    }

    public Integer getIdKancelar() {
        return idKancelar;
    }

    public LekarUpdateForm setIdKancelar(Integer idKancelar) {
        this.idKancelar = idKancelar;
        return this;
    }

    public Integer getIdSpecializace() {
        return idSpecializace;
    }

    public LekarUpdateForm setIdSpecializace(Integer idSpecializace) {
        this.idSpecializace = idSpecializace;
        return this;
    }
}
