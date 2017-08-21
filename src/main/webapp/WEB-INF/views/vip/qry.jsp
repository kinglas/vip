<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <base href="<%=contextPath%>/">
    <title>会员查询</title>
</head>
<body>
    <header>
        <strong>${message}</strong>
        <form action="vip/query.do" method="post">
            <p>
                <label>
                    VIP:<input name="code" autofocus>
                </label>
                <button type="submit">GO!</button>
            </p>
        </form>
        <p>
            <button onclick="vipUpdate()">修改信息</button>
        </p>
    </header>
    <main>
        <c:if test="${v!=null}">
        <article>
            <p>
                <span>
                    编号：<b id="code">${v.code}</b>
                </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VIP等级：<b>${v.level}</b>
                </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;消费总金额：<b style="color: red">￥${v.money}元</b>
                </span>
            </p>
            <p>
                <span>
                    姓名：<b>${v.name}</b>
                </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：<b>${v.gender}</b>
                </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年龄：<b>${v.age}</b>
                </span>
            </p>
            <p>
                <span>
                    QQ：<b>${v.qq}</b>
                </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email：<b>${v.email}</b>
                </span>
                <span>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址/邮编：<b>${v.address}(${v.zip})</b>
                </span>
            </p>
            </c:if>
        </article>
    </main>
    <%--<%session.removeAttribute("message");%>--%>
</body>
<script src="static/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script>
    function vipUpdate() {
        var code = $("#code").html();
        window.location.href = "vip/toeditview.do?code="+code;
    }
</script>
</html>
