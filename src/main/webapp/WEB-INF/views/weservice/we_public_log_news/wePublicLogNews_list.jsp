<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_public_log_news/wePublicLogNews.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_public_log_news/wePublicLogNews.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_public_log_news/wePublicLogNews.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_public_log_news/wePublicLogNews.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.wePublicLogNewsForm, 'deleteall');">
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
				<sunbor:column property="wePublicLogNews.fdOpenid">
					<bean:message bundle="weservice" key="wePublicLogNews.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNews.fdCode">
					<bean:message bundle="weservice" key="wePublicLogNews.fdCode"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNews.fdCreatetime">
					<bean:message bundle="weservice" key="wePublicLogNews.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNews.fdMsgtype">
					<bean:message bundle="weservice" key="wePublicLogNews.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNews.fdArticlecount">
					<bean:message bundle="weservice" key="wePublicLogNews.fdArticlecount"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogNews.fdSrcid">
					<bean:message bundle="weservice" key="wePublicLogNews.fdSrcid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="wePublicLogNews" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_public_log_news/wePublicLogNews.do" />?method=view&fdId=${wePublicLogNews.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${wePublicLogNews.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${wePublicLogNews.fdOpenid}" />
				</td>
				<td>
					<c:out value="${wePublicLogNews.fdCode}" />
				</td>
				<td>
					<c:out value="${wePublicLogNews.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${wePublicLogNews.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${wePublicLogNews.fdArticlecount}" />
				</td>
				<td>
					<c:out value="${wePublicLogNews.fdSrcid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>