<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_public_log_text/wePublicLogText.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_public_log_text/wePublicLogText.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_public_log_text/wePublicLogText.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_public_log_text/wePublicLogText.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.wePublicLogTextForm, 'deleteall');">
		</kmss:auth>
	</div>
<c:if test="${queryPage.totalrows==0}">
	<%@ include file="/resource/jsp/list_norecord.jsp"%>
</c:if>
<c:if test="${queryPage.totalrows>0}">
	<%@ include file="/resource/jsp/list_pagenav_top.jsp"%>
	<table id="List_ViewTable">
		<tr>
			<sunbor:columnHead htmlTag="td">
				<td width="10pt">
					<input type="checkbox" name="List_Tongle">
				</td>
				<td width="40pt">
					<bean:message key="page.serial"/>
				</td>
				<sunbor:column property="wePublicLogText.fdOpenid">
					<bean:message bundle="weservice" key="wePublicLogText.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogText.fdCode">
					<bean:message bundle="weservice" key="wePublicLogText.fdCode"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogText.fdCreatetime">
					<bean:message bundle="weservice" key="wePublicLogText.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogText.fdMsgtype">
					<bean:message bundle="weservice" key="wePublicLogText.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogText.fdContent">
					<bean:message bundle="weservice" key="wePublicLogText.fdContent"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogText.fdSrcid">
					<bean:message bundle="weservice" key="wePublicLogText.fdSrcid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="wePublicLogText" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_public_log_text/wePublicLogText.do" />?method=view&fdId=${wePublicLogText.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${wePublicLogText.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${wePublicLogText.fdOpenid}" />
				</td>
				<td>
					<c:out value="${wePublicLogText.fdCode}" />
				</td>
				<td>
					<c:out value="${wePublicLogText.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${wePublicLogText.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${wePublicLogText.fdContent}" />
				</td>
				<td>
					<c:out value="${wePublicLogText.fdSrcid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>