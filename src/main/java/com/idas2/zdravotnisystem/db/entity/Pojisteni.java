package com.idas2.zdravotnisystem.db.entity;

import com.idas2.zdravotnisystem.db.entity.base.UUIDableTimedEntity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Pojisteni extends UUIDableTimedEntity<Integer> {

    private static final long serialVersionUID = -1567403174561554709L;

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

    public Pojisteni setCisloKarty(String cisloKarty) {
        this.cisloKarty = cisloKarty;
        return this;
    }

    public String getCisloSmlouvy() {
        return cisloSmlouvy;
    }

    public Pojisteni setCisloSmlouvy(String cisloSmlouvy) {
        this.cisloSmlouvy = cisloSmlouvy;
        return this;
    }

    public Integer getPojistnaCastka() {
        return pojistnaCastka;
    }

    public Pojisteni setPojistnaCastka(Integer pojistnaCastka) {
        this.pojistnaCastka = pojistnaCastka;
        return this;
    }

    public LocalDate getPojisteniOd() {
        return pojisteniOd;
    }

    public Pojisteni setPojisteniOd(LocalDate pojisteniOd) {
        this.pojisteniOd = pojisteniOd;
        return this;
    }

    public LocalDate getPojisteniDo() {
        return pojisteniDo;
    }

    public Pojisteni setPojisteniDo(LocalDate pojisteniDo) {
        this.pojisteniDo = pojisteniDo;
        return this;
    }

    public Integer getPojistovnaIdPojistovna() {
        return pojistovnaIdPojistovna;
    }

    public Pojisteni setPojistovnaIdPojistovna(Integer pojistovnaIdPojistovna) {
        this.pojistovnaIdPojistovna = pojistovnaIdPojistovna;
        return this;
    }

    public Integer getZdravotniKartaIdKarta() {
        return zdravotniKartaIdKarta;
    }

    public Pojisteni setZdravotniKartaIdKarta(Integer zdravotniKartaIdKarta) {
        this.zdravotniKartaIdKarta = zdravotniKartaIdKarta;
        return this;
    }
}
