<%@page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <style>
        body{
            background-image: url("images/backview.jpg");
        }
    </style>
</head>
<body>
    <h1 style="margin-top: 30px;text-align: center;color: blue">佳佳乐VIP消费查询系统</h1>
    <form action="/login.do" method="post" style="margin-left: 550px;margin-top: 200px">
        <strong>${message}</strong>
        <p>
            <label>Account:&nbsp;&nbsp;<input name="account" value="0001"></label>
        </p>
        <p>
            <label>Password:<input name="password" type="password" value="123456"></label>
        </p>
        <p style="margin-left: 100px">
            <button>login</button>
        </p>
    </form>
    <%--删掉session中的message信息--%>
    <%session.removeAttribute("message");%>
</body>
</html>
