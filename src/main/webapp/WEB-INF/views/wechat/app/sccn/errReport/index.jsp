
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
        	故障上报
    </template:block>

    <template:block name="body">
        <template:super />
        <a href="<%=request.getContextPath()%>/wechat/app/sccn/errReport/create" target="_blank">新增</a>
        <c:forEach items="${page.content}" var="m">
            <div>
                <a href="<%=request.getContextPath()%>/wechat/app/sccn/errReport/${m.id}" target="_blank">${m.text}</a>
                <a href="<%=request.getContextPath()%>/wechat/app/sccn/errReport/${m.id}/edit" target="_blank">编辑</a>
                <a href="<%=request.getContextPath()%>/wechat/app/sccn/errReport/${m.id}?_method=DELETE" target="_blank">删除</a>
            </div>
        </c:forEach>
        count: ${page.total}, page: ${page.page}, limit: ${page.size}
    </template:block>
</template:template>
