<#import '../layout/navbar.ftlh' as layout>

<@layout.render>

    <div class="row">
        <div class="col-lg-8">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-lg-3 mt-4 ml-2">
            <img src="/static/img/undraw_profile.svg" width="300" height="300"/>
        </div>
    </div>

</@layout.render>