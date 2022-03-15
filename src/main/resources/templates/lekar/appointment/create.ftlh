<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <h1>Nova procedura</h1>
            <hr>
            <form method="post" action="/lekar/procedura/create">
                <div class="form-group">
                    <label for="popisField">Popis</label>
                    <@spring.formInput "createForm.popis" "class=\"form-control\" id=\"popisField\" " />
                    <@spring.showErrors "" "validation-error-label" />
                </div>
                <@form.inputDate "createForm.datum" "Datum" "class=\"form-control\""/>
                <@form.selectOptions "createForm.idHospitalizace" hospitalizaceList "Pacient"/>
                <@form.selectOptions "createForm.idTypProcedury"  typProceduryList "Procedura" />
                <@form.selectOptions "createForm.idZarizeni" zarizeniList "Zarizeni" />
                <button type="submit" class="btn btn-primary mt-3">Submit</button>
            </form>
        </div>
    </div>

</@layout.render>