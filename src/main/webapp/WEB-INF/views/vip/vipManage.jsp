<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>会员管理</title>
    <base href="<%=contextPath%>/">
    <script src="static/jquery/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body class="container">
<br>
    <table class="table table-hover table-bordered">
        <thead>
            <tr >
                <td>姓名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>qq</td>
                <td>email</td>
                <td>地址</td>
                <td>邮编</td>
                <td>会员等级</td>
                <td>消费金额</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${vips}" var="item">
            <tr>
                <td class="code">${item.code}</td>
                <td>${item.name}</td>
                <td>${item.age}</td>
                <td>${item.gender}</td>
                <td>${item.qq}</td>
                <td>${item.email}</td>
                <td>${item.address}</td>
                <td>${item.zip}</td>
                <td>${item.level}</td>
                <td>${item.money}</td>
                <td>${item.remark}</td>
                <td>
                    <button type="button" class="btn btn-danger deleteVip">删除</button>
                    <button type="button" class="btn btn-info vipEdit">修改</button>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
<script>
    $(function () {
        $(".code").hide();
    })
    /*function deleteVip() {
        alert($(this).parent().parent().find("td").eq(1).text());
    }*/
    $(".deleteVip").click(function () {
        var code = $(this).parent().parent().find("td").eq(0).html();
        $.ajax({
            url:"vip/delete.do",
            data:{"code":code},
            success:function (data) {
               alert("${sessionScope.message}")
            }
        })
    })

    $(".vipEdit").click(function () {
        var code = $(this).parent().parent().find("td").eq(0).html();
        window.location.href = "vip/edit.do?code="+code
    })

</script>
</html>
