<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weRuleReplyPictextsonForm, 'deleteall');">
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
				<sunbor:column property="weRuleReplyPictextson.fdTitle">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdTitle"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictextson.fdPic">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdPic"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictextson.fdText">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdText"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictextson.fdUrl">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdUrl"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictextson.fdTags">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdTags"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictextson.fdOrder">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdOrder"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictextson.fdWerulereply.fdId">
					<bean:message bundle="weservice" key="weRuleReplyPictextson.fdWerulereply"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weRuleReplyPictextson" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do" />?method=view&fdId=${weRuleReplyPictextson.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weRuleReplyPictextson.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdTitle}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdPic}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdText}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdUrl}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdTags}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdOrder}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictextson.fdWerulereply.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>