/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import usd.project.dao.InvoiceDao;
import usd.project.logic.PhotoUtil;

@WebServlet(name = "pembayaranServlet", urlPatterns = {"./pembayaranServlet"})
@MultipartConfig(maxFileSize = 16177215)
public class pembayaranServlet extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String idInvoice = request.getParameter("idInvoice");
            String button = request.getParameter("tombol");

            InvoiceDao iDao = new InvoiceDao();
            String forwardJsp = "";
            if (button.equals("Pembatalan")) {
                int result = iDao.updateBatal(idInvoice);

                if (result > 0) {
                    forwardJsp = "/homeUtama.jsp";
                } else {
                    forwardJsp = "/homeUtama.jsp";
                }
                RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
                rd.forward(request, response);

            } else {
                if (request.getPart("buktipembayaran").getSize() == 0) {
                    out.println("<h1>Anda belum memasukan foto</h1>");
                } else {
                    // obtains input stream of the upload file inputStream =
                    PhotoUtil ambilfoto = new PhotoUtil();
                    int result = iDao.updatePending(idInvoice, ambilfoto.ambilFoto(request.getPart("buktipembayaran")));

                    if (result > 0) {
                        forwardJsp = "/homeUtama.jsp";
                    } else {
                        forwardJsp = "/homeUtama.jsp";
                    }

                    RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
                    rd.forward(request, response);
                }

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
            Logger.getLogger(pembayaranServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pembayaranServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(pembayaranServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(pembayaranServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
