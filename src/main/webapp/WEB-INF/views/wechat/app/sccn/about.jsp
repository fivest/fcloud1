<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	关于我们
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
    </template:block>
    <template:block name="body">
        <template:super />
        

        
        
        
        关于我们关于我们
<a href="#popupLogin" data-rel="popup" data-position-to="window" data-role="button" data-inline="true" data-icon="check" data-theme="a" data-transition="pop">Sign in</a>
<div data-role="popup" id="popupLogin" data-theme="a" class="ui-corner-all">
    <form>
        <div style="padding:10px 20px;">
            <h3>Please sign in</h3>
            <label for="un" class="ui-hidden-accessible">Username:</label>
            <input type="text" name="user" id="un" value="" placeholder="username" data-theme="a">
            <label for="pw" class="ui-hidden-accessible">Password:</label>
            <input type="password" name="pass" id="pw" value="" placeholder="password" data-theme="a">
            <button type="submit" data-theme="b" data-icon="check">Sign in</button>
        </div>
    </form>
</div>
        
    </template:block>
</template:template>
