<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/hospitalizace/save" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="nazev">
                                Duvod
                            </label>
                            <div class="form-group">
                                <@spring.formInput "form.duvod" "required class=\"form-control form-control-sm\" placeholder=\"Duvod\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="cislo">
                                Stav Pacienta
                            </label>
                            <div class="form-group">
                                <@spring.formInput "form.stavPacienta" "required class=\"form-control form-control-sm\" placeholder=\"Stav Pacienta\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-lg-6">
                            <@form.inputDate "form.hospitalizaceOd" "Od" "class=\"form-control\""/>
                        </div>
                        <div class="form-group col-lg-6">
                            <@form.inputDate "form.hospitalizaceDo" "Do" "class=\"form-control\""/>
                        </div>
                    </div>
                    <@form.selectOptions "form.pacientUzivatelIdUzivatel" pacientList "Pacient" />
                    <input type="submit" class="btn btn-lg btn-success mt-4" value="Create"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>