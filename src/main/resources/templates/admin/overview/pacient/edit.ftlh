<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>


<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <h1>Profile</h1>
            <hr>
            <form method="post" action="/admin/uzivatel/pacient/${pacientView.getUuid()}/profile/update">
                <div class="form-row">
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="emailField">Email address</label>
                        </div>
                        <@spring.formInput
                        "pacientUpdateForm.email"
                        "class=\"form-control\" id=\"emailField\"
                    type=\"email\" value=\"$\{pacientView.getEmail()!\"\"}\""
                        />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="jmenoField">Jmeno</label>
                        </div>
                        <@spring.formInput "pacientUpdateForm.jmeno" "class=\"form-control\" id=\"jmenoField\" value=\"$\{pacientView.getJmeno()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="prijmeniField">Prijmeni</label>
                        </div>
                        <@spring.formInput "pacientUpdateForm.prijmeni" "class=\"form-control\" id=\"prijmeniField\" value=\"$\{pacientView.getPrijmeni()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-lg-4">
                        <div class="mt-2">
                            <label for="telCisloField">Telefonni Cislo</label>
                        </div>
                        <@spring.formInput "pacientUpdateForm.telCislo" "class=\"form-control\" id=\"telCisloField\" value=\"$\{pacientView.getTelCislo()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-8">
                        <div class="mt-2">
                            <label for="adresaField">Adresa</label>
                        </div>
                        <@spring.formInput "pacientUpdateForm.adresa" "class=\"form-control\" id=\"adresaField\" value=\"$\{pacientView.getAdresa()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-lg-3">
                        <@form.inputBirthDate "pacientUpdateForm.datumNarozeni" "Datum Narozeni" "class=\"form-control\" id=\"datumNarozeniField\" value=\"$\{pacientView.getDatumNarozeni()!\"\"}\"" />
                    </div>
                    <div class="form-group col-lg-3">
                        <div class="mt-2">
                            <label for="rustField">Rust</label>
                        </div>
                        <@spring.formInput "pacientUpdateForm.rust" "class=\"form-control\" id=\"rustField\" value=\"$\{pacientView.getRust()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-3">
                        <div class="mt-2">
                            <label for="hmotnostField">Hmotnost</label>
                        </div>
                        <@spring.formInput "pacientUpdateForm.hmotnost" "class=\"form-control\" id=\"hmotnostField\" value=\"$\{pacientView.getHmotnost()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-3">
                        <@form.selectOptions "pacientUpdateForm.idPokoj" pokojList "Pokoj"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <hr>
            <h1>Zdravotni Karta</h1>
            <hr>
            <form method="post" action="/admin/uzivatel/pacient/${pacientView.getUuid()}/karta/update">
                <div class="form-row">
                    <div class="form-group col-lg-4">
                        <@form.inputDate "kartaForm.platnostOd" "Platnost Od" "class=\"form-control\" id=\"datumNarozeniField\" value=\"$\{pacientView.getDatumNarozeni()!\"\"}\"" />
                    </div>
                    <div class="form-group col-lg-4">
                        <@form.inputDate "kartaForm.platnostDo" "Platnost Do" "class=\"form-control\" id=\"datumNarozeniField\" value=\"$\{pacientView.getDatumNarozeni()!\"\"}\"" />
                    </div>
                    <div class="form-group col-lg-4 mt-2">
                        <label for="datumVytvareniField">Datum Vytvareni</label>
                        <input type="text" class="form-control" id="datumVytvareniField" disabled
                               value="${zdravotniKarta.getDatumVytvareni()!""}">
                    </div>
                </div>
                <div class="row">
                    <button type="submit" class="btn mb-1 btn-primary ml-3">Submit</button>
                    <a class="btn mb-1 btn-success ml-5" href="/lekar/pacient/${pacientView.getUuid()}/zaznam/add" role="button">Novy Zaznam</a>
                    <a class="btn mb-1 btn-secondary ml-5" href="/lekar/pacient/${pacientView.getUuid()}/zaznam/list" role="button">Seznam Zaznamu</a>
                </div>
            </form>
            <hr>
            <h1>Pojisteni</h1>
            <hr>
            <form method="post" action="/admin/uzivatel/pacient/${pacientView.getUuid()}/pojisteni/update">
                <div class="form-row">
                    <div class="form-group col-lg-5">
                        <div class="mt-2">
                            <label for="pojisteniCisloKartyField">Cislo Karty</label>
                        </div>
                        <@spring.formInput "pojisteniForm.cisloKarty" "class=\"form-control\" id=\"pojisteniCisloKartyField\" value=\"$\{pojisteni.getCisloKarty()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-5">
                        <div class="mt-2">
                            <label for="pojisteniCisloSmlouvyField">Cislo Smlouvy</label>
                        </div>
                        <@spring.formInput "pojisteniForm.cisloSmlouvy" "class=\"form-control\" id=\"pojisteniCisloSmlouvyField\" value=\"$\{pojisteni.getCisloSmlouvy()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-2">
                        <div class="mt-2">
                            <label for="pojisteniCisloSmlouvyField">Pojistna Castka</label>
                        </div>
                        <@spring.formInput "pojisteniForm.pojistnaCastka" "class=\"form-control\" id=\"pojisteniCastkaField\" value=\"$\{pojisteni.getPojistnaCastka()!\"\"}\"" />
                        <@spring.showErrors "" "validation-error-label" />
                    </div>
                    <div class="form-group col-lg-4 mt-2">
                        <@form.inputDate "pojisteniForm.pojisteniOd" "Platnost Od" "class=\"form-control\" id=\"datumNarozeniField\" value=\"$\{pacientView.getDatumNarozeni()!\"\"}\"" />
                    </div>
                    <div class="form-group col-lg-4 mt-2">
                        <@form.inputDate "pojisteniForm.pojisteniDo" "Platnost Do" "class=\"form-control\" id=\"datumNarozeniField\" value=\"$\{pacientView.getDatumNarozeni()!\"\"}\"" />
                    </div>
                    <div class="form-group col-lg-4">
                        <@form.selectOptions "pojisteniForm.pojistovnaIdPojistovna" pojistovnaList "Pojistovna"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>

        <div class="row col-lg-4" style="display: flex; justify-content: flex-end">
            <#--            <img src=${avatar!"/static/img/undraw_profile.svg"} class="img-fluid"/>-->
            <form method="post" enctype="multipart/form-data" action="/admin/uzivatel/pacient/avatar/${pacientView.getUuid()}update">
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