<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <title>Demo Main 编辑</title>
</head>
<body>
编辑界面

<form:form action="/demo${fn:idp(model)}" method="POST" commandName="model">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>名称:</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="保存" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>