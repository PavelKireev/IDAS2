<#import '/spring.ftl' as spring>
<#import '../../navbar.ftlh' as layout>
<#import '../../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Administrator</h2>
        <a class="btn btn-success ml-4 mb-2" href="/admin/uzivatel/admin/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">Nazev a Cislo</th>
            <th scope="col">Plocha</th>
            <th scope="col">Kapacita</th>
            <th scope="col">Pocet Pacientu</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getId()!""}</td>
                <td>${item.getNazev()!""} ${item.getCislo()!""}</td>
                <td>${item.getPlocha()!""}</td>
                <td>${item.getKapacita()!""}</td>
                <td>${item.getPocetPacientu()!""}</td>
                <td>
                    <a class="btn btn-primary ml-4" href="/admin/mistnost/pokoj/${item.getId()}/edit" role="button">Update</a>
                </td>
                <td>
                    <a class="btn btn-danger ml-4" href="/admin/mistnost/pokoj/${item.getId()}/delete" role="button">Delete</a>
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