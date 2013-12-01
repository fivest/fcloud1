<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_rule_reply_default/weRuleReplyDefault.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_rule_reply_default/weRuleReplyDefault.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_rule_reply_default/weRuleReplyDefault.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_rule_reply_default/weRuleReplyDefault.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weRuleReplyDefaultForm, 'deleteall');">
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
				<sunbor:column property="weRuleReplyDefault.fdUse">
					<bean:message bundle="weservice" key="weRuleReplyDefault.fdUse"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyDefault.fdRuleType">
					<bean:message bundle="weservice" key="weRuleReplyDefault.fdRuleType"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyDefault.fdRuleJson">
					<bean:message bundle="weservice" key="weRuleReplyDefault.fdRuleJson"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyDefault.fdWepublic.fdId">
					<bean:message bundle="weservice" key="weRuleReplyDefault.fdWepublic"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weRuleReplyDefault" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_rule_reply_default/weRuleReplyDefault.do" />?method=view&fdId=${weRuleReplyDefault.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weRuleReplyDefault.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weRuleReplyDefault.fdUse}" />
				</td>
				<td>
					<c:out value="${weRuleReplyDefault.fdRuleType}" />
				</td>
				<td>
					<c:out value="${weRuleReplyDefault.fdRuleJson}" />
				</td>
				<td>
					<c:out value="${weRuleReplyDefault.fdWepublic.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>