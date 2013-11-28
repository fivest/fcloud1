<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	参展商报名
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
    </template:block>
    <template:block name="body">
        <template:super />
<form:form id="canzhanshangForm" action="/wechat/app/cihezh/canzhanshang${fn:idp(model)}" method="POST" commandName="model">
<form:hidden path="id" />
<div data-role="page">

  <div data-role="content">

<div data-role="fieldcontain">
    <label for="name">公司名称</label>
    <input type="text" name="name" id="name" placeholder="请填写公司名称" value="">
</div>

<div data-role="fieldcontain">
    <label for="lxfs">联系方式</label>
    <input type="text" name="lxfs" id="lxfs" placeholder="请填写联系电话和地址" value="">
</div>

<div data-role="fieldcontain">
    <label for="type">公司类型</label>
    <select name="type" id="type">
        <option value="生产厂商" selected="true">生产厂商</option>
        <option value="代理商">代理商</option>
        <option value="出口商">出口商</option>
        <option value="进口商">进口商</option>
        <option value="展团组织者">展团组织者</option>
        <option value="其它">其它</option>
    </select>
</div>

<div data-role="fieldcontain">
	<label for="czsp">参展产品</label>
	<textarea cols="40" rows="8" name="czsp" id="czsp"></textarea>
</div>

<div data-role="fieldcontain">
	<label for="czmd">参展目的</label>
	<input type="checkbox" name="czmd" id="czmd-0" class="custom" data-mini="true" value="展示企业形象">
	<label for="czmd-0">展示企业形象</label>
	<input type="checkbox" name="czmd" id="czmd-1" class="custom" data-mini="true" value="宣传新产品">
	<label for="czmd-1">宣传新产品</label>
	<input type="checkbox" name="czmd" id="czmd-2" class="custom" data-mini="true" value="寻求合作伙伴">
	<label for="czmd-2">寻求合作伙伴</label>
	<input type="checkbox" name="czmd" id="czmd-3" class="custom" data-mini="true" value="其他">
	<label for="czmd-3">其他</label>
</div>

<div data-role="fieldcontain">
	<label for="hkgg">会刊广告</label>
	<input type="checkbox" name="hkgg" id="hkgg-0" class="custom" data-mini="true" value="封面">
	<label for="hkgg-0">封面</label>
	<input type="checkbox" name="hkgg" id="hkgg-1" class="custom" data-mini="true" value="封底">
	<label for="hkgg-1">封底</label>
	<input type="checkbox" name="hkgg" id="hkgg-2" class="custom" data-mini="true" value="封二/封三">
	<label for="hkgg-2">封二/封三</label>
	<input type="checkbox" name="hkgg" id="hkgg-3" class="custom" data-mini="true" value="扉页一">
	<label for="hkgg-3">扉页一</label>
	<input type="checkbox" name="hkgg" id="hkgg-4" class="custom" data-mini="true" value="扉页二">
	<label for="hkgg-4">扉页二</label>
	<input type="checkbox" name="hkgg" id="hkgg-5" class="custom" data-mini="true" value="跨版彩色">
	<label for="hkgg-5">跨版彩色</label>
	<input type="checkbox" name="hkgg" id="hkgg-6" class="custom" data-mini="true" value="文字整版">
	<label for="hkgg-6">文字整版</label>
	<input type="checkbox" name="hkgg" id="hkgg-7" class="custom" data-mini="true" value="内页全版彩色">
	<label for="hkgg-7">内页全版彩色</label>
	<input type="checkbox" name="hkgg" id="hkgg-8" class="custom" data-mini="true" value="内页半版彩色">
	<label for="hkgg-8">内页半版彩色</label>
</div>

<div data-role="fieldcontain">
    <label for="zwyd">展位预定</label>
    <input type="text" name="zwyd" id="zwyd" placeholder="请填写展位要求" value="">
</div>

<div data-role="fieldcontain">
	<label for="mp">门票及印刷品</label>
	<input type="checkbox" name="mp" id="mp-0" class="custom" data-mini="true">
	<label for="mp-0">门票</label>
	<input type="checkbox" name="mp" id="mp-1" class="custom" data-mini="true">
	<label for="mp-1">证件及挂绳</label>
	<input type="checkbox" name="mp" id="mp-2" class="custom" data-mini="true">
	<label for="mp-2">环保资料袋</label>
	<input type="checkbox" name="mp" id="mp-3" class="custom" data-mini="true">
	<label for="mp-3">其他</label>
</div>

<div class="ui-block-a"><button data-theme="b" onclick="javascript:$('#canzhanshangForm').submit();">提交报名表</button></div>








    
    
    
  </div>
</div>






<script>
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
	WeixinJSBridge.call('hideOptionMenu');
});

</script>



</form:form>
    </template:block>
</template:template>
