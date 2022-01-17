<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Pacient</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/table/PACIENT/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">Uuid</th>
            <th scope="col">Jmeno a Prijmeni</th>
            <th scope="col">Email</th>
            <th scope="col">Telefonni Cislo</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getId()!""}</td>
                <td>${item.getUuid()!""}</td>
                <td>${item.getJmeno()!""} ${item.getPrijmeni()!""}</td>
                <td>${item.getEmail()!""}</td>
                <td>${item.getTelCislo()!""}</td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/table/PACIENT/${item.getId()}/update" role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/table/PACIENT/${item.getId()}/delete" role="button">Delete</a>
                </td>
                <td>
                    <a class="btn btn-warning ml-4" href="/admin/table/PACIENT/${item.getId()}/simulate"
                       role="button">Simulace</a>
                </td>

                <#--                <td>-->
                <#--                    <div class="row">-->
                <#--                        <a href="${item}"> ${item!""} </a>-->
                <#--                                                <a class="btn btn-primary ml-4" href="" role="button">Update</a>-->
                <#--                                                <a class="btn btn-danger ml-4" href="" role="button">Delete</a>-->
                <#--                    </div>-->
                <#--                </td>-->
            </tr>
            <#assign count = count + 1 >
        </#list>
        </tbody>
    </table>
</@layout.render>