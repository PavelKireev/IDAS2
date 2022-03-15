<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/mistnost/pokoj/save" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="nazev">
                                Nazev
                            </label>
                            <div class="form-group">
                                <@spring.formInput "createForm.nazev" "required class=\"form-control form-control-sm\" placeholder=\"Nazev\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">

                            <label for="cislo">
                                Cislo
                            </label>
                            <div class="form-group">
                                <@spring.formInput "createForm.cislo" "required class=\"form-control form-control-sm\" placeholder=\"Cislo\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label>
                                Plocha
                            </label>
                            <div class="form-group">
                                <@spring.formInput "createForm.plocha" "required class=\"form-control form-control-sm\" placeholder=\"Plocha\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <label>
                                Kapacita
                            </label>
                            <div class="form-group">
                                <@spring.formInput "createForm.kapacita" "required class=\"form-control form-control-sm\" placeholder=\"Kapacita \"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <label>
                                Pocet Pacientu
                            </label>
                            <div class="form-group">
                                <@spring.formInput "createForm.pocetPacientu" "required class=\"form-control form-control-sm\" placeholder=\"Pocet Pacientu \"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-lg btn-success mt-3" value="Create"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>