<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <title>Demo Main 编辑</title>
</head>
<body>
编辑界面

<form:form action="/weservice/we_rule_reply_default/weRuleReplyDefault${fn:idp(model)}" method="POST"
           commandName="model">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>默认关注回复：</td>
            <td>
                <form:select path="default_one_type">
                    <form:option value="1">文本</form:option>
                    <form:option value="2">单图文</form:option>
                    <form:option value="3">多图文</form:option>
                </form:select>
            </td>
            <td>
                <form:input path="" value=""/>
            </td>
            <td>
                <form:checkbox path="" value=""/>
            </td>
        </tr>
        <tr>
            <td>默认取消关注回复：</td>
            <td>
                <form:select path="default_two_type">
                    <form:option value="1">文本</form:option>
                    <form:option value="2">单图文</form:option>
                    <form:option value="3">多图文</form:option>
                </form:select>
            </td>
            <td>
                <form:input path="" value=""/>
            </td>
            <td>
                <form:checkbox path="" value=""/>
            </td>
        </tr>
        <tr>
            <td>默认无匹配回复：</td>
            <td>
                <form:select path="default_three_type">
                    <form:option value="1">文本</form:option>
                    <form:option value="2">单图文</form:option>
                    <form:option value="3">多图文</form:option>
                </form:select>
            </td>
            <td>
                <form:input path="" value=""/>
            </td>
            <td>
                <form:checkbox path="" value=""/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="保存"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>