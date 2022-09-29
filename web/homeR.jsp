<%@page import="java.util.Base64"%>
<%@page import="java.sql.Blob"%>
<!DOCTYPE html>
<html lang="en">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <head>
        <jsp:useBean id="pengunjung" class="usd.project.model.BeanPengunjung" scope="session"/>
        <jsp:useBean id="resto" class="usd.project.model.RestoranBean" scope="request"/>
        <jsp:useBean id="daftarMeja" class="usd.project.model.DaftarMeja" scope="request"/>
        <jsp:useBean id="jadwalResto" class="usd.project.model.JadwalRestoBean" scope="request"/>

        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Detail Restoran</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <%@ include file="tempHead.jsp" %>

    </head>
    <body>
        <!-- ======= Top Bar ======= -->
        <section id="topbar" class="d-none d-lg-flex align-items-center fixed-top topbar-transparent">
            <div class="container text-right">
                <i class="icofont-phone"></i> <%=resto.getNoTelp()%>
                <i class="icofont-clock-time icofont-rotate-180"></i> <%=resto.getJamBuka()%> - <%=resto.getJamTutup()%> WIB
            </div>
        </section>

        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top d-flex align-items-center header-transparent">
            <div class="container d-flex align-items-center">

                <div class="logo mr-auto">
                    <h1 class="text-light"><a href="homeUtama.jsp"><span>Rest-On</span></a></h1>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
                </div>

                <nav class="nav-menu d-none d-lg-block">
                    <ul>
                        <li class="active"><a href="homeUtama.jsp">Home</a></li>
                        <li><a href="#about">Meja</a></li> <!-- nampilin semua meja -->
                        <li><a href="#gallery">Galeri</a></li> <!-- nampilin semua foto -->
                        <li><a href="#contact">Kontak</a></li> <!-- nampilin kontak resto -->
                        <li><a href="./RiwayatTransaksiPengunjungServlet">Akun</a></li> <!-- nampilin kontak resto -->
                    </ul>
                </nav><!-- .nav-menu -->

            </div>
        </header><!-- End Header -->



        <!-- ======= Hero Section ======= -->
        <section id="hero">
            <div class="hero-container">
                <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">

                    <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>

                    <div class="carousel-inner" role="listbox">

                        <%
                            Blob foto = resto.getFoto1();
                            byte[] data = foto.getBytes(1l, (int) foto.length());
                            String encode = Base64.getEncoder().encodeToString(data);
                            request.setAttribute("imgBase", encode);
                        %>
                        <!-- Slide 1 -->
                        <div class="carousel-item active" style="background: url(data:image/jpeg;base64,${imgBase});">
                            <%@ include file="deskResto.jsp" %>
                        </div>
                        <%
                            foto = resto.getFoto2();
                            data = foto.getBytes(1l, (int) foto.length());
                            encode = Base64.getEncoder().encodeToString(data);
                            request.setAttribute("imgBase", encode);
                        %>
                        <!-- Slide 2 -->
                        <div class="carousel-item" style="background: url(data:image/jpeg;base64,${imgBase});">
                            <%@ include file="deskResto.jsp" %>
                        </div>
                        <%
                            foto = resto.getFoto3();
                            data = foto.getBytes(1l, (int) foto.length());
                            encode = Base64.getEncoder().encodeToString(data);
                            request.setAttribute("imgBase", encode);
                        %>
                        <!-- Slide 3 -->
                        <div class="carousel-item" style="background: url(data:image/jpeg;base64,${imgBase});">
                            <%@ include file="deskResto.jsp" %>
                        </div>

                        <!-- Tambahkan 1 slide lagi buat foto 4-->
                    </div>

                    <a class="carousel-control-prev" href="#heroCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon icofont-simple-left" aria-hidden="true"></span>
                        <span class="sr-only">Kembali</span>
                    </a>

                    <a class="carousel-control-next" href="#heroCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon icofont-simple-right" aria-hidden="true"></span>
                        <span class="sr-only">Selanjutnya</span>
                    </a>

                </div>
            </div>
        </section><!-- End Hero -->
        <main id="main">

            <form action="./ProsesReservasiServlet" method="post" role="form" id="form1" >
                <!-- ======= Reservasi Section ======= -->
                <!--TAMPILKAN SEMUA MEJA DENGAN LOOPING -->
                <%for (int i = 0; i < daftarMeja.getDaftarMeja().size(); i++) {
                        foto = daftarMeja.getDaftarMeja().get(i).getFotoM();
                        data = foto.getBytes(1l, (int) foto.length());
                        encode = Base64.getEncoder().encodeToString(data);
                        request.setAttribute("imgBase", encode);
                %>
                <section id="about" class="about">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-lg-5 align-items-stretch video-box" style='background-image: url(data:image/jpeg;base64,${imgBase});'> <!-- nanti diganti foto meja -->
                            </div>
                            <div class="col-lg-7 d-flex flex-column justify-content-left align-items-stretch">

                                <div class="content">
                                    <h3><strong><%=daftarMeja.getDaftarMeja().get(i).getNamaM()%></strong></h3>
                                    <p class="font-italic">
                                        <%=daftarMeja.getDaftarMeja().get(i).getDeskripsiM()%>
                                    </p>
                                    <p>
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" value="<%=daftarMeja.getDaftarMeja().get(i).getNamaM()%>" name='namaM' onclick="var input = document.getElementById('jumPesanan<%=i%>');
                                                    if (this.checked) {
                                                        input.disabled = false;
                                                        input.focus();
                                                    } else {
                                                        input.disabled = true;
                                                    }"/>
                                            <span class="form-check-sign"></span>
                                            Saya ingin memesan meja ini
                                        </label>
                                    </div>
                                    <input type="number" size="20" name="jumPesanan" id='jumPesanan<%=i%>' disabled="disabled">
                                    <input type="hidden" name="hargaMeja" value="<%=daftarMeja.getDaftarMeja().get(i).getHargaM()%>">

                                </div>
                            </div>
                        </div>
                    </div>
                </section><!-- End Meja Section -->
                <%}%>


                <!-- ======= Reservasi Section ======= -->
                <section id="book-a-table" class="book-a-table">
                    <div class="container">

                        <div class="section-title">
                            <h2>Reservasi <span>Meja</span></h2>
                            <p>Kami tunggu kedatangan Anda.</p>
                        </div>

                        <div class="form-row">
                            <div class="col-lg-4 col-md-6 form-group">
                                <input type="date" name="tglBooking" class="form-control" id="date" placeholder="Tanggal Booking" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                                <div class="validate"></div>
                            </div>
                            <div class="col-lg-4 col-md-6 form-group"> <!-- ini bikin inputan jam sesuai jam resto, bentuknya drop down list -->
                                <select name="jamResto" id="jamResto">
                                    <% for (int i = 0; i < jadwalResto.getJamMeja().size(); i++) {
                                    %>
                                    <option value="<%=jadwalResto.getJamMeja().get(i)%>"><%=jadwalResto.getJamMeja().get(i)%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" name="idResto" value="<%=resto.getIdResto()%>">
                        <div class="text-center"><input class="button-pesan" type="submit" form="form1" value="Reservasi"></div>
                        </form>

                    </div>
                </section>
                <!-- End Book A Table Section -->

                <!-- ======= Gallery Section ======= -->
                <section id="gallery" class="gallery">
                    <!-- ======= Gallery Section ======= -->
                    <section id="gallery" class="gallery">
                        <div class="container-fluid">

                            <div class="section-title">
                                <h2>Foto-foto <span>Restoran Kami</span></h2>
                            </div>

                            <div class="row no-gutters">

                                <%

                                    foto = resto.getFoto1();
                                    data = foto.getBytes(1l, (int) foto.length());
                                    encode = Base64.getEncoder().encodeToString(data);
                                    request.setAttribute("imgBase", encode);
                                %>
                                <div class="col-lg-3 col-md-4">
                                    <div class="gallery-item">
                                        <a href="data:image/jpeg;base64,${imgBase}" class="venobox" data-gall="gallery-item">
                                            <img src="data:image/jpeg;base64,${imgBase}" alt="" class="img-fluid">
                                        </a>
                                    </div>
                                </div> <%
                                    foto = resto.getFoto2();
                                    data = foto.getBytes(1l, (int) foto.length());
                                    encode = Base64.getEncoder().encodeToString(data);
                                    request.setAttribute("imgBase", encode);
                                %>
                                <div class="col-lg-3 col-md-4">
                                    <div class="gallery-item">
                                        <a href="data:image/jpeg;base64,${imgBase}" class="venobox" data-gall="gallery-item">
                                            <img src="data:image/jpeg;base64,${imgBase}" alt="" class="img-fluid">
                                        </a>
                                    </div>
                                </div>
                                <%
                                    foto = resto.getFoto3();
                                    data = foto.getBytes(1l, (int) foto.length());
                                    encode = Base64.getEncoder().encodeToString(data);
                                    request.setAttribute("imgBase", encode);
                                %>
                                <div class="col-lg-3 col-md-4">
                                    <div class="gallery-item">
                                        <a href="data:image/jpeg;base64,${imgBase}" class="venobox" data-gall="gallery-item">
                                            <img src="data:image/jpeg;base64,${imgBase}" alt="" class="img-fluid">
                                        </a>
                                    </div>
                                </div>
                                <%
                                    foto = resto.getFoto4();
                                    data = foto.getBytes(1l, (int) foto.length());
                                    encode = Base64.getEncoder().encodeToString(data);
                                    request.setAttribute("imgBase", encode);
                                %>
                                <div class="col-lg-3 col-md-4">
                                    <div class="gallery-item">
                                        <a href="data:image/jpeg;base64,${imgBase}" class="venobox" data-gall="gallery-item">
                                            <img src="data:image/jpeg;base64,${imgBase}" alt="" class="img-fluid">
                                        </a>
                                    </div>
                                </div>



                            </div>
                        </div>
                    </section>
                    <!-- End Gallery Section -->

                    <!-- ======= Contact Section ======= -->
                    <section id="contact" class="contact">
                        <div class="container">

                            <div class="section-title">
                                <h2><span>Hubungi</span> Kami</h2>
                            </div>
                        </div>
                        <div class="container mt-5">
                            <div class="info-wrap">
                                <div class="row">
                                    <div class="col-lg-3 col-md-6 info">
                                        <i class="icofont-google-map"></i>
                                        <h4>Alamat :</h4>
                                        <p><%=resto.getAlamatR()%></p>
                                    </div>

                                    <div class="col-lg-3 col-md-6 info mt-4 mt-lg-0">
                                        <i class="icofont-clock-time icofont-rotate-90"></i>
                                        <h4>Jam Buka:</h4>
                                        <p><%=resto.getJamBuka()%> - <%=resto.getJamTutup()%> WIB</p>
                                    </div>

                                    <div class="col-lg-3 col-md-6 info mt-4 mt-lg-0">
                                        <i class="icofont-envelope"></i>
                                        <h4>Email:</h4>
                                        <p><%=resto.getEmailR()%></p>
                                    </div>

                                    <div class="col-lg-3 col-md-6 info mt-4 mt-lg-0">
                                        <i class="icofont-phone"></i>
                                        <h4>No Telp.</h4>
                                        <p><%=resto.getNoTelp()%></p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </section>
                    <!-- End Contact Section -->

                    </main>
                    <!-- End #main -->
                    <%@ include file="footerPengunjung.jsp" %>
                    </body>
                    </html>