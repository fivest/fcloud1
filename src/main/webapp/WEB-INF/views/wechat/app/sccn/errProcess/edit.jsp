<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	故障处理
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
    </template:block>
    <template:block name="body">
        <template:super />
<form:form id="errProcessForm" action="/wechat/app/sccn/errProcess${fn:idp(model)}" method="POST" commandName="model">
<form:hidden path="id" />
<div data-role="page">
  <div data-role="header" data-theme="b">
	    <a href="/wechat/app/sccn/errProcess" data-icon="back" data-theme="c">返回</a>
	    <h1>故障处理</h1>
		<a href="#" data-icon="check" data-theme="c" onclick="javascript:$('#errProcessForm').submit();">保存</a>
  </div>
  <div data-role="content">
所属故障

<div data-role="fieldcontain">
    <label for="type">故障分类</label>
    <select name="type" id="type">
        <option>请选择</option>
        <optgroup label="市级业务平台故障">
            <option value="机房供电故障" selected="true">机房供电故障</option>
            <option value="数字电视平台故障">数字电视平台故障</option>
            <option value="互动电视平台故障">互动电视平台故障</option>
            <option value="互联网接入故障">互联网接入故障</option>
        </optgroup>
        <optgroup label="市级传输网故障">
            <option value="机房供电故障">机房供电故障</option>
            <option value="传输设备故障">传输设备故障</option>
            <option value="传输光缆线路故障">传输光缆线路故障</option>
        </optgroup>
        <optgroup label="覆盖网故障">
            <option value="分前端机房供电故障">分前端机房供电故障</option>
            <option value="分前端机房设备故障">分前端机房设备故障</option>
            <option value="机房外设备故障">机房外设备故障</option>
            <option value="光缆线路故障">光缆线路故障</option>
            <option value="电缆线路故障">电缆线路故障</option>
        </optgroup>
        <optgroup label="分公司业务平台故障">
            <option value="机房供电故障">机房供电故障</option>
            <option value="有线电视分平台故障">有线电视分平台故障</option>
            <option value="互动电视分平台故障">互动电视分平台故障</option>
            <option value="互联网接入分平台故障">互联网接入分平台故障</option>
        </optgroup>
    </select>
</div>



<div data-role="fieldcontain">
	<label for="date">故障恢复时间</label>
	<input type="date" name="recovery_time" id="recovery_time" value="2013-11-20">
</div>

	
<div data-role="fieldcontain">
    <label for="text">故障原因</label>
    <input type="text" name="reason" id="reason" placeholder="请填写故障原因" value="故障原因">
</div>
	
<div data-role="fieldcontain">
    <label for="text">处理过程</label>
    <input type="text" name="process_record" id="process_record" placeholder="请填写处理过程" value="处理过程">
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
