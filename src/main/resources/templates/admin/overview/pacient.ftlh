<#import '/spring.ftl' as spring>
<#import '../navbar.ftlh' as layout>
<#import '../../partials/form.ftlh' as form>

<@layout.render>
    <#assign count = 1>

    <div class="row">
        <h2>Pacient</h2>
        <a class="btn btn-success ml-4" href="/admin/table/PACIENT/create" role="button">Create</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Id</th>
            <th scope="col">Rust</th>
            <th scope="col">Hmotnost</th>
            <th scope="col">Datum Narozeni</th>
            <th scope="col">Nemocnicni Pokoj Id</th>
            <th scope="col">Adresa</th>
            <th scope="col">Otec Id</th>
            <th scope="col">Matka Id</th>
        </tr>
        </thead>
        <tbody>
        <#list list as item>
            <tr>
                <th scope="row">${count}</th>
                <td>${item.getUzivatelIdUzivatel()!""}</td>
                <td>${item.getRust()!""}</td>
                <td>${item.getHmotnost()!""}</td>
                <td>${item.getDatumNarozeni()!""}</td>
                <td>${item.getNemocnicniPokojIdMistnost()!""}</td>
                <td>${item.getAdresa()!""}</td>
                <td>${item.getIdOtec()!""}</td>
                <td>${item.getIdMatka()!""}</td>
                <td><a class="btn btn-primary ml-4" href="/admin/table/PACIENT/${item.getId()}/update" role="button">Update</a>
                </td>
                <td><a class="btn btn-danger ml-4" href="/admin/table/PACIENT/${item.getId()}/delete" role="button">Delete</a>
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