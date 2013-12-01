<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/edit_top.jsp"%>
<html:form action="/weservice/we_user_log_location/weUserLogLocation.do">
<div id="optBarDiv">
	<c:if test="${weUserLogLocationForm.method_GET=='edit'}">
		<input type=button value="<bean:message key="button.update"/>"
			onclick="Com_Submit(document.weUserLogLocationForm, 'update');">
	</c:if>
	<c:if test="${weUserLogLocationForm.method_GET=='add'}">
		<input type=button value="<bean:message key="button.save"/>"
			onclick="Com_Submit(document.weUserLogLocationForm, 'save');">
		<input type=button value="<bean:message key="button.saveadd"/>"
			onclick="Com_Submit(document.weUserLogLocationForm, 'saveadd');">
	</c:if>
	<input type="button" value="<bean:message key="button.close"/>" onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.weUserLogLocation"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdCode"/>
		</td><td width="35%">
			<xform:text property="fdCode" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdOpenid"/>
		</td><td width="35%">
			<xform:text property="fdOpenid" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdCreatetime"/>
		</td><td width="35%">
			<xform:text property="fdCreatetime" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdMsgtype"/>
		</td><td width="35%">
			<xform:text property="fdMsgtype" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdLocationX"/>
		</td><td width="35%">
			<xform:text property="fdLocationX" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdLocationY"/>
		</td><td width="35%">
			<xform:text property="fdLocationY" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdScale"/>
		</td><td width="35%">
			<xform:text property="fdScale" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdLabel"/>
		</td><td width="35%">
			<xform:text property="fdLabel" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weUserLogLocation.fdMsgid"/>
		</td><td width="35%">
			<xform:text property="fdMsgid" style="width:85%" />
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