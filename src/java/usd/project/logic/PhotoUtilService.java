/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.logic;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.servlet.http.Part;

/**
 *
 * @author gregoriusyuristama
 */
public interface PhotoUtilService {
    public Blob ambilFoto(Part inputPart);
}
