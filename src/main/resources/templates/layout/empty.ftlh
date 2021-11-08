<#macro render title="GitFlic" description="">
    <html lang="ru">
        <head>
            <title>${title!"GitFlic"}</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="${description!""}">

            <!-- Bootstrap core CSS -->
            <link href="/static/css/bootstrap.min.css" rel="stylesheet">

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
            <!-- Custom styles for this template -->
            <#--<link href="/static/css/floating-labels.css" rel="stylesheet">-->

            <link rel="apple-touch-icon" sizes="57x57" href="/static/image/favicon/apple-icon-57x57.png">
            <link rel="apple-touch-icon" sizes="60x60" href="/static/image/favicon/apple-icon-60x60.png">
            <link rel="apple-touch-icon" sizes="72x72" href="/static/image/favicon/apple-icon-72x72.png">
            <link rel="apple-touch-icon" sizes="76x76" href="/static/image/favicon/apple-icon-76x76.png">
            <link rel="apple-touch-icon" sizes="114x114" href="/static/image/favicon/apple-icon-114x114.png">
            <link rel="apple-touch-icon" sizes="120x120" href="/static/image/favicon/apple-icon-120x120.png">
            <link rel="apple-touch-icon" sizes="144x144" href="/static/image/favicon/apple-icon-144x144.png">
            <link rel="apple-touch-icon" sizes="152x152" href="/static/image/favicon/apple-icon-152x152.png">
            <link rel="apple-touch-icon" sizes="180x180" href="/static/image/favicon/apple-icon-180x180.png">
            <link rel="icon" type="image/png" sizes="192x192"  href="/static/image/favicon/android-icon-192x192.png">
            <link rel="icon" type="image/png" sizes="32x32" href="/static/image/favicon/favicon-32x32.png">
            <link rel="icon" type="image/png" sizes="96x96" href="/static/image/favicon/favicon-96x96.png">
            <link rel="icon" type="image/png" sizes="16x16" href="/static/image/favicon/favicon-16x16.png">
            <link rel="manifest" href="/static/image/favicon/manifest.json">
            <meta name="msapplication-TileColor" content="#ffffff">
            <meta name="msapplication-TileImage" content="/static/image/favicon/ms-icon-144x144.png">
            <meta name="theme-color" content="#ffffff">
        </head>

        <body>
            <#nested />

            <!-- Yandex.Metrika counter -->
            <script type="text/javascript" >
                (function(m,e,t,r,i,k,a){m[i]=m[i]||function(){(m[i].a=m[i].a||[]).push(arguments)};
                    m[i].l=1*new Date();k=e.createElement(t),a=e.getElementsByTagName(t)[0],k.async=1,k.src=r,a.parentNode.insertBefore(k,a)})
                (window, document, "script", "https://mc.yandex.ru/metrika/tag.js", "ym");

                ym(74493169, "init", {
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true
                });
            </script>
            <noscript><div><img src="https://mc.yandex.ru/watch/74493169" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
            <!-- /Yandex.Metrika counter -->
            <script src="/static/js/jquery/jquery.min.js"></script>
            <script src="/static/js/bootstrap.bundle.min.js"></script>
        </body>
    </html>
</#macro>