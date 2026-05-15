/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import com.akunerio.webapptest.controllers.JDBC;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author luliou
 */
public class Product extends JDBC {
    private int id;
    private String name;
    private double price;

    public Product() {
      
    }
     
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    Product toModel(ResultSet rs) {
    try {
        return new Product(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getDouble("price")
        );
    } catch(Exception e) {
        setMessage(e.getMessage());
    }
    return null;
    }
    
    public ArrayList<Product> get() {
        ArrayList<Product> res = new ArrayList<>();
       
        try {
            ResultSet rs = getData("SELECT * FROM product");
            while (rs.next()) {
                res.add(toModel(rs));
            }
        } catch (Exception e) {
            setMessage(e.getMessage());
        }
        return res;
    }
    
    ArrayList<Object> toRow(ResultSet rs) {
        ArrayList<Object> res = new ArrayList<>();
        int i = 1;
        try {
            while (true) {
                res.add(rs.getObject(i));
                i++;
            }
        } catch(Exception e) {
            setMessage(e.getMessage());
        }
        return res;
    }
    
    public ArrayList<ArrayList<Object>> query(String query) {
        ArrayList<ArrayList<Object>> res = new ArrayList<>();
        try {
            ResultSet rs = getData(query);
            while (rs.next()) {
                res.add(toRow(rs));
            }
        } catch (Exception e) {
            setMessage(e.getMessage());
        }
        return res;
    }
    
    public Product find(String id) {
        ResultSet rs = getData("SELECT * FROM product WHERE id = " + id);
        try {
            if (rs.next()) {
                return toModel(rs);
            }
        } catch (Exception e) {
            setMessage(e.getMessage());
        }
        return null;
    }

    public void insert() {
        runQuery("INSERT INTO product(name, price) "
                + " VALUES ('" + name + "', '" + price + "')");
    }

    public void update() {
        runQuery("UPDATE product SET name = '" + name + "', price = '" + price + "'"
                + " WHERE id = " + id);
    }

    public void delete() {
        runQuery("DELETE FROM product WHERE id = " + id);
    }
    
    public void setMessage(String m){
        System.out.println(m);
    }
    
}
