package com.baidu.agileStatusQuery.service.impl;

import com.baidu.agileStatusQuery.beans.argumentsBean;
import com.baidu.agileStatusQuery.beans.valueBean;
import com.baidu.agileStatusQuery.dao.impl.infoDaoImpl;
import com.baidu.agileStatusQuery.service.Iservice;
import com.google.gson.JsonArray;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class serviceImpl implements Iservice {
    private static final Logger log = Logger.getLogger(serviceImpl.class);

    @Override
    public String initialize() {
        infoDaoImpl infoObject = new infoDaoImpl();
        List<valueBean> listOfValue = new ArrayList<valueBean>();
        valueBean valueObject = new valueBean();
        argumentsBean arguObject = new argumentsBean();
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject();

        listOfValue = infoObject.doQueryInAll();
        try {
            for (int i = 0; i < listOfValue.size(); i++) {
                valueObject = listOfValue.get(i);

                String url = "http://agile.baidu.com/api/agile/lastSimpleJobBuild?jobConfIds=" + valueObject.getJobConfId();
                String jsonStr = this.sendPost("", "url");
                valueObject.setArguments(jsonStr);
                //更新数据库
                boolean result = infoObject.doUpdate("argu", String.valueOf(valueObject.getId()), jsonStr);
                if (result == true) {
                    log.info("Update database successfully!");
                } else {
                    log.error("Failed to update database!");
                }
//                //将arguments字段置为空，减少传输消耗；
//                valueObject.setArguments("");
                jsonObj = this.javaBean2jsonObj(valueObject);
                jsonArr.add(jsonObj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("failed to initialize" + e);
        }

        //将json数组转化为字符串返回前端
        return jsonArr.toString();
    }

    @Override
    public String sendPost(String jsonStr, String path) {
        //byte[] data = jsonStr.getBytes();
        java.net.URL url = null;
        java.net.HttpURLConnection conn = null;
        String msg = "";//保存调用http服务后的响应信息
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
            log.error("调用agile接口失败：" + e);
        }
        return msg;
    }

    @Override
    public String clickForDetails(String moduleName, String jobConfId) {
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("moduleName", moduleName);
        jsonArr.add(jsonObj);
        String url = "http://agile.baidu.com/api/agile/lastSimpleJobBuild?jobConfIds=" + jobConfId;
        String jsonStr = this.sendPost("", url);
        //字符串转json数组
        JSONArray jsonArrOrigin = JSONArray.fromObject(jsonStr);
        jsonArr.add(jsonArrOrigin);

        return jsonArr.toString();
    }

    @Override
    public JSONObject javaBean2jsonObj(argumentsBean arguObj) {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("jobConfId", arguObj.getJobConfId());
        jsonObj.put("jobName", arguObj.getJobName());
        jsonObj.put("status", arguObj.getStatus());
        jsonObj.put("endTime", arguObj.getEndTime());
        jsonObj.put("startTime", arguObj.getStartTime());
        jsonObj.put("duration", arguObj.getDuration());
        jsonObj.put("triggerUser", arguObj.getTriggerUser());

        return jsonObj;
    }

    @Override
    public JSONObject javaBean2jsonObj(valueBean valueObj) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("id", valueObj.getId());
        jsonObj.put("name", valueObj.getName());
        jsonObj.put("jobConfId", valueObj.getJobConfId());
        jsonObj.put("arguments", valueObj.getArguments());

        return jsonObj;
    }

    @Override
    public argumentsBean jsonObj2javaBean(JSONObject jsonObj) throws Exception {
        argumentsBean arguObj = new argumentsBean();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        arguObj.setJobConfId(jsonObj.getString("jobConfId"));
        arguObj.setJobName(jsonObj.getString("jobName"));
        arguObj.setStatus(jsonObj.getString("status"));
        String strDate = sd.format(new Date(jsonObj.getLong("startTime")));
        arguObj.setStartTime(strDate);
        strDate = sd.format(new Date(jsonObj.getLong("endTime")));
        arguObj.setEndTime(strDate);
        arguObj.setDuration(jsonObj.getString("duration"));
        arguObj.setTriggerUser(jsonObj.getString("triggerUser"));

        return arguObj;
    }


}
