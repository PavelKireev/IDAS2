package com.idas2.zdravotnisystem.form.uzivatel;

public class PasswordUpdateForm {

    private Integer id;
    private String currentPassword;
    private String password;
    private String passwordConfirm;

    public Integer getId() {
        return id;
    }

    public PasswordUpdateForm setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public PasswordUpdateForm setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PasswordUpdateForm setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public PasswordUpdateForm setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
        return this;
    }
}
