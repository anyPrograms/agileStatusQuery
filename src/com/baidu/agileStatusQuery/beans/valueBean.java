package com.baidu.agileStatusQuery.beans;

public class valueBean {
    /**
     * id : 1
     * name : 金牌销售线下流水线
     * arguments : {"id":2013367,"jobConfld":39300,"jobName":"发布","status":"WAITTING","endTime":null,"startTime":null,"duration":null,"triggerUser":null}
     */

    private int id;
    private String name;
    private String arguments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArguments() {
        return arguments;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }
}
