package example.Daos;
import example.beans.valueBeans;
import java.util.*;

/**
 * 定义tb_info表的数据层操作标准
 */
public interface IinfoDAO {


    /**
     * 更新数据库记录
     * @param vo 包含了要修改记录的信息，一定要有id和name;
     * @return 数据保存成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doUpdate(valueBeans vo) throws Exception;


    /**
     * 以编号查询数据库，
     * @param id 对应数据库唯一记录
     * @return 成功则返回一个valueBeans对象的列表，否则返回null
     * @throws Exception SQL执行异常
     */
    public List<valueBeans> doQuery(int id) throws Exception;

}
