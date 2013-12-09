<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户编辑</title>
</head>
<body>

<h1 style="text-align: center;">用户编辑</h1>

<div style="text-align: center; width: 300px; margin: 30px auto;">
<c:if test="${not model.new }">
<a href="<c:url value="/wechat/auth/module_access_mapping/${model.id }/edit" />" >查看权限</a>
</c:if>
<form:form action="/wechat/user${fn:idp(model)}" method="POST" commandName="model">
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
                <input type="submit" value="提交" />
            </td>
        </tr>
    </table>
    <form:hidden path="id" />
</form:form>
</div>

</body>
</html>