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
public class DaftarInvoice {

    private LinkedList<InvoiceBean> daftar;

    public LinkedList<InvoiceBean> getInvoice() {
        return daftar;
    }

    public void setInvoice(LinkedList<InvoiceBean> invoice) {
        this.daftar = invoice;
    }

}
