<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/hospitalizace/${id}/update" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="nazev">
                                Duvod
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.duvod" "required class=\"form-control form-control-sm\" placeholder=\"Duvod\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="cislo">
                                Stav Pacienta
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.stavPacienta" "required class=\"form-control form-control-sm\" placeholder=\"Stav Pacienta\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-lg-6">
                            <@form.inputDate "updateForm.hospitalizaceOd" "Od" "class=\"form-control\""/>
                        </div>
                        <div class="form-group col-lg-6">
                            <@form.inputDate "updateForm.hospitalizaceDo" "Do" "class=\"form-control\""/>
                        </div>
                    </div>
                    <@form.selectOptions "updateForm.pacientUzivatelIdUzivatel" pacientList "Pacient" />
                    <input type="submit" class="btn btn-lg btn-success mt-4" value="Update"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>