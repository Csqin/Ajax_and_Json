<%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/5/9
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        //$.get(url, [data], [callback], [type])
        function fun()
        {
            $.get("ajaxServlet",{username:"rose"},function (data) {
                alert(data);
            },"text");
        }
    </script>
</head>
<body>
<input  type="button" value="发送异步请求" onclick="fun();">
<input>
</body>
</html>
