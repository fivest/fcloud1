<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
        模块访问路径列表
    </template:block>

    <template:block name="body">
        <template:super />
        <c:url value="/wechat/auth/module_access" var="urlPrefix" />
        <a href="${urlPrefix }/create" target="_blank">新增</a>
        <table style="width: 100%;border-collapse: collapse">
        	<c:forEach items="${page.content}" var="m" varStatus="vs">
            <tr>
            	<td>${vs.index + 1}</td>
            	<td><a href="${urlPrefix }/${m.id}" target="_blank">${m.name}</a></td>
            	<td>${m.pathPrefix}</td>
            	<td>
	                <a href="${urlPrefix }/${m.id}/edit" target="_blank">编辑</a>
	                <a href="${urlPrefix }/${m.id}?_method=DELETE" target="_blank">删除</a>
                </td>
            </tr>
        	</c:forEach>
        </table>
        总共: ${page.total}, 当前页: ${page.page}, 每页: ${page.size}
    </template:block>
</template:template>