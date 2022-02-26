<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Pacient</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/uzivatel/pacient/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Popis</th>
            <th scope="col">Pacient</th>
            <th scope="col">Lekar</th>
            <th scope="col">Typ Procedury</th>
            <th scope="col">Typ Zarizeni</th>
            <th scope="col">Datum</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getPopis()!""}</td>
                <td>${item.getJmenoPacient()!""} ${item.getPrijmeniPacient()!""}</td>
                <td>${item.getJmenoLekar()!""} ${item.getPrijmeniLekar()!""}</td>
                <td>${item.getIdTypProcedury()}</td>
                <td>${item.getNazevZarizeni()!""} ${item.getTypZarizeniNazev()!""}</td>
                <td>${item.getDatum()!""}</td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/procedura/${item.getId()}/edit"
                       role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/procedura/${item.getId()}/delete"
                       role="button">Delete</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>