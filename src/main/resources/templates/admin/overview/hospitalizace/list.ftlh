<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Hospitalizace</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/hospitalizace/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">Jmeno a Prijmeni</th>
            <th scope="col">Duvod</th>
            <th scope="col">Doba</th>
            <th scope="col">Stav</th>
            <th scope="col">Pokoj</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getId()!""}</td>
                <td>${item.getPacientJmeno()!""} ${item.getPacientPrijmeni()!""}</td>
                <td>${item.getDuvod()!""}</td>
                <td>Od: ${item.getHospitalizaceOd()!""} <br> Do: ${item.getHospitalizaceDo()!""}</td>
                <td>${item.getStavPacienta()!""}</td>
                <td>${item.getPokojCislo()!""} ${item.getPokojNazev()!""}</td>
                <td>
                    <a class="btn mb-1 btn-secondary ml-5"
                       href="/admin/hospitalizace/${item.getId()}/zaznam"
                       role="button">Zaznamy</a>
                </td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/hospitalizace/${item.getId()}/edit" role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/hospitalizace/${item.getId()}/delete" role="button">Delete</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>