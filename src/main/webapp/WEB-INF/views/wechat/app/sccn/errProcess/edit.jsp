<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <title>故障处理 编辑</title>
</head>
<body>
编辑界面

<form:form action="/wechat/app/sccn/errProcess${fn:idp(model)}" method="POST" commandName="model">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>故障原因:</td>
            <td><form:input path="reason" /></td>
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