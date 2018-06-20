package com.baidu.agileStatusQuery.servlets;

import com.baidu.agileStatusQuery.service.impl.serviceImpl;
import org.apache.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/initialize.do")
public class entranceServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(entranceServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        try{
            String name = request.getParameter("name");
            //System.out.println("接受到的数据：" + idForQuery);
            serviceImpl service=new serviceImpl();
            out.write(service.initialize(name));
        }catch(Exception e){
            e.printStackTrace();
            log.error("entranceServlet error::"+e);
        }finally{
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
