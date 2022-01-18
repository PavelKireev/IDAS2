<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/uzivatel/pacient/save" method="POST">
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
                    <input type="submit" class="btn btn-lg btn-success" value="Create"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>