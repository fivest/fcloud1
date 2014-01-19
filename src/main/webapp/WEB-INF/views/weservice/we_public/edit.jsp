<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <link rel="stylesheet" href="/public/js/city/css.css"/>
    <link rel="stylesheet" href="/public/js/city/form.css"/>
    <script src="/public/js/city/kit.js"></script>
    <!--[if IE]>
    <script src="/public/js/city/ieFix.js"></script>
    <![endif]-->
    <script src="/public/js/city/dom.js"></script>
    <script src="/public/js/city/event.js"></script>
    <script src="/public/js/city/TreeDict.js"></script>
    <script src="/public/js/city/math.js"></script>
    <script src="/public/js/city/form.js"></script>
    <script src="/public/js/city/combobox.js"></script>
    <script src="/public/js/city/suggestselect.js"></script>
    <script src="/public/js/city/list.js"></script>
    <!--json data-->
    <script src="/public/js/city/json-data-city.js" charset="utf-8"></script>

    <title>公众号设置</title>
</head>
<body>
<h1 style="text-align: center;">公众号设置</h1>

<div style="text-align: center; margin: 50px auto;">
    <form:form action="/weservice/we_public${fn:idp(model)}" method="POST" commandName="model">
        <form:hidden path="id"/>
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
                <%--<td><form:input path="fdPtype"/></td>--%>
                <td>
                        <form:select path="fdPtype">
                            <form:option value="1">订阅号</form:option>
                        </form:select>
                </td>
            </tr>
            <tr>
                <td>接口URL:</td>
                <td><form:input path="fdIntUrl"/></td>
            </tr>
            <tr>
                <td>Token:</td>
                <td><form:input path="fdIntToken" readonly="true"/></td>
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
                    <ul>
                        <li>
                            <span> 省份 </span>
                            <select class="kitjs-form-suggestselect"></select>
                            <span> 市/县 </span>
                            <select class="kitjs-form-suggestselect"></select>
                            <span> 区 </span>
                            <select class="kitjs-form-suggestselect"></select>
                        </li>
                    </ul>
                    <form:hidden path="fdArea"/>
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
                <td><form:textarea path="fdInfo"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="保存" onclick="setArea();"/>
                </td>
            </tr>
        </table>
        <script>
            var a = $kit.els8cls($kit.ui.Form.ComboBox.Select.defaultConfig.transformCls), a1 = [];
            for (var i = 0; i < a.length; i++) {
                a1.push(a[i])
            }
            a = a1;
            var b1 = new $kit.ui.Form.ComboBox.Select({
                el: a[0],
                data: (function () {
                    var provTreeDict = new TreeDict();
                    for (var prov in chinaJSON) {
                        provTreeDict.ad(prov, prov);
                    }
                    return provTreeDict;
                })()
            });
            b1.transform();
            b1.ev({
                ev: 'change',
                fn: function () {
                    var prov = chinaJSON[b1.inputEl.value];
                    if (prov == null) {
                        return;
                    }
                    var cityTree = new TreeDict();
                    for (var city in prov) {
                        cityTree.ad(city, city);
                    }
                    b2.inputEl.value = '';
                    b2.formEl.value = '';
                    b2.config.data = cityTree;
                    b2.list.buildList(cityTree.search(''));
                }
            });
            var b2 = new $kit.ui.Form.ComboBox.Select({
                el: a[1],
                data: undefined
            });
            b2.transform();
            b2.ev({
                ev: 'change',
                fn: function () {
                    var city = chinaJSON[b1.inputEl.value][b2.inputEl.value];
                    if (city == null) {
                        return;
                    }
                    var districtTree = new TreeDict();
                    for (var district in city) {
                        districtTree.ad(district, city[district]);
                    }
                    b3.inputEl.value = '';
                    b3.formEl.value = '';
                    b3.config.data = districtTree;
                    b3.list.buildList(districtTree.search(''));
                }
            });
            var b3 = new $kit.ui.Form.ComboBox.Select({
                el: a[2],
                data: undefined
            });
            b3.transform();
            var fdArea = document.getElementById("fdArea").value;
            if(fdArea != null && fdArea.length > 0){
                var areas = fdArea.split(":");
                b1.inputEl.value = areas[0];
                b2.inputEl.value = areas[1];
                b3.inputEl.value = areas[2];
            }


            function setArea(){
                if(b1.inputEl.value != null && b1.inputEl.value.length>0){
                    var area = b1.inputEl.value+":"+b2.inputEl.value+":"+b3.inputEl.value;
                    document.getElementById("fdArea").value=area;
                }
            }
        </script>
    </form:form>
</div>
</body>
</html>