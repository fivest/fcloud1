<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weRuleReplyPictextForm, 'deleteall');">
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
				<sunbor:column property="weRuleReplyPictext.fdTitle">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdTitle"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictext.fdPic">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdPic"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictext.fdSummary">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdSummary"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictext.fdText">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdText"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictext.fdUrl">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdUrl"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictext.fdTags">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdTags"/>
				</sunbor:column>
				<sunbor:column property="weRuleReplyPictext.fdWerulereply.fdId">
					<bean:message bundle="weservice" key="weRuleReplyPictext.fdWerulereply"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weRuleReplyPictext" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do" />?method=view&fdId=${weRuleReplyPictext.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weRuleReplyPictext.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdTitle}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdPic}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdSummary}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdText}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdUrl}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdTags}" />
				</td>
				<td>
					<c:out value="${weRuleReplyPictext.fdWerulereply.fdId}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>