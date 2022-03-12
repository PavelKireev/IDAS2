<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-12">
            <div class="bg-light border rounded p-4 mb-3">
                <form class="form-signin user" action="/admin/mistnost/ordinace/${id}/update" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="nazev">
                                Nazev
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.nazev" "required class=\"form-control form-control-sm\" placeholder=\"Nazev\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <label for="cislo">
                                Cislo
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.cislo" "required class=\"form-control form-control-sm\" placeholder=\"Cislo\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <label>
                                Plocha
                            </label>
                            <div class="form-group">
                                <@spring.formInput "updateForm.plocha" "required class=\"form-control form-control-sm\" placeholder=\"Plocha\"" />
                                <@spring.showErrors "<br>" "small"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group ml-2 row">
                            <div class="form-check">
                                <@spring.formCheckbox "updateForm.jeVProvozu" "class=\"form-check-input\" type=\"checkbox\" id=\"flexCheckDefault\""/>
                                <label class="form-check-label" for="flexCheckDefault">
                                    Je V Provozu
                                </label>
                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-lg btn-success mt-3" value="Update"/>
                </form>
            </div>
        </div>
    </div>

</@layout.render>