<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resource/jsp/tree_top.jsp" %>
//Com_Parameter.XMLDebug = true;
function generateTree()
{
	LKSTree = new TreeView(
		"LKSTree",
		"<bean:message key="module.weservice" bundle="weservice"/>",
		document.getElementById("treeDiv")
	);
	var n1, n2, n3, n4, n5;
	n1 = LKSTree.treeRoot;
	
	<%-- 用户图片消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weUserLogImage" bundle="weservice" />",
		"<c:url value="/weservice/we_user_log_image/weUserLogImage.do?method=list" />"
	);
	<%-- 回复音乐消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.wePublicLogMusic" bundle="weservice" />",
		"<c:url value="/weservice/we_public_log_music/wePublicLogMusic.do?method=list" />"
	);
	<%-- 回复规则 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weRuleReply" bundle="weservice" />",
		"<c:url value="/weservice/we_rule_reply/weRuleReply.do?method=list" />"
	);
	<%-- 自定义菜单 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weMenu" bundle="weservice" />",
		"<c:url value="/weservice/we_menu/weMenu.do?method=list" />"
	);
	<%-- 子图文 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weRuleReplyPictextson" bundle="weservice" />",
		"<c:url value="/weservice/we_rule_reply_pictextson/weRuleReplyPictextson.do?method=list" />"
	);
	<%-- 文本回复 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weRuleReplyText" bundle="weservice" />",
		"<c:url value="/weservice/we_rule_reply_text/weRuleReplyText.do?method=list" />"
	);
	<%-- 用户地理位置消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weUserLogLocation" bundle="weservice" />",
		"<c:url value="/weservice/we_user_log_location/weUserLogLocation.do?method=list" />"
	);
	<%-- 公众号 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.wePublic" bundle="weservice" />",
		"<c:url value="/weservice/we_public/wePublic.do?method=list" />"
	);
	<%-- 回复子图文消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.wePublicLogNew" bundle="weservice" />",
		"<c:url value="/weservice/we_public_log_new/wePublicLogNew.do?method=list" />"
	);
	<%-- 单图文回复 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weRuleReplyPictext" bundle="weservice" />",
		"<c:url value="/weservice/we_rule_reply_pictext/weRuleReplyPictext.do?method=list" />"
	);
	<%-- 回复文本消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.wePublicLogText" bundle="weservice" />",
		"<c:url value="/weservice/we_public_log_text/wePublicLogText.do?method=list" />"
	);
	<%-- 用户链接消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weUserLogLink" bundle="weservice" />",
		"<c:url value="/weservice/we_user_log_link/weUserLogLink.do?method=list" />"
	);
	<%-- 多图文回复 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weRuleReplyPictexts" bundle="weservice" />",
		"<c:url value="/weservice/we_rule_reply_pictexts/weRuleReplyPictexts.do?method=list" />"
	);
	<%-- 默认回复规则 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weRuleReplyDefault" bundle="weservice" />",
		"<c:url value="/weservice/we_rule_reply_default/weRuleReplyDefault.do?method=list" />"
	);
	<%-- 回复图文消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.wePublicLogNews" bundle="weservice" />",
		"<c:url value="/weservice/we_public_log_news/wePublicLogNews.do?method=list" />"
	);
	<%-- 用户文本消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weUserLogText" bundle="weservice" />",
		"<c:url value="/weservice/we_user_log_text/weUserLogText.do?method=list" />"
	);
	<%-- OpenID --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weOpenid" bundle="weservice" />",
		"<c:url value="/weservice/we_openid/weOpenid.do?method=list" />"
	);
	<%-- 用户事件消息 --%>
	n2 = n1.AppendURLChild(
		"<bean:message key="table.weUserLogEvent" bundle="weservice" />",
		"<c:url value="/weservice/we_user_log_event/weUserLogEvent.do?method=list" />"
	);
	
	LKSTree.EnableRightMenu();
	LKSTree.Show();
}
<%@ include file="/resource/jsp/tree_down.jsp" %>