package com.baidu.agileStatusQuery.beans;

public class jsonBean {
    private int id;
    private int jobConfId;
    private String jobName;
    private String status;
    private long endTime;
    private long startTime;
    private String duration;//持续时间
    private String triggerUser;//执行者

    /**
     * id : 2046046
     * jobConfId : 52869
     * jobName : 编译
     * status : SUCC
     * endTime : 1526536648000
     * startTime : 1526536094000
     * duration : 9m14s
     * triggerUser : xujinfeng
     */

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

