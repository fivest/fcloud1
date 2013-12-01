<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_user_log_link/weUserLogLink.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_user_log_link/weUserLogLink.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_user_log_link/weUserLogLink.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_user_log_link/weUserLogLink.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weUserLogLinkForm, 'deleteall');">
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
				<sunbor:column property="weUserLogLink.fdCode">
					<bean:message bundle="weservice" key="weUserLogLink.fdCode"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdOpenid">
					<bean:message bundle="weservice" key="weUserLogLink.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdCreatetime">
					<bean:message bundle="weservice" key="weUserLogLink.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdMsgtype">
					<bean:message bundle="weservice" key="weUserLogLink.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdTitle">
					<bean:message bundle="weservice" key="weUserLogLink.fdTitle"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdDescription">
					<bean:message bundle="weservice" key="weUserLogLink.fdDescription"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdUrl">
					<bean:message bundle="weservice" key="weUserLogLink.fdUrl"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLink.fdMsgid">
					<bean:message bundle="weservice" key="weUserLogLink.fdMsgid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weUserLogLink" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_user_log_link/weUserLogLink.do" />?method=view&fdId=${weUserLogLink.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weUserLogLink.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weUserLogLink.fdCode}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdOpenid}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdTitle}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdDescription}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdUrl}" />
				</td>
				<td>
					<c:out value="${weUserLogLink.fdMsgid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>