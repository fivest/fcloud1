
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Demo Main Index</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/demo/main/create" target="_blank">新增</a>
<c:forEach items="${model}" var="m">
    <div>
        <a href="<%=request.getContextPath()%>/demo/main/${m.id}" target="_blank">${m.name}</a>
        <a href="<%=request.getContextPath()%>/demo/main/${m.id}/edit" target="_blank">编辑</a>
        <a href="<%=request.getContextPath()%>/demo/main/${m.id}/delete" target="_blank">删除</a>
    </div>
</c:forEach>
</body>
</html>