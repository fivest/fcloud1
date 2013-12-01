<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <title>Demo Main 编辑</title>
</head>
<body>
编辑界面

<form:form action="/weservice/we_public/wePublic${fn:idp(model)}" method="POST" commandName="model">
    <form:hidden path="id" />
    <table>
        <tr>
            <td>公众号名称:</td>
            <td><form:input path="fdName"/></td>
        </tr>
         <tr>
            <td>二维码:</td>
            <td><form:input path="fdCode"/></td>
        </tr>
        <tr>
            <td>微信号:</td>
            <td><form:input path="fdPublic"/></td>
        </tr>
        <tr>
            <td>类型:</td>
            <td><form:input path="fdPtype"/></td>
        </tr>
        <tr>
            <td>接口URL:</td>
            <td><form:input path="fdIntUrl"/></td>
        </tr>
        <tr>
            <td>Token:</td>
            <td><form:input path="fdIntToken"/></td>
        </tr>
        <tr>
            <td>AppId:</td>
            <td><form:input path="fdAppId"/></td>
        </tr>
        <tr>
            <td>AppSecret:</td>
            <td><form:input path="fdAppSecret"/></td>
        </tr>
        <tr>
            <td>地区:</td>
            <td>
                <form:select path="fdCountry">
                </form:select>    
             </td>
            <td>
                <form:select path="fdArea">
                </form:select>
            </td>
        </tr>
        <tr>
            <td>登录邮箱:</td>
            <td><form:input path="fdEmail"/></td>
        </tr>
         <tr>
            <td>头像:</td>
            <td><form:input path="fdPic"/></td>
        </tr>
        <tr>
            <td>功能介绍:</td>
            <td><form:input path="fdInfo"/></td>
        </tr>
        
       
        
       
        
        
        
        <tr>
            <td colspan="2">
                <input type="submit" value="保存" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>