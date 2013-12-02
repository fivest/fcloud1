<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	会议议程
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
	<style>
	body{line-height: 1.45;position: absolute;left:10px;right:10px;}
	b{color:#0b5487;}
	</style>
    </template:block>
    <template:block name="body">
        <template:super />
        <h3>&nbsp;&nbsp;会议议程</h3>
<center><img src="/public/app/cihezh/home02.jpg" width="100%" /></center>    
<p>  
<b>（一）会议时间</b>
<br>
　　2013年12月11号下午。（暂定）
<p>
<b>（二）会议地点</b>
<br>
　　深圳会展中心3号馆。 （暂定）
<p>
<b>（三）组织单位</b>
<br>
　　1、主办单位：中国（深圳）国际健康产业博览会组委会
<br>
　　2、承办单位：汇金融通金融联盟、深圳世界贸易中心会、深圳市君诺投资顾问有限公司、深圳市创新投资集团有限公司、广东华商律师事务所
<p>
<b>（四）会议参加对象</b>
<br>
　　本次会议的参加对象主要分为金融（投资）机构以及参会（项目）企业两个层面：
<br>
　　1、金融（投资）机构：国内著名的创投/私募机构、证券公司、银行、融资租赁公司、担保公司、前海股权交易中心、医药健康等相关产业的上市公司等企业或单位（约30—40个）；
<br>
　　2、参会（项目）企业：由主办方推荐的参加2013中国（深圳）国际健康产业博览会的优秀项目公司（约20个）。（另外，我们还将整理约30个项目的材料，供会议参加对象了解、交流）
<p>   
<div align="center"><img style="width:100%" src="/public/app/cihezh/hyyc.jpg" /></div> 

<br>
  <%@ include file="/public/app/cihezh/bottom.jsp"%>
  <br>
    </template:block>
</template:template>
