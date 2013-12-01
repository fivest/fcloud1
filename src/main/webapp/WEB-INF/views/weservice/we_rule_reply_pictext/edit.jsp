<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<link href="/public/css/themes/base/jquery.ui.theme.css" type="text/css" rel="stylesheet">
<html>
<head>
    <title>Demo Main 编辑</title>
</head>
<body>
编辑界面

<form:form action="/weservice/we_rule_reply_pictext/weRuleReplyPictext${fn:idp(model)}" method="POST" commandName="model">
    <form:hidden path="id" />
    标题：<form:input path="fdTitle"/>
    标签：<form:input path=""/>
</form:form>
</body>
</html>