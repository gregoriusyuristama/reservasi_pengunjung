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
public class DaftarMeja {
    LinkedList<MejaBean> daftarMeja;

    public LinkedList<MejaBean> getDaftarMeja() {
        return daftarMeja;
    }

    public void setDaftarMeja(LinkedList<MejaBean> daftarMeja) {
        this.daftarMeja = daftarMeja;
    }
}
