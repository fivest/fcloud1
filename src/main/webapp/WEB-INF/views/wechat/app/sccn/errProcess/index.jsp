
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
        	故障处理
    </template:block>

    <template:block name="body">
        <template:super />
        <a href="<%=request.getContextPath()%>/wechat/app/sccn/errProcess/create" target="_blank">新增</a>
        <c:forEach items="${page.content}" var="m">
            <div>
                <a href="<%=request.getContextPath()%>/wechat/app/sccn/errProcess/${m.id}" target="_blank">${m.reason}</a>
                <a href="<%=request.getContextPath()%>/wechat/app/sccn/errProcess/${m.id}/edit" target="_blank">编辑</a>
                <a href="<%=request.getContextPath()%>/wechat/app/sccn/errProcess/${m.id}?_method=DELETE" target="_blank">删除</a>
            </div>
        </c:forEach>
        count: ${page.total}, page: ${page.page}, limit: ${page.size}
    </template:block>
</template:template>
