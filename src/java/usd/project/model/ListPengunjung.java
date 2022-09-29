/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.model;

import java.util.LinkedList;

/**
 *
 * @author gregoriusyuristama
 */
public class ListPengunjung {

    LinkedList<BeanPengunjung> daftarPengunjung;

    public LinkedList<BeanPengunjung> getDaftarPengunjung() {
        return daftarPengunjung;
    }

    public void setDaftarPengunjung(LinkedList<BeanPengunjung> daftarPengunjung) {
        this.daftarPengunjung = daftarPengunjung;
    }

}
