package usd.project.model;

import java.io.Serializable;
import java.sql.Blob;

public class BeanPengunjung implements Serializable {

    private String idPengunjung, namaP, gender, noTelpP, passwordP, emailP;
    private Blob fotoP;

    public BeanPengunjung() {
    }

    public BeanPengunjung(String idPengunjung, String namaP, String gender, String noTelpP, String passwordP, String emailP, Blob fotoP) {
        this.idPengunjung = idPengunjung;
        this.namaP = namaP;
        this.gender = gender;
        this.noTelpP = noTelpP;
        this.passwordP = passwordP;
        this.emailP = emailP;
        this.fotoP = fotoP;
    }

    public String getIdPengunjung() {
        return idPengunjung;
    }

    public void setIdPengunjung(String idPengunjung) {
        this.idPengunjung = idPengunjung;
    }

    public String getNamaP() {
        return namaP;
    }

    public void setNamaP(String namaP) {
        this.namaP = namaP;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNoTelpP() {
        return noTelpP;
    }

    public void setNoTelpP(String noTelpP) {
        this.noTelpP = noTelpP;
    }

    public String getPasswordP() {
        return passwordP;
    }

    public void setPasswordP(String passwordP) {
        this.passwordP = passwordP;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public Blob getFotoP() {
        return fotoP;
    }

    public void setFotoP(Blob fotoP) {
        this.fotoP = fotoP;
    }

}
