<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <title>模块路径编辑</title>
</head>
<body>

<h1 style="text-align: center;">模块路径编辑</h1>

<div style="text-align: center; width: 300px; margin: 30px auto;">
<form:form action="/wechat/auth/module_access${fn:idp(model)}" method="POST" commandName="model">
    <table style="width: 500px;">
        <tr>
            <td>名称:</td>
            <td><form:input path="name" /><form:errors path="name" cssStyle="color: red"/></td>
        </tr>
        <tr>
            <td>访问前缀:</td>
            <td><form:input path="pathPrefix" /><form:errors path="pathPrefix" cssStyle="color: red"/></td>
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