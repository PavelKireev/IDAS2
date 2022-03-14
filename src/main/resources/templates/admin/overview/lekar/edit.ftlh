<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/uzivatel/lekar/${id}/update" method="POST">
                    <div class="form-group" style="display: none">
                        <@spring.formInput "updateForm.id" "required class=\"form-control form-control-sm\" placeholder=\"id\"" />
                        <@spring.showErrors "<br>" "small"/>
                    </div>

                    <label for="email">
                        Email
                    </label>
                    <div class="form-group">
                        <@spring.formInput "updateForm.email" "required class=\"form-control form-control-sm\" placeholder=\"Email\"" "email"/>
                        <@spring.showErrors "<br>" "small"/>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>
                                Jmeno
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.jmeno" "required class=\"form-control form-control-sm\" placeholder=\"Jmeno\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <label>
                                Prijmeni
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.prijmeni" "required class=\"form-control form-control-sm\" placeholder=\"Pijmeni\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <label>
                                Telefonni Cislo
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.telCislo" "required class=\"form-control form-control-sm\" placeholder=\"Telefonni Cislo\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <label>
                                Plat
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.plat" "required class=\"form-control form-control-sm\" placeholder=\"Plat\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-lg-6">
                            <@form.selectOptions "updateForm.idSpecializace" specializaceList "Specializace" />
                        </div>
                        <div class="col-lg-6">
                            <@form.selectOptions "updateForm.idKancelar" kancelarList "Kancelar" />
                        </div>
                    </div>
                    <input type="submit" class="btn btn-lg btn-success mt-3" value="Update"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>