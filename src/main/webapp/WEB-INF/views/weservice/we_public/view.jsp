<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <link rel="stylesheet" href="/public/js/city/css.css"/>
    <link rel="stylesheet" href="/public/js/city/form.css"/>
    <script src="/public/js/jquery.min.js"></script>

    <title>公众号设置</title>
</head>
<body>
<h1 style="text-align: center;">公众号设置</h1>

<div style="text-align: center; margin: 50px auto;">
    <form:form action="/weservice/we_public/wePublic${fn:idp(model)}" method="POST" commandName="model">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td>公众号名称:</td>
                <td><form:input path="fdName" readonly="true"/></td>
            </tr>
            <tr>
                <td>二维码:</td>
                <td><form:input path="fdCode" readonly="true"/></td>
            </tr>
            <tr>
                <td>微信号:</td>
                <td><form:input path="fdPublic" readonly="true"/></td>
            </tr>
            <tr>
                <td>类型:</td>
                    <%--<td><form:input path="fdPtype"/></td>--%>
                <td>
                    <form:select path="fdPtype">
                        <form:option value="1">订阅号</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>接口URL:</td>
                <td><form:input path="fdIntUrl" readonly="true"/></td>
            </tr>
            <tr>
                <td>Token:</td>
                <td><form:input path="fdIntToken" readonly="true"/></td>
            </tr>
            <tr>
                <td>AppId:</td>
                <td><form:input path="fdAppId" readonly="true"/></td>
            </tr>
            <tr>
                <td>AppSecret:</td>
                <td><form:input path="fdAppSecret" readonly="true"/></td>
            </tr>
            <tr>
                <td>地区:</td>
                <td>
                    <form:hidden path="fdArea"/>
                    <ul>
                        <li>
                            <span> 省份： </span>
                                <label id="prov"></label>
                            <span> 市/县： </span>
                                <label id="city"></label>
                            <span> 区 : </span>
                                <label id="district"></label>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>登录邮箱:</td>
                <td><form:input path="fdEmail" readonly="true"/></td>
            </tr>
            <tr>
                <td>头像:</td>
                <td><form:input path="fdPic" readonly="true"/></td>
            </tr>
            <tr>
                <td>功能介绍:</td>
                <td><form:textarea path="fdInfo" readonly="true"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="保存"/>
                </td>
            </tr>
        </table>
    </form:form>
    <script type="text/javascript">
        $(function(){
            var area = $("#fdArea").val();
            if(area != null && area.length > 0){
                var areas = area.split(":");
                $("#prov").html(areas[0]);
                $("#city").html(areas[1]);
                $("#district").html(areas[2]);
            }
        })
    </script>
</div>
</body>
</html>