# agileStatusQuery
## agile job执行状态查询器

### Author : Shichao Qiao,Min Li;

## 接口文档：
## 【初始化】
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
        "jobConfId":"778153"
    },
    {
        "id":2,
        "name":"第二条记录",
        "jobConfId":"803611"
        },
    {
        "id":3,
        "name":"金牌销售",
        "jobConfId":"803611,778153"
    }
]
```

## 【查看详情】
### 地址：/details.do
### 请求方式：GET/POST
### 参数列表：
|参数|含义|必选|说明|
|---|---|---|---|
|id|记录索引|是|","逗号分隔，如：1,2,3|

### 返回格式：
``` json
{
    "moduleName":"金牌销售测试环境",
    "arguments":[
        {
            "jobConfId":"198667",
            "urlName":"http://agile.baidu.com/#/builds/baidu/cop-rigel/goldsales@Master.qa@branches",
            "jobName":"编译",
            "status":"SUCC",
            "startTime":"2018-06-27 14:29:57",
            "endTime":"2018-06-27 14:40:16",
            "duration":"10m19s",
            "triggerUser":"xuke07"
        },
        {
            "jobConfId":"198670",
            "urlName":"http://agile.baidu.com/#/builds/baidu/cop-rigel/goldsales@Master.qa@branches",
            "jobName":"发布",
            "status":"WAITTING",
            "duration":null,
            "triggerUser":null
        }
    ]
}
```