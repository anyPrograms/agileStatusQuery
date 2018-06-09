package com.baidu.agileStatusQuery.dao.impl;

import com.baidu.agileStatusQuery.beans.valueBean;
import com.baidu.agileStatusQuery.dao.IInfoDao;
import org.apache.log4j.Logger;

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
    public boolean doUpdate(String id, String name) {
        Connection conn = null;
        PreparedStatement stat = null;
        int rowCount = 0;//受影响的行数
        try {
            conn = getConn();
            String sql = "update tb_info SET name=" + name + " WHERE id=" + id;
            stat = conn.prepareStatement(sql);
            rowCount = stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("update database error:" + e);
        } finally {
            closeConn(stat, conn);
        }
        if (rowCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<valueBean> doQuery(String id) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<valueBean> listOfValue = new ArrayList<>();
        valueBean valueObject = new valueBean();
        try {
            conn = getConn();
            String sql = "select * from tb_info where id=" + id;
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            while (rs.next()) {
                valueObject.setId(rs.getInt("id"));
                valueObject.setName(rs.getString("name"));
                valueObject.setArguments(rs.getString("arguments"));
                listOfValue.add(valueObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("search database error:" + e);
        } finally {
            closeConn(rs, stat, conn);
        }
        return listOfValue;
    }
}
