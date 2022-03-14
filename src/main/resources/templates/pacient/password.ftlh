<#import '/spring.ftl' as spring>
<#import 'navbar.ftlh' as layout>
<#import '../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
    <div class="col-lg-12">
        <form method="post" action="/pacient/password/update">

            <div class="form-group" style="display: none">
                <@spring.formInput "passwordForm.id" "required class=\"form-control form-control-sm\" placeholder=\"Password\"" />
                <@spring.showErrors "" "validation-error-label" />
            </div>

            <div class="form-group">
                <div class="mt-2">
                    <label for="telCisloField">Aktualni heslo</label>
                </div>
                <@spring.formInput "passwordForm.currentPassword" "required class=\"form-control form-control-sm\" placeholder=\"Aktualni Heslo\"" "password" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="form-group">
                <div class="mt-2">
                    <label for="adresaField">Nove heslo</label>
                </div>
                <@spring.formInput "passwordForm.password" "required class=\"form-control form-control-sm\" placeholder=\"Nove Heslo\"" "password" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="form-group">
                <div class="mt-2">
                    <label for="adresaField">Nove heslo potvrzeni</label>
                </div>
                <@spring.formInput "passwordForm.passwordConfirm" "required class=\"form-control form-control-sm\" placeholder=\"Heslo Potvrzeni\"" "password" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</@layout.render>