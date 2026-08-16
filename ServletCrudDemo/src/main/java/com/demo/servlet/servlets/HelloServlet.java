package com.demo.servlet.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    public HelloServlet(){
        System.out.println("Hello Constructor called");
    }

    @Override
    public void init(){
        System.out.println("init() method called");
    }

    @Override
    public void doGet(HttpServletRequest request ,
                      HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.setContentType("application/ json");
        response.getWriter().write("Hello");
    }

    @Override
    public void destroy(){
        System.out.println("Destroy Method Called");
    }
}
