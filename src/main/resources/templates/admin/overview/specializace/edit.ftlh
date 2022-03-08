<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>


<@layout.render>

    <h1>Update Pojistovna</h1>
    <hr>
    <form method="post" action="/admin/specializace/${id}/update">
        <div class="form-row">
            <div class="col-lg-5">
                <div class="mt-2">
                    <label for="jmenoField">Nazev</label>
                </div>
                <@spring.formInput "updateForm.nazev" "class=\"form-control\" id=\"titulField\"" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="col-lg-5">
                <div class="form-row">
                    <div class="mt-2">
                        <label for="textField">Popis</label>
                    </div>
                    <@spring.formInput "updateForm.popis" "class=\"form-control\" id=\"textField\"" />
                    <@spring.showErrors "" "validation-error-label" />
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form>

</@layout.render>