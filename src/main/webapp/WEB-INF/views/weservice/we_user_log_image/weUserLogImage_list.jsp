<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/list_top.jsp"%>
<html:form action="/weservice/we_user_log_image/weUserLogImage.do">
	<div id="optBarDiv">
		<kmss:auth requestURL="/weservice/we_user_log_image/weUserLogImage.do?method=add">
			<input type="button" value="<bean:message key="button.add"/>"
				onclick="Com_OpenWindow('<c:url value="/weservice/we_user_log_image/weUserLogImage.do" />?method=add');">
		</kmss:auth>
		<kmss:auth requestURL="/weservice/we_user_log_image/weUserLogImage.do?method=deleteall">
			<input type="button" value="<bean:message key="button.delete"/>"
				onclick="if(!List_ConfirmDel())return;Com_Submit(document.weUserLogImageForm, 'deleteall');">
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
				<sunbor:column property="weUserLogImage.fdCode">
					<bean:message bundle="weservice" key="weUserLogImage.fdCode"/>
				</sunbor:column>
				<sunbor:column property="weUserLogImage.fdOpenid">
					<bean:message bundle="weservice" key="weUserLogImage.fdOpenid"/>
				</sunbor:column>
				<sunbor:column property="weUserLogImage.fdCreatetime">
					<bean:message bundle="weservice" key="weUserLogImage.fdCreatetime"/>
				</sunbor:column>
				<sunbor:column property="weUserLogImage.fdMsgtype">
					<bean:message bundle="weservice" key="weUserLogImage.fdMsgtype"/>
				</sunbor:column>
				<sunbor:column property="weUserLogImage.fdPicurl">
					<bean:message bundle="weservice" key="weUserLogImage.fdPicurl"/>
				</sunbor:column>
				<sunbor:column property="weUserLogImage.fdMsgid">
					<bean:message bundle="weservice" key="weUserLogImage.fdMsgid"/>
				</sunbor:column>
			</sunbor:columnHead>
		</tr>
		<c:forEach items="${queryPage.list}" var="weUserLogImage" varStatus="vstatus">
			<tr
				kmss_href="<c:url value="/weservice/we_user_log_image/weUserLogImage.do" />?method=view&fdId=${weUserLogImage.fdId}">
				<td>
					<input type="checkbox" name="List_Selected" value="${weUserLogImage.fdId}">
				</td>
				<td>
					${vstatus.index+1}
				</td>
				<td>
					<c:out value="${weUserLogImage.fdCode}" />
				</td>
				<td>
					<c:out value="${weUserLogImage.fdOpenid}" />
				</td>
				<td>
					<c:out value="${weUserLogImage.fdCreatetime}" />
				</td>
				<td>
					<c:out value="${weUserLogImage.fdMsgtype}" />
				</td>
				<td>
					<c:out value="${weUserLogImage.fdPicurl}" />
				</td>
				<td>
					<c:out value="${weUserLogImage.fdMsgid}" />
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/resource/jsp/list_pagenav_down.jsp" %>
</c:if>
</html:form>
<%@ include file="/resource/jsp/list_down.jsp"%>