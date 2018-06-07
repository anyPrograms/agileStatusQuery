package example.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import example.utils.DBUtil;

public class RegistDao extends DBUtil {
    public boolean insertData(String username, String password) {
        Connection conn = null;
        PreparedStatement stat = null;
        int rowCount = 0;

        try {
            conn = getConn();
            String sql = "insert into tb_info(name,arguments) value(?,?)";
            stat = conn.prepareStatement(sql);
            //设置值
            stat.setString(1, username);
            stat.setString(2, password);
            //执行
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
}
