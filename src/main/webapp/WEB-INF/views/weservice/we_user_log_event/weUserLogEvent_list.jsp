<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_user_log_event/weUserLogEvent.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_user_log_event/weUserLogEvent.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_user_log_event/weUserLogEvent.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_user_log_event/weUserLogEvent.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weUserLogEventForm, 'deleteall');">
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
				<sunbor:column property="weUserLogEvent.fdCode">
					<bean:message bundle="weservice" key="weUserLogEvent.fdCode"/>
				</sunbor:column>
				<sunbor:column property="weUserLogEvent.fdOpenid">
					<bean:message bundle="weservice" key="weUserLogEvent.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="weUserLogEvent.fdCreatetime">
					<bean:message bundle="weservice" key="weUserLogEvent.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="weUserLogEvent.fdMsgtype">
					<bean:message bundle="weservice" key="weUserLogEvent.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="weUserLogEvent.fdEvent">
					<bean:message bundle="weservice" key="weUserLogEvent.fdEvent"/>
				</sunbor:column>
				<sunbor:column property="weUserLogEvent.fdEventkey">
					<bean:message bundle="weservice" key="weUserLogEvent.fdEventkey"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weUserLogEvent" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_user_log_event/weUserLogEvent.do" />?method=view&fdId=${weUserLogEvent.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weUserLogEvent.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weUserLogEvent.fdCode}" />
				</td>
				<td>
					<c:out value="${weUserLogEvent.fdOpenid}" />
				</td>
				<td>
					<c:out value="${weUserLogEvent.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${weUserLogEvent.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${weUserLogEvent.fdEvent}" />
				</td>
				<td>
					<c:out value="${weUserLogEvent.fdEventkey}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>