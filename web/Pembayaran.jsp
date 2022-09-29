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
        
        <jsp:useBean id="daftarInvoice" class="usd.project.model.DaftarInvoice" scope="request"/>
        <jsp:useBean id="pengunjung" class="usd.project.model.BeanPengunjung" scope="session"/>
        <jsp:useBean id="resto" class="usd.project.model.RestoranBean" scope="request"/>
        <jsp:useBean id="daftarMeja" class="usd.project.model.DaftarMeja" scope="request"/>

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
            <h1>TRANSAKSI TRANSFER</h1>
            <%
                int totalHarga = 0;
                for (int i = 0; i < daftarMeja.getDaftarMeja().size(); i++) {
                    System.out.println(daftarMeja.getDaftarMeja().get(i).getNamaM());
                    totalHarga += daftarMeja.getDaftarMeja().get(i).getHargaM() * daftarInvoice.getInvoice().get(i).getJumlahM();
                }
            %>
            <ol>
                <li>Pembayaran melalui transfer bank <%=resto.getNamaBank()%> </li>
                <li>No Rekening: <%=resto.getNoRek()%> atas nama: <%=resto.getNamaPemilik()%></li>
                <li>Total Pembayaran: Rp. <%=totalHarga%></li>
            </ol>
            <br>
            <h2>Rincian Pembayaran</h2>
            <table border="1">
                <tr>
                    <th>Nama Meja</th>
                    <th>Jumlah Meja</th>
                    <th>Harga</th>
                </tr>
                <%for (int i = 0; i < daftarMeja.getDaftarMeja().size(); i++) {
                %>
                <tr>
                    <td><%=daftarMeja.getDaftarMeja().get(i).getNamaM()%></td> 
                    <td><%=daftarInvoice.getInvoice().get(i).getJumlahM()%></td>
                    <%
                        int total = daftarInvoice.getInvoice().get(i).getJumlahM() * daftarMeja.getDaftarMeja().get(i).getHargaM();
                    %>
                    <td><%=total%></td>
                    <%/**
                         * DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
                         * String formattedDate = df.format(rs.getDate("tanggal"));
                         *
                         */
                    %>

                </tr>
                <%}%>
            </table>

            <br>
            <h2>Upload Tanda Bukti Pembayaran</h2>
            <form method="post" action="./pembayaranServlet" enctype="multipart/form-data">
                <input type="hidden" name="idInvoice" value="<%=daftarInvoice.getInvoice().get(0).getIdInvoice()%>"/>
                <input type="file" name="buktipembayaran" size="50" accept="image/*" />
                <br><br>
                <button type="submit" name="tombol" value="Pembatalan">Pembatalan</button>
                <button type="submit" name="tombol" value="Konfirmasi">Konfirmasi</button>
            </form>

        </div>
        <%@ include file="footerPengunjung.jsp" %>
    </body>
</html>