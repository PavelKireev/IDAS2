<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>


<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <h1>Nemocnicni Pokoj</h1>
            <hr>
            <form method="post" action="/admin/mistnost/pokoj/${id}/update">
                <div class="form-row">
                    <div class="form-group col-lg-6">
                        <div class="mt-2">
                            <label for="nazevField">Nazev</label>
                        </div>
                        <@spring.formInput
                        "updateForm.nazev"
                        "class=\"form-control\" id=\"nazevField\" value=\"$\{form.getEmail()!\"\"}\""
                        />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-6">
                        <div class="mt-2">
                            <label for="cisloField">Cislo</label>
                        </div>
                        <@spring.formInput "updateForm.cislo" "class=\"form-control\" id=\"cisloField\" value=\"$\{form.getCislo()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="plochaField">Plocha</label>
                        </div>
                        <@spring.formInput "updateForm.plocha" "class=\"form-control\" id=\"plochaField\" value=\"$\{form.getPlocha()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="kapacitaField">Kapacita</label>
                        </div>
                        <@spring.formInput "updateForm.kapacita" "class=\"form-control\" id=\"kapacitaField\" value=\"$\{form.getKapacita()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="pocetPacientuField">Pocet Pacietntu</label>
                        </div>
                        <@spring.formInput "updateForm.pocetPacientu" "class=\"form-control\" id=\"pocetPacientuField\" value=\"$\{form.getPocetPacientu()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

</@layout.render>