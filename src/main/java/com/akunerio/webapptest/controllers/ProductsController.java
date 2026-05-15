/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.akunerio.webapptest.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import models.Product;

/**
 *
 * @author luliou
 */
@WebServlet(name = "ProductsController", urlPatterns = {"/products"})
public class ProductsController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String menu = request.getParameter("action");
        
        if (menu == null) { //view menu
            //get all data from database
            request.setAttribute("title", "Daftar Produk");
            
//            ArrayList<Product> prods = new ArrayList<>();
//            prods.add(new Product(1, "Nasi Goreng", 15000));
//            prods.add(new Product(2, "Nasi Mawud", 20000));
//            HashMap<String, Object> json = new HashMap();
//            json.put("status", true);
//            json.put("data", prods);
//            String res = new Gson().toJson(json);
//            response.setContentType("application/json");
//            response.setCharacterEncoding("UTF-8");
//            PrintWriter out = response.getWriter();
//            out.print(res);

            ArrayList<Product> prods = new Product().get();
            System.out.println("hasil" + prods);

            // Temporarily instantiate JDBC to see if it recorded an error
            JDBC db = new JDBC();
            db.connect();
            System.out.println("DB Status: " + db.getMessage());
            request.setAttribute("list", prods);

            request.getRequestDispatcher("view_product.jsp").forward(request, response);
            
        } else if ("add".equals(menu)) {
            request.setAttribute("title","Tambah Produk");
         
            request.getRequestDispatcher("form_product.jsp").forward(request, response);
            
        } else if ("edit".equals(menu)) {
            //get one data from database
//            request.setAttribute("title", "Edit Produk");
//            Product p = new Product(6, "Nasi Ituu", 15000000);
//            request.setAttribute("product", p);

            request.setAttribute("title", "Edit Produk");
            request.setAttribute("action", "?id=" + request.getParameter("id"));
            Product p = new Product().find(request.getParameter("id"));
            if (p == null) {
                response.sendRedirect("product");
                return;
            }
            request.setAttribute("product", p);

            request.getRequestDispatcher("form_product.jsp").forward(request, response);
       
        } else if ("custom".equals(menu)) { //view menu Object
            request.setAttribute("title", "Dashboard");
            ArrayList<ArrayList<Object>> prods = new Product().query(
                "SELECT COUNT(*), AVG(price) FROM product");
            request.setAttribute("list", prods);
            request.getRequestDispatcher("view_custom.jsp").forward(request, response);
        }
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        
        if (id == null) { //insert data
            Product p = new Product();
            p.setName(request.getParameter("name"));
            p.setPrice(Double.parseDouble(request.getParameter("price")));
            p.insert();
        }  else if (action == null) { //update data
            Product p = new Product();
            p.setId(Integer.parseInt(id));
            p.setName(request.getParameter("name"));
            p.setPrice(Double.parseDouble(request.getParameter("price")));
            p.update();
            request.getSession().setAttribute("msg", p.getMessage());
        } else if ("del".equals(action)) { //delete data
            Product p = (Product) new Product().find(id);
            if (p != null) {
                p.delete();
            }
        }

        response.sendRedirect("products");
    }


}
