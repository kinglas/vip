<%--
  Created by IntelliJ IDEA.
  User: kinglas
  Date: 2017/7/31
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        if(window.top!=window){
            window.top.location.href=window.location.href;
        }
    </script>
</head>
<body>
    <form action="/updatepassword.do" method="post" style="margin-left: 550px;margin-top: 200px">
        <strong>${message}</strong>
        <p>
            <label>旧密码:<input name="oldPassword"></label>
        </p>
        <p>
            <label>新密码:<input name="newPassword" type="password"></label>
        </p>
        <p>
            <label>新密码确认:<input name="newPasswordConfirm" type="password"></label>
        </p>
        <p>
            <button type="submit">确定</button>
            <a href="/index.do">返回</a>
        </p>
    </form>
</body>
</html>
