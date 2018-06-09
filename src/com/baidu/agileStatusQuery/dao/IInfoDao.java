package com.baidu.agileStatusQuery.dao;

import com.baidu.agileStatusQuery.beans.valueBean;

import java.util.List;

/**
 * 定义数据层操作
 */
public interface IInfoDao {

    /**
     * 更新数据库
     * @param  id,name 待修改的记录id和修改后名称
     * @return 数据保存成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doUpdate(String id,String name) throws Exception;

    /**
     * 以编号查询数据库，
     * @param id 对应数据库唯一记录
     * @return 成功则返回一个valueBeans对象的列表，否则返回null
     * @throws Exception SQL执行异常
     */
    public List<valueBean> doQuery(String id) throws Exception;
}
