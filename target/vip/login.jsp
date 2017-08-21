<%@page pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style>
        body{
            background-image: url("images/backview.jpg");
        }
    </style>
</head>
<body class="container">
    <h1 style="margin-top: 30px;text-align: center;color: blue">佳佳乐VIP消费查询系统</h1>
    <form action="/login.do" method="post" style="margin-top: 170px;margin-left: 200px">
        <strong>${message}</strong>
        <div class="form-horizontal">
            <div class="form-group  has-feedback">
                <label class="col-sm-2 control-label">账号:</label>
                <div class="col-sm-5">
                    <input type="text" name="account" class="form-control input-lg" placeholder="请输入账号"/>
                    <%--<span class="glyphicon glyphicon-ok form-control-feedback"></span>--%>
                </div>
            </div>
            <div class="form-group has-error has-feedback" style="margin-top: 20px">
                <label class="col-sm-2 control-label">密码:</label>
                <div class="col-sm-5">
                    <input type="password" name="password" class="form-control input-lg"placeholder="请输入密码"/>
                    <%--<span class="glyphicon glyphicon-alert form-control-feedback" ></span>--%>
                </div>
            </div>
            <button type="submit" class="btn btn-success" style="margin-left: 300px;margin-top: 70px">点我登录</button>

        </div>
    </form>
    <%--删掉session中的message信息--%>
    <%session.removeAttribute("message");%>
</body>
</html>
