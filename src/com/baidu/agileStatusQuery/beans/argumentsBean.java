package com.baidu.agileStatusQuery.beans;

/**
 * 这个与jsonBean的区别是多了一个moduleName
 */
public class argumentsBean {
    private String jobConfId;
    private String urlName;
    private String jobName;
    private String status;
    private String startTime;
    private String endTime;
    private String duration;//持续时间
    private String triggerUser;//执行者

    /**
     * moduleName : goldsales
     * jobConfId : 52869
     * urlName : "http://agile.baidu.com/#/builds/baidu/cop-rigel/gaia-base@Master@dev"
     * jobName : 编译
     * status : SUCC
     * endTime : 2008-07-11 21:13:47
     * startTime : 2008-07-11 21:13:47
     * duration : 9m14s
     * triggerUser : xujinfeng
     */


    public String getJobConfId() {
        return jobConfId;
    }

    public void setJobConfId(String jobConfId) {
        this.jobConfId = jobConfId;
    }

    public String getUrlName(){
        return urlName;
    }

    public void setUrlName(String urlName){
        this.urlName=urlName;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTriggerUser() {
        return triggerUser;
    }

    public void setTriggerUser(String triggerUser) {
        this.triggerUser = triggerUser;
    }

}
