package com.baidu.agileStatusQuery.utils;

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ListenerLoadConfig implements ServletContextListener {
    private Logger log = Logger.getLogger(ListenerLoadConfig.class);

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        String path = event.getServletContext().getRealPath("WEB-INF/config/dbconfig.properties");
        LoadDBConfig.load(path);
        log.info("load database success");
    }

}
