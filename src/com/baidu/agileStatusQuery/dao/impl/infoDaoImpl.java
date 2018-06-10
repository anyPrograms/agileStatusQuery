package com.baidu.agileStatusQuery.dao.impl;

import com.baidu.agileStatusQuery.beans.valueBean;
import com.baidu.agileStatusQuery.dao.IInfoDao;
import org.apache.log4j.Logger;
import sun.awt.SunHints;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.baidu.agileStatusQuery.utils.DBUtil.*;

public class infoDaoImpl implements IInfoDao {
    private static final Logger log = Logger.getLogger(infoDaoImpl.class);

    @Override
    public boolean doUpdate(String param, String id, String value) {
        Connection conn = null;
        PreparedStatement stat = null;
        value="'"+value+"'";
        int rowCount = 0;//受影响的行数
        String sql = "";
        try {
            conn = getConn();
            switch (param) {
                case "name": {
                    sql = "update tb_info SET name=" + value + " WHERE id=" + id;
                    break;
                }
                case "argu": {
                    sql = "update tb_info SET arguments=" + value + " WHERE id=" + id;
                    break;
                }
                default: {
                    log.error("doUpdate(String param,String id,String value)参数格式不正确::" +
                            "param:" + param + ",id:" + id + ",value:" + value);
                    return false;
                }
            }
            stat = conn.prepareStatement(sql);
            rowCount = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("update database error::" + e);
        } finally {
            closeConn(stat, conn);
        }
        if (rowCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<valueBean> doQuery(String param, String value) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        value="'"+value+"'";
        List<valueBean> listOfValue = new ArrayList<valueBean>();
        try {
            conn = getConn();
            String sql = "";
            switch (param) {
                case "id": {
                    sql = "select * from tb_info"+" WHERE id=" + value;
                    break;
                }
                case "jobConfId": {
                    sql = "select * from tb_info"+" WHERE jobConfId=" + value;
                    break;
                }
                default: {
                    log.error("doQuery(String param,String value)参数格式不正确::" +
                            "param:" + param + ",value:" + value);
                    break;
                }
            }
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                valueBean valueObject = new valueBean();
                valueObject.setId(rs.getInt("id"));
                valueObject.setName(rs.getString("name"));
                valueObject.setJobConfId(rs.getString("jobConfId"));
                valueObject.setArguments(rs.getString("arguments"));
                listOfValue.add(valueObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("search database error::" + e);
        } finally {
            closeConn(rs, stat, conn);
        }
        return listOfValue;
    }

    @Override
    public List<valueBean> doQueryInAll(){
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<valueBean> listOfValue = new ArrayList<valueBean>();

        try {
            conn = getConn();
            String sql = "select * from tb_info";
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while(rs.next()){
                valueBean valueObject = new valueBean();
                valueObject.setId(rs.getInt("id"));
                valueObject.setName(rs.getString("name"));
                valueObject.setJobConfId(rs.getString("jobConfId"));
                valueObject.setArguments(rs.getString("arguments"));
                listOfValue.add(valueObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("search database error::" + e);
        } finally {
            closeConn(rs, stat, conn);
        }
        return listOfValue;

    }
}
