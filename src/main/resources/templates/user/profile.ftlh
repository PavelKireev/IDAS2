<#import '../layout/navbar.ftlh' as layout>
<#import '../partials/form.ftlh' as form>

<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="row col-lg-4">
            <img src=${avatar!"/static/img/undraw_profile.svg"} width="300" height="300"/>
            <form method="post" enctype="multipart/form-data" action="/profile/avatar">
                <div class="form-group">
                    <label for="exampleFormControlFile1">Example file input</label>
                    <input type="file" class="form-control-file" id="obrazek" name="obrazek">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

</@layout.render>