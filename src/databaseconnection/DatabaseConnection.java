/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kp
 */
public class DatabaseConnection {

    String db = "dataleak";
    String username = "root";
    String password = "root";
    Connection con = null;
    Statement stmt;
    ResultSet rs = null;
    //String dbPath = "d:\\ims.mdb";

    public DatabaseConnection() {
    }

    public Connection dbconnection() {

        try {
            String url = "jdbc:mysql://localhost/" + db;
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection(url, username, password);
             String path=new File(".").getCanonicalPath();
//             dbPath=path+"/reports/ims.mdb";
//            // dbPath=getDatabasepath();
//             //dbPath="\\\\IBN\\Data (D)\\ims.mdb";
//            // System.out.println(dbPath);
//             Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//             con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};Dbq="+dbPath);
             
               
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return con;
    }

    public ResultSet getResultSet(String query) {
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int getUpdate(String query) {
        int i = 0;
        try {
            stmt = con.createStatement();
            i = stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public void closeConnection(DatabaseConnection dbcon)
    {
        try {
            dbcon.dbconnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
 

    private String getDatabasepath() {
        String path = "";

        try {

            String filepath = new File(".").getCanonicalPath();
            File file = new File(filepath + "/dbpath/dbconfig.txt");
            FileInputStream fis = new FileInputStream(file);
            byte buff[] = new byte[fis.available()];
            int i = fis.read(buff);
            path = new String(buff);
            path = path.trim();
            fis.close();


        } catch (Exception e) {
            //e.printStackTrace();
        }

        return path;
    }
    
    
    
}
