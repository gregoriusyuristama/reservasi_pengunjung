/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.logic;

import usd.project.db.DbConnection;
import usd.project.model.RestoranBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import usd.project.dao.MejaDao;
import usd.project.dao.PengunjungDao;
import usd.project.dao.RestoDao;
import usd.project.model.BeanPengunjung;
import usd.project.model.DaftarInvoice;
import usd.project.model.MejaBean;

/**
 *
 * @author gregoriusyuristama
 */
public class Lookup implements LookupService {

    public Lookup() {
    }

    @Override
    public RestoranBean findResto(String id) {
        RestoDao rDao = new RestoDao();
        RestoranBean resto = null;
        try {
            resto = rDao.getResto(id);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resto;
    }

    @Override
    public BeanPengunjung findPengunjung(String id) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        DbConnection dbConn = new DbConnection();
        BeanPengunjung pengunjung = new BeanPengunjung();
        try {
            conn = dbConn.getConnection();
            st = conn.createStatement();
            String sql = "select * from pengunjung where idPengunjung='" + id + "'";

            rs = st.executeQuery(sql);

            rs.next();
            pengunjung = new BeanPengunjung(rs.getString("idPengunjung"),
                    rs.getString("namaP"), rs.getString("gender"), rs.getString("noTelpP"),
                    rs.getString("passwordP"), rs.getString("emailP"), rs.getBlob("fotoP"));

        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return pengunjung;
    }

    @Override
    public LinkedList<BeanPengunjung> findListPengunjungTransaksi(DaftarInvoice di) {
        LinkedList<BeanPengunjung> daftarPengunjung = new LinkedList();
        PengunjungDao pDao = new PengunjungDao();
        for (int i = 0; i < di.getInvoice().size(); i++) {
            try {
                daftarPengunjung.add(pDao.getPengunjung(di.getInvoice().get(i).getIdPengunjung()));
            } catch (SQLException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return daftarPengunjung;
    }

    @Override
    public LinkedList<MejaBean> findListMejaTransaksi(DaftarInvoice di) {
        LinkedList<MejaBean> daftarMeja = new LinkedList();
        MejaDao mDao = new MejaDao();
        for (int i = 0; i < di.getInvoice().size(); i++) {
            try {
                daftarMeja.add(mDao.getMeja(di.getInvoice().get(i).getIdResto(), di.getInvoice().get(i).getNamaM()));
            } catch (SQLException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return daftarMeja;
    }

    @Override
    public LinkedList<RestoranBean> findListRestoTransaksi(DaftarInvoice di) {
        LinkedList<RestoranBean> daftarResto = new LinkedList();
        RestoDao rdao = new RestoDao();
        for (int i = 0; i < di.getInvoice().size(); i++) {
            try {
                daftarResto.add(rdao.getResto(di.getInvoice().get(i).getIdResto()));
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Lookup.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return daftarResto;
    }

}
