package com.baidu.agileStatusQuery.service.impl;

import com.baidu.agileStatusQuery.beans.argumentsBean;
import com.baidu.agileStatusQuery.beans.valueBean;
import com.baidu.agileStatusQuery.dao.impl.infoDaoImpl;
import com.baidu.agileStatusQuery.service.Iservice;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class serviceImpl implements Iservice {
    private static final Logger log = Logger.getLogger(serviceImpl.class);

    @Override
    public String initialize() {
        infoDaoImpl infoObject = new infoDaoImpl();
        List<valueBean> listOfValue = new ArrayList<valueBean>();
        valueBean valueObject = new valueBean();
        argumentsBean arguObject = new argumentsBean();
        JSONArray jsonArr = new JSONArray();
        JSONArray jsonArrFinal = new JSONArray();//存储最终结果

        listOfValue = infoObject.doQueryInAll();
        try {
            for (int i = 0; i < listOfValue.size(); i++) {
                valueObject = listOfValue.get(i);
/**
 * 下面这部分代码是初始化首页的时候请求agile，并更新数据库，实际上并不需要这样做。直接读库取所需的字段即可。
 *              //下面一句，取到的jobConf为一个json数组，实际使用应取json里面的jobConfId
 String url = "http://agile.baidu.com/api/agile/lastSimpleJobBuild?jobConfIds=" + valueObject.getJobConf();
 String jsonStr = "[]";
 jsonStr = this.sendPost("", url);

 JSONArray jsonArrOrigin = JSONArray.fromObject(jsonStr);

 //当远程数据为空的时候，读本地数据库存储的数据；
 if (jsonArrOrigin.size() == 0) {

 } else if (jsonArrOrigin.size() == 1) {
 valueObject.setArguments(jsonStr);//将agile返回数据存入对象
 argumentsBean arguObj = this.jsonObj2javaBean(jsonArrOrigin.getJSONObject(0));
 JSONObject jsonObj_temp = this.javaBean2jsonObj(arguObj);
 valueObject.setArguments(jsonObj_temp.toString());//将该json对象转换为valueBean对象的参数
 } else {
 valueObject.setArguments(jsonStr);//将agile返回数据存入对象
 JSONArray jsonArrForMultiObjects = new JSONArray();
 for (int j = 0; j < jsonArrOrigin.size(); j++) {
 argumentsBean arguObj = this.jsonObj2javaBean(jsonArrOrigin.getJSONObject(j));
 jsonArrForMultiObjects.add(this.javaBean2jsonObj(arguObj));
 }
 valueObject.setArguments(jsonArrForMultiObjects.toString());//将该json数组转换为valueBean对象的参数
 }

 //更新数据库
 boolean result = infoObject.doUpdate("argu", String.valueOf(valueObject.getId()), valueObject.getArguments());
 if (result == true) {
 log.info("Update database successfully!");
 } else {
 log.info("No data need to be updated!");
 }

 // JSONObject jsonObj = this.javaBean2jsonObj(valueObject);
 // jsonArr.add(jsonObj);
 */
                jsonArrFinal.add(this.javaBean2jsonObj(valueObject));
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed to initialize::" + e);
        }

        //将json数组转化为字符串返回前端
        return jsonArrFinal.toString();
    }

    @Override
    public String sendPost(String jsonStr, String path) {
        //byte[] data = jsonStr.getBytes();
        java.net.URL url = null;
        java.net.HttpURLConnection conn = null;
        String msg = "[]";//保存调用http服务后的响应信息
        try {
            url = new java.net.URL(path);
            conn = (java.net.HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);//设置连接超时时间为5s
            conn.setReadTimeout(20 * 1000);//设置读取超时时间为20s
            //使用URL连接进行输出，则将DoOutput标志设为true
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
//            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
//            OutputStream outStream = conn.getOutputStream();
//            outStream.write(data);
            if (conn.getResponseCode() == 200) {
                //HTTP服务端返回的编码是UTF-8，故必须设置为UTF-8，保持编码统一，否则会出现中文乱码
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                msg = in.readLine();
                in.close();
            }
            conn.disconnect();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("调用agile接口失败::" + e);
        }

        String defaultString = "Param is invalid!";
        if (msg.equals(defaultString)) {
            log.info("jobConfId 参数错误,请检查拼写::" + path);
            return "";
        } else {
            return msg;
        }
    }

    @Override
    public String clickForDetails(String id) {
        JSONObject jsonObjNew = new JSONObject();//用于存储模块名和返回的json数组
        JSONArray jsonArr = new JSONArray();//用于存储从unix时间戳转换为普通时间之后的json对象
        JSONObject jsonObj = new JSONObject();
        infoDaoImpl infoObj = new infoDaoImpl();
        Map<String, String> mapJobConf = new HashMap<String, String>();

        List<valueBean> listObj = infoObj.doQuery("id", id);
        if (listObj.size() == 0) {
            return "null";
        }
        jsonObjNew.put("moduleName", listObj.get(0).getName());
        String jobConfIdStr = "";
        JSONArray jsonArrJobConf = JSONArray.fromObject(listObj.get(0).getJobConf());
        //取jobConf内的jobConfId
        for (int i = 0; i < jsonArrJobConf.size(); i++) {
            JSONObject jsonObjJobConf = jsonArrJobConf.getJSONObject(i);
            jobConfIdStr += jsonObjJobConf.getString("jobConfId") + ",";
            //将jobConfId和urlName放入map中
            mapJobConf.put(jsonObjJobConf.getString("jobConfId"), jsonObjJobConf.getString("urlName"));
        }
        //去掉最后一个逗号
        jobConfIdStr = jobConfIdStr.substring(0, jobConfIdStr.length() - 1);
        String url = "http://agile.baidu.com/api/agile/lastSimpleJobBuild?jobConfIds=" + jobConfIdStr;
        String jsonStr = this.sendPost("", url);

        if (jsonStr.length() == 2) {
            //agile接口返回“[]”，因而从数据库读参数
            jsonObjNew.put("arguments", listObj.get(0).getArguments());
        } else {
            //字符串转json数组
            JSONArray jsonArrOrigin = JSONArray.fromObject(jsonStr);
            try {
                for (int i = 0; i < jsonArrOrigin.size(); i++) {
                    argumentsBean arguObj = this.jsonObj2javaBean(jsonArrOrigin.getJSONObject(i));
                    arguObj.setUrlName(mapJobConf.get(jsonArrOrigin.getJSONObject(i).getString("jobConfId")));
                    jsonArr.add(this.javaBean2jsonObj(arguObj));
                }
                jsonObjNew.put("arguments", jsonArr);

                //更新数据库
                boolean result = infoObj.doUpdate("argu", id, jsonArr.toString());
                if (result == true) {
                    log.info("Update database successfully!");
                } else {
                    log.info("No data need to be updated!");
                }

            } catch (Exception e) {
                e.printStackTrace();
                log.error("Transcode jsonObject to javaBean error::" + e);
            }
        }
        return jsonObjNew.toString();

    }

    @Override
    public JSONObject javaBean2jsonObj(argumentsBean arguObj) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("jobConfId", arguObj.getJobConfId());
        jsonObj.put("urlName",arguObj.getUrlName());
        jsonObj.put("jobName", arguObj.getJobName());
        jsonObj.put("status", arguObj.getStatus());
        jsonObj.put("startTime", arguObj.getStartTime());
        jsonObj.put("endTime", arguObj.getEndTime());
        jsonObj.put("duration", arguObj.getDuration());
        jsonObj.put("triggerUser", arguObj.getTriggerUser());

        return jsonObj;
    }

    @Override
    public JSONObject javaBean2jsonObj(valueBean valueObj) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", valueObj.getId());
        jsonObj.put("name", valueObj.getName());
        String strOfJobConfId = "";
        JSONArray jobConfIdArray = JSONArray.fromObject(valueObj.getJobConf());
        for (int i = 0; i < jobConfIdArray.size(); i++) {
            JSONObject jsonObjTemp = jobConfIdArray.getJSONObject(i);
            strOfJobConfId += jsonObjTemp.get("jobConfId") + ",";
        }
        //去掉最后一个逗号
        strOfJobConfId = strOfJobConfId.substring(0, strOfJobConfId.length() - 1);

        jsonObj.put("jobConfId", strOfJobConfId);
        //注释下面一行，initialize接口返回没有arguments项，第一个界面不需要
        //jsonObj.put("arguments", valueObj.getArguments());

        return jsonObj;
    }

    @Override
    public argumentsBean jsonObj2javaBean(JSONObject jsonObj) throws Exception {
        argumentsBean arguObj = new argumentsBean();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        arguObj.setJobConfId(jsonObj.getString("jobConfId"));
        arguObj.setJobName(jsonObj.getString("jobName"));
        arguObj.setStatus(jsonObj.getString("status"));
        String strDate = null;
        if (jsonObj.getString("startTime") == "null") {
            arguObj.setStartTime(null);
        } else {
            strDate = sd.format(new Date(jsonObj.getLong("startTime")));
            arguObj.setStartTime(strDate);
        }
        if (jsonObj.getString("endTime") == "null") {
            arguObj.setEndTime(null);
        } else {
            strDate = sd.format(new Date(jsonObj.getLong("endTime")));
            arguObj.setEndTime(strDate);
        }
        arguObj.setDuration(jsonObj.getString("duration"));
        arguObj.setTriggerUser(jsonObj.getString("triggerUser"));

        return arguObj;
    }


}
