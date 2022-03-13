<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>


<@layout.render>

    <h1>Profile</h1>
    <hr>
    <form method="post" action="/lekar/hospitalizace/zaznam/create?hospId=${hospId}">
        <div class="form-row">
            <div class="mt-2">
                <label for="jmenoField">Titul</label>
            </div>
            <@spring.formInput "zaznamCreateForm.titul" "class=\"form-control\" id=\"titulField\"" />
            <@spring.showErrors "" "validation-error-label" />
        </div>

        <div class="form-row">
            <div class="mt-2">
                <label for="textField">Text</label>
            </div>
            <@spring.formTextarea "zaznamCreateForm.text" "class=\"form-control\" id=\"textField\"" />
            <@spring.showErrors "" "validation-error-label" />
        </div>
        <button type="submit" class="btn btn-primary mt-2">Submit</button>
    </form>

</@layout.render>