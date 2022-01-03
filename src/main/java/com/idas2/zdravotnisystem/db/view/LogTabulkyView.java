package com.idas2.zdravotnisystem.db.view;

import java.sql.Date;

public class LogTabulkyView {

    private String akce;
    private String tabulka;
    private Date datum;
    private String text;
    private Integer primarniKlic;

    public String getAkce() {
        return akce;
    }

    public LogTabulkyView setAkce(String akce) {
        this.akce = akce;
        return this;
    }

    public String getTabulka() {
        return tabulka;
    }

    public LogTabulkyView setTabulka(String tabulka) {
        this.tabulka = tabulka;
        return this;
    }

    public Date getDatum() {
        return datum;
    }

    public LogTabulkyView setDatum(Date datum) {
        this.datum = datum;
        return this;
    }

    public String getText() {
        return text;
    }

    public LogTabulkyView setText(String text) {
        this.text = text;
        return this;
    }



    public Integer getPrimarniKlic() {
        return primarniKlic;
    }

    public LogTabulkyView setPrimarniKlic(Integer primarniKlic) {
        this.primarniKlic = primarniKlic;
        return this;
    }
}
