<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/edit_top.jsp"%>
<html:form action="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do">
<div id="optBarDiv">
	<c:if test="${weRuleReplyPictextsonForm.method_GET=='edit'}">
		<input type=button value="<bean:message key="button.update"/>"
			onclick="Com_Submit(document.weRuleReplyPictextsonForm, 'update');">
	</c:if>
	<c:if test="${weRuleReplyPictextsonForm.method_GET=='add'}">
		<input type=button value="<bean:message key="button.save"/>"
			onclick="Com_Submit(document.weRuleReplyPictextsonForm, 'save');">
		<input type=button value="<bean:message key="button.saveadd"/>"
			onclick="Com_Submit(document.weRuleReplyPictextsonForm, 'saveadd');">
	</c:if>
	<input type="button" value="<bean:message key="button.close"/>" onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.weRuleReplyPictextson"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdTitle"/>
		</td><td width="35%">
			<xform:text property="fdTitle" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdPic"/>
		</td><td width="35%">
			<xform:text property="fdPic" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdText"/>
		</td><td width="35%">
			<xform:textarea property="fdText" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdUrl"/>
		</td><td width="35%">
			<xform:text property="fdUrl" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdTags"/>
		</td><td width="35%">
			<xform:text property="fdTags" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdOrder"/>
		</td><td width="35%">
			<xform:text property="fdOrder" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReplyPictextson.fdWerulereply"/>
		</td><td width="35%">
			<xform:select property="fdWerulereplyId">
				<xform:beanDataSource serviceBean="weRuleReplyPictextsService" selectBlock="fdId,fdId" orderBy="" />
			</xform:select>
		</td>
		<td class="td_normal_title" width=15%>&nbsp;</td><td width=35%>&nbsp;</td>
	</tr>
</table>
</center>
<html:hidden property="fdId" />
<html:hidden property="method_GET" />
<script>
	$KMSSValidation();
</script>
</html:form>
<%@ include file="/resource/jsp/edit_down.jsp"%>