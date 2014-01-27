<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
        Demo Main Index
    </template:block>

    <template:block name="body">
        <template:super/>
        <div data-role="header" data-theme="a">
            <span class="ui-title"/>

            <div class="ui-btn-right">
                <a href="<%=request.getContextPath()%>/weservice/we_rule_reply_text/create" target="_blank">新增</a>
            </div>
        </div>
        <table class="movie-list ui-responsive">
            <thead>
            <tr>
                <th>文本内容</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${page.content}" var="m">
                <tr>
                    <td>${m.fdText}
                    </td>
                    
                    <td><a href="<%=request.getContextPath()%>/weservice/we_rule_reply_text/${m.id}/edit" target="_blank">编辑</a>
                        <a href="<%=request.getContextPath()%>/weservice/we_rule_reply_text/${m.id}?_method=DELETE"
                           target="_blank">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        总共: ${page.total}, 当前页: ${page.page}, 每页: ${page.size}
    </template:block>
</template:template>
<link type="text/css" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" rel="stylesheet"/>
