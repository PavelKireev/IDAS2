<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>


<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <h1>${lekarView.getJmeno()!""} ${lekarView.getPrijmeni()!""} <br></h1>
            <hr>
            <form method="post" action="/lekar/profile/info/update">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1"
                           aria-describedby="emailHelp" disabled value="${lekarView.getEmail()!""}">
                </div>
                <div class="form-group">
                    <label for="jmenoField">Jmeno</label>
                    <input type="text" class="form-control" id="jmenoField" disabled value="${lekarView.getJmeno()!""}">
                </div>
                <div class="form-group">
                    <label for="prijmeniField">Prijmeni</label>
                    <input type="text" class="form-control" id="prijmeniField" disabled
                           value="${lekarView.getPrijmeni()!""}">
                </div>
                <div class="form-group">
                    <label for="telCisloField">Telefonni Cislo</label>
                    <@spring.formInput "updateForm.telCislo" "class=\"form-control\" id=\"telCisloField\" value=\"$\{lekarView.getTelCislo()!""}\"" />
                    <@spring.showErrors "" "validation-error-label" />
                </div>
                <div class="form-group">
                    <div class="mt-2">
                        <label for="kancelarField">Kancelar</label>
                    </div>
                    <input type="text" class="form-control" id="kancelarField" disabled
                           value="${lekarView.getKancelarCislo()!""}">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>


        <div class="row col-lg-4" style="display: flex; justify-content: flex-end">
            <form method="post" enctype="multipart/form-data" action="/lekar/profile/avatar">
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