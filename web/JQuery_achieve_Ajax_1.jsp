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
        //Ajax的实现：$.ajax({参数1，参数2......});
        function fun()
        {
            $.ajax({
                url:"ajaxServlet111",//请求地址
                data:{"username":"Tom"},//请求参数
                type:"POST",//请求方式
                success:function (data) {  //请求成功后执行的方法
                    alert(data);
                },
                error:function () {//请求响应出错后执行的方法
                    alert("出错啦。。。")
                }
            });
        }
    </script>
</head>
<body>
<input  type="button" value="发送异步请求" onclick="fun();">
<input>
</body>
</html>
