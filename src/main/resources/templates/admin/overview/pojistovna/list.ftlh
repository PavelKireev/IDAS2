<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Pojistovna</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/pojistovna/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nazev</th>
            <th scope="col">Adresa</th>
            <th scope="col">Telefonni Cislo</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getNazev()!""}</td>
                <td>${item.getAdresa()!""}</td>
                <td>${item.getTelCislo()!""}</td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/pojistovna/${item.getId()}/edit"
                       role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/pojistovna/${item.getId()}/delete"
                       role="button">Delete</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>