<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <h2>Log</h2>
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Text</th>
                <th scope="col">Tabulka</th>
                <th scope="col">Jmeno a Prijmeni</th>
                <th scope="col">Email</th>
                <th scope="col">Telefonni Cislo</th>
                <th scope="col">Stav</th>
                <th scope="col">Akce</th>
                <th scope="col">Datum</th>
            </tr>
            </thead>
            <tbody>
            <#list list as item>
                <tr>
                    <th scope="row">${count}</th>
                    <td>${item.getText()!""}</td>
                    <td>${item.getTabulka()!""}</td>
                    <td>${item.getJmeno()!""} ${item.getPrijmeni()!""}</td>
                    <td>${item.getEmail()!""}</td>
                    <td>${item.getTelCislo()!""}</td>
                    <td>${item.getStav()!""}</td>
                    <td>${item.getAkce()!""}</td>
                    <td>${item.getDatum()!""}</td>
                </tr>
                <#assign count = count + 1 >
            </#list>
            </tbody>
        </table>
    </div>
</@layout.render>