<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	故障上报
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
    </template:block>
    <template:block name="body">
        <template:super />
<form:form id="errReportForm" action="/wechat/app/sccn/errReport${fn:idp(model)}" method="POST" commandName="model">
<form:hidden path="id" />
<div data-role="page">
  <div data-role="header" data-theme="b">
	    <a href="/wechat/app/sccn/errReport" data-icon="back" data-theme="c">返回</a>
	    <h1>故障上报</h1>
		<a href="#" data-icon="check" data-theme="c" onclick="javascript:$('#errReportForm').submit();">保存</a>
  </div>
  <div data-role="content">

<div data-role="fieldcontain">
    <label for="unit">故障单位</label>
    <select name="unit" id="unit">
        <option value="成华区" selected="true">成华区</option>
        <option value="武侯区">武侯区</option>
        <option value="锦江区">锦江区</option>
    </select>
</div>

<div data-role="fieldcontain">
    <label for="type">故障分类</label>
    <select name="type" id="type">
        <option value="市级业务平台故障" selected="true">市级业务平台故障</option>
        <option value="市级传输网故障">市级传输网故障</option>
        <option value="覆盖网故障">覆盖网故障</option>
    </select>
</div>
	
<div data-role="fieldcontain">
    <label for="text">故障内容</label>
    <input type="text" name="text" id="text" placeholder="请填写故障内容" value="">
</div>
	
<div data-role="fieldcontain">
	<label for="date">故障发生时间</label>
	<input type="date" name="datetime" id="datetime" value="2013-11-20">
</div>
    
<div data-role="fieldcontain">
	<fieldset data-role="controlgroup">
	    <legend>故障性质</legend>
	        <input type="radio" name="property" id="radio-choice-1" value="不可抗力或上游故障">
	        <label for="radio-choice-1">不可抗力或上游故障</label>
	        <input type="radio" name="property" id="radio-choice-2" value="本地故障">
	        <label for="radio-choice-2">本地故障</label>
	</fieldset>
</div>
    
<div data-role="fieldcontain">
    <label for="text">录入人</label>
    <input type="text" name="openid" id="openid" placeholder="" value="张三">
</div>
    
    
    
    
  </div>
</div>










</form:form>
    </template:block>
</template:template>
