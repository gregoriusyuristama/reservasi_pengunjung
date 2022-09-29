/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.model;

import java.io.Serializable;
import java.sql.Blob;

/**
 *
 * @author gregoriusyuristama
 */
public class RestoranBean implements Serializable {
    private String idResto, namaR, alamatR, emailR, KTP, noRek, noTelp, passwordR, deskripsiR, 
            namaPemilik, namaBank, jamBuka, jamTutup;
    private Blob fotoKTP, foto1, foto2, foto3, foto4, foto5;

    public RestoranBean() {
    }

    public RestoranBean(String idResto, String namaR, String alamatR, String emailR, String KTP, String noRek, String noTelp, String passwordR, String deskripsiR, String namaPemilik, String namaBank, String jamBuka, String jamTutup, Blob fotoKTP, Blob foto1, Blob foto2, Blob foto3, Blob foto4, Blob foto5) {
        this.idResto = idResto;
        this.namaR = namaR;
        this.alamatR = alamatR;
        this.emailR = emailR;
        this.KTP = KTP;
        this.noRek = noRek;
        this.noTelp = noTelp;
        this.passwordR = passwordR;
        this.deskripsiR = deskripsiR;
        this.namaPemilik = namaPemilik;
        this.namaBank = namaBank;
        this.jamBuka = jamBuka;
        this.jamTutup = jamTutup;
        this.fotoKTP = fotoKTP;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
    }    

    public String getIdResto() {
        return idResto;
    }

    public void setIdResto(String idResto) {
        this.idResto = idResto;
    }

    public String getNamaR() {
        return namaR;
    }

    public void setNamaR(String namaR) {
        this.namaR = namaR;
    }

    public String getAlamatR() {
        return alamatR;
    }

    public void setAlamatR(String alamatR) {
        this.alamatR = alamatR;
    }

    public String getEmailR() {
        return emailR;
    }

    public void setEmailR(String emailR) {
        this.emailR = emailR;
    }

    public String getKTP() {
        return KTP;
    }

    public void setKTP(String KTP) {
        this.KTP = KTP;
    }

    public String getNoRek() {
        return noRek;
    }

    public void setNoRek(String noRek) {
        this.noRek = noRek;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPasswordR() {
        return passwordR;
    }

    public void setPasswordR(String passwordR) {
        this.passwordR = passwordR;
    }

    public String getDeskripsiR() {
        return deskripsiR;
    }

    public void setDeskripsiR(String deskripsiR) {
        this.deskripsiR = deskripsiR;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }

    public String getJamTutup() {
        return jamTutup;
    }

    public void setJamTutup(String jamTutup) {
        this.jamTutup = jamTutup;
    }

    public Blob getFotoKTP() {
        return fotoKTP;
    }

    public void setFotoKTP(Blob fotoKTP) {
        this.fotoKTP = fotoKTP;
    }

    public Blob getFoto1() {
        return foto1;
    }

    public void setFoto1(Blob foto1) {
        this.foto1 = foto1;
    }

    public Blob getFoto2() {
        return foto2;
    }

    public void setFoto2(Blob foto2) {
        this.foto2 = foto2;
    }

    public Blob getFoto3() {
        return foto3;
    }

    public void setFoto3(Blob foto3) {
        this.foto3 = foto3;
    }

    public Blob getFoto4() {
        return foto4;
    }

    public void setFoto4(Blob foto4) {
        this.foto4 = foto4;
    }

    public Blob getFoto5() {
        return foto5;
    }

    public void setFoto5(Blob foto5) {
        this.foto5 = foto5;
    }
    

 
}
