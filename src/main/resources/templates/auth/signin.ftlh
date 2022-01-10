<#import "/spring.ftl" as spring>
<#import "../layout/empty.ftlh" as layout>

<#assign title = "Zdravotni System" />
<#assign description = "Sign In" />

<@layout.render title description>
    <div class="container-fluid">
        <div class="d-flex flex-row justify-content-center">
            <div class="col-xl-3 col-lg-4 col-md-6 col-12">
                <div class="d-flex flex-row justify-content-center">
                    <img class="my-4" height="100px" width="100px" src="/static/image/logo.svg">
                </div>
                <div class="text-center mb-4">
                    <h1 class="h5 mb-3 font-weight-normal">Login</h1>
                </div>
                <div class="bg-light border rounded p-4 mb-3">
                    <form class="form-signin user" action="/login" method="POST">
                        <div class="form-group">
                            <@spring.formInput "signInForm.email" "required class=\"form-control form-control-sm\" placeholder=\"Email\"" "email"/>
                            <@spring.showErrors "<br>" "small"/>
                        </div>
                        <div class="form-group">
                            <@spring.formInput "signInForm.password" "required class=\"form-control form-control-sm\" placeholder=\"Password\"" "password"/>
                            <@spring.showErrors "<br>" "small"/>
                            <#if RequestParameters.error??>
                                <span class="small"> Invalid login or password</span>
                            </#if>
                        </div>
                        <input type="submit" class="btn btn-sm btn-success btn-user btn-block" value="Login"/>
                    </form>
                    <a class="btn btn-primary btn-sm btn-primary btn-block mt-1" href="/pacient/sign-up" role="button">Sign Up</a>
                </div>
            </div>
        </div>
    </div>
</@layout.render>