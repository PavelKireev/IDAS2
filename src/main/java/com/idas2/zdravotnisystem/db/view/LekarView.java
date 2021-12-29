package com.idas2.zdravotnisystem.db.view;

public class LekarView {

    private Integer id;
    private String uuid;
    private String heslo;
    private String email;
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private byte[] obrazek;
    private String obrazekNazev;
    private String obrazekPripona;
    private Integer plat;
    private String kancelarNazev;
    private String kancelarCislo;
    private String specializaceNazev;

    private Integer idKancelar;
    private Integer idSpecializace;

    public Integer getId() {
        return id;
    }

    public LekarView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public LekarView setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getHeslo() {
        return heslo;
    }

    public LekarView setHeslo(String heslo) {
        this.heslo = heslo;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LekarView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public LekarView setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LekarView setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public LekarView setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public byte[] getObrazek() {
        return obrazek;
    }

    public LekarView setObrazek(byte[] obrazek) {
        this.obrazek = obrazek;
        return this;
    }

    public String getObrazekNazev() {
        return obrazekNazev;
    }

    public LekarView setObrazekNazev(String obrazekNazev) {
        this.obrazekNazev = obrazekNazev;
        return this;
    }

    public String getObrazekPripona() {
        return obrazekPripona;
    }

    public LekarView setObrazekPripona(String obrazekPripona) {
        this.obrazekPripona = obrazekPripona;
        return this;
    }

    public Integer getPlat() {
        return plat;
    }

    public LekarView setPlat(Integer plat) {
        this.plat = plat;
        return this;
    }

    public String getKancelarNazev() {
        return kancelarNazev;
    }

    public LekarView setKancelarNazev(String kancelarNazev) {
        this.kancelarNazev = kancelarNazev;
        return this;
    }

    public String getKancelarCislo() {
        return kancelarCislo;
    }

    public LekarView setKancelarCislo(String kancelarCislo) {
        this.kancelarCislo = kancelarCislo;
        return this;
    }

    public String getSpecializaceNazev() {
        return specializaceNazev;
    }

    public LekarView setSpecializaceNazev(String specializaceNazev) {
        this.specializaceNazev = specializaceNazev;
        return this;
    }

    public Integer getIdKancelar() {
        return idKancelar;
    }

    public LekarView setIdKancelar(Integer idKancelar) {
        this.idKancelar = idKancelar;
        return this;
    }

    public Integer getIdSpecializace() {
        return idSpecializace;
    }

    public LekarView setIdSpecializace(Integer idSpecializace) {
        this.idSpecializace = idSpecializace;
        return this;
    }
}
