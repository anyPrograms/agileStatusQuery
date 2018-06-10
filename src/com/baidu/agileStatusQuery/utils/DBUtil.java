package com.baidu.agileStatusQuery.utils;

import java.sql.*;
import org.apache.log4j.Logger;
import static com.baidu.agileStatusQuery.utils.LoadDBConfig.*;

public class DBUtil {

    private static final Logger log = Logger.getLogger(DBUtil.class);

    public static Connection getConn() {
        Connection conn = null;
        try {
            //加载驱动
            Class.forName(getDBValue("driverclass"));
            String url = getDBValue("url");
            String user = getDBValue("username");
            String password = getDBValue("password");
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("connect database error::" + e);

        }
        return conn;
    }

    /**
     * 关闭数据库连接
     *
     * @param rs
     * @param stat
     * @param conn
     */
    public static void closeConn(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Failed to close database connection");
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param stat
     * @param conn
     */
    public static void closeConn(Statement stat, Connection conn) {
        try {
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Failed to close database connection");
        }
    }
}

