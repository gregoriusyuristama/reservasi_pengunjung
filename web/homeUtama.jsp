<%@page import="java.sql.Blob"%>
<%@page import="java.util.Base64"%>
<!DOCTYPE html>
<html>
    <head>

        <jsp:useBean id="daftarResto" class="usd.project.model.ListResto" scope="session"/>
        <jsp:useBean id="pengunjung" class="usd.project.model.BeanPengunjung" scope="session"/>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Home Utama</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Lightbox-->
        <link rel="stylesheet" href="vendor/lightbox2/css/lightbox.min.css">
        <!-- Range slider-->
        <link rel="stylesheet" href="vendor/nouislider/nouislider.min.css">
        <!-- Bootstrap select-->
        <link rel="stylesheet" href="vendor/bootstrap-select/css/bootstrap-select.min.css">
        <!-- Owl Carousel-->
        <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.carousel.min.css">
        <link rel="stylesheet" href="vendor/owl.carousel2/assets/owl.theme.default.css">
        <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/favicon.png"> <!-- logo di tab -->

        <!-- GABUNGAN -->
        <%@ include file="cssPengunjung.jsp" %>
        <!-- selesai gabung -->

    </head>

    <body>
        <!-- gabung header -->
        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top d-flex align-items-center header-transparent">
            <div class="container d-flex align-items-center">
                <div class="logo mr-auto">
                    <h1 class="text-light"><a href="homeUtama.jsp"><span>Rest-On</span></a></h1>
                </div>

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="homeUtama.jsp">Home</a></li>
                        <li><a href="#gallery">Restoran</a></li> <!-- nampilin semua meja -->
                        <li><a href="#footer">Tentang Kami</a></li> <!-- nampilin semua foto -->
                        <li><a href="RiwayatTransaksiPengunjungServlet">Akun</a></li> <!-- login -->
                    </ul>
                </nav>
                <!-- .nav-menu -->
            </div>

        </header><!-- End Header -->



        <!-- selesai gabung -->



        <div class="page-holder">
            <!-- navbar-->
            <header class="header bg-white">
                <div class="container px-0 px-lg-3">
                </div>
            </header>

            <!-- HERO SECTION-->
            <%@ include file="deskWeb.jsp" %>

            <div class="container">
                <!-- TRENDING PRODUCTS-->
                <section class="py-5">
                    <header>
                        <p class="small text-muted small text-uppercase mb-1">Restoran yang tersedia saat ini</p>
                        <h2 class="h5 text-uppercase mb-4">DI Yogyakarta, Indonesia</h2>
                    </header>

                    <section id="gallery" class="gallery">
                        <div class="row">
                            <!-- PRODUCT-->
                            <% for (int i = 0; i < daftarResto.getDaftarResto().size(); i++) {
                                    Blob foto = daftarResto.getDaftarResto().get(i).getFoto1();
                                    byte[] data = foto.getBytes(1l, (int) foto.length());
                                    String encode = Base64.getEncoder().encodeToString(data);
                                    request.setAttribute("imgBase", encode);
                            %>
                            <div class="col-xl-3 col-lg-4 col-sm-6">
                                <div class="product text-center">
                                    <div class="position-relative mb-3">
                                        <div class="badge text-white badge-"></div><a class="d-block" href="./ReservasiServlet?idResto=<%=daftarResto.getDaftarResto().get(i).getIdResto()%>"><img class="img-fluid w-100" src="data:image/jpeg;base64,${imgBase}" alt="..."></a>
                                        <div class="product-overlay">
                                            <ul class="mb-0 list-inline">
                                                <li class="list-inline-item m-0 p-0"><a class="btn btn-sm btn-dark" href="./ReservasiServlet?idResto=<%=daftarResto.getDaftarResto().get(i).getIdResto()%>">Lihat</a></li>
                                                <li class="list-inline-item mr-0"></li>
                                            </ul>
                                        </div>
                                    </div>
                                        <h6> <a class="reset-anchor" href="homeR.jsp"><%=daftarResto.getDaftarResto().get(i).getNamaR()%></a></h6>
                                </div>
                            </div>
                            <% }%>

                        </div>
                    </section>
                </section>

                <!-- SERVICES-->
                <section class="py-5 bg-light">
                    <div class="container">
                        <div class="row text-center">
                            <div class="col-lg-4 mb-3 mb-lg-0">
                                <div class="d-inline-block">
                                    <div class="media align-items-end">
                                        <svg class="svg-icon svg-icon-big svg-icon-light">
                                        <use xlink:href="#delivery-time-1"> </use>
                                        </svg>
                                        <div class="media-body text-left ml-3">
                                            <p class="text-uppercase mb-1">Cepat</p>
                                            <p class="text-small mb-0 text-muted">Reservasi mudah</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 mb-3 mb-lg-0">
                                <div class="d-inline-block">
                                    <div class="media align-items-end">
                                        <svg class="svg-icon svg-icon-big svg-icon-light">
                                        <use xlink:href="#helpline-24h-1"> </use>
                                        </svg>
                                        <div class="media-body text-left ml-3">
                                            <p class="text-uppercase mb-1">24/7</p>
                                            <p class="text-small mb-0 text-muted">Reservasi kapanpun dan dimanapun.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="d-inline-block">
                                    <div class="media align-items-end">
                                        <svg class="svg-icon svg-icon-big svg-icon-light">
                                        <use xlink:href="#label-tag-1"> </use>
                                        </svg>
                                        <div class="media-body text-left ml-3">
                                            <p class="text-uppercase mb-1">Save Time and Cut Cots</p>
                                            <p class="text-small mb-0 text-muted">Mudah dan Terjangkau</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <br> <br>

            </div>

            <!-- JavaScript files-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
            <script src="vendor/lightbox2/js/lightbox.min.js"></script>
            <script src="vendor/nouislider/nouislider.min.js"></script>
            <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
            <script src="vendor/owl.carousel2/owl.carousel.min.js"></script>
            <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
            <script src="js/front.js"></script>
            <script>
                // ------------------------------------------------------- //
                //   Inject SVG Sprite - 
                //   see more here 
                //   https://css-tricks.com/ajaxing-svg-sprite/
                // ------------------------------------------------------ //
                function injectSvgSprite(path) {

                    var ajax = new XMLHttpRequest();
                    ajax.open("GET", path, true);
                    ajax.send();
                    ajax.onload = function (e) {
                        var div = document.createElement("div");
                        div.className = 'd-none';
                        div.innerHTML = ajax.responseText;
                        document.body.insertBefore(div, document.body.childNodes[0]);
                    }
                }
                // this is set to BootstrapTemple website as you cannot 
                // inject local SVG sprite (using only 'icons/orion-svg-sprite.svg' path)
                // while using file:// protocol
                // pls don't forget to change to your domain :)
                injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg');

            </script>
            <!-- FontAwesome CSS - loading as last, so it doesn't block rendering-->
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.1/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        </div>
        <%@ include file="footerPengunjung.jsp" %>
    </body>
</html>