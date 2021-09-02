/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prisonmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author al-sany
 */
public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    //constructors
    public DBConnect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", 
                    "system", "Samil000");
            System.out.println("DB Connect Successful");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    public DBConnect(String url, String user, String password) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public Connection connection(){
        return con;
    }
    
    public ResultSet getResultSet(String query) {
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return rs;
    }
    public int insertUpdate(String query){
        try {
            st.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    return 0;
    }
}
