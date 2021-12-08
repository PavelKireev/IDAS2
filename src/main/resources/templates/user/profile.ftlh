<#import '../layout/navbar.ftlh' as layout>
<#import '../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <h1>${user.getJmeno()!""} ${user.getPrijmeni()!""} ${pacientView.getUuid()!""}</h1>
            <hr>
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
<#--                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone-->
<#--                        else.</small>-->
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Jmeno</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Prijmeni</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Telefonni cislo</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Rust</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Hmotnost</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Datum narozeni</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Pokoj</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>


        <div class="row col-lg-4" style="display: flex; justify-content: flex-end">
<#--            <img src=${avatar!"/static/img/undraw_profile.svg"} class="img-fluid"/>-->
            <form method="post" enctype="multipart/form-data" action="/profile/avatar">
                <div class="input-group mb-3 mt-3">
                    <div class="card" style="width: 26rem;">
                        <img class="card-img-top" src="${avatar!"/static/img/undraw_profile.svg"}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Profile Photo</h5>
                            <div class="custom-file">
                                <input type="file"
                                       class="custom-file-input"
                                       id="obrazek" name="obrazek"
                                       aria-describedby="inputGroupFileAddon01">
                                <label class="custom-file-label" for="obrazek">Choose file</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>

                    </div>
                    <#--                    <div class="input-group-prepend">-->
                    <#--                        <span class="input-group-text" type="submit" id="inputGroupFileAddon01">Upload</span>-->
                    <#--                    </div>-->
<#--                    <div class="custom-file">-->
<#--                        <input type="file"-->
<#--                               class="custom-file-input"-->
<#--                               id="obrazek" name="obrazek"-->
<#--                               aria-describedby="inputGroupFileAddon01">-->
<#--                        <label class="custom-file-label" for="obrazek">Choose file</label>-->
<#--                    </div>-->
<#--                </div>-->
                <#--                <div class="form-group">-->
                <#--                    <label for="exampleFormControlFile1">Example file input</label>-->
                <#--                    <input type="file" class="form-control-file" id="obrazek" name="obrazek">-->
                <#--                </div>-->
                <#--                <button type="submit" class="btn btn-primary">Submit</button>-->
                </div>
            </form>

    <script>
        $('#obrazek').on('change',function(){
            //get the file name
            var fileName = $(this).val();
            //replace the "Choose a file" label
            $(this).next('.custom-file-label').html(fileName);
        })
    </script>

</@layout.render>