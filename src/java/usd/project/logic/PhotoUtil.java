/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.logic;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author gregoriusyuristama
 */
public class PhotoUtil implements PhotoUtilService{

    /**
     *
     * @param inputPart
     * @return
     * @throws IOException
     * @throws SQLException
     */
    @Override
        public Blob ambilFoto(Part inputPart){
        InputStream inputStream = null;
        if (inputPart.getSize() != 0) {

            try {
                // obtains input stream of the upload file inputStream =
                inputStream = inputPart.getInputStream();
                byte[] bytes = IOUtils.toByteArray(inputStream);
                return new SerialBlob(bytes);
            } catch (SQLException | IOException ex) {
                Logger.getLogger(PhotoUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
