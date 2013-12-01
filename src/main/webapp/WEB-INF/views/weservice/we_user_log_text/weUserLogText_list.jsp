<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_user_log_text/weUserLogText.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_user_log_text/weUserLogText.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_user_log_text/weUserLogText.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_user_log_text/weUserLogText.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weUserLogTextForm, 'deleteall');">
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
				<sunbor:column property="weUserLogText.fdCode">
					<bean:message bundle="weservice" key="weUserLogText.fdCode"/>
				</sunbor:column>
				<sunbor:column property="weUserLogText.fdOpenid">
					<bean:message bundle="weservice" key="weUserLogText.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="weUserLogText.fdCreatetime">
					<bean:message bundle="weservice" key="weUserLogText.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="weUserLogText.fdMsgtype">
					<bean:message bundle="weservice" key="weUserLogText.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="weUserLogText.fdContent">
					<bean:message bundle="weservice" key="weUserLogText.fdContent"/>
				</sunbor:column>
				<sunbor:column property="weUserLogText.fdMsgid">
					<bean:message bundle="weservice" key="weUserLogText.fdMsgid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weUserLogText" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_user_log_text/weUserLogText.do" />?method=view&fdId=${weUserLogText.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weUserLogText.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weUserLogText.fdCode}" />
				</td>
				<td>
					<c:out value="${weUserLogText.fdOpenid}" />
				</td>
				<td>
					<c:out value="${weUserLogText.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${weUserLogText.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${weUserLogText.fdContent}" />
				</td>
				<td>
					<c:out value="${weUserLogText.fdMsgid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>