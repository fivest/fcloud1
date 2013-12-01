<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_public_log_music/wePublicLogMusic.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_public_log_music/wePublicLogMusic.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_public_log_music/wePublicLogMusic.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_public_log_music/wePublicLogMusic.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.wePublicLogMusicForm, 'deleteall');">
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
				<sunbor:column property="wePublicLogMusic.fdOpenid">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogMusic.fdCode">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdCode"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogMusic.fdCreatetime">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogMusic.fdMsgtype">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogMusic.fdMusicurl">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdMusicurl"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogMusic.fdHqmusicurl">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdHqmusicurl"/>
				</sunbor:column>
				<sunbor:column property="wePublicLogMusic.fdSrcid">
					<bean:message bundle="weservice" key="wePublicLogMusic.fdSrcid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="wePublicLogMusic" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_public_log_music/wePublicLogMusic.do" />?method=view&fdId=${wePublicLogMusic.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${wePublicLogMusic.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdOpenid}" />
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdCode}" />
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdMusicurl}" />
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdHqmusicurl}" />
				</td>
				<td>
					<c:out value="${wePublicLogMusic.fdSrcid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>