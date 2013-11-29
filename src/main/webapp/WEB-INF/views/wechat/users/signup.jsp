<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Demo Main 编辑</title>
</head>
<body>

<h1>用户注册</h1>

<div style="text-align: center">
<form:form action="/users/signup" method="POST" modelAttribute="model">
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