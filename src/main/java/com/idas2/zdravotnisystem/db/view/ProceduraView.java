package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class ProceduraView {

    private Integer id;

    private Integer idProcedura;
    private Date datum;
    private String popis;
    private Integer idTypProcedury;

    private Integer idZarizeni;
    private String nazevZarizeni;
    private String znackaZarizeni;
    private Date datuVyrobyZarizeni;
    private Boolean jeFunkcni;

    private Integer idTypZarizeni;
    private String typZarizeniNazev;
    private String cilenePouziti;
    private String typZarizeniPopis;

    private Integer idMistnost;
    private String ordinaceNazev;
    private String ordinaceCislo;
    private String ordinacePlocha;
    private Boolean ordinaceJeVprovozu;

    private Integer idHospitalizace;
    private String duvod;
    private String stavPacienta;
    private Date hospitalizaceOd;
    private Date hospitalizaceDo;

    private Integer idPacient;
    private String uuidPacient;
    private String jmenoPacient;
    private String prijmeniPacient;
    private String telCisloPacient;

    private byte[] obrazekDataPacient;
    private Integer rustPacient;
    private Integer hmotnostPacient;
    private Date datumNarozeniPacient;

    // space

    private Integer idLekar;
    private String uuidLekar;
    private String jmenoLekar;
    private String prijmeniLekar;
    private String telCisloLekar;
    private Integer idObrazekLekar;
    private byte[] obrazekDataLekar;
    private Integer idKancelarLekar;
    private String nazevKancelarLekar;
    private Integer idSpecializace;
    private String nazevSpecializace;

    public Integer getId() {
        return id;
    }

    public ProceduraView setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getIdProcedura() {
        return idProcedura;
    }

    public ProceduraView setIdProcedura(Integer idProcedura) {
        this.idProcedura = idProcedura;
        return this;
    }

    public Date getDatum() {
        return datum;
    }

    public ProceduraView setDatum(Date datum) {
        this.datum = datum;
        return this;
    }

    public String getPopis() {
        return popis;
    }

    public ProceduraView setPopis(String popis) {
        this.popis = popis;
        return this;
    }

    public Integer getIdTypProcedury() {
        return idTypProcedury;
    }

    public ProceduraView setIdTypProcedury(Integer idTypProcedury) {
        this.idTypProcedury = idTypProcedury;
        return this;
    }

    public Integer getIdZarizeni() {
        return idZarizeni;
    }

    public ProceduraView setIdZarizeni(Integer idZarizeni) {
        this.idZarizeni = idZarizeni;
        return this;
    }

    public String getNazevZarizeni() {
        return nazevZarizeni;
    }

    public ProceduraView setNazevZarizeni(String nazevZarizeni) {
        this.nazevZarizeni = nazevZarizeni;
        return this;
    }

    public String getZnackaZarizeni() {
        return znackaZarizeni;
    }

    public ProceduraView setZnackaZarizeni(String znackaZarizeni) {
        this.znackaZarizeni = znackaZarizeni;
        return this;
    }

    public Date getDatuVyrobyZarizeni() {
        return datuVyrobyZarizeni;
    }

    public ProceduraView setDatuVyrobyZarizeni(Date datuVyrobyZarizeni) {
        this.datuVyrobyZarizeni = datuVyrobyZarizeni;
        return this;
    }

    public Boolean getJeFunkcni() {
        return jeFunkcni;
    }

    public ProceduraView setJeFunkcni(Boolean jeFunkcni) {
        this.jeFunkcni = jeFunkcni;
        return this;
    }

    public Integer getIdTypZarizeni() {
        return idTypZarizeni;
    }

    public ProceduraView setIdTypZarizeni(Integer idTypZarizeni) {
        this.idTypZarizeni = idTypZarizeni;
        return this;
    }

    public String getTypZarizeniNazev() {
        return typZarizeniNazev;
    }

    public ProceduraView setTypZarizeniNazev(String typZarizeniNazev) {
        this.typZarizeniNazev = typZarizeniNazev;
        return this;
    }

    public String getCilenePouziti() {
        return cilenePouziti;
    }

    public ProceduraView setCilenePouziti(String cilenePouziti) {
        this.cilenePouziti = cilenePouziti;
        return this;
    }

    public String getTypZarizeniPopis() {
        return typZarizeniPopis;
    }

    public ProceduraView setTypZarizeniPopis(String typZarizeniPopis) {
        this.typZarizeniPopis = typZarizeniPopis;
        return this;
    }

    public Integer getIdMistnost() {
        return idMistnost;
    }

    public ProceduraView setIdMistnost(Integer idMistnost) {
        this.idMistnost = idMistnost;
        return this;
    }

    public String getOrdinaceNazev() {
        return ordinaceNazev;
    }

    public ProceduraView setOrdinaceNazev(String ordinaceNazev) {
        this.ordinaceNazev = ordinaceNazev;
        return this;
    }

    public String getOrdinaceCislo() {
        return ordinaceCislo;
    }

    public ProceduraView setOrdinaceCislo(String ordinaceCislo) {
        this.ordinaceCislo = ordinaceCislo;
        return this;
    }

    public String getOrdinacePlocha() {
        return ordinacePlocha;
    }

    public ProceduraView setOrdinacePlocha(String ordinacePlocha) {
        this.ordinacePlocha = ordinacePlocha;
        return this;
    }

    public Boolean getOrdinaceJeVprovozu() {
        return ordinaceJeVprovozu;
    }

    public ProceduraView setOrdinaceJeVprovozu(Boolean ordinaceJeVprovozu) {
        this.ordinaceJeVprovozu = ordinaceJeVprovozu;
        return this;
    }

    public Integer getIdHospitalizace() {
        return idHospitalizace;
    }

    public ProceduraView setIdHospitalizace(Integer idHospitalizace) {
        this.idHospitalizace = idHospitalizace;
        return this;
    }

    public String getDuvod() {
        return duvod;
    }

    public ProceduraView setDuvod(String duvod) {
        this.duvod = duvod;
        return this;
    }

    public String getStavPacienta() {
        return stavPacienta;
    }

    public ProceduraView setStavPacienta(String stavPacienta) {
        this.stavPacienta = stavPacienta;
        return this;
    }

    public Date getHospitalizaceOd() {
        return hospitalizaceOd;
    }

    public ProceduraView setHospitalizaceOd(Date hospitalizaceOd) {
        this.hospitalizaceOd = hospitalizaceOd;
        return this;
    }

    public Date getHospitalizaceDo() {
        return hospitalizaceDo;
    }

    public ProceduraView setHospitalizaceDo(Date hospitalizaceDo) {
        this.hospitalizaceDo = hospitalizaceDo;
        return this;
    }

    public Integer getIdPacient() {
        return idPacient;
    }

    public ProceduraView setIdPacient(Integer idPacient) {
        this.idPacient = idPacient;
        return this;
    }

    public String getUuidPacient() {
        return uuidPacient;
    }

    public ProceduraView setUuidPacient(String uuidPacient) {
        this.uuidPacient = uuidPacient;
        return this;
    }

    public String getJmenoPacient() {
        return jmenoPacient;
    }

    public ProceduraView setJmenoPacient(String jmenoPacient) {
        this.jmenoPacient = jmenoPacient;
        return this;
    }

    public String getPrijmeniPacient() {
        return prijmeniPacient;
    }

    public ProceduraView setPrijmeniPacient(String prijmeniPacient) {
        this.prijmeniPacient = prijmeniPacient;
        return this;
    }

    public String getTelCisloPacient() {
        return telCisloPacient;
    }

    public ProceduraView setTelCisloPacient(String telCisloPacient) {
        this.telCisloPacient = telCisloPacient;
        return this;
    }

    public byte[] getObrazekDataPacient() {
        return obrazekDataPacient;
    }

    public ProceduraView setObrazekDataPacient(byte[] obrazekDataPacient) {
        this.obrazekDataPacient = obrazekDataPacient;
        return this;
    }

    public Integer getRustPacient() {
        return rustPacient;
    }

    public ProceduraView setRustPacient(Integer rustPacient) {
        this.rustPacient = rustPacient;
        return this;
    }

    public Integer getHmotnostPacient() {
        return hmotnostPacient;
    }

    public ProceduraView setHmotnostPacient(Integer hmotnostPacient) {
        this.hmotnostPacient = hmotnostPacient;
        return this;
    }

    public Date getDatumNarozeniPacient() {
        return datumNarozeniPacient;
    }

    public ProceduraView setDatumNarozeniPacient(Date datumNarozeniPacient) {
        this.datumNarozeniPacient = datumNarozeniPacient;
        return this;
    }

    public Integer getIdLekar() {
        return idLekar;
    }

    public ProceduraView setIdLekar(Integer idLekar) {
        this.idLekar = idLekar;
        return this;
    }

    public String getUuidLekar() {
        return uuidLekar;
    }

    public ProceduraView setUuidLekar(String uuidLekar) {
        this.uuidLekar = uuidLekar;
        return this;
    }

    public String getJmenoLekar() {
        return jmenoLekar;
    }

    public ProceduraView setJmenoLekar(String jmenoLekar) {
        this.jmenoLekar = jmenoLekar;
        return this;
    }

    public String getPrijmeniLekar() {
        return prijmeniLekar;
    }

    public ProceduraView setPrijmeniLekar(String prijmeniLekar) {
        this.prijmeniLekar = prijmeniLekar;
        return this;
    }

    public String getTelCisloLekar() {
        return telCisloLekar;
    }

    public ProceduraView setTelCisloLekar(String telCisloLekar) {
        this.telCisloLekar = telCisloLekar;
        return this;
    }

    public Integer getIdObrazekLekar() {
        return idObrazekLekar;
    }

    public ProceduraView setIdObrazekLekar(Integer idObrazekLekar) {
        this.idObrazekLekar = idObrazekLekar;
        return this;
    }

    public byte[] getObrazekDataLekar() {
        return obrazekDataLekar;
    }

    public ProceduraView setObrazekDataLekar(byte[] obrazekDataLekar) {
        this.obrazekDataLekar = obrazekDataLekar;
        return this;
    }

    public Integer getIdKancelarLekar() {
        return idKancelarLekar;
    }

    public ProceduraView setIdKancelarLekar(Integer idKancelarLekar) {
        this.idKancelarLekar = idKancelarLekar;
        return this;
    }

    public String getNazevKancelarLekar() {
        return nazevKancelarLekar;
    }

    public ProceduraView setNazevKancelarLekar(String nazevKancelarLekar) {
        this.nazevKancelarLekar = nazevKancelarLekar;
        return this;
    }

    public Integer getIdSpecializace() {
        return idSpecializace;
    }

    public ProceduraView setIdSpecializace(Integer idSpecializace) {
        this.idSpecializace = idSpecializace;
        return this;
    }

    public String getNazevSpecializace() {
        return nazevSpecializace;
    }

    public ProceduraView setNazevSpecializace(String nazevSpecializace) {
        this.nazevSpecializace = nazevSpecializace;
        return this;
    }
}
