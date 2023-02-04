/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grill.java;

import com.grill.java.GrillConnectionString;
import com.grill.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author omobi
 */
public class AdminAccess {
    
    GrillConnectionString con = new GrillConnectionString();
    
    
    public List<Order> selectAllOrders() throws SQLException{
        List<Order> admin = new ArrayList<>();
        
        Connection connection = con.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * from ordertable");
        ResultSet rs = ps.executeQuery();

         while (rs.next()) {
               String id = rs.getString("ID");
               String name = rs.getString("Name");
               String email = rs.getString("Email");
               String foodname = rs.getString("FoodName");
               String deliveryopt = rs.getString("DeliveryOption");
               String modeofpay = rs.getString("ModeOfPayment");
                
                ///String password = rs.getString("password");
                admin.add(new Order(id, name, email, foodname,deliveryopt, modeofpay));
            }
        return admin;
    }
    
    
    public int insertOrder(Order order) throws SQLException{
        int inserted = 0;
        Connection connect = con.getConnection();
        PreparedStatement ps = connect.prepareStatement("INSERT INTO ordertable(Name, Email, FoodName, DeliveryOption, "
                + "ModeOfPayment) values(?,?,?,?,?)");
        ps.setString(1, order.getName());
        ps.setString(2, order.getEmail());
        ps.setString(3, order.getFoodname());
        ps.setString(4, order.getDeliveryopt());
        ps.setString(5, order.getModeofpay());
        
        inserted = ps.executeUpdate();
        
        return inserted;
    }
    
    public boolean deleteOrder(int id) throws SQLException{
        boolean deleted = false;
        Connection connect = con.getConnection();
        PreparedStatement ps = connect.prepareStatement("DELETE FROM ordertable where id=?");
        ps.setInt(1, id);
        deleted = ps.executeUpdate() > 0;
        
        return deleted;
    }
    
// Cant i use an int here too instead of a boolean
    
    
    public boolean checkAdmin(String email, String password) {
    try (Connection connection = con.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM admintable where Email=? and Password=?");) {
        ps.setString(1, email);
        ps.setString(2, password);
        // Step 3: Execute the query or update query
        ResultSet rs = ps.executeQuery();
        // Step 4: Process the ResultSet object.
        if (rs.next()) {
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    
}

//Why are we using boolean in some places and int or String in others

// In our process servlet we had a deleted servlet, is that delete from the click of the delete button? if it is
// is see we are also trying to get an id parameter is that like a hidden form input? because if we click on a
// button why are we trying to get a parameter

// Sometimes many request has many methods why? eg request.getParameter or setParameter, or request.getSession;

// how for the process servlets we have sessions afterwards

// Sorry what does while(rs.next()) mean