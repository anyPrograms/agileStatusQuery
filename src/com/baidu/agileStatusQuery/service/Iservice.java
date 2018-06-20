package com.baidu.agileStatusQuery.service;

import com.baidu.agileStatusQuery.beans.argumentsBean;
import com.baidu.agileStatusQuery.beans.valueBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface Iservice {

    /**
     * ①初始化界面
     *
     * @return 返回一个json数组，存储所有的json对象，
     * @throws Exception
     */
    public String initialize(String name) throws Exception;

    /**
     * ②调用agile开发接口获得返回json列表
     *
     * @param jsonStr post请求的参数，get请求可以填""
     * @param path    接口的完整url
     * @return 成功则返回接口返回的字符串，失败返回一个空字符串
     * @throws Exception
     */
    public String sendPost(String jsonStr, String path) throws Exception;

    /**
     * ③点击之后展开参数列表
     *
     * @param jobConfId 该模块包含的任务Id
     * @return 返回一个json字符串
     * @throws Exception
     */
    public String clickForDetails(String jobConfId) throws Exception;

    /**
     * ④⑤javabean对象转json对象
     *
     * @param arguObj argumentsBean对象
     * @return 返回一个json对象
     * @throws Exception
     */
    public JSONObject javaBean2jsonObj(argumentsBean arguObj) throws Exception;

    public JSONObject javaBean2jsonObj(valueBean valueObj) throws Exception;

    /**
     * ⑥json对象转javabean对象
     *
     * @param jsonObj json对象
     * @return 返回一个javabean对象
     * @throws Exception
     */
    public argumentsBean jsonObj2javaBean(JSONObject jsonObj) throws Exception;
}
