package com.idas2.zdravotnisystem.form.lekar;

public class LekarKartaUpdateForm {

    private String platnostOd;
    private String platnostDo;

    public String getPlatnostDo() {
        return platnostDo;
    }

    public String getPlatnostOd() {
        return platnostOd;
    }

    public LekarKartaUpdateForm setPlatnostOd(String platnostOd) {
        this.platnostOd = platnostOd;
        return this;
    }

    public LekarKartaUpdateForm setPlatnostDo(String platnostDo) {
        this.platnostDo = platnostDo;
        return this;
    }
}
