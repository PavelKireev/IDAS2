<#import "/spring.ftl" as spring>
<#import "../layout/empty.ftlh" as layout>

<#assign title = "Вход в GitFlic" />
<#assign description = "Войти в учетную запись" />

<@layout.render title description>
    <div class="container-fluid">
        <div class="d-flex flex-row justify-content-center">
            <div class="col-xl-3 col-lg-4 col-md-6 col-12">
                <div class="d-flex flex-row justify-content-center">
                    <img class="my-4" height="70px" width="70px" src="/static/image/logo/logo_b_full.svg">
                </div>
                <div class="text-center mb-4">
                    <h1 class="h5 mb-3 font-weight-normal">Войти в кабинет</h1>
                </div>
                <div class="bg-light border rounded p-4 mb-3">
                    <form class="form-signin user" action="/auth/login" method="POST">
                        <div class="form-group">
                            <@spring.formInput "signInForm.email" "required class=\"form-control form-control-sm\" placeholder=\"Почта\"" "email"/>
                            <@spring.showErrors "<br>" "small"/>
                        </div>

                        <div class="form-group">
                            <@spring.formInput "signInForm.password" "required class=\"form-control form-control-sm\" placeholder=\"Пароль\"" "password"/>
                            <@spring.showErrors "<br>" "small"/>
                            <#if RequestParameters.error??>
                                <span class="small"> Неверный логин или пароль</span>
                            </#if>
                        </div>

                        <div class="d-flex flex-column mb-3">
                            <div class="form-check p-0">
                                <input type="checkbox" id="rememberMe" name="rememberMe">
                                <label class="form-check-label" for="rememberMe">
                                    Запомнить меня
                                </label>
                            </div>
                        </div>
                        <input type="submit" class="btn btn-sm btn-success btn-user btn-block" value="Войти"/>
                    </form>
                    <div class="small">
                        <a href="/restore-password">Забыли пароль?</a>
                    </div>
                </div>
                <div class="border rounded p-3 d-flex flex-row justify-content-center">
                    <span>
                        Впервые на GitFlic?
                        <a href="/auth/signup" class="">Создать аккаунт</a>
                    </span>
                </div>
            </div>
        </div>
    </div>
</@layout.render>

</html>