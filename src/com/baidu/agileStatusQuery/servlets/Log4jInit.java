package com.baidu.agileStatusQuery.servlets;

import com.baidu.agileStatusQuery.utils.ListenerLoadConfig;
import com.baidu.agileStatusQuery.utils.LoadDBConfig;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Log4jInit extends HttpServlet {
    public void init() {
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j");
        if (file != null) {
            PropertyConfigurator.configure(prefix + file);
        }

//        //加载数据库配置
//        ListenerLoadConfig listener = new ListenerLoadConfig();
//        String path = getServletContext().getRealPath("WEB-INF/config/dbconfig.properties");
//        LoadDBConfig.load(path);

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
    }
}
