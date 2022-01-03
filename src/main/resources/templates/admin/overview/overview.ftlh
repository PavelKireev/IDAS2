<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <h2>Prehled Tabulek </h2>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tabulka</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>
                    <div class="row">
                        <a href="/admin/table/${item}"> ${item!""} </a>
<#--                        <a class="btn btn-primary ml-4" href="" role="button">Update</a>-->
<#--                        <a class="btn btn-danger ml-4" href="" role="button">Delete</a>-->
                    </div>
                </td>
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>