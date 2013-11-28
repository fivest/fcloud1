<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>

<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	展会反馈
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
    </template:block>
    <template:block name="body">
        <template:super />
<form:form id="zhanhfkForm" action="/wechat/app/cihezh/zhanhfk${fn:idp(model)}" method="POST" commandName="model">
<form:hidden path="id" />
<div data-role="page">

  <div data-role="content">

<div data-role="fieldcontain">
	<label for="fknr">反馈内容</label>
	<textarea cols="40" rows="8" name="fknr" id="fknr"></textarea>
</div>

<div data-role="fieldcontain">
    <label for="tel">手机号</label>
    <input type="tel" name="tel" id="tel" placeholder="请填写联系方式" value="">
</div>

<div data-role="fieldcontain">
    <label for="wenum">微信号</label>
    <input type="email" name="wenum" id="wenum" placeholder="请填写个人微信号" value="">
</div>


<div class="ui-block-a"><button data-theme="b" onclick="javascript:$('#zhanhfkForm').submit();">提交反馈</button></div>








    
    
    
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
