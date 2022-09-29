/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.dao;

import usd.project.db.DbConnection;
import java.sql.Blob;
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
public class RestoDao {

    public int insert(RestoranBean resto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "insert into restoran (idResto, namaR, alamatR, emailR, KTP, fotoKTP, noRek, noTelpR, passwordR, "
                + "deskripsiR, namaPemilik, namaBank, jamBuka, jamTutup, foto1, foto2, foto3, foto4, foto5) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, resto.getIdResto());
            pstmt.setString(2, resto.getNamaR());
            pstmt.setString(3, resto.getAlamatR());
            pstmt.setString(4, resto.getEmailR());
            pstmt.setString(5, resto.getKTP());
            pstmt.setBlob(6, resto.getFotoKTP());
            pstmt.setString(7, resto.getNoRek());
            pstmt.setString(8, resto.getNoTelp());
            pstmt.setString(9, resto.getPasswordR());
            pstmt.setString(10, resto.getDeskripsiR());
            pstmt.setString(11, resto.getNamaPemilik());
            pstmt.setString(12, resto.getNamaBank());
            pstmt.setString(13, resto.getJamBuka());
            pstmt.setString(14, resto.getJamTutup());
            pstmt.setBlob(15, resto.getFoto1());
            pstmt.setBlob(16, resto.getFoto2());
            pstmt.setBlob(17, resto.getFoto3());
            pstmt.setBlob(18, resto.getFoto4());
            pstmt.setBlob(19, resto.getFoto5());

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public int update(RestoranBean resto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "UPDATE `restoran` SET `alamatR` = ?, `emailR` = ?, `foto1` = ?, `foto2` = ?, "
                + "`foto3` = ?, `foto4` = ?, `foto5` = ?, `deskripsiR` = ?, `noTelpR` = ?, `namaBank` = ?, "
                + "`noRek` = ?, `jamBuka` = ?, `jamTutup` = ?  WHERE `restoran`.`idResto` = ?";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, resto.getAlamatR());
            pstmt.setString(2, resto.getEmailR());
            pstmt.setBlob(3, resto.getFoto1());
            pstmt.setBlob(4, resto.getFoto2());
            pstmt.setBlob(5, resto.getFoto3());
            pstmt.setBlob(6, resto.getFoto4());
            pstmt.setBlob(7, resto.getFoto5());
            pstmt.setString(8, resto.getDeskripsiR());
            pstmt.setString(9, resto.getNoTelp());
            pstmt.setString(10, resto.getNamaBank());
            pstmt.setString(11, resto.getNoRek());
            pstmt.setString(12, resto.getJamBuka());
            pstmt.setString(13, resto.getJamTutup());
            pstmt.setString(14, resto.getIdResto());

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public Blob getFotoKTP(String idResto) throws SQLException, ClassNotFoundException {
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        Blob fotoKTP = null;
        String sql = "select fotoKTP from restoran where idResto = '" + idResto + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                fotoKTP = rs.getBlob(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }
        return fotoKTP;
    }

    public RestoranBean getResto(String idResto) throws SQLException, ClassNotFoundException {
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        RestoranBean resto = new RestoranBean();
        String sql = "select * from restoran where idResto = '" + idResto + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            resto.setIdResto(rs.getString(1));
            resto.setNamaR(rs.getString(2));
            resto.setAlamatR(rs.getString(3));
            resto.setEmailR(rs.getString(4));
            resto.setKTP(rs.getString(5));
            resto.setFotoKTP(rs.getBlob(6));
            resto.setNoRek(rs.getString(7));
            resto.setNoTelp(rs.getString(8));
            resto.setPasswordR(rs.getString(9));
            resto.setDeskripsiR(rs.getString(10));
            resto.setNamaPemilik(rs.getString(11));
            resto.setNamaBank(rs.getString(12));
            resto.setFoto1(rs.getBlob(13));
            resto.setFoto2(rs.getBlob(14));
            resto.setFoto3(rs.getBlob(15));
            resto.setFoto4(rs.getBlob(16));
            resto.setFoto5(rs.getBlob(17));
            resto.setJamBuka(rs.getString(18));
            resto.setJamTutup(rs.getString(19));

        } catch (SQLException ex) {
            Logger.getLogger(RestoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }
        return resto;
    }

    public int updatePass(String idResto, String newPass) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "UPDATE `restoran` SET `passwordR` = ?  WHERE `restoran`.`idResto` = ?";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPass);
            pstmt.setString(2, idResto);

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public LinkedList<RestoranBean> getAllResto() throws SQLException, ClassNotFoundException {
        LinkedList<RestoranBean> daftarResto = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from restoran";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RestoranBean resto = new RestoranBean();
                resto.setIdResto(rs.getString(1));
                resto.setNamaR(rs.getString(2));
                resto.setAlamatR(rs.getString(3));
                resto.setEmailR(rs.getString(4));
                resto.setKTP(rs.getString(5));
                resto.setFotoKTP(rs.getBlob(6));
                resto.setNoRek(rs.getString(7));
                resto.setNoTelp(rs.getString(8));
                resto.setPasswordR(rs.getString(9));
                resto.setDeskripsiR(rs.getString(10));
                resto.setNamaPemilik(rs.getString(11));
                resto.setNamaBank(rs.getString(12));
                resto.setFoto1(rs.getBlob(13));
                resto.setFoto2(rs.getBlob(14));
                resto.setFoto3(rs.getBlob(15));
                resto.setFoto4(rs.getBlob(16));
                resto.setFoto5(rs.getBlob(17));
                resto.setJamBuka(rs.getString(18));
                resto.setJamTutup(rs.getString(19));
                daftarResto.add(resto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RestoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarResto;
    }
}
