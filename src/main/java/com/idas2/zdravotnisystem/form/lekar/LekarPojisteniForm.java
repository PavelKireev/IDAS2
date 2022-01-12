package com.idas2.zdravotnisystem.form.lekar;

import java.time.LocalDate;

public class LekarPojisteniForm {

    private String cisloKarty;
    private String cisloSmlouvy;
    private Integer pojistnaCastka;
    private LocalDate pojisteniOd;
    private LocalDate pojisteniDo;
    private Integer pojistovnaIdPojistovna;
    private Integer zdravotniKartaIdKarta;

    public String getCisloKarty() {
        return cisloKarty;
    }

    public LekarPojisteniForm setCisloKarty(String cisloKarty) {
        this.cisloKarty = cisloKarty;
        return this;
    }

    public String getCisloSmlouvy() {
        return cisloSmlouvy;
    }

    public LekarPojisteniForm setCisloSmlouvy(String cisloSmlouvy) {
        this.cisloSmlouvy = cisloSmlouvy;
        return this;
    }

    public Integer getPojistnaCastka() {
        return pojistnaCastka;
    }

    public LekarPojisteniForm setPojistnaCastka(Integer pojistnaCastka) {
        this.pojistnaCastka = pojistnaCastka;
        return this;
    }

    public LocalDate getPojisteniOd() {
        return pojisteniOd;
    }

    public LekarPojisteniForm setPojisteniOd(LocalDate pojisteniOd) {
        this.pojisteniOd = pojisteniOd;
        return this;
    }

    public LocalDate getPojisteniDo() {
        return pojisteniDo;
    }

    public LekarPojisteniForm setPojisteniDo(LocalDate pojisteniDo) {
        this.pojisteniDo = pojisteniDo;
        return this;
    }

    public Integer getPojistovnaIdPojistovna() {
        return pojistovnaIdPojistovna;
    }

    public LekarPojisteniForm setPojistovnaIdPojistovna(Integer pojistovnaIdPojistovna) {
        this.pojistovnaIdPojistovna = pojistovnaIdPojistovna;
        return this;
    }

    public Integer getZdravotniKartaIdKarta() {
        return zdravotniKartaIdKarta;
    }

    public LekarPojisteniForm setZdravotniKartaIdKarta(Integer zdravotniKartaIdKarta) {
        this.zdravotniKartaIdKarta = zdravotniKartaIdKarta;
        return this;
    }

}
