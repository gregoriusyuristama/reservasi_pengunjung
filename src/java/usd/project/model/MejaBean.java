/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.model;

import java.sql.Blob;

/**
 *
 * @author gregoriusyuristama
 */
public class MejaBean {
    String idResto, namaM, deskripsiM;
    int jumlahM, hargaM;
    Blob fotoM;

    public String getIdResto() {
        return idResto;
    }

    public void setIdResto(String idResto) {
        this.idResto = idResto;
    }

    public String getNamaM() {
        return namaM;
    }

    public void setNamaM(String namaM) {
        this.namaM = namaM;
    }

    public String getDeskripsiM() {
        return deskripsiM;
    }

    public void setDeskripsiM(String deskripsiM) {
        this.deskripsiM = deskripsiM;
    }

    public int getJumlahM() {
        return jumlahM;
    }

    public void setJumlahM(int jumlahM) {
        this.jumlahM = jumlahM;
    }

    public int getHargaM() {
        return hargaM;
    }

    public void setHargaM(int hargaM) {
        this.hargaM = hargaM;
    }

    public Blob getFotoM() {
        return fotoM;
    }

    public void setFotoM(Blob fotoM) {
        this.fotoM = fotoM;
    }
    
    
}
