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
import java.util.logging.Level;
import java.util.logging.Logger;
import usd.project.model.BeanPengunjung;

/**
 *
 * @author gregoriusyuristama
 */
public class PengunjungDao {

    public int insert(BeanPengunjung pengunjung) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "insert into pengunjung (namaP, gender, emailP, noTelpP, passwordP, fotoP, idPengunjung)"
                + "values (?,?,?,?,?,?,?)";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pengunjung.getNamaP());
            pstmt.setString(2, pengunjung.getGender());
            pstmt.setString(3, pengunjung.getEmailP());
            pstmt.setString(4, pengunjung.getNoTelpP());
            pstmt.setString(5, pengunjung.getPasswordP());
            pstmt.setBlob(6, pengunjung.getFotoP());
            pstmt.setString(7, pengunjung.getIdPengunjung());

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public BeanPengunjung getPengunjung(String idPengunjung) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        BeanPengunjung pengunjung = new BeanPengunjung();
        try {
            String sql = "select * from pengunjung where idPengunjung = '" + idPengunjung + "'";
            conn = dbConn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            pengunjung.setIdPengunjung(rs.getString(1));
            pengunjung.setNamaP(rs.getString(2));
            pengunjung.setFotoP(rs.getBlob(3));
            pengunjung.setGender(rs.getString(4));
            pengunjung.setNoTelpP(rs.getString(5));
            pengunjung.setPasswordP(rs.getString(6));
            pengunjung.setEmailP(rs.getString(7));

        } catch (SQLException ex) {
            Logger.getLogger(PengunjungDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return pengunjung;

    }
    public int update(BeanPengunjung pengunjung) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "update pengunjung set emailP = ?, "
                + "namaP = ?, noTelpP = ?, fotoP = ? "
                + "where idPengunjung = ?";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pengunjung.getEmailP());
            pstmt.setString(2, pengunjung.getNamaP());
            pstmt.setString(3, pengunjung.getNoTelpP());
            pstmt.setBlob(4, pengunjung.getFotoP());
            pstmt.setString(5, pengunjung.getIdPengunjung());

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }
        public int updatePass(String idPengunjung, String newPass) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "UPDATE `pengunjung` SET `passwordP` = ?  WHERE `pengunjung`.`idPengunjung` = ?";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPass);
            pstmt.setString(2, idPengunjung);

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }
}
