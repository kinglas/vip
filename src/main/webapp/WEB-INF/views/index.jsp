<%--
  Created by IntelliJ IDEA.
  User: kinglas
  Date: 2017/7/28
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <style>
        menu,h1,ul{
            margin: 0;
        }
        html,body{
            margin: 0;
            height: 100%;
            font-size: 14px;
        }
        body>header{
            /*line-height: 80px;*/
            text-align: center;
            background: #999999;
        }
        body>header>h1{
            display: inline;
            text-align: center;
        }
        .body{
            position: absolute;
            top: 80px;
            bottom: 0;
            width: 100%;
        }
        .body>menu{
            position: absolute;
            left: 0;
            width: 200px;
            height: 100%;
            background: #eeeeee;
            box-sizing: border-box;
        }
        .body>main{
            margin-left: 200px;
            height: 100%;
            display: block;
            width: 100%;
        }
        main>iframe{
            width: 100%;
            height: 100%;
            border: 0;
            display: block;
        }
        li{
            margin-top: 20px;
            font-size: 16px;
        }
    </style>
</head>
<body >
    <div class="bg-info">
    <header class="bg-info">
        <nav class="bg-info navbar navbar-fixed-top" role="navigation">
            <div class="container-fluid" style="height: 79px">
                <div class="btn-Submit navbar-center">
                    <!--调查标题-->
                    <div class="navbar-brands" style="text-align: center;font-size:x-large;">佳佳乐VIP消费查询系统</div>
                    <div style="margin-left: 700px;margin-top: 10px">
                        <span>
                            <b style="color: red">${sessionScope.currentUser.name}!</b>
                            <a href="logout.do">退出登录</a>
                         </span>
                    </div>
                </div>
            </div>
        </nav>
    </header>
    <section class="container body">
        <menu>
            <ul>
                <li>
                    <a href="vip/query.do" target="mainFrame">VIP客户查询</a>
                </li>
                <li>
                    <a href="vip/add.do" target="mainFrame">VIP客户录入</a>
                </li>
                <li>
                    <a href="vip/tomanageView.do" target="mainFrame">VIP客户管理</a>
                </li>
                <li>
                    <a target="mainFrame">VIP消费记录查看</a>
                </li>
                <li>
                    <a target="mainFrame">VIP消费记录录入</a>
                </li>
                <li>
                    <a target="mainFrame">VIP消费记录管理</a>
                </li>
                <li>
                    <a href="updatepassword.do" target="mainFrame">修改密码</a>
                </li>
            </ul>
        </menu>
        <main>
            <iframe name="mainFrame" src="welcome.do"></iframe>
        </main>
    </section>
    </div>
</body>
</html>
