<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/edit_top.jsp"%>
<html:form action="/weservice/we_public_log_new/wePublicLogNew.do">
<div id="optBarDiv">
	<c:if test="${wePublicLogNewForm.method_GET=='edit'}">
		<input type=button value="<bean:message key="button.update"/>"
			onclick="Com_Submit(document.wePublicLogNewForm, 'update');">
	</c:if>
	<c:if test="${wePublicLogNewForm.method_GET=='add'}">
		<input type=button value="<bean:message key="button.save"/>"
			onclick="Com_Submit(document.wePublicLogNewForm, 'save');">
		<input type=button value="<bean:message key="button.saveadd"/>"
			onclick="Com_Submit(document.wePublicLogNewForm, 'saveadd');">
	</c:if>
	<input type="button" value="<bean:message key="button.close"/>" onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.wePublicLogNew"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdOpenid"/>
		</td><td width="35%">
			<xform:text property="fdOpenid" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdCode"/>
		</td><td width="35%">
			<xform:text property="fdCode" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdCreatetime"/>
		</td><td width="35%">
			<xform:text property="fdCreatetime" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdOrder"/>
		</td><td width="35%">
			<xform:text property="fdOrder" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdTitle"/>
		</td><td width="35%">
			<xform:text property="fdTitle" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdDescription"/>
		</td><td width="35%">
			<xform:textarea property="fdDescription" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdPicurl"/>
		</td><td width="35%">
			<xform:text property="fdPicurl" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdUrl"/>
		</td><td width="35%">
			<xform:text property="fdUrl" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdSrcid"/>
		</td><td width="35%">
			<xform:text property="fdSrcid" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.fdWepubliclognews"/>
		</td><td width="35%">
			<xform:text property="fdWepubliclognews" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogNew.name11"/>
		</td><td width="35%">
			<xform:select property="name11Id">
				<xform:beanDataSource serviceBean="wePublicLogNewsService" selectBlock="fdId,fdId" orderBy="" />
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