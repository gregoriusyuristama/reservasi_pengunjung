/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.dao;

import usd.project.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usd.project.model.RestoranBean;

/**
 *
 * @author gregoriusyuristama
 */
public class JadwalMejaDao {

    public int insertJadwal(LinkedList<String> jadwal, RestoranBean resto, int range) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;
        conn = dbConn.getConnection();

        PreparedStatement ps = null;
        String insert_sql = "insert into jadwalresto (jamMeja, idResto) values (?,?)";
        try {
            ps = conn.prepareStatement(insert_sql);
            for (int i = 0; i < jadwal.size(); i++) {
                // out.println("<h3>" + jadwalMeja.get(i) + "</h3>");
                ps.setString(1, jadwal.get(i));
                ps.setString(2, resto.getIdResto());
                result = ps.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return result;

    }

    public int deleteJadwal(String idResto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();

        int result = 0;
        try {
            conn = dbConn.getConnection();
            String sql = "delete from jadwalresto where idResto = '" + idResto + "'";
            Statement st = conn.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return result;
    }
        public LinkedList<String> getJadwal(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<String> jadwalMeja = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from jadwalresto where idResto='" + idResto + "'";
            
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                jadwalMeja.add(rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JadwalMejaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return jadwalMeja;
    }
}
