package com.baidu.agileStatusQuery.servlets;

import com.baidu.agileStatusQuery.service.impl.serviceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/details.do")
public class clickForDetails extends HttpServlet {

    private static final Logger log = Logger.getLogger(clickForDetails.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String jobConfId = request.getParameter("jobConfId");
            System.out.println("接收到的数据：jobConfId：" + jobConfId);

            serviceImpl service = new serviceImpl();
            String result = service.clickForDetails(jobConfId);
            System.out.println("返回的数据：" + result);
            out.write(result);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("clickForDetails servlet error::" + e);
        } finally {
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
