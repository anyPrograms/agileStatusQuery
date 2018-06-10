# agileStatusQuery
## agile job执行状态查询器

## Author : Michael Joe,Min Li;

接口文档：
##【初始化】
### 地址：/initialize.do
### 请求方式：GET/POST
### 参数列表：
|参数|含义|必选|说明|
|---|---|---|---|

### 返回格式：
``` json
[
    {
        "id":1,
        "name":"第一条查询",
        "jobConfId":"778153",
        "arguments":{
            "jobConfId":"778153",
            "jobName":"编译",
            "status":"SUCC",
            "endTime":"2018-06-07 19:38:34",
            "startTime":"2018-06-07 19:34:01",
            "duration":"4m33s",
            "triggerUser":"wangcaixia01"
        }
    },
    {
        "id":2,
        "name":"第二条记录",
        "jobConfId":"803611",
        "arguments":{
            "jobConfId":"803611",
            "jobName":"猫头鹰源码安全扫描",
            "status":"CANCEL",
            "endTime":"2018-06-07 19:50:48",
            "startTime":"2018-06-07 19:38:35",
            "duration":"12m13s",
            "triggerUser":"wangcaixia01"
        }
    },
    {
        "id":3,
        "name":"金牌销售",
        "jobConfId":"803611,778153",
        "arguments":[
            {
                "jobConfId":"778153",
                "jobName":"编译",
                "status":"SUCC",
                "endTime":"2018-06-07 19:38:34",
                "startTime":"2018-06-07 19:34:01",
                "duration":"4m33s",
                "triggerUser":"wangcaixia01"
            },
            {
                "jobConfId":"803611",
                "jobName":"猫头鹰源码安全扫描",
                "status":"CANCEL",
                "endTime":"2018-06-07 19:50:48",
                "startTime":"2018-06-07 19:38:35",
                "duration":"12m13s",
                "triggerUser":"wangcaixia01"
            }
        ]
    }
]
```

##【查看详情】
### 地址：/initialize.do
### 请求方式：GET/POST
### 参数列表：
|参数|含义|必选|说明|
|---|---|---|---|
|jobConfId|任务Id|是|","逗号分隔，如：123,456|

### 返回格式：
``` json
[
    {
        "moduleName":"金牌销售"
    },
    [
        {
            "jobConfId":"778153",
            "jobName":"编译",
            "status":"SUCC",
            "endTime":"2018-06-07 19:38:34",
            "startTime":"2018-06-07 19:34:01",
            "duration":"4m33s",
            "triggerUser":"wangcaixia01"
        },
        {
            "jobConfId":"803611",
            "jobName":"猫头鹰源码安全扫描",
            "status":"CANCEL",
            "endTime":"2018-06-07 19:50:48",
            "startTime":"2018-06-07 19:38:35",
            "duration":"12m13s",
            "triggerUser":"wangcaixia01"
        }
    ]
]
```