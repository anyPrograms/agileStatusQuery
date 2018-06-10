package com.baidu.agileStatusQuery.utils;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 * 加载数据库配置
 */
public class LoadDBConfig {

    private static final Logger log = Logger.getLogger(LoadDBConfig.class);
    private static HashMap<String, String> dbMap = new HashMap<String, String>();

    public static String getDBValue(String name) {
        return dbMap.get(name);
    }

    public static void load(String path) {
        try {
            //加载配置
            Properties pro = new Properties();
            //加载文件
            pro.load(new FileInputStream(path));
            //取值
            String driverclass = pro.getProperty("driverclass");
            String url = pro.getProperty("url");
            String username = pro.getProperty("username");
            String password = pro.getProperty("password");
            dbMap.put("driverclass", driverclass);
            dbMap.put("url", url);
            dbMap.put("username", username);
            dbMap.put("password", password);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("load database config error::" + e);
        }
    }

}
