/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grill.model;

/**
 *
 * @author omobi
 */
public class Order {
    String id, name, email, foodname, deliveryopt,modeofpay;

    public Order(String id, String name, String email, String foodname, String deliveryopt, String modeofpay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.foodname = foodname;
        this.deliveryopt = deliveryopt;
        this.modeofpay = modeofpay;
    }

    public Order(String name, String email, String foodname, String deliveryopt, String modeofpay) {
        this.name = name;
        this.email = email;
        this.foodname = foodname;
        this.deliveryopt = deliveryopt;
        this.modeofpay = modeofpay;
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getDeliveryopt() {
        return deliveryopt;
    }

    public void setDeliveryopt(String deliveryopt) {
        this.deliveryopt = deliveryopt;
    }

    public String getModeofpay() {
        return modeofpay;
    }

    public void setModeofpay(String modeofpay) {
        this.modeofpay = modeofpay;
    }
    
}
