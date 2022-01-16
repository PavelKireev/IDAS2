<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>


<@layout.render>

    <#assign count = 1>

    <div class="row">
        <h2>Pacienty</h2>
        <#--        <a class="btn mb-1 btn-success ml-4" href="/lekar/procedura/add" role="button">Pridat</a>-->
    </div>

    <div class="mt-2">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Jmeno</th>
                <th scope="col">Prijmeni</th>
                <th scope="col">Pokoj</th>
                <th scope="col">Více Info</th>
                <th scope="col">Delete</th>
            </tr>
            </thead>
            <tbody>
            <#list list as item>
                <tr>
                    <th scope="row">${count}</th>
                    <td>${item.getJmeno()!""}</td>
                    <td>${item.getPrijmeni()!""}</td>
                    <td>${item.getPokojCislo()!""}</td>
                    <td><a class="btn btn-primary ml-4" href="/lekar/pacient/${item.getUuid()}/edit"
                           role="button">Info</a>
                    </td>
                    <td><a class="btn btn-danger ml-4" href="/lekar/pacient/delete?pacId=${item.getId()}"
                           role="button">Smazat Ucet</a>
                    </td>
                </tr>
                <#assign count = count + 1 >
            </#list>
            </tbody>
        </table>
    </div>

</@layout.render>