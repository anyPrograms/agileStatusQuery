window.onload=function(){
    var xmlHttp =new XMLHttpRequest();
    xmlHttp.open('GET',"http://localhost:8080/initialize.do",false);//设为异步
    xmlHttp.send(null);
    
    if(xmlHttp.status==200){
        var jsonStrOrigin=JSON.parse(xmlHttp.responseText);
        for(var i=0;i<jsonStrOrigin.length;i++){
            var jsonObjModule=jsonStrOrigin[i];

            var tableLine="<tr>" +
            "<td height=" + "'34px'" + " align='center'>" +
            "<input type = 'checkbox' class='button-allselect'></td >" +
            "<td align='center' class='demo'>" +jsonObjModule.id+ "</td >" +
            "<td align='center'>" +jsonObjModule.name+ "</td>" +
            "<td>" +
            "<div align='center' class='button-column'>" +
            "<button type='button' onclick='toSecondPage("+jsonObjModule.jobConfId+")'>&emsp;查 看&emsp;</button>" +
            "</div>" +
            "</td>" +
            "</tr>";

            $("#tableMain").append(tableLine);
        }
    }

}