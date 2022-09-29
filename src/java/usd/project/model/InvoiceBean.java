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
public class InvoiceBean {
    private String idInvoice, idResto, idPengunjung, statusPembayaran, tglBayar, tglBooking, namaM;
    private Blob buktiPembayaran;
    private int jumlahM;

    public String getNamaM() {
        return namaM;
    }

    public void setNamaM(String namaM) {
        this.namaM = namaM;
    }

    public int getJumlahM() {
        return jumlahM;
    }

    public void setJumlahM(int jumlahM) {
        this.jumlahM = jumlahM;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdResto() {
        return idResto;
    }

    public void setIdResto(String idResto) {
        this.idResto = idResto;
    }

    public String getIdPengunjung() {
        return idPengunjung;
    }

    public void setIdPengunjung(String idPengunjung) {
        this.idPengunjung = idPengunjung;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public String getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(String tglBayar) {
        this.tglBayar = tglBayar;
    }

    public String getTglBooking() {
        return tglBooking;
    }

    public void setTglBooking(String tglBooking) {
        this.tglBooking = tglBooking;
    }

    public Blob getBuktiPembayaran() {
        return buktiPembayaran;
    }

    public void setBuktiPembayaran(Blob buktiPembayaran) {
        this.buktiPembayaran = buktiPembayaran;
    }
}
