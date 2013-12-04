<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>您已注册成功</title>
</head>
<body>

<h1>您已注册成功！</h1>

<h2>请牢记您的登录名<span style="color: red">${model.name}</span>和密码</h2>
<h2>忘记密码可以通过注册邮箱找回</h2>

<a href="/" target="_self">返回主页</a>
</body>
</html>