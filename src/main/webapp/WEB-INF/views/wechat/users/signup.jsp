<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>

<h1 style="text-align: center;">用户注册</h1>

<div style="text-align: center; width: 300px; margin: 30px auto;">
<form:form action="/signup" method="POST" commandName="model">
    <form:hidden path="id" />
    <table style="width: 500px;">
        <tr>
            <td>登录名:</td>
            <td><form:input path="name" /><form:errors path="name" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><form:input path="email" /><form:errors path="email" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><form:password path="password" /><form:errors path="password" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>重复输入:</td>
            <td><form:password path="repeatPwd" /><form:errors path="repeatPwd" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册" />
            </td>
        </tr>
    </table>
</form:form>
</div>

</body>
</html>