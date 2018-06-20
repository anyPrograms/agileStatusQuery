package com.baidu.agileStatusQuery.dao;

import com.baidu.agileStatusQuery.beans.valueBean;

import java.util.List;

/**
 * 定义数据层操作
 */
public interface IInfoDao {

    /**
     * 修改记录名字
     *
     * @param param,id,value 待修改的记录id和修改后的值,其中param指代修改的字段，param="name"代表修改名字，="argu"代表修改arguments
     * @return 数据保存成功返回true，否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doUpdate(String param, String id, String value) throws Exception;

    /**
     * 以value查询数据库
     *
     * @param param,value param指待查项，value为值
     * @return 成功则返回一个valueBeans对象的列表，否则返回空list
     * @throws Exception SQL执行异常
     */
    public List<valueBean> doQuery(String param, String value) throws Exception;

    /**
     * 获取全量数据库内容列表
     * @return 成功返回一个valueBeans对象的列表，否则返回空list
     * @throws Exception SQL执行异常
     */
    public List<valueBean> doQueryInAll(String searchLabel) throws Exception;

}
