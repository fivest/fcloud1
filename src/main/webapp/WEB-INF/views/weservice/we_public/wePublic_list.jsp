<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_public/wePublic.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_public/wePublic.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_public/wePublic.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_public/wePublic.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.wePublicForm, 'deleteall');">
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
				<sunbor:column property="wePublic.fdPublic">
					<bean:message bundle="weservice" key="wePublic.fdPublic"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdName">
					<bean:message bundle="weservice" key="wePublic.fdName"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdEmail">
					<bean:message bundle="weservice" key="wePublic.fdEmail"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdPtype">
					<bean:message bundle="weservice" key="wePublic.fdPtype"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdCountry">
					<bean:message bundle="weservice" key="wePublic.fdCountry"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdArea">
					<bean:message bundle="weservice" key="wePublic.fdArea"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdInfo">
					<bean:message bundle="weservice" key="wePublic.fdInfo"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdPic">
					<bean:message bundle="weservice" key="wePublic.fdPic"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdCode">
					<bean:message bundle="weservice" key="wePublic.fdCode"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdIntUrl">
					<bean:message bundle="weservice" key="wePublic.fdIntUrl"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdIntToken">
					<bean:message bundle="weservice" key="wePublic.fdIntToken"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdAppId">
					<bean:message bundle="weservice" key="wePublic.fdAppId"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdAppSecret">
					<bean:message bundle="weservice" key="wePublic.fdAppSecret"/>
				</sunbor:column>
				<sunbor:column property="wePublic.fdCreatetime">
					<bean:message bundle="weservice" key="wePublic.fdCreatetime"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="wePublic" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_public/wePublic.do" />?method=view&fdId=${wePublic.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${wePublic.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${wePublic.fdPublic}" />
				</td>
				<td>
					<c:out value="${wePublic.fdName}" />
				</td>
				<td>
					<c:out value="${wePublic.fdEmail}" />
				</td>
				<td>
					<c:out value="${wePublic.fdPtype}" />
				</td>
				<td>
					<c:out value="${wePublic.fdCountry}" />
				</td>
				<td>
					<c:out value="${wePublic.fdArea}" />
				</td>
				<td>
					<c:out value="${wePublic.fdInfo}" />
				</td>
				<td>
					<c:out value="${wePublic.fdPic}" />
				</td>
				<td>
					<c:out value="${wePublic.fdCode}" />
				</td>
				<td>
					<c:out value="${wePublic.fdIntUrl}" />
				</td>
				<td>
					<c:out value="${wePublic.fdIntToken}" />
				</td>
				<td>
					<c:out value="${wePublic.fdAppId}" />
				</td>
				<td>
					<c:out value="${wePublic.fdAppSecret}" />
				</td>
				<td>
					<kmss:showDate value="${wePublic.fdCreatetime}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>