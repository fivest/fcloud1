<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_user_log_location/weUserLogLocation.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_user_log_location/weUserLogLocation.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_user_log_location/weUserLogLocation.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_user_log_location/weUserLogLocation.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weUserLogLocationForm, 'deleteall');">
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
				<sunbor:column property="weUserLogLocation.fdCode">
					<bean:message bundle="weservice" key="weUserLogLocation.fdCode"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdOpenid">
					<bean:message bundle="weservice" key="weUserLogLocation.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdCreatetime">
					<bean:message bundle="weservice" key="weUserLogLocation.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdMsgtype">
					<bean:message bundle="weservice" key="weUserLogLocation.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdLocationX">
					<bean:message bundle="weservice" key="weUserLogLocation.fdLocationX"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdLocationY">
					<bean:message bundle="weservice" key="weUserLogLocation.fdLocationY"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdScale">
					<bean:message bundle="weservice" key="weUserLogLocation.fdScale"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdLabel">
					<bean:message bundle="weservice" key="weUserLogLocation.fdLabel"/>
				</sunbor:column>
				<sunbor:column property="weUserLogLocation.fdMsgid">
					<bean:message bundle="weservice" key="weUserLogLocation.fdMsgid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weUserLogLocation" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_user_log_location/weUserLogLocation.do" />?method=view&fdId=${weUserLogLocation.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weUserLogLocation.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdCode}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdOpenid}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdLocationX}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdLocationY}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdScale}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdLabel}" />
				</td>
				<td>
					<c:out value="${weUserLogLocation.fdMsgid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>