<#macro render>

    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Zdravotni System</title>
        <link rel="icon" type="image/png" href="/static/image/logo.svg">

        <!-- Custom fonts for this template-->
        <link href="/static/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Custom styles for this template-->
        <link href="/static/css/sb-admin-2.min.css" rel="stylesheet">


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
        <#--        <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>-->

        <script src="/static/js/jquery-ui-timepicker-addon.js"></script>
        <link href="/static/css/jquery-ui-timepicker-addon.css" rel="stylesheet">

        <#--    <script src="/webjars/select2/4.0.5/js/select2.min.js"></script>-->
        <#--    <link href="/webjars/select2/4.0.5/css/select2.min.css" rel="stylesheet">-->
        <link href="/static/css/select2-bootstrap.min.css" rel="stylesheet">

        <link href="/static/css/sb-admin-2.min.css?v=2" rel="stylesheet">
        <#--    <link href="/static/fonts/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">-->

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

    </head>

    <body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                <div class="sidebar-brand-icon">
                    <i class="fas fa-briefcase-medical"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Zdravotni System</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <#--        <!-- Nav Item - Dashboard &ndash;&gt;-->
            <#--        <li class="nav-item">-->
            <#--            <a class="nav-link" href="index.html">-->
            <#--                <i class="fas fa-fw fa-tachometer-alt"></i>-->
            <#--                <span>Dashboard</span></a>-->
            <#--        </li>-->

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="/admin/overview">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Overview</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse1"
                   aria-expanded="true" aria-controls="collapse1">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Log</span>
                </a>
                <div id="collapse1" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Typ:</h6>
                        <a class="collapse-item" href="/admin/log/uzivatele">Uzivatele</a>
                        <a class="collapse-item" href="/admin/log/tabulky">Tabulky</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse2"
                   aria-expanded="true" aria-controls="collapse2">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Uzivatele</span>
                </a>
                <div id="collapse2" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Typ:</h6>
                        <a class="collapse-item" href="/admin/uzivatel/pacient">Pacient</a>
                        <a class="collapse-item" href="/admin/uzivatel/lekar">Lekar</a>
                        <a class="collapse-item" href="/admin/uzivatel/admin">Administrator</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse3"
                   aria-expanded="true" aria-controls="collapse3">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Mistnosti</span>
                </a>
                <div id="collapse3" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Typ:</h6>
                        <a class="collapse-item" href="/admin/mistnost/pokoj">Pokoj</a>
                        <a class="collapse-item" href="/admin/mistnost/kancelar">Kancelar</a>
                        <a class="collapse-item" href="/admin/mistnost/ordinace">Ordinace</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/hospitalizace">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Hospitalizace</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/pojistovna">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Pojistovny</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse5"
                   aria-expanded="true" aria-controls="collapse5">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Procedury</span>
                </a>
                <div id="collapse5" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Typ:</h6>
                        <a class="collapse-item" href="/admin/procedura">Procedury</a>
                        <a class="collapse-item" href="/admin/procedura/typ">Typy procedur</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse6"
                   aria-expanded="true" aria-controls="collapse6">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Zarizeni</span>
                </a>
                <div id="collapse6" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Typ:</h6>
                        <a class="collapse-item" href="/admin/zarizeni">Zarizeni</a>
                        <a class="collapse-item" href="/admin/zarizeni/typ">Typ zarizeni</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/specializace">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Specializace</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                ${authUser.getUser().getJmeno()!""} ${authUser.getUser().getPrijmeni()!""}</span>
                                <img class="img-profile rounded-circle"
                                     src="${authUserAvatar!"/static/img/undraw_profile.svg"}">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                 aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="/pacient/profile/info">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <#--                            <a class="dropdown-item" href="#">-->
                                <#--                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>-->
                                <#--                                Settings-->
                                <#--                            </a>-->
                                <#--                            <a class="dropdown-item" href="#">-->
                                <#--                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>-->
                                <#--                                Activity Log-->
                                <#--                            </a>-->
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/logout" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <#nested>
                    <#--                <!-- Page Heading &ndash;&gt;-->
                    <#--                <h1 class="h3 mb-4 text-gray-800">Blank Page</h1>-->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/logout">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/static/vendor/jquery/jquery.min.js"></script>
    <script src="/static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/static/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/static/js/sb-admin-2.min.js"></script>

    </body>

    </html>

</#macro>

