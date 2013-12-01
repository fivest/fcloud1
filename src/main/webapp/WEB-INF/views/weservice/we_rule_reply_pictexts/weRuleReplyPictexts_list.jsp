<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_rule_reply_pictexts/weRuleReplyPictexts.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_rule_reply_pictexts/weRuleReplyPictexts.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_rule_reply_pictexts/weRuleReplyPictexts.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_rule_reply_pictexts/weRuleReplyPictexts.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weRuleReplyPictextsForm, 'deleteall');">
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
				<sunbor:column property="weRuleReplyPictexts.fdTitle">
					<bean:message bundle="weservice" key="weRuleReplyPictexts.fdTitle"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictexts.fdPic">
					<bean:message bundle="weservice" key="weRuleReplyPictexts.fdPic"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictexts.fdText">
					<bean:message bundle="weservice" key="weRuleReplyPictexts.fdText"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictexts.fdUrl">
					<bean:message bundle="weservice" key="weRuleReplyPictexts.fdUrl"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictexts.fdTags">
					<bean:message bundle="weservice" key="weRuleReplyPictexts.fdTags"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictexts.fdWerulereply.fdId">
					<bean:message bundle="weservice" key="weRuleReplyPictexts.fdWerulereply"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weRuleReplyPictexts" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_rule_reply_pictexts/weRuleReplyPictexts.do" />?method=view&fdId=${weRuleReplyPictexts.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weRuleReplyPictexts.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weRuleReplyPictexts.fdTitle}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictexts.fdPic}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictexts.fdText}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictexts.fdUrl}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictexts.fdTags}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictexts.fdWerulereply.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>