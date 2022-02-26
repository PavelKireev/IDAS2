<#import '/spring.ftl' as spring>
<#import '../../../navbar.ftlh' as layout>
<#import '../../../../partials/form.ftlh' as form>


<@layout.render>

    <#assign count = 1>

    <div class="row mb-2 ml-1">
        <h2>Zaznamy</h2>
        <a
                class="btn btn-success mb-1 ml-3"
                href="/admin/hospitalizace/${hospId}/zaznam/create"
                role="button">Pridat</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Titul</th>
            <th scope="col">Text</th>
            <th scope="col">Lekar</th>
            <th scope="col">Datum Vytvareni</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getTitul()!""}</td>
                <td>${item.getText()!""}</td>
                <td>${item.getJmeno()!""} ${item.getPrijmeni()!""}</td>
                <td>${item.getDatumVytvareni()!""}</td>
<#--                <td>-->
<#--                    <a-->
<#--                            class="btn mb-1 btn-primary ml-5"-->
<#--                            href="/admin/hospitalizace/${hospId}/zaznam/${item.getId()}/edit"-->
<#--                            role="button">Update</a>-->
<#--                </td>-->
                <td>
                    <a
                            class="btn mb-1 btn-danger ml-5"
                            href="/admin/hospitalizace/${hospId}/zaznam/${item.getId()}/delete"
                            role="button">Delete</a>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>

</@layout.render>