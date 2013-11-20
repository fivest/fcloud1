<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	绑定账号
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
    </template:block>
    <template:block name="body">
        <template:super />
       
    <ul data-role="listview" data-inset="true">
        <li class="ui-body ui-body-d">
        	<div class="ui-grid-solo">
            	<div align="center"><img style="width:100%" src="/public/app/sccn/logo.jpg" /></div>
            </div>
        </li>

        <li data-role="fieldcontain">
            <label for="fdUser">用户名</label>
			<input type="text" name="fdUser" id="fdUser" value="">
        </li>

        <li data-role="fieldcontain">
			<label for="fdPassword">密码</label>
			<input type="password" data-clear-btn="true" placeholder="个人密码仅第一次验证时使用" name="fdPassword" id="fdPassword" value="" autocomplete="off">
   
        </li>
        <li class="ui-body ui-body-d">
            <fieldset class="ui-grid-a">
                    <div class="ui-block-a"><button data-theme="b">绑定账号</button></div>
                    <div class="ui-block-b"><button data-theme="b">返回</button></div>
            </fieldset>
        </li>
    </ul>


















    </template:block>
</template:template>
