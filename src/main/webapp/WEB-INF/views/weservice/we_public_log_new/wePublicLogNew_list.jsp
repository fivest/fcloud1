<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_public_log_new/wePublicLogNew.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_public_log_new/wePublicLogNew.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_public_log_new/wePublicLogNew.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_public_log_new/wePublicLogNew.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.wePublicLogNewForm, 'deleteall');">
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
				<sunbor:column property="wePublicLogNew.fdOpenid">
					<bean:message bundle="weservice" key="wePublicLogNew.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdCode">
					<bean:message bundle="weservice" key="wePublicLogNew.fdCode"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdCreatetime">
					<bean:message bundle="weservice" key="wePublicLogNew.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdOrder">
					<bean:message bundle="weservice" key="wePublicLogNew.fdOrder"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdTitle">
					<bean:message bundle="weservice" key="wePublicLogNew.fdTitle"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdDescription">
					<bean:message bundle="weservice" key="wePublicLogNew.fdDescription"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdPicurl">
					<bean:message bundle="weservice" key="wePublicLogNew.fdPicurl"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdUrl">
					<bean:message bundle="weservice" key="wePublicLogNew.fdUrl"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdSrcid">
					<bean:message bundle="weservice" key="wePublicLogNew.fdSrcid"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.fdWepubliclognews">
					<bean:message bundle="weservice" key="wePublicLogNew.fdWepubliclognews"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNew.name11.fdId">
					<bean:message bundle="weservice" key="wePublicLogNew.name11"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="wePublicLogNew" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_public_log_new/wePublicLogNew.do" />?method=view&fdId=${wePublicLogNew.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${wePublicLogNew.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdOpenid}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdCode}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdOrder}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdTitle}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdDescription}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdPicurl}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdUrl}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdSrcid}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.fdWepubliclognews}" />
				</td>
				<td>
					<c:out value="${wePublicLogNew.name11.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>