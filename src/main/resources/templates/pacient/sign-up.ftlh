<#import "../partials/form.ftlh" as form>
<#import "/spring.ftl" as spring>
<#import "../layout/empty.ftlh" as layout>

<#assign title = "Zdravotni System" />
<#assign description = "Sign In" />

<@layout.render title description>

    <div class="container-fluid">
        <div class="d-flex flex-row justify-content-center">
            <div class="col-xl-5 col-lg-4 col-md-6 col-12">
                <div class="d-flex flex-row justify-content-center">
                    <img class="my-4" height="100px" width="100px" src="/static/image/logo.svg">
                </div>
                <div class="text-center mb-4">
                    <h1 class="h5 mb-3 font-weight-normal">Sign Up</h1>
                </div>
                <div class="bg-light border rounded p-4 mb-3">
                    <form class="form-signin user" action="/pacient/register" method="POST">
                        <label for="email">
                            Email
                        </label>
                        <div class="form-group">
                            <@spring.formInput "form.email" "required class=\"form-control form-control-sm\" placeholder=\"Email\"" "email"/>
                            <@spring.showErrors "<br>" "small"/>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>
                                    Heslo
                                </label>
                                <div class="form-group">
                                    <@spring.formInput "form.heslo" "required class=\"form-control form-control-sm\" placeholder=\"Password\"" "password"/>
                                    <@spring.showErrors "<br>" "small"/>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label>
                                    Heslo Potvrzeni
                                </label>
                                <div class="form-group">
                                    <@spring.formInput "form.confirmHeslo" "required class=\"form-control form-control-sm\" placeholder=\"Confirm Password\"" "password"/>
                                    <@spring.showErrors "<br>" "small"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>
                                    Jmeno
                                </label>
                                <div class="form-group">
                                    <@spring.formInput "form.jmeno" "required class=\"form-control form-control-sm\" placeholder=\"Jmeno\"" />
                                    <@spring.showErrors "<br>" "small"/>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label>
                                    Prijmeni
                                </label>
                                <div class="form-group">
                                    <@spring.formInput "form.prijmeni" "required class=\"form-control form-control-sm\" placeholder=\"Pijmeni\"" />
                                    <@spring.showErrors "<br>" "small"/>
                                </div>
                            </div>
                        </div>
                        <label>
                            Adresa
                        </label>
                        <div class="form-group">
                            <@spring.formInput "form.adresa" "required class=\"form-control form-control-sm\" placeholder=\"Adresa\"" />
                            <@spring.showErrors "<br>" "small"/>
                        </div>
                        <label>
                            Telefonni Cislo
                        </label>
                        <div class="form-group">
                            <@spring.formInput "form.telCislo" "required class=\"form-control form-control-sm\" placeholder=\"Telefonni Cislo\"" />
                            <@spring.showErrors "<br>" "small"/>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-4">
                                <label>
                                    Rust
                                </label>
                                <div class="form-group">
                                    <@spring.formInput "form.rust" "required class=\"form-control form-control-sm\" placeholder=\"Rust\"" />
                                    <@spring.showErrors "<br>" "small"/>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <label>
                                    Hmotnost
                                </label>
                                <div class="form-group">
                                    <@spring.formInput "form.hmotnost" "required class=\"form-control form-control-sm\" placeholder=\"Hmotnost\"" />
                                    <@spring.showErrors "<br>" "small"/>
                                </div>
                            </div>
                            <div class="form-group col-md-4">
                                <@form.inputBirthDate "form.datumNarozeni" "Datum Narozeni" "class=\"form-control\""/>
                            </div>
                        </div>
                        <input type="submit" class="btn btn-sm btn-success btn-user btn-block" value="Sign Up"/>
                    </form>
                </div>
            </div>
        </div>
    </div>

</@layout.render>