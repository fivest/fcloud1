<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/edit_top.jsp"%>
<html:form action="/weservice/we_menu/weMenu.do">
<div id="optBarDiv">
	<c:if test="${weMenuForm.method_GET=='edit'}">
		<input type=button value="<bean:message key="button.update"/>"
			onclick="Com_Submit(document.weMenuForm, 'update');">
	</c:if>
	<c:if test="${weMenuForm.method_GET=='add'}">
		<input type=button value="<bean:message key="button.save"/>"
			onclick="Com_Submit(document.weMenuForm, 'save');">
		<input type=button value="<bean:message key="button.saveadd"/>"
			onclick="Com_Submit(document.weMenuForm, 'saveadd');">
	</c:if>
	<input type="button" value="<bean:message key="button.close"/>" onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.weMenu"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weMenu.fdJson"/>
		</td><td width="35%">
			<xform:textarea property="fdJson" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weMenu.fdVersion"/>
		</td><td width="35%">
			<xform:text property="fdVersion" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weMenu.fdCreatetime"/>
		</td><td width="35%">
			<xform:datetime property="fdCreatetime" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="weMenu.name5"/>
		</td><td width="35%">
			<xform:select property="name5Id">
				<xform:beanDataSource serviceBean="wePublicService" selectBlock="fdId,fdId" orderBy="" />
			</xform:select>
		</td>
	</tr>
</table>
</center>
<html:hidden property="fdId" />
<html:hidden property="method_GET" />
<script>
	Com_IncludeFile("calendar.js");
	$KMSSValidation();
</script>
</html:form>
<%@ include file="/resource/jsp/edit_down.jsp"%>