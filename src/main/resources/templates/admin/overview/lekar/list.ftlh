<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Lekar</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/uzivatel/lekar/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">Jmeno a Prijmeni</th>
            <th scope="col">Email</th>
            <th scope="col">Telefonni Cislo</th>
            <th scope="col">Plat</th>
            <th scope="col">Specializace</th>
            <th scope="col">Kancelar</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getId()!""}</td>
                <td>${item.getJmeno()!""} ${item.getPrijmeni()!""}</td>
                <td>${item.getEmail()!""}</td>
                <td>${item.getTelCislo()!""}</td>
                <td>${item.getPlat()}</td>
                <td>${item.getSpecializaceNazev()!""}</td>
                <td>${item.getKancelarCislo()!""} ${item.getKancelarNazev()!""}</td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/uzivatel/lekar/${item.getId()}/edit" role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/uzivatel/lekar/${item.getId()}/delete" role="button">Delete</a>
                </td>
                <td>
                    <a class="btn btn-warning ml-4" href="/admin/uzivatel/lekar/${item.getId()}/simulate"
                       role="button">Simulace</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>