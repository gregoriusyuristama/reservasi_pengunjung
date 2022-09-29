package usd.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import usd.project.dao.PengunjungDao;
import usd.project.logic.PhotoUtil;
import usd.project.logic.PhotoUtilService;
import usd.project.model.BeanPengunjung;

@WebServlet(name = "updatePengunjung", urlPatterns = {"./updatePengunjung"})
@MultipartConfig(maxFileSize = 16177215)
public class updatePengunjung extends HttpServlet {

    private static final int BUFFER_SIZE = 4096;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            BeanPengunjung pengunjung = (BeanPengunjung) session.getAttribute("pengunjung");
            PhotoUtilService ambilfoto = new PhotoUtil();
            pengunjung.setNamaP(request.getParameter("namaP"));
            pengunjung.setEmailP(request.getParameter("emailP"));
            pengunjung.setNoTelpP(request.getParameter("noTelpP"));
            if (request.getPart("fotoP").getSize() != 0) {
                pengunjung.setFotoP(ambilfoto.ambilFoto(request.getPart("fotoP")));
            }
            PengunjungDao pDao = new PengunjungDao();
            int result = pDao.update(pengunjung);
            String forwardJsp = "";
            if (result > 0) {
                forwardJsp = "/homeUtama.jsp";
            } else {
                forwardJsp = "/homeUtama.jsp";
            }

            RequestDispatcher rd = request.getRequestDispatcher(forwardJsp);
            rd.forward(request, response);

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
            Logger.getLogger(updatePengunjung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updatePengunjung.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(updatePengunjung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updatePengunjung.class.getName()).log(Level.SEVERE, null, ex);
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
