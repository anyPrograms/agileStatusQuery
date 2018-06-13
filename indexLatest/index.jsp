<%--
  Created by IntelliJ IDEA.
  User: qiaoshichao
  Date: 2018/6/10
  Time: 0:13
  To change this template use File | Settings | File Templates.
  --%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
      <head>
        <title>临时测试页1</title>
        <script type="text/javascript" src="js/initForm.js"></script>
        <script type="text/javascript" src="js/clickForDetails.js"></script>
        <script type="text/javascript" src="js/toSecondPage.js"></script>
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
      </head>
      <body>

        <table class="table" ; id="tableMain">

          <tr>
            <th width=4%>
              <input name="checkbox" type="checkbox" class="button-allselect"
                onclick="selectall()" />
            </th>
            <th width=11%>id</th>
            <!-- <th width=21%>name</th>-->
          <th width=36%>name</th>
          <th width=21%>可执行操作</th>
        </tr>
      </table>

    </body>
  </html>
