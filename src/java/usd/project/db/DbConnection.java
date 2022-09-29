/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usd.project.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gregoriusyuristama
 */
public class DbConnection {

    String host = "localhost";
    String username = "root";
    String password = "";
    String port = "3306"; // mysql
    String dbName = "rpl";
    Connection conn = null;
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {

            Class.forName("com.mysql.jdbc.Driver"); // mysql 5.x

            String host = this.host;
            String username = this.username;
            String password = this.password;
            String port = this.port;
            String dbName = this.dbName;

            String url = "jdbc:mysql://"+host+":"+port+"/"+dbName;//mysql 8.x maupn 5.x

            conn = DriverManager.getConnection(url, username, password);

        }  catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }
        public void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
