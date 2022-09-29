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

                        <!-- Slide 1 -->
                        <div class="carousel-item active" style="background: url(assets/img/slide/slide-1.jpg);">
                            <%@ include file="deskResto.jsp" %>
                        </div>

                        <!-- Slide 2 -->
                        <div class="carousel-item" style="background: url(assets/img/slide/slide-2.jpg);">
                            <%@ include file="deskResto.jsp" %>
                        </div>

                        <!-- Slide 3 -->
                        <div class="carousel-item" style="background: url(assets/img/slide/slide-3.jpg);">
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