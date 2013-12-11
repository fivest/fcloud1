<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	2013深圳健博会
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
	<style>
	.ui-li-desc	{
		overflow: visible;
		white-space: normal;
	}	
	</style>
    </template:block>
    <template:block name="body">
        <template:super />
<div data-role="page" id="page1">   
        
	<div data-role="header"  data-theme="b">
	    
	    <h1>展会新闻</h1>
	    <a href="#" onclick="location.href=location.href;" data-icon="refresh" class="ui-btn-left" data-theme="c">刷新</a>
	</div>




    <div data-role="content">
        <ul id="list" class="touch" data-role="listview" data-split-icon="delete" data-split-theme="d">
			
			<li>
				<a rel="external" href="/public/app/cihezh/czzn.jsp">
					<h3>组委会最新参展指南</h3>
					<p>2013年12月11日至13日，深圳会展中心3号馆</p>
				</a>
			</li>
			
			<li>
				<a rel="external" href="/public/app/cihezh/jkdcj.jsp">
					<h3>健康大抽奖</h3>
					<p>2013年12月11日至13日，展会期间健康大奖送不停！</p>
				</a>
			</li>
			
			<li>
				<a rel="external" href="/public/app/cihezh/jsrs.jsp">
					<h3>金色人生助阵健博会</h3>
					<p>金色人生社区活跃团体组织文艺表演参加花甲之友健康快乐才艺表演，展现老年人健康活力。</p>
				</a>
			</li>

            
        </ul>
        
    </div>





<br/>



</div>  




<script>
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
});
</script>
    </template:block>
</template:template>
