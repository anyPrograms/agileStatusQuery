function initForm(){
    var xmlHttp =new XMLHttpRequest();
    xmlHttp.open('GET',"http://localhost:8080/initialize.do",false);//置请求为同步请求
    xmlHttp.responseType='json';
    xmlHttp.send(null);
    xmlhttp.onload=function(){
        if(status=200){
            //接口访问成功
            var jsonStrOrigin=xmlHttp.responseText;
            var jsonObjOrigin=JSON.parse(jsonStrOrigin);
            for(var i=0;i<jsonObjOrigin.length;i++){
                var jsonObjSingle=jsonObjOrigin[i];
                alter("json数组每一个对象的第二个参数moduleName："+jsonObjSingle.name);
            }

        }else{
            //接口访问失败的操作
        }
    }

}