<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>模块路径编辑</title>
</head>
<body>

<h1 style="text-align: center;">路径匹配</h1>

<div style="text-align: center; width: 500px; margin: 30px auto;">
<form:form action="/wechat/auth/module_access_mapping/${user.id }" method="POST">
    <table style="width: 100%;border-collapse: collapse;" border="1">
        <tr>
            <td>用户:</td>
            <td>${user.name }</td>
        </tr>
        <tr>
            <td colspan="2">可访问模块:</td>
        </tr>
        <tr>
            <td colspan="2">
                <table style="width: 100%;border-collapse: collapse;" border="1">
                	<tr>
                		<td><input type="checkbox" name="all"></td>
                		<td>序号</td>
                		<td>模块名称</td>
                		<td>模块URL</td>
                	</tr>
                	<c:forEach items="${modules }" var="module" varStatus="sv">
                	<tr>
                		<td><input type="checkbox" name="module" value="${module.id }"
                			<c:if test="${not empty maps[module.id] }">checked</c:if> ></td>
                		<td>${sv.index + 1 }</td>
                		<td>${module.name }</td>
                		<td>${module.pathPrefix }</td>
                	</tr>
                	</c:forEach>
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交" />
            </td>
        </tr>
    </table>
</form:form>
</div>

</body>
</html>