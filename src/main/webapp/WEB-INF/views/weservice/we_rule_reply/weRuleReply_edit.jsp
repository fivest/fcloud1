<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/edit_top.jsp"%>
<html:form action="/weservice/we_rule_reply/weRuleReply.do">
<div id="optBarDiv">
	<c:if test="${weRuleReplyForm.method_GET=='edit'}">
		<input type=button value="<bean:message key="button.update"/>"
			onclick="Com_Submit(document.weRuleReplyForm, 'update');">
	</c:if>
	<c:if test="${weRuleReplyForm.method_GET=='add'}">
		<input type=button value="<bean:message key="button.save"/>"
			onclick="Com_Submit(document.weRuleReplyForm, 'save');">
		<input type=button value="<bean:message key="button.saveadd"/>"
			onclick="Com_Submit(document.weRuleReplyForm, 'saveadd');">
	</c:if>
	<input type="button" value="<bean:message key="button.close"/>" onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.weRuleReply"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReply.fdUse"/>
		</td><td width="35%">
			<xform:text property="fdUse" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReply.fdKey"/>
		</td><td width="35%">
			<xform:text property="fdKey" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReply.fdMatchType"/>
		</td><td width="35%">
			<xform:text property="fdMatchType" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReply.fdReplyType"/>
		</td><td width="35%">
			<xform:text property="fdReplyType" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weRuleReply.fdWepublic"/>
		</td><td width="35%">
			<xform:select property="fdWepublicId">
				<xform:beanDataSource serviceBean="wePublicService" selectBlock="fdId,fdId" orderBy="" />
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