/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.dao;

import java.sql.Blob;
import usd.project.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import usd.project.model.InvoiceBean;
import usd.project.model.MejaBean;

/**
 *
 * @author gregoriusyuristama
 */
public class InvoiceDao {

    public int insert(InvoiceBean inv, LinkedList<MejaBean> daftarMeja) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "INSERT INTO `invoice` (`idInvoice`, `idResto`, `idPengunjung`, "
                + "`tglBayar`, `tglBooking`, `statusPembayaran`, `buktiPembayaran`) "
                + "VALUES (? , ? , ? , ? , ? , ? , ?)";

        String sql2 = "INSERT INTO `buktiinvoice` (`idInvoice`, `idResto`, `namaM`, "
                + "`jumlahM`) VALUES (? , ? , ? , ?)";
        try {

            PreparedStatement pstmt = null;

            PreparedStatement pstmt2 = null;
            conn = dbConn.getConnection();

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, inv.getIdInvoice());
            pstmt.setString(2, inv.getIdResto());
            pstmt.setString(3, inv.getIdPengunjung());
            pstmt.setString(4, inv.getTglBayar());
            pstmt.setString(5, inv.getTglBooking());
            pstmt.setString(6, inv.getStatusPembayaran());
            pstmt.setBlob(7, inv.getBuktiPembayaran());

            result = pstmt.executeUpdate();
            for (int i = 0; i < daftarMeja.size(); i++) {
                pstmt2 = conn.prepareStatement(sql2);
                pstmt2.setString(1, inv.getIdInvoice());
                pstmt2.setString(2, inv.getIdResto());
                pstmt2.setString(3, daftarMeja.get(i).getNamaM());
                pstmt2.setInt(4, daftarMeja.get(i).getJumlahM());

                result += pstmt2.executeUpdate();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public LinkedList<InvoiceBean> getAllInvLunas(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice join buktiinvoice on invoice.idInvoice = buktiinvoice.idInvoice where invoice.idResto = '" + idResto + "' and statusPembayaran = 'Lunas'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                inv.setNamaM(rs.getString(10));
                inv.setJumlahM(rs.getInt(11));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public LinkedList<InvoiceBean> getAllInvPending(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice join buktiinvoice on invoice.idInvoice = buktiinvoice.idInvoice where invoice.idResto = '" + idResto + "' and statusPembayaran = 'Pending'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                inv.setNamaM(rs.getString(10));
                inv.setJumlahM(rs.getInt(11));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public LinkedList<InvoiceBean> getAllInvBelumBayar(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice join buktiinvoice on invoice.idInvoice = buktiinvoice.idInvoice where invoice.idResto = '" + idResto + "' and statusPembayaran = 'Belum Bayar'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                inv.setNamaM(rs.getString(10));
                inv.setJumlahM(rs.getInt(11));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public LinkedList<InvoiceBean> getAllInvBatal(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice join buktiinvoice on invoice.idInvoice = buktiinvoice.idInvoice where invoice.idResto = '" + idResto + "' and statusPembayaran = 'Batal'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                inv.setNamaM(rs.getString(10));
                inv.setJumlahM(rs.getInt(11));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public LinkedList<InvoiceBean> getAllInv(String idResto) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice join buktiinvoice on invoice.idInvoice = buktiinvoice.idInvoice where invoice.idResto = '" + idResto + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                inv.setNamaM(rs.getString(10));
                inv.setJumlahM(rs.getInt(11));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public InvoiceBean getInvoice(String idInvoice) throws SQLException, ClassNotFoundException {
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        InvoiceBean invoice = new InvoiceBean();
        String sql = "select * from invoice where idInvoice = '" + idInvoice + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            invoice.setIdInvoice(rs.getString(1));
            invoice.setIdResto(rs.getString(2));
            invoice.setIdPengunjung(rs.getString(3));
            invoice.setTglBayar(rs.getString(4));
            invoice.setTglBooking(rs.getString(5));
            invoice.setStatusPembayaran(rs.getString(6));
            invoice.setBuktiPembayaran(rs.getBlob(7));
        } catch (SQLException ex) {
            Logger.getLogger(RestoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }
        return invoice;
    }

    public int updateLunas(String idInvoice) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "update invoice set statusPembayaran = 'Lunas' WHERE idInvoice = '"
                + idInvoice + "'";
        try {

            Statement st = null;
            conn = dbConn.getConnection();
            st = conn.prepareStatement(sql);
            result = st.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public int updateBelumBayar(String idInvoice) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "update invoice set statusPembayaran = 'Belum Bayar', buktiPembayaran = NULL WHERE idInvoice = '"
                + idInvoice + "'";
        try {

            Statement st = null;
            conn = dbConn.getConnection();
            st = conn.prepareStatement(sql);
            result = st.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public int updateBatal(String idInvoice) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "update invoice set statusPembayaran = 'Batal' WHERE idInvoice = '"
                + idInvoice + "'";
        try {

            Statement st = null;
            conn = dbConn.getConnection();
            st = conn.prepareStatement(sql);
            result = st.executeUpdate(sql);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public int updatePending(String idInvoice, Blob foto) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        DbConnection dbConn = new DbConnection();
        int result = 0;

        String sql = "update invoice set statusPembayaran = 'Pending', buktiPembayaran = ? WHERE idInvoice = ?";
        try {

            PreparedStatement ps = null;
            conn = dbConn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setBlob(1, foto);
            ps.setString(2, idInvoice);
            result = ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return result;
    }

    public LinkedList<InvoiceBean> getAllInvPengunjung(String idPengunjung) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice  where invoice.idPengunjung = '" + idPengunjung + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public LinkedList<InvoiceBean> getAllInvTransaksi(String idInvoice) throws SQLException, ClassNotFoundException {
        LinkedList<InvoiceBean> daftarInvoice = new LinkedList();
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();

        String sql = "select * from invoice join buktiinvoice on invoice.idInvoice = buktiinvoice.idInvoice where invoice.idInvoice = '" + idInvoice + "'";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                InvoiceBean inv = new InvoiceBean();
                inv.setIdInvoice(rs.getString(1));
                inv.setIdResto(rs.getString(2));
                inv.setIdPengunjung(rs.getString(3));
                inv.setTglBayar(rs.getString(4));
                inv.setTglBooking(rs.getString(5));
                inv.setStatusPembayaran(rs.getString(6));
                inv.setBuktiPembayaran(rs.getBlob(7));
                inv.setNamaM(rs.getString(10));
                inv.setJumlahM(rs.getInt(11));
                daftarInvoice.add(inv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbConn.closeConnection();
        }

        return daftarInvoice;
    }

    public String generateIdInv() throws SQLException, ClassNotFoundException {
        Random rand = new Random();
        String idInv = getAlphaNumericString(5) + rand.nextInt(1000);
        Statement stmt = null;
        ResultSet rs = null;
        DbConnection dbConn = new DbConnection();
        Connection conn = dbConn.getConnection();
        int rowCount = -1;
        while (rowCount > 0) {
            rowCount = -1;
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT COUNT(*) FROM invoice WHERE idInvoice = '" + idInv + "'");
                rs.next();
                idInv = getAlphaNumericString(5) + (rand.nextInt(900)+100);
                rowCount = rs.getInt(1);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        dbConn.closeConnection();
        return idInv;
    }

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
