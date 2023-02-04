/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grill.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omobi
 */
public class GrillConnectionString {
        public static String
            jdbc_connection="jdbc:mysql://localhost:3306/grill-db";
    public static String password="";
    public static String username="root";
    public Connection getConnection() throws SQLException{
        Connection connection =  null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbc_connection, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrillConnectionString.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    } 
}
