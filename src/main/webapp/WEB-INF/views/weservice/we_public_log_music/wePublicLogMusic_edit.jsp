<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/kmss-xform.tld" prefix="xform"%>
<%@ include file="/resource/jsp/edit_top.jsp"%>
<html:form action="/weservice/we_public_log_music/wePublicLogMusic.do">
<div id="optBarDiv">
	<c:if test="${wePublicLogMusicForm.method_GET=='edit'}">
		<input type=button value="<bean:message key="button.update"/>"
			onclick="Com_Submit(document.wePublicLogMusicForm, 'update');">
	</c:if>
	<c:if test="${wePublicLogMusicForm.method_GET=='add'}">
		<input type=button value="<bean:message key="button.save"/>"
			onclick="Com_Submit(document.wePublicLogMusicForm, 'save');">
		<input type=button value="<bean:message key="button.saveadd"/>"
			onclick="Com_Submit(document.wePublicLogMusicForm, 'saveadd');">
	</c:if>
	<input type="button" value="<bean:message key="button.close"/>" onclick="Com_CloseWindow();">
</div>

<p class="txttitle"><bean:message bundle="weservice" key="table.wePublicLogMusic"/></p>

<center>
<table class="tb_normal" width=95%>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdOpenid"/>
		</td><td width="35%">
			<xform:text property="fdOpenid" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdCode"/>
		</td><td width="35%">
			<xform:text property="fdCode" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdCreatetime"/>
		</td><td width="35%">
			<xform:text property="fdCreatetime" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdMsgtype"/>
		</td><td width="35%">
			<xform:text property="fdMsgtype" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdMusicurl"/>
		</td><td width="35%">
			<xform:text property="fdMusicurl" style="width:85%" />
		</td>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdHqmusicurl"/>
		</td><td width="35%">
			<xform:text property="fdHqmusicurl" style="width:85%" />
		</td>
	</tr>
	<tr>
		<td class="td_normal_title" width=15%>
			<bean:message bundle="weservice" key="wePublicLogMusic.fdSrcid"/>
		</td><td width="35%">
			<xform:text property="fdSrcid" style="width:85%" />
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