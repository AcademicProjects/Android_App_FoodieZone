package com.example.product_page;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Order {
     private String user_id;
     private Product p;
     private int count ;
     private int total_price;
     private String orderDate;
     private int orderHour;


    public Order(String user_id, Product p, int count, int orderHour) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        this.orderDate = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        this.orderHour = orderHour;
        this.user_id = user_id;
        this.p = p;
        this.count = count;
        this.total_price = count * p.getPrice();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderHour() {
        return orderHour;
    }

    public void setOrderHour(int orderHour) {
        this.orderHour = orderHour;
    }
}
