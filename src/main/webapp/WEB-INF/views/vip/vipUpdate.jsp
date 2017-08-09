<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=contextPath%>">
    <style>
        body{
            padding-top: 100px;
            padding-left: 200px;
        }
    </style>
</head>
<body>
<header>
    <strong>${message}</strong>
</header>
<main>
    <c:if test="${vipEntity!=null}">
    <article id="content">
        <form action="/vip/update.do" method="post">
            <p>
                <input type="hidden" name="code" value="${vipEntity.code}">
                <span>
                    编号：<b name="code">${vipEntity.code}</b>
                </span>
                <span>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VIP等级：<b>${vipEntity.level}</b>
                    </span>
                <span>
                        消费总金额：<b style="color: red">￥${vipEntity.money}元</b>
                    </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：<b>${vipEntity.gender}</b>
                </span>
            </p>
            <p>
                <span>
                    姓名：<input name="name" value="${vipEntity.name}">
                </span>

                <span>
                    年龄：<input name="age" value="${vipEntity.age}">
                </span>
            </p>
            <p>
                <span>
                    QQ：<input name="qq" value="${vipEntity.qq}">
                </span>
                <span>
                        Email：<input name="email" value="${vipEntity.email}">
                </span>
            </p>
            <p>
                <span>
                        地址：<input name="address" value="${vipEntity.address}">
                </span>
                <span>
                        邮编：<input name="zip" value="${vipEntity.zip}">
                </span>
            </p>
            <p>
                <span>
                        备注：<textarea name="remark" style="width: 390px;height: auto">${vipEntity.remark}</textarea>
                </span>
            </p>
            </c:if>
            <p>
                <button type="submit"STYLE="margin-left: 200px ">确定</button>
            </p>
        </form>
    </article>
</main>
</body>
</html>
