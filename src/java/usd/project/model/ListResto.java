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
public class ListResto {

    private LinkedList<RestoranBean> daftarResto;

    public LinkedList<RestoranBean> getDaftarResto() {
        return daftarResto;
    }

    public void setDaftarResto(LinkedList<RestoranBean> daftarResto) {
        this.daftarResto = daftarResto;
    }

}
