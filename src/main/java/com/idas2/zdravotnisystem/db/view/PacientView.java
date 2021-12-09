package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class PacientView {

    private Integer id;
    private String password;

    private String uuid;
    private String email;
    private String jmeno;
    private String prijmeni;
    private String telCislo;
    private byte[] obrazekData;
    private String obrazekNazev;
    private String obrazekPripona;
    private Integer rust;
    private Integer hmotnost;

    private Date datumNarozeni;
    private Date obrazekDatum;

    private String pokojNazev;
    private String pokojCislo;
    private String pokojPlocha;
    private Integer pokojKapacita;
    private Integer pokojPocetPacientu;

    private String adresa;

    public Integer getId() {
        return id;
    }

    public PacientView setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PacientView setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUuid() {
        return uuid;
    }

    public PacientView setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PacientView setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getJmeno() {
        return jmeno;
    }

    public PacientView setJmeno(String jmeno) {
        this.jmeno = jmeno;
        return this;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public PacientView setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
        return this;
    }

    public String getTelCislo() {
        return telCislo;
    }

    public PacientView setTelCislo(String telCislo) {
        this.telCislo = telCislo;
        return this;
    }

    public byte[] getObrazekData() {
        return obrazekData;
    }

    public PacientView setObrazekData(byte[] obrazekData) {
        this.obrazekData = obrazekData;
        return this;
    }

    public String getObrazekNazev() {
        return obrazekNazev;
    }

    public PacientView setObrazekNazev(String obrazekNazev) {
        this.obrazekNazev = obrazekNazev;
        return this;
    }

    public String getObrazekPripona() {
        return obrazekPripona;
    }

    public PacientView setObrazekPripona(String obrazekPripona) {
        this.obrazekPripona = obrazekPripona;
        return this;
    }

    public Date getObrazekDatum() {
        return obrazekDatum;
    }

    public PacientView setObrazekDatum(Date obrazekDatum) {
        this.obrazekDatum = obrazekDatum;
        return this;
    }

    public Integer getRust() {
        return rust;
    }

    public PacientView setRust(Integer rust) {
        this.rust = rust;
        return this;
    }

    public Integer getHmotnost() {
        return hmotnost;
    }

    public PacientView setHmotnost(Integer hmotnost) {
        this.hmotnost = hmotnost;
        return this;
    }

    public Date getDatumNarozeni() {
        return datumNarozeni;
    }

    public PacientView setDatumNarozeni(Date datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
        return this;
    }

    public String getPokojNazev() {
        return pokojNazev;
    }

    public PacientView setPokojNazev(String pokojNazev) {
        this.pokojNazev = pokojNazev;
        return this;
    }

    public String getPokojCislo() {
        return pokojCislo;
    }

    public PacientView setPokojCislo(String pokojCislo) {
        this.pokojCislo = pokojCislo;
        return this;
    }

    public String getPokojPlocha() {
        return pokojPlocha;
    }

    public PacientView setPokojPlocha(String pokojPlocha) {
        this.pokojPlocha = pokojPlocha;
        return this;
    }

    public Integer getPokojKapacita() {
        return pokojKapacita;
    }

    public PacientView setPokojKapacita(Integer pokojKapacita) {
        this.pokojKapacita = pokojKapacita;
        return this;
    }

    public Integer getPokojPocetPacientu() {
        return pokojPocetPacientu;
    }

    public PacientView setPokojPocetPacientu(Integer pokojPocetPacientu) {
        this.pokojPocetPacientu = pokojPocetPacientu;
        return this;
    }

    public String getAdresa() {
        return adresa;
    }

    public PacientView setAdresa(String adresa) {
        this.adresa = adresa;
        return this;
    }
}
