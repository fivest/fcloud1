<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/view_top.jsp"%>
<script>
	function confirmDelete(msg){
	var del = confirm("<bean:message key="page.comfirmDelete"/>");
	return del;
}
</script>
<div id="optBarDiv">
	<kmss:auth requestURL="/weservice/we_user_log_text/weUserLogText.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
		<input type="button"
			value="<bean:message key="button.edit"/>"
			onclick="Com_OpenWindow('weUserLogText.do?method=edit&fdId=${param.fdId}','_self');">
	</kmss:auth>
	<kmss:auth requestURL="/weservice/we_user_log_text/weUserLogText.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
		<input type="button"
			value="<bean:message key="button.delete"/>"
			onclick="if(!confirmDelete())return;Com_OpenWindow('weUserLogText.do?method=delete&fdId=${param.fdId}','_self');">
	</kmss:auth>
	<input type="button"
		value="<bean:message key="button.close"/>"
		onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.weUserLogText"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogText.fdCode"/>
		</td><td width="35%">
			<xform:text property="fdCode" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogText.fdOpenid"/>
		</td><td width="35%">
			<xform:text property="fdOpenid" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogText.fdCreatetime"/>
		</td><td width="35%">
			<xform:text property="fdCreatetime" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogText.fdMsgtype"/>
		</td><td width="35%">
			<xform:text property="fdMsgtype" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogText.fdContent"/>
		</td><td width="35%">
			<xform:textarea property="fdContent" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogText.fdMsgid"/>
		</td><td width="35%">
			<xform:text property="fdMsgid" style="width:85%" />
		</td>
	</tr>
</table>
</center>
<%@ include file="/resource/jsp/view_down.jsp"%>