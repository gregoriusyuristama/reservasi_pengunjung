<%@page import="java.util.Base64"%>
<%@page import="java.sql.Blob"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <!-- This file has been downloaded from Bootsnipp.com. Enjoy! -->
        <title>Edit Profil</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
        <link rel="shortcut icon" href="img/favicon.png">
        <!-- Tweaks for older IEs--><!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->

        <!-- GABUNGAN -->
        <%@ include file="cssPengunjung.jsp" %>

        <!-- selesai gabung -->

        <style type="text/css">
            body{
                background: -webkit-linear-gradient(left, #ffffff, #ffffff);
            }
            .emp-profile{
                padding: 3%;
                margin-top: 3%;
                margin-bottom: 3%;
                border-radius: 0.5rem;
                background: #fff;
            }
            .profile-img{
                text-align: center;
            }
            .profile-img img{
                width: 70%;
                height: 100%;
            }
            .profile-img .file {
                position: relative;
                overflow: hidden;
                margin-top: -20%;
                width: 70%;
                border: none;
                border-radius: 0;
                font-size: 15px;
                background: #212529b8;
            }
            .profile-img .file input {
                position: absolute;
                opacity: 0;
                right: 0;
                top: 0;
            }
            .profile-head h5{
                color: #333;
            }
            .profile-head h6{
                color: #0062cc;
            }
            .profile-edit-btn{
                border: none;
                border-radius: 1.5rem;
                width: 70%;
                padding: 2%;
                font-weight: 600;
                color: #35322d;
                cursor: pointer;
            }
            .proile-rating{
                font-size: 12px;
                color: #818182;
                margin-top: 5%;
            }
            .proile-rating span{
                color: #495057;
                font-size: 15px;
                font-weight: 600;
            }
            .profile-head .nav-tabs{
                margin-bottom:5%;
            }
            .profile-head .nav-tabs .nav-link{
                font-weight:600;
                border: none;
            }
            .profile-head .nav-tabs .nav-link.active{
                border: none;
                border-bottom:2px solid #0062cc;
            }
            .profile-work{
                padding: 14%;
                margin-top: -15%;
            }
            .profile-work p{
                font-size: 12px;
                color: #818182;
                font-weight: 600;
                margin-top: 10%;
            }
            .profile-work a{
                text-decoration: none;
                color: #495057;
                font-weight: 600;
                font-size: 14px;
            }
            .profile-work ul{
                list-style: none;
            }
            .profile-tab label{
                font-weight: 600;
            }
            .profile-tab p{
                font-weight: 600;
                color: #35322d;
            }
        </style>
        <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <jsp:useBean id="pengunjung" class="usd.project.model.BeanPengunjung" scope="session"/>
        <jsp:useBean id="daftarInvoice" class="usd.project.model.DaftarInvoice" scope="request"/>
        <jsp:useBean id="daftarResto" class="usd.project.model.ListResto" scope="request"/>

    </head>


    <body>
        <!-- gabung header -->
        <!-- ======= Header ======= -->
        <header id="header" class="d-flex align-items-center ">
            <div class="container d-flex align-items-center">
                <div class="logo mr-auto">
                    <h1 class="text-light"><a href="homeUtama.jsp"><span>Rest-On</span></a></h1>
                </div>

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="homeUtama.jsp">Home</a></li>
                        <li><a href="homeUtama.jsp">Restoran</a></li> <!-- nampilin homeUtama -->
                        <li><a href="#footer">Tentang Kami</a></li> <!-- nampilin footer -->
                        <li><a href="./RiwayatTransaksiPengunjungServlet">Akun</a></li> <!-- login -->
                    </ul>
                </nav><!-- .nav-menu -->
            </div>

        </header><!-- End Header -->
        <div class="container emp-profile" style="background-color:#e7e7e7">


            <form method="post" action="./updatePengunjung" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <%
                                Blob foto = pengunjung.getFotoP();
                                byte[] data = foto.getBytes(1l, (int) foto.length());
                                String encode = Base64.getEncoder().encodeToString(data);
                                request.setAttribute("imgBase", encode);
                            %>
                            <img src="data:image/jpeg;base64,${imgBase}" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Ganti Foto
                                <input type="file" name="fotoP"/>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="profile-head">
                            <h5>
                                <%=pengunjung.getNamaP()%>
                            </h5>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Biodata Diri</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Riwayat Transaksi</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-md-8">
                            <div class="tab-content profile-tab" id="myTabContent">
                                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>ID Pengguna</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type ="text" value ="<%=pengunjung.getIdPengunjung()%>" disabled/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Gender</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type ="text" value ="<%=pengunjung.getGender()%>" disabled/>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Nama</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type ="text" name="namaP" value ="<%=pengunjung.getNamaP()%>" />
                                        </div>
                                    </div>


                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>Email</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type ="text" name="emailP" value ="<%=pengunjung.getEmailP()%>" />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>No. Telp</label>
                                        </div>
                                        <div class="col-md-6">
                                            <input type ="text" name="noTelpP" value ="<%=pengunjung.getNoTelpP()%>" />
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                </div>
                                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <label>ID Invoice</label>
                                        </div>
                                        <div class="col-md-6">
                                            <p>Status</p>
                                        </div>
                                    </div>

                                    <%  for (int i = 0; i < daftarInvoice.getInvoice().size(); i++) {
                                    %><div class="row">
                                        <div class="col-md-6">
                                            <p>
                                                <a href="./LihatInvoiceServlet?idResto=<%=daftarInvoice.getInvoice().get(i).getIdResto()%>
                                                   &pembayaran=<%=daftarInvoice.getInvoice().get(i).getIdInvoice()%>">
                                                    <%=daftarInvoice.getInvoice().get(i).getIdInvoice()%>
                                                </a>
                                            </p>
                                        </div>
                                        <div class="col-md-6"><p>
                                                <% String status = daftarInvoice.getInvoice().get(i).getStatusPembayaran();
                                                    if (status.equalsIgnoreCase("Belum Bayar")) {
                                                %>
                                            
                                                <a href="./KirimPembayaranServlet?idResto=<%=daftarInvoice.getInvoice().get(i).getIdResto()%>
                                                   &pembayaran=<%=daftarInvoice.getInvoice().get(i).getIdInvoice()%>">Belum Bayar</a>
                                            
                                            <% } else {
                                            %>
                                            <%=status%>
                                            <% }
                                            %>
                                            </p>
                                        </div>
                                    </div>
                                    <%
                                        }%>

                                </div>
                            </div>

                        </div>
                    </div>

                </div>

                <div class="col-md-2" style="float: right">
                    <a href="./LogoutServlet" class="profile-edit-btn">Logout</a>
                </div>
                <div class="col-md-2" style="float: right">
                    <input type="submit" class="profile-edit-btn" name="update" value="Update"/>
                </div>
                <div class="col-md-2" style="float: right">
                    <a href="./EditPassword.jsp" class="profile-edit-btn">Edit Password</a>
                </div>
            </form>  
        </div>

        <%@ include file="footerPengunjung.jsp" %>
    </body>
</html>