/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.controller;

import usd.project.model.LoginBeanPengunjung;
import usd.project.dao.LoginPengunjungDao;
import usd.project.model.BeanPengunjung;
import usd.project.logic.Lookup;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import usd.project.dao.PengunjungDao;
import usd.project.dao.RestoDao;
import usd.project.logic.LookupService;
import usd.project.model.ListResto;

/**
 *
 * @author Asus
 */
public class LoginServletPengunjung extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginPengunjungDao loginDao;

    public void init() {
        loginDao = new LoginPengunjungDao();
    }

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("idPengunjung");
        String password = request.getParameter("passwordP");
        LoginBeanPengunjung loginBean = new LoginBeanPengunjung();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        String value = request.getParameter("remember");
        try {
            if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                synchronized (session) {
                    boolean rememberMe = false;
                    if (value != null && value.equalsIgnoreCase("on")) {
                        rememberMe = true;
                    }
                    if (rememberMe) {           //If your checkbox value is true
                        Cookie cookieUsername = new Cookie("cookieLoginUser", username);
                        Cookie cookiePassword = new Cookie("cookieLoginPassword",
                                password);

                        cookieUsername.setMaxAge(60 * 60 * 24 * 365);
                        cookiePassword.setMaxAge(60 * 60 * 24 * 365);
                        response.addCookie(cookieUsername);
                        response.addCookie(cookiePassword);
                        System.out.println(cookiePassword);
                        System.out.println(cookieUsername);
                    }
                    PengunjungDao pDao = new PengunjungDao();
                    RestoDao rDao = new RestoDao();
                    BeanPengunjung pengunjung = pDao.getPengunjung(username);
                    session.setAttribute("pengunjung", pengunjung);
                    ListResto dr = new ListResto();
                    dr.setDaftarResto(rDao.getAllResto());
                    session.setAttribute("daftarResto", dr);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("./homeUtama.jsp");
                    dispatcher.forward(request, response);
                }
            } else {
                response.sendRedirect("LoginPengunjungNew.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            Logger.getLogger(LoginServletPengunjung.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginServletPengunjung.class.getName()).log(Level.SEVERE, null, ex);
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
