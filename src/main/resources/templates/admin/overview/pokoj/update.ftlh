<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>


<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <h1>Profile</h1>
            <hr>
            <form method="post" action="/admin/uzivatel/admin/${view.getId()}/update">
                <div class="form-row">
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="emailField">Email address</label>
                        </div>
                        <@spring.formInput
                        "form.email"
                        "class=\"form-control\" id=\"emailField\"
                    type=\"email\" value=\"$\{view.getEmail()!\"\"}\""
                        />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="jmenoField">Jmeno</label>
                        </div>
                        <@spring.formInput "form.jmeno" "class=\"form-control\" id=\"jmenoField\" value=\"$\{form.getJmeno()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="prijmeniField">Prijmeni</label>
                        </div>
                        <@spring.formInput "form.prijmeni" "class=\"form-control\" id=\"prijmeniField\" value=\"$\{form.getPrijmeni()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="mt-2">
                        <label for="telCisloField">Telefonni Cislo</label>
                    </div>
                    <@spring.formInput "form.telCislo" "class=\"form-control\" id=\"telCisloField\" value=\"$\{form.getTelCislo()!\"\"}\"" />
                    <@spring.showErrors "" "validation-error-label" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <div class="row col-lg-4" style="display: flex; justify-content: flex-end">
            <#--            <img src=${avatar!"/static/img/undraw_profile.svg"} class="img-fluid"/>-->
            <form method="post" enctype="multipart/form-data"
                  action="/admin/uzivatel/admin/avatar/${view.getUuid()}/update">
                <div class="input-group mb-3 mt-3">
                    <div class="card" style="width: 26rem;">
                        <img class="card-img-top" src="${avatar!"/static/img/undraw_profile.svg"}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Profile Photo</h5>
                            <div class="custom-file">
                                <input type="file"
                                       class="custom-file-input"
                                       id="obrazek" name="obrazek"
                                       aria-describedby="inputGroupFileAddon01">
                                <label class="custom-file-label" for="obrazek">Choose file</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary mt-1">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script>
        $('#obrazek').on('change', function () {
            //get the file name
            var fileName = $(this).val();
            //replace the "Choose a file" label
            $(this).next('.custom-file-label').html(fileName);
        })
    </script>

</@layout.render>