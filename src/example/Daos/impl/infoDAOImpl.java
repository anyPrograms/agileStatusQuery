package example.Daos.impl;

import example.Daos.IinfoDAO;
import example.beans.valueBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static example.utils.DBUtil.*;

public class infoDAOImpl implements IinfoDAO {

    @Override
    public boolean doUpdate(valueBeans vo) {
        Connection conn = null;
        PreparedStatement stat = null;
        int rowCount = 0;
        try {
            conn = getConn();
            String sql = "update tb.info SET name=" + vo.getName() + "WHERE id=" + String.valueOf(vo.getId());
            stat = conn.prepareStatement(sql);
            rowCount = stat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn(stat, conn);
        }
        if (rowCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<valueBeans> doQuery(int id) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs=null;
        try {
            conn = getConn();
            String sql = "select * from tb_info where id=" + String.valueOf(id);
            stat = conn.prepareStatement(sql);
            rs =stat.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            closeConn(rs,stat,conn);
        }

    }

}
