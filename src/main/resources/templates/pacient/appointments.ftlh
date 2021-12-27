<#import '/spring.ftl' as spring>
<#import 'navbar.ftlh' as layout>
<#import '../partials/form.ftlh' as form>

<@layout.render>

    <#assign count = 1>

    <h2> Procedury </h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Popis Procedury</th>
            <th scope="col">Cislo Ordinace</th>
            <th scope="col">Lekar</th>
            <th scope="col">Datum</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getPopis()!""}</td>
                <td>${item.getOrdinaceCislo()!""}</td>
                <td>${item.getJmenoLekar()!""} ${item.getPrijmeniLekar()!""}</td>
                <td>${item.getDatum()!""}</td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>