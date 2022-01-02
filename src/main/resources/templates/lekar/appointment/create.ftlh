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
                    <label for="telCisloField">Popis</label>
                    <@spring.formInput "form.popis" "class=\"form-control\" id=\"popisField\" " />
                    <@spring.showErrors "" "validation-error-label" />
                </div>
                <@form.inputDate "form.datum" "Datum"/>
                <div class="input-group mb-3">
                    <select class="custom-select" id="inputGroupSelect02">
                        <option selected>Choose...</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                    <div class="input-group-append">
                        <label class="input-group-text" for="inputGroupSelect02">Options</label>
                    </div>
                </div>
                <@form.selectOptions "form.hospitalizace" hospitalizaceList "id" "pacientPrijmeni" />
                <@form.select2 "form.hospitalizace" "Hospitalizace" "/reference/hospitalizace" form.hospitalizace!""/>
                <@form.select2 "form.idTypProcedury" "Procedura" "" form.idTypProcedury!""/>
                <@form.select2 "form.idTypZarizeni" "Zarizeni" "/reference/typzarizeni" form.idTypZarizeni!""/>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

</@layout.render>