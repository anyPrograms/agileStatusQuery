window.onload = function clickForDetails() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open('GET', "http://localhost:8080/initialize.do", false);
    xmlHttp.send(null);

    var str = location.href;//获取url中?后面的字符串
    var num = str.split("?");
    var num = num[1];
    var num = num.split("&");
    var num = num[0];
    var num = num.split("=");
    var num = num[1];
    var num = num.split(",");


    if (xmlHttp.status == 200) {
        var jsonStrOrigin = JSON.parse(xmlHttp.responseText);
        for (var z = 0; z < num.length; z++) {
            for (var i = 0; i < jsonStrOrigin.length; i++) {
                var jsonObjModule = jsonStrOrigin[i];
                if (jsonObjModule.jobConfId == num[z]) {

                    var tableLine = "<tr>" +
                        "<td height='34px' align='center'>" +jsonObjModule.arguments.jobName + "</td>" +
                        "<td align='center'>" + jsonObjModule.arguments.jobName + "</td>" +
                        "<td align='center'>" + jsonObjModule.arguments.status + "</td>" +
                        "<td align='center'>" + jsonObjModule.arguments.startTime + "</td>" +
                        "<td align='center'>" + jsonObjModule.arguments.endTime + "</td>" +
                        "<td align='center'>" + jsonObjModule.arguments.duration + "</td>" +
                        "<td align='center'>" + jsonObjModule.arguments.triggerUser + "</td>" +
                        "</tr>";

                    $("#tableMain").append(tableLine);
                }
            }
        }
    }
}