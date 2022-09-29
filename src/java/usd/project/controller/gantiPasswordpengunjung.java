package usd.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usd.project.dao.PengunjungDao;
import usd.project.model.BeanPengunjung;

/**
 *
 * @author WINDOWS 10
 */
public class gantiPasswordpengunjung extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        BeanPengunjung pengunjung = (BeanPengunjung) session.getAttribute("pengunjung");
        String inputoldpass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confPass = request.getParameter("confPass");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            PengunjungDao pDao = new PengunjungDao();
            if (!pengunjung.getPasswordP().equals(inputoldpass)) {
                out.println("<h1>Password Anda Salah</h1>");
            } else {
                if (newPass.equals(confPass) && !newPass.equals(pengunjung.getPasswordP())) {
                    int result = pDao.updatePass(pengunjung.getIdPengunjung(), newPass);
                    String forwardJsp = "";
                    if (result > 0) {
                        forwardJsp = "/homeUtama.jsp";
                    } else {
                        forwardJsp = "/homeUtama.jsp";
                    }
                } else if (!newPass.equals(confPass)) {
                    out.println("<h1>New Password dan Konfirmasi Password Salah</h1>");
                } else {
                    out.println("<h1>New Password dan Old Password sama</h1>");
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
            Logger.getLogger(gantiPasswordpengunjung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gantiPasswordpengunjung.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(gantiPasswordpengunjung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gantiPasswordpengunjung.class.getName()).log(Level.SEVERE, null, ex);
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
