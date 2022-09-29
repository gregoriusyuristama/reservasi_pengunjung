/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usd.project.dao.InvoiceDao;
import usd.project.dao.MejaDao;
import usd.project.dao.RestoDao;
import usd.project.model.BeanPengunjung;
import usd.project.model.DaftarInvoice;
import usd.project.model.DaftarMeja;
import usd.project.model.InvoiceBean;
import usd.project.model.MejaBean;

/**
 *
 * @author gregoriusyuristama
 */
public class ProsesReservasiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String[] jumlahM = request.getParameterValues("jumPesanan");
            String[] namaM = request.getParameterValues("namaM");
            String[] hargaM = request.getParameterValues("hargaMeja");
            LinkedList<MejaBean> daftarMeja = new LinkedList();
            String idResto = request.getParameter("idResto");
            MejaDao mDao = new MejaDao();
            for (int i = 0; i < jumlahM.length; i++) {
                System.out.println(namaM[i]);
                MejaBean meja = mDao.getMeja(idResto, namaM[i]);
          
                meja.setJumlahM(Integer.parseInt(jumlahM[i]));
                daftarMeja.add(meja);
            }
            String tglBookingJam = request.getParameter("tglBooking")+" "+request.getParameter("jamResto")+":00";
            HttpSession session = request.getSession();
            synchronized (session) {
                BeanPengunjung pengunjung = (BeanPengunjung) session.getAttribute("pengunjung");
                InvoiceBean inv = new InvoiceBean();
                InvoiceDao iDao = new InvoiceDao();
                RestoDao rDao = new RestoDao();

                inv.setIdInvoice(iDao.generateIdInv());
                inv.setIdPengunjung(pengunjung.getIdPengunjung());
                inv.setIdResto(idResto);
                inv.setStatusPembayaran("Belum Bayar");
                inv.setTglBooking(tglBookingJam);

                DaftarInvoice di = new DaftarInvoice();
                DaftarMeja dm = new DaftarMeja();
                dm.setDaftarMeja(daftarMeja);

                int result = iDao.insert(inv, daftarMeja);
                String forwardJsp = "";
                if (result > 0) {
                    di.setInvoice(iDao.getAllInvTransaksi(inv.getIdInvoice()));
                    request.setAttribute("daftarInvoice", di);
                    request.setAttribute("resto", rDao.getResto(idResto));
                    request.setAttribute("daftarMeja", dm);
                    forwardJsp = "/Pembayaran.jsp";
                } else {
                    forwardJsp = "/HomePengunjung.jsp";
                }
                RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
                rd.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProsesReservasiServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProsesReservasiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProsesReservasiServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProsesReservasiServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
