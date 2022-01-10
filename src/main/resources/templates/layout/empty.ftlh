<#macro render title="GitFlic" description="">
    <html lang="ru">
    <head>
        <title>${title!"Zdravotni System"}</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="${description!""}">

        <link rel="icon" type="image/png" href="/static/image/logo.svg">

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Zdravotni System</title>
        <link rel="icon" type="image/png" href="/static/image/logo.svg">

        <!-- Custom fonts for this template-->
        <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet">

        <!-- Custom styles for this template-->
        <#--        <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">-->

        <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
                integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
                crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
                integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
                crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
                integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
                crossorigin="anonymous"></script>

        <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link href="/webjars/bootstrap-glyphicons/bdd2cbfba0/css/bootstrap-glyphicons.css" rel="stylesheet">
        <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
        <script src="/webjars/jquery-ui/1.12.1/jquery-ui.min.js"></script>
        <script src="/static/js/popper.min.js"></script>
        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <script src="/static/js/jquery-ui-timepicker-addon.js"></script>
        <link href="/static/css/jquery-ui-timepicker-addon.css" rel="stylesheet">

        <#--                    <script src="/webjars/select2/4.0.5/js/select2.min.js"></script>-->
        <#--                    <link href="/webjars/select2/4.0.5/css/select2.min.css" rel="stylesheet">-->
        <link href="/static/css/select2-bootstrap.min.css" rel="stylesheet">

        <#--        <link href="/static/css/sb-admin-2.min.css?v=2" rel="stylesheet">-->
        <#--            <link href="/static/fonts/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">-->

        <link href="/webjars/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet">
        <link href="/static/css/jquery-ui/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet">
        <link href="/static/css/jquery-ui/custom-theme/jquery.ui.1.10.0.ie.css" rel="stylesheet">
        <link href="/static/css/custom.css?v=38" rel="stylesheet">
        <link href="/static/css/custom-checkbox.css" rel="stylesheet">
        <link href="/static/css/feed.css?v=37" rel="stylesheet">
        <link href="/static/css/invoice.css?v=37" rel="stylesheet">
        <link href="/static/css/table-customize.css" rel="stylesheet">

        <script src="/static/js/login.js"></script>
        <script src="/static/js/custom.js"></script>

        <script src="/static/js/clipboard.min.js"></script>
        <script src="/static/js/readmore.js"></script>

        <meta name="theme-color" content="#563d7c">


        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }

            .collapsing {
                transition: none;
            }
        </style>
    </head>

    <body>
    <#nested />
    </body>
    </html>
</#macro>