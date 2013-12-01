<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_rule_reply/weRuleReply.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_rule_reply/weRuleReply.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_rule_reply/weRuleReply.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_rule_reply/weRuleReply.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weRuleReplyForm, 'deleteall');">
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
				<sunbor:column property="weRuleReply.fdUse">
					<bean:message bundle="weservice" key="weRuleReply.fdUse"/>
				</sunbor:column>
				<sunbor:column property="weRuleReply.fdKey">
					<bean:message bundle="weservice" key="weRuleReply.fdKey"/>
				</sunbor:column>
				<sunbor:column property="weRuleReply.fdMatchType">
					<bean:message bundle="weservice" key="weRuleReply.fdMatchType"/>
				</sunbor:column>
				<sunbor:column property="weRuleReply.fdReplyType">
					<bean:message bundle="weservice" key="weRuleReply.fdReplyType"/>
				</sunbor:column>
				<sunbor:column property="weRuleReply.fdWepublic.fdId">
					<bean:message bundle="weservice" key="weRuleReply.fdWepublic"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weRuleReply" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_rule_reply/weRuleReply.do" />?method=view&fdId=${weRuleReply.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weRuleReply.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weRuleReply.fdUse}" />
				</td>
				<td>
					<c:out value="${weRuleReply.fdKey}" />
				</td>
				<td>
					<c:out value="${weRuleReply.fdMatchType}" />
				</td>
				<td>
					<c:out value="${weRuleReply.fdReplyType}" />
				</td>
				<td>
					<c:out value="${weRuleReply.fdWepublic.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>