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
	<kmss:auth requestURL="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do?method=edit&fdId=${param.fdId}" requestMethod="GET">
		<input type="button"
			value="<bean:message key="button.edit"/>"
			onclick="Com_OpenWindow('weRuleReplyPictext.do?method=edit&fdId=${param.fdId}','_self');">
	</kmss:auth>
	<kmss:auth requestURL="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do?method=delete&fdId=${param.fdId}" requestMethod="GET">
		<input type="button"
			value="<bean:message key="button.delete"/>"
			onclick="if(!confirmDelete())return;Com_OpenWindow('weRuleReplyPictext.do?method=delete&fdId=${param.fdId}','_self');">
	</kmss:auth>
	<input type="button"
		value="<bean:message key="button.close"/>"
		onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.weRuleReplyPictext"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdTitle"/>
		</td><td width="35%">
			<xform:text property="fdTitle" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdPic"/>
		</td><td width="35%">
			<xform:text property="fdPic" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdSummary"/>
		</td><td width="35%">
			<xform:text property="fdSummary" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdText"/>
		</td><td width="35%">
			<xform:textarea property="fdText" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdUrl"/>
		</td><td width="35%">
			<xform:text property="fdUrl" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdTags"/>
		</td><td width="35%">
			<xform:text property="fdTags" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictext.fdWerulereply"/>
		</td><td width="35%">
			<c:out value="${weRuleReplyPictextForm.fdWerulereplyName}" />
		</td>
		<td class="td_normal_title" width=15%>&nbsp;</td><td width=35%>&nbsp;</td>
	</tr>
</table>
</center>
<%@ include file="/resource/jsp/view_down.jsp"%>