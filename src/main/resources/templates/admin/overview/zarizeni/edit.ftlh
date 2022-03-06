<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>


<@layout.render>
    <h1>Edit Zarizeni</h1>
    <hr>
    <form method="post" action="/admin/zarizeni/${id}/update">
        <div class="form-row">
            <div class="col-lg-4">
                <div class="mt-2">
                    <label for="jmenoField">Nazev</label>
                </div>
                <@spring.formInput "form.nazev" "class=\"form-control\" id=\"titulField\"" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="col-lg-4">
                <div class="form-row">
                    <div class="mt-2">
                        <label for="textField">Znacka</label>
                    </div>
                    <@spring.formInput "form.znacka" "class=\"form-control\" id=\"textField\"" />
                    <@spring.showErrors "" "validation-error-label" />
                </div>
            </div>
            <div class="col-lg-4 ml-1">
                <@form.inputDate "form.datumVyroby" "Datum Vyroby" "class=\"form-control\""/>
            </div>
        </div>
        <div class="form-row">
            <div class="col-lg-4 ml-1">
                <@form.selectOptions "form.idTypZarizeni" typZarizeniList "Typ Zarizeni" />
            </div>
            <div class="col-lg-4 ml-1">
                <@form.selectOptions "form.idMistnost" ordinaceList "Ordinace" />
            </div>
            <div class="col-lg-4 ml-1">
                <div class="form-row">
                    <div class="form-check">
                        <@spring.formCheckbox "form.jeFunkcni" "class=\"form-check-input\" type=\"checkbox\" id=\"flexCheckDefault\""/>
                        <label class="form-check-label" for="flexCheckDefault">
                            Je Funkcni
                        </label>
                    </div>
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form>

</@layout.render>