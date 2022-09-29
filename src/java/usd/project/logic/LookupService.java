/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.logic;

import java.util.LinkedList;
import usd.project.model.BeanPengunjung;
import usd.project.model.DaftarInvoice;
import usd.project.model.MejaBean;
import usd.project.model.RestoranBean;

/**
 *
 * @author gregoriusyuristama
 */
public interface LookupService {
    public RestoranBean findResto(String id);
    public BeanPengunjung findPengunjung(String id);
    public LinkedList<BeanPengunjung> findListPengunjungTransaksi(DaftarInvoice di);
    public LinkedList<MejaBean> findListMejaTransaksi(DaftarInvoice di); 
    public LinkedList<RestoranBean> findListRestoTransaksi(DaftarInvoice di);
    
}
