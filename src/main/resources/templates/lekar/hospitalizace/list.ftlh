<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>

<@layout.render>

    <#assign count = 1>

    <h2>Historie Hospitalizace</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Od</th>
            <th scope="col">Duvod</th>
            <th scope="col">Stav</th>
            <th scope="col">Do</th>
            <th scope="col">Cislo Pokoje</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getHospitalozaceOd()!""}</td>
                <td>${item.getDuvod()!""}</td>
                <td>${item.getStavPacienta()!""}</td>
                <td>${item.getHospitalizaceDo()!""}</td>
                <td>${item.getPokojCislo()!""}</td>
                <td>
                    <a class="btn mb-1 btn-secondary ml-5"
                       href="/lekar/hospitalizace/zaznam/list?hospId=${item.getId()}"
                       role="button">Zaznamy</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>