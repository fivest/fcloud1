<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_menu/weMenu.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_menu/weMenu.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_menu/weMenu.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_menu/weMenu.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weMenuForm, 'deleteall');">
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
				<sunbor:column property="weMenu.fdJson">
					<bean:message bundle="weservice" key="weMenu.fdJson"/>
				</sunbor:column>
				<sunbor:column property="weMenu.fdVersion">
					<bean:message bundle="weservice" key="weMenu.fdVersion"/>
				</sunbor:column>
				<sunbor:column property="weMenu.fdCreatetime">
					<bean:message bundle="weservice" key="weMenu.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="weMenu.name5.fdId">
					<bean:message bundle="weservice" key="weMenu.name5"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weMenu" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_menu/weMenu.do" />?method=view&fdId=${weMenu.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weMenu.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weMenu.fdJson}" />
				</td>
				<td>
					<c:out value="${weMenu.fdVersion}" />
				</td>
				<td>
					<kmss:showDate value="${weMenu.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${weMenu.name5.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>