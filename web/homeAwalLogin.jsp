<%-- 
    Document   : homeAwalLogin
    Created on : Dec 13, 2020, 12:52:11 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Home</title>
        <meta content="" name="description">
        <meta content="" name="keywords">
        <%@ include file="tempHead.jsp" %>
    </head>
    <body>
        <div class="page-holder">
            <!-- navbar-->
            <header class="header bg-white">
                <div class="container px-0 px-lg-3">
                </div>
            </header>
            <!-- ======= Header ======= -->
            <header id="header" class="fixed-top d-flex align-items-center header-transparent">
                <div class="container d-flex align-items-center">
                    <div class="logo mr-auto">
                        <h1 class="text-light"><a href="homeUtama.jsp"><span>Nama website kita</span></a></h1>
                    </div>

                    <nav class="nav-menu d-none d-lg-block">
                        <ul>
                            <li class="active"><a href="homeUtama.jsp">Home</a></li>
                            <li><a href="#footer">Tentang Kami</a></li> <!-- nampilin semua foto -->
                        </ul>
                    </nav>
                    <!-- .nav-menu -->
                </div>

            </header>
            <!-- End Header -->

        </div>

        <!-- ======= Hero Section ======= -->
        <section id="hero">
            <div class="hero-container">
                <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">
                    <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>
                    <div class="carousel-inner" role="listbox">

                        <!-- Slide 1 -->
                        <div class="carousel-item active" style="background: url(assets/img/slide/slide-1.jpg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown"><span>Selamat</span> Datang</h2>
                                    <p class="animate__animated animate__fadeInUp">Login untuk melanjutkan</p>
                                    <a href="#book-a-table" class="btn-book animate__animated animate__fadeInUp scrollto">Saya seorang pemilik resto</a>
                                    <a href="#book-a-table" class="btn-book animate__animated animate__fadeInUp scrollto">Saya ingin melakukan reservasi</a>
                                </div>
                            </div>
                        </div>

                        <!-- Slide 2 -->
                        <div class="carousel-item" style="background: url(assets/img/slide/slide-2.jpg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown"><span>Selamat</span> Datang</h2>
                                    <p class="animate__animated animate__fadeInUp">Deskripsi Web Kita</p>
                                    <a href="#book-a-table" class="btn-book animate__animated animate__fadeInUp scrollto">Saya seorang pemilik resto</a>
                                    <a href="#book-a-table" class="btn-book animate__animated animate__fadeInUp scrollto">Saya ingin melakukan reservasi</a>

                                </div>
                            </div>
                        </div>

                        <!-- Slide 3 -->
                        <div class="carousel-item" style="background: url(assets/img/slide/slide-3.jpg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown"><span>Selamat</span> Datang</h2>
                                    <p class="animate__animated animate__fadeInUp">Deskripsi Web Kita</p>
                                    <a href="#book-a-table" class="btn-book animate__animated animate__fadeInUp scrollto">Saya seorang pemilik resto</a>
                                    <a href="#book-a-table" class="btn-book animate__animated animate__fadeInUp scrollto">Saya ingin melakukan reservasi</a>

                                </div>
                            </div>
                        </div>

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
        </section>
        <!-- End Hero -->


        <%@ include file="footerPengunjung.jsp" %>
    </body>
</html>