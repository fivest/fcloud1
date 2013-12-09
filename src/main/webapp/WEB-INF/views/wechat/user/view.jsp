<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户查看</title>
</head>
<body>
<h1 style="text-align: center;">用户查看</h1>

<div style="text-align: center; width: 300px; margin: 30px auto;">
<c:if test="${not model.new }">
<a href="<c:url value="/wechat/auth/module_access_mapping/${model.id }/edit" />" >查看权限</a>
</c:if>
<a href="<c:url value="/user/${model.id }/edit" />" >编辑</a>
<table style="width: 500px;">
    <tr>
        <td>用户名:</td>
        <td>${model.name}</td>
    </tr>
    <tr>
        <td>邮箱:</td>
        <td>${model.email}</td>
    </tr>
</table>
</div>
</body>
</html>