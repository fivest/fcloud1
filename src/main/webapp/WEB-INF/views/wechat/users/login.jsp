<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

<h1 style="text-align: center;">用户登录</h1>

<div style="text-align: center;width: 300px; margin: 50px auto;">
    <form:form action="/login" method="POST" modelAttribute="form">
        <table style="width: 500px;">
            <tr>
                <td>登录名:</td>
                <td><form:input path="username" /><form:errors path="username" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><form:password path="password" /><form:errors path="password" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录" />
                </td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>