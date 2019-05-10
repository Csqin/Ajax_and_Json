<%--
  Created by IntelliJ IDEA.
  User: ShmilyCSQ
  Date: 2019/5/10
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        //页面加载结束后，获取用户名输入框失去焦点事件，通过ajax提交用户名进行数据校验
        //需要注意客户端发送ajax请求时，请求响应的数据类型
        $(function () {
            $("#username").blur(function () {
                //获取输入框的值
                var username =$(this).val();  // this.value;
                //发送ajax请求,data是获取服务器发送回来的数据
                $.get("registerServlet",{username:username},function (data) {
                    //alert(data);
                    //获取提示框的id
                    var s_msg= $("#msg");
                    //如果用户名存在
                    if(data.userExsit)
                    {
                        s_msg.css("color","red");
                        s_msg.html(data.msg);
                    }
                    else{
                          //如果用户名不存在
                        s_msg.css("color","green");
                        s_msg.html(data.msg);
                    }
                });
            });
        });
    </script>
</head>
<body>
<input  id="username"   name="username" type="text"  placeholder="请输入用户名">
<span id="msg"></span>
<br>
<input  type="password" name="password" placeholder="请输入密码"><br>
<input  type="submit" value="提交">
</body>
</html>
