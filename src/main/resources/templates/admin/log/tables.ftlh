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
                <th scope="col">Akce</th>
                <th scope="col">Tabulka</th>
                <th scope="col">Datum</th>
                <th scope="col">Text</th>
                <th scope="col">Primarni Klic</th>

            </tr>
            </thead>
            <tbody>
            <#list list as item>
                <tr>
                    <th scope="row">${count}</th>
                    <td>${item.getAkce()!""}</td>
                    <td>${item.getTabulka()!""}</td>
                    <td>${item.getDatum()!""}</td>
                    <td>${item.getText()!""}</td>
                    <td>${item.getPrimarniKlic()!""}</td>
                </tr>
                <#assign count = count + 1 >
            </#list>
            </tbody>
        </table>
    </div>
</@layout.render>