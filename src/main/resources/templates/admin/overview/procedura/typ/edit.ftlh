<#import '/spring.ftl' as spring>
<#import '../../../navbar.ftlh' as layout>
<#import '../../../../partials/form.ftlh' as form>


<@layout.render>

    <h1 xmlns="http://www.w3.org/1999/html">Create Typ Zarizeni</h1>
    <hr>
    <form method="post" action="/admin/procedura/typ/save">
        <div class="form-row">
            <div class="mt-2">
                <label for="jmenoField">Nazev</label>
            </div>
            <@spring.formInput "typUpdateForm.nazev" "class=\"form-control\" id=\"titulField\"" />
            <@spring.showErrors "" "validation-error-label" />
        </div>
        <div class="form-row">
            <div class="mt-2">
                <label for="textField">Popis</label>
            </div>
            <@spring.formTextarea "typUpdateForm.popis" "class=\"form-control\" id=\"textField\"" />
            <@spring.showErrors "" "validation-error-label" />
        </div>

        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form>

</@layout.render>