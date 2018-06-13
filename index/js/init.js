window.onload=function() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/initialize.do",
        data: $('#form').serialize(),
        datatype:String,
        success: function (result) {
            // var mycars=new Array
            // var mycar=new Array
            // mycars = JSONObject.parseObject(result);
            // mycars = Integer.parseInt(mycars("id"));
            alert("传回来的字符串：");
            alert("提交成功！");
            // for(i=0;i<6;i++)
            // $(".demo").eq(i).html(mycars[i]);
        //     $.each(data,function(i,n){
        //         alert(date);//显示name和test
        //     });
        },
        error: function () {
            alert("提交失败！");
        }
    });
}
