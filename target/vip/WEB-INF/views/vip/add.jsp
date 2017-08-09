<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <title>录入VIP客户</title>
    <meta charset="UTF-8">
    <base href="<%=request.getContextPath()%>">
</head>
<body>
    <header>
        <h1>录入VIP客户</h1>
    </header>
    <main>
        <p>
            <strong>${message}</strong>
        </p>
        <form action="/vip/add.do" method="post">
            <p>
                <label>*手机号：<input name="code" value="${param.code}" placeholder="将作为VIP编号录入"></label>
            </p>
            <p>
                <label>*姓名：<input name="name" value="${param.name}"></label>
            </p>
            <p>
                <label>*性别：</label>
                <label>
                    <input name="sex" type="radio" value="1" checked>男
                </label>
                <label>
                    <input name="sex" type="radio" value="0" ${param.sex=='0'?'checked':''}>女
                </label>
            </p>
            <p>
                <label>年龄：<input name="age" value="${param.age}"></label>
            </p>
            <p>
                <label>QQ：<input name="qq" value="${param.qq}"></label>
            </p>
            <p>
                <label>email：<input name="email" value="${param.email}"></label>
            </p>
            <p>
                <label>地址：<input name="address" value="${param.address}"></label>
            </p>
            <p>
                <label>邮编：<input name="zip" value="${param.zip}"></label>
            </p>
            <p>
                <label>备注：<textarea name="remark">${param.remark}</textarea></label>
            </p>
            <p>
                <button type="submit">确定</button>
                <a href="/welcome.do">返回</a>
            </p>
        </form>
    </main>
</body>
</html>
