package cdata.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConecta {

    public Connection connection() {
        Connection cn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
                    "jdbc:mysql://192.168.100.187:3306/webdb?serverTimezone=UTC", "admin", "Oracle12cR2!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cn;
    }

}
