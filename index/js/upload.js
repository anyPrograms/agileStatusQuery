function upload() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/TestServlet.do",
        data: $('#form').serialize(),
        datatype:String,
        success: function (result) {
            alert("传回来的字符串：" + result);
            // var arraydata = eval(data);
            alert("提交成功！");
            $("#text1").html(result);
        },
        error: function () {
            alert("提交失败！");
        }
    });
}