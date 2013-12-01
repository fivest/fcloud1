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
		var url="<%=request.getContextPath()%>/wechat/app/cihezh/canzhanshang/create"+"?"+u_data;
		this.location.href=url;
	}
	
	function openEdit(id){
		var u_data=new Date().getTime();
		var url="<%=request.getContextPath()%>/wechat/app/cihezh/canzhanshang/"+id+"/edit"+"?"+u_data;
		this.location.href=url;
	}
	
	//"<%=request.getContextPath()%>/wechat/app/cihezh/canzhanshang/${m.id}?_method=DELETE"
	$(function () {
		$("#confirmdel").bind('click',function(){
			alert("不允许删除！")
			//var u_data=new Date().getTime();
			//var url="<%=request.getContextPath()%>/wechat/app/cihezh/canzhanshang/"+id+"/edit"+"?"+u_data;
			$('.ui-dialog').dialog('close');
		});
	});
		


	</script>
    </template:block>
    <template:block name="body">
        <template:super />
<div data-role="page" id="page1">   
        
	<div data-role="header"  data-theme="b">
	    <a href="#" data-icon="refresh" data-theme="c">刷新</a>
	    <h1>参展商</h1>
	    <a data-icon="plus" data-theme="c" href="javascript:openadd();">新增</a>
	</div>




    <div data-role="content">
        <ul id="list" class="touch" data-role="listview" data-split-icon="delete" data-split-theme="d">
			<c:forEach items="${page.content}" var="m" varStatus="status">
			<li>
				<a href="javascript:openEdit('${m.id}');">
					<h3>${m.name}</h3>
					<p class="topic"><strong>${m.lxfs}</strong></p>
	                <p>${m.type}</p>
	                <p>${m.czsp}</p>
	                <p class="ui-li-aside">${m.czsp}</strong></p>
				</a>
				
				<a href="#dialogPage" data-rel="dialog" class="delete">Delete</a>
			</li>
			</c:forEach> 
            
            
        </ul>
        
    </div>

        

        <c:if test="${!page.firstPage}">
        	<a href="?page=${page.page-1}" data-role="button" data-inline="true" data-icon="arrow-l">上一页</a>
        </c:if>
        <c:if test="${!page.lastPage}">
        	<a href="?page=${page.page+1}" data-role="button" data-inline="true" data-icon="arrow-r" data-iconpos="right">下一页</a>
        </c:if>
        
        <br/>	
        &nbsp;总数：${page.total} 
        &nbsp;页次：${page.page}/${page.totalPages}
        &nbsp;每页：${page.size}
        
<br/>



</div>  



<div data-role="page" id="dialogPage">
	<div data-role="header" data-theme="d">
		<h1>确认</h1>
	</div>
	<div data-role="content">
		<p>是否确认删除记录？</p>
		<a data-role="button" data-rel="back" data-theme="b">否</a>
		<button id="confirmdel" data-theme="f">是</button>
	</div>
</div>
        
    </template:block>
</template:template>
