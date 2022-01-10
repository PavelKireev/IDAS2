<#import '/spring.ftl' as spring>
<#import 'navbar.ftlh' as layout>
<#import '../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
    <div class="col-lg-8">
        <h1>${user.getJmeno()!""} ${user.getPrijmeni()!""} </h1>
        <hr>
        <form method="post" action="/pacient/profile/info/update">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1"
                       aria-describedby="emailHelp" disabled value="${pacientView.getEmail()!""}">
            </div>
            <div class="form-group">
                <label for="jmenoField">Jmeno</label>
                <input type="text" class="form-control" id="jmenoField" disabled value="${pacientView.getJmeno()!""}">
            </div>
            <div class="form-group">
                <label for="prijmeniField">Prijmeni</label>
                <input type="text" class="form-control" id="prijmeniField" disabled
                       value="${pacientView.getPrijmeni()!""}">
            </div>
            <div class="form-group">
                <div class="mt-2">
                    <label for="telCisloField">Telefonni Cislo</label>
                </div>
                <@spring.formInput "pacientForm.telCislo" "class=\"form-control\" id=\"telCisloField\" value=\"$\{pacientView.getTelCislo()!""}\"" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="form-group">
                <div class="mt-2">
                    <label for="adresaField">Adresa</label>
                </div>
                <@spring.formInput "pacientForm.adresa" "class=\"form-control\" id=\"adreseField\" value=\"$\{pacientView.getTelCislo()!""}\"" />
                <@spring.showErrors "" "validation-error-label" />
            </div>
            <div class="form-group">
                <div class="mt-2">
                    <label for="datumNarozeniField">Datum Narozeni</label>
                </div>
                <input class="form-control" id="datumNarozeniField" disabled
                       value="${pacientView.getDatumNarozeni()!""}">
            </div>
            <div class="form-group">
                <label for="rustField">Rust</label>
                <input type="text" class="form-control" id="rustField" value="${pacientView.getRust()!""}" disabled>
            </div>
            <div class="form-group">
                <label for="hmotnostField">Hmotnost</label>
                <input type="text" class="form-control" id="hmotnostField" disabled
                       value="${pacientView.getHmotnost()!""}">
            </div>
            <div class="form-group">
                <label for="pokojField">Pokoj</label>
                <input type="text" class="form-control" id="pokojField" disabled
                       value="${pacientView.getPokojCislo()!""}">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>


    <div class="row col-lg-4" style="display: flex; justify-content: flex-end">
<#--            <img src=${avatar!"/static/img/undraw_profile.svg"} class="img-fluid"/>-->
    <form method="post" enctype="multipart/form-data" action="/pacient/profile/avatar">
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
                <button type="submit" class="btn btn-primary">Submit</button>

            </div>
            <#--                    <div class="input-group-prepend">-->
            <#--                        <span class="input-group-text" type="submit" id="inputGroupFileAddon01">Upload</span>-->
            <#--                    </div>-->
            <#--                    <div class="custom-file">-->
            <#--                        <input type="file"-->
            <#--                               class="custom-file-input"-->
            <#--                               id="obrazek" name="obrazek"-->
            <#--                               aria-describedby="inputGroupFileAddon01">-->
            <#--                        <label class="custom-file-label" for="obrazek">Choose file</label>-->
            <#--                    </div>-->
            <#--                </div>-->
            <#--                <div class="form-group">-->
            <#--                    <label for="exampleFormControlFile1">Example file input</label>-->
            <#--                    <input type="file" class="form-control-file" id="obrazek" name="obrazek">-->
            <#--                </div>-->
            <#--                <button type="submit" class="btn btn-primary">Submit</button>-->
        </div>
    </form>

    <script>
        $('#obrazek').on('change', function () {
            //get the file name
            var fileName = $(this).val();
            //replace the "Choose a file" label
            $(this).next('.custom-file-label').html(fileName);
        })
    </script>

</@layout.render>