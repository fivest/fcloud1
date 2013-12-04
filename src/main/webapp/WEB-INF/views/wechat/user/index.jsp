<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
        用户列表
    </template:block>

    <template:block name="body">
        <template:super />
        <a href="<%=request.getContextPath()%>/user/create" target="_blank">新增</a>
        <table style="width: 100%;border-collapse: collapse">
        	<c:forEach items="${page.content}" var="m" varStatus="vs">
            <tr>
            	<td>${vs.index + 1}</td>
            	<td><a href="<%=request.getContextPath()%>/user/${m.id}" target="_blank">${m.name}</a></td>
            	<td>${m.email}</td>
            	<td>
	                <a href="<%=request.getContextPath()%>/user/${m.id}/edit" target="_blank">编辑</a>
	                <a href="<%=request.getContextPath()%>/user/${m.id}/status?_method=DELETE" target="_blank">禁用</a>
                </td>
            </tr>
        	</c:forEach>
        </table>
        总共: ${page.total}, 当前页: ${page.page}, 每页: ${page.size}
    </template:block>
</template:template>