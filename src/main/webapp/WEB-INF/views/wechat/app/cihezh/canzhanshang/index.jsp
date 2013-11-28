<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="template" uri="http://www.fcloud.com/taglib/template" %>
<template:template extend="/public/index_tpl.jsp">
    <template:block name="title">
	参展商
    </template:block>
    <template:block name="head">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/public/jquerymobile/themes/default/jquery.mobile-1.3.2.min.css" />
	<SCRIPT type="text/javascript" src="/public/js/jquery.min.js"></SCRIPT>
	<script type="text/javascript" src="/public/jquerymobile/js/jquery.mobile-1.3.2.min.js"></script>
	<script>
	function openadd(){
		var u_data=new Date().getTime();
		var url="<%=request.getContextPath()%>/wechat/app/sccn/errProcess/create"+"?"+u_data;
		this.location.href=url;
	}
	</script>
    </template:block>
    <template:block name="body">
        <template:super />
	<div data-role="header"  data-theme="b">
	    <a href="#" data-icon="refresh" data-theme="c">刷新</a>
	    <h1>故障处理</h1>
	    <a data-icon="plus" data-theme="c" href="javascript:openadd();">新增</a>
	</div>




    <div data-role="content">
        <ul id="list" class="touch" data-role="listview" data-split-icon="delete" data-split-theme="d">
            <li>
                <a href="#">
                    <h3>同安天鹅堡光缆问题</h3>
                    <p class="topic"><strong>大面积故障</strong></p>
                    <p>因外面修路把光缆挖断了，现要影响同安天鹅堡的电视宽带和互动无法正常使用要明天才能恢复若有报修请暂不派单了麻烦解释一下。谢谢！</p>
                    <p>处理过程</p>
                    <p class="ui-li-aside">黄喻[1107]<br><strong>2013-10-23 20:45:03</strong></p>
                </a>
                <a href="#" class="delete">Delete</a>
            </li>
            
			<c:forEach items="${page.content}" var="m" varStatus="status">
			<li>
				<a href="#">
					<h3>所属故障</h3>
					<p class="topic"><strong>${m.type}</strong></p>
	                <p>${m.reason}</p>
	                <p>${m.process_record}</p>
	                <p class="ui-li-aside">${m.openid}<br><strong>${m.recovery_time}</strong></p>
				</a>
				<a href="<%=request.getContextPath()%>/wechat/app/sccn/errProcess/${m.id}?_method=DELETE" class="delete">Delete</a>
			</li>
			</c:forEach> 
            
            
        </ul>
    </div>














        
        
        
        
        
<p>
        count: ${page.total}, page: ${page.page}, limit: ${page.size}
    </template:block>
</template:template>
