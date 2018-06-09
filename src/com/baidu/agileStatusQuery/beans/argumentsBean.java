package com.baidu.agileStatusQuery.beans;

/**
 * 这个与jsonBean的区别是多了一个moduleName
 */
public class argumentsBean {
    private int statusCode;
    private String moduleName;//这个要自己查
    private int jobConfId;
    private String jobName;
    private String status;
    private long endTime;
    private long startTime;
    private String duration;//持续时间
    private String triggerUser;//执行者

    /**
     * statusCode : 200
     * moduleName : goldsales
     * jobConfId : 52869
     * jobName : 编译
     * status : SUCC
     * endTime : 1526536648000
     * startTime : 1526536094000
     * duration : 9m14s
     * triggerUser : xujinfeng
     */

    public int getStatusCode(){
        return statusCode;
    }
    public void setStatusCode(int statusCode){
        this.statusCode=statusCode;
    }

    public String getModuleName() {
        return moduleName;
    }
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getJobConfId() {
        return jobConfId;
    }
    public void setJobConfId(int jobConfId) {
        this.jobConfId = jobConfId;
    }

    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public long getEndTime() {
        return endTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public String getDuration(){
        return duration;
    }
    public void setDuration(String duration){
        this.duration=duration;
    }

    public String getTriggerUser(){
        return triggerUser;
    }
    public void setTriggerUser(String triggerUser){
        this.triggerUser=triggerUser;
    }
}
