window.onload=function clickForDetails() {
    var result;
    var url=window.location.search;//获取url中?后面的字符串
    if(url/indexOf("?")!=-1){
        result=url.substr(url.indexOf("=")+1);
    }


    var xmlHttp2 = new XMLHttpRequest();
    xmlHttp2.open("GET", "http://localhost:8080/details.do", false);
    xmlHttp2.send("jobConfId=" + result);


    if (status == 200) {
        var jsonStrOrigin = xmlHttp2.responseText;
        var jsonObjOrigin = JSON.parse(jsonStrOrigin);
        var jsonObjArgu = jsonObjOrigin["arguments"];

        $("#headLine").append(jsonObjOrigin.moduleName);
        for (var i = 0; i < jsonObjArgu.length; i++) {
            var jsonObjModuleSingle = jsonObjArgu[i];

            var tableLine2 = "<tr>" +
                "<td height='34px' align='center'>" + jsonOBJModule.jobConfId + "</td>" +
                "<td align='center'>" + jsonOBJModule.jobName + "</td>" +
                "<td align='center'>" + jsonOBJModule.status + "</td>" +
                "<td align='center'>" + jsonOBJModule.starttime + "</td>" +
                "<td align='center'>" + jsonOBJModule.endTime + "</td>" +
                "<td align='center'>" + jsonOBJModule.duration + "</td>" +
                "<td align='center'>" + jsonOBJModule.triggerUser + "</td>" +
                "</tr>";

            $("#tableMain2").append(tableLine2);
        }


    }

}
