<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/procedura/${id}/update" method="POST">
                    <div class="form-row">
                        <div class="col-lg-6">
                            <label for="nazev">
                                Popis
                            </label>
                            <div class="form-group">
                                <@spring.formInput "form.popis" "required class=\"form-control form-control-sm\" placeholder=\"Popis\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-lg-6">
                            <@form.inputDate "form.datum" "Datum" "class=\"form-control\""/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-lg-3">
                            <@form.selectOptions "form.idHospitalizace" hospitalizaceList "Pacient" />
                        </div>
                        <div class="form-group col-lg-3">
                            <@form.selectOptions "form.idTypProcedury" typProceduryList "Typ Procedury" />
                        </div>
                        <div class="form-group col-lg-3">
                            <@form.selectOptions "form.idZarizeni" zarizeniList "Zarizeni" />
                        </div>
                        <div class="form-group col-lg-3">
                            <@form.selectOptions "form.idLekar" lekarList "Lekar" />
                        </div>
                    </div>
                    <input type="submit" class="btn btn-lg btn-success mt-4" value="Update"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>