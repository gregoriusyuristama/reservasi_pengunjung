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
import usd.project.model.DaftarMeja;
import usd.project.model.MejaBean;

/**
 *
 * @author gregoriusyuristama
 */
public class MejaDao {

    public MejaBean getMeja(String idResto, String namaM) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        MejaBean meja = new MejaBean();
        try {
            String sql = "select * from meja where idResto = '" + idResto + "' and namaM = '" + namaM + "'";
            conn = dbConn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            meja.setFotoM(rs.getBlob(3));
            meja.setHargaM(rs.getInt(4));
            meja.setDeskripsiM(rs.getString(5));
            meja.setJumlahM(rs.getInt(6));
            meja.setIdResto(idResto);
            meja.setNamaM(namaM);
            

        } catch (SQLException ex) {
            Logger.getLogger(MejaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return meja;

    }
    public LinkedList<MejaBean> getAllMeja(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<MejaBean> daftarMeja = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from meja where idResto = '" + idResto + "'";
            
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MejaBean meja = new MejaBean();
                meja.setIdResto(rs.getString(1));
                meja.setNamaM(rs.getString(2));
                meja.setFotoM(rs.getBlob(3));
                meja.setHargaM(rs.getInt(4));
                meja.setDeskripsiM(rs.getString(5));
                meja.setJumlahM(rs.getInt(6));
                daftarMeja.add(meja);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarMeja;
    }

    public int insert(MejaBean meja) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "insert into meja (idResto, namaM, fotoM, hargaM, deskripsiM, jumlahM) "
                + "values (?,?,?,?,?,?)";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, meja.getIdResto());
            pstmt.setString(2, meja.getNamaM());
            pstmt.setBlob(3, meja.getFotoM());
            pstmt.setInt(4, meja.getHargaM());
            pstmt.setString(5, meja.getDeskripsiM());
            pstmt.setInt(6, meja.getJumlahM());

            result = pstmt.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public int insertBatch(DaftarMeja daftarMeja, String idResto, String[] namaMlama) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "update meja set namaM = ?, deskripsiM = ?, jumlahM = ?, hargaM = ?, fotoM=? where meja.idResto = '" + idResto + "' and meja.namaM = ?";
        try {

            PreparedStatement pstmt = null;
            conn = dbConn.getConnection();

            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < daftarMeja.getDaftarMeja().size(); i++) {

                pstmt.setString(1, daftarMeja.getDaftarMeja().get(i).getNamaM());
                pstmt.setString(2, daftarMeja.getDaftarMeja().get(i).getDeskripsiM());
                pstmt.setInt(3, daftarMeja.getDaftarMeja().get(i).getJumlahM());
                pstmt.setInt(4, daftarMeja.getDaftarMeja().get(i).getHargaM());
                pstmt.setBlob(5, daftarMeja.getDaftarMeja().get(i).getFotoM());
                pstmt.setString(6, namaMlama[i]);

                result = pstmt.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }
}
