<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Zarizeni</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/zarizeni/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nazev</th>
            <th scope="col">Znacka</th>
            <th scope="col">Datum Vyroby</th>
            <th scope="col">Mistnost</th>
            <th scope="col">Typ Zarizeni</th>

        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getNazev()!""}</td>
                <td>${item.getZnacka()!""}</td>
                <td>${item.getDatumVyroby()!""}</td>
                <td>${item.getOrdinaceCislo()!""} ${item.getOrdinaceNazev()!""}</td>
                <td>${item.getTypZarizeniNazev()!""}</td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/zarizeni/${item.getId()}/edit"
                       role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/zarizeni/${item.getId()}/delete"
                       role="button">Delete</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>