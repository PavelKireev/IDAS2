<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Ordinace</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/mistnost/ordinace/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">Cislo a Nazev</th>
            <th scope="col">Plocha</th>
            <th scope="col">Je V Provozu</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getId()!""}</td>
                <td>${item.getCislo()!""} ${item.getNazev()!""}</td>
                <td>${item.getPlocha()!""}</td>
                <#if item.getJeVProvozu()>
                    <td>Ano</td>
                <#else>
                    <td>Ne</td>
                </#if>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/mistnost/ordinace/${item.getId()}/edit" role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/mistnost/ordinace/${item.getId()}/delete" role="button">Delete</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>