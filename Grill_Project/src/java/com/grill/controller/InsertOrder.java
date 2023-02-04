/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.grill.controller;
import com.grill.java.AdminAccess;
import com.grill.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omobi
 */
public class InsertOrder extends HttpServlet {
    AdminAccess ada = new AdminAccess();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            All these parameters that we are getting is from the name right? like name in the form
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String foodname = request.getParameter("foodname");
            String deliveryopt = request.getParameter("deliveryopt");
            String modeofpay = request.getParameter("modeofpay");
            
            HttpSession session = request.getSession();
            Order order = new Order(name, email, foodname, deliveryopt, modeofpay);
            if(!(name.equals("")) & !(email.equals("")) & !(foodname.equals("")) & !(deliveryopt.equals("")) & 
                !(modeofpay.equals(""))){
                if(ada.insertOrder(order) > 0){
                    session.setAttribute("success", "Your request is Processing, your order should be ready soon");
                    response.sendRedirect("order");
                }
                
                else{
                    session.setAttribute("error", "Sorry Your information is invalid");
                    response.sendRedirect("order");
                }
            }
            
            else{
                session.setAttribute("error", "Fill in all input forms");
                response.sendRedirect("order");
            }
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
