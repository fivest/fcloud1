<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <script src="/public/js/jquery.min.js"></script>
    <title>Demo Main 编辑</title>
</head>
<body>
<h1 style="text-align: center;">默认规则设置</h1>

<div style="text-align: center; margin: 50px auto;">
    <form:form action="/weservice/we_rule_reply_default/save" method="POST"
               commandName="model">
        <input type="hidden" id="fdArea" name="fdArea"/>
        <table>
            <tr>
                <td>默认关注回复：</td>
                <td>
                    <select id="default_one_type">
                        <option value="1">文本</option>
                        <option value="2">单图文</option>
                        <option value="3">多图文</option>
                    </select>
                </td>
                <td>
                    <textarea id="default_one_text" style="width: 100%"></textarea>
                </td>
                <td>
                    <input type="checkbox" id="default_one_use"/>
                    <input type="hidden" id="default_one_id"/>
                </td>
            </tr>
            <tr>
                <td>默认取消关注回复：</td>
                <td>
                    <select id="default_two_type">
                        <option value="1">文本</option>
                        <option value="2">单图文</option>
                        <option value="3">多图文</option>
                    </select>
                </td>
                <td>
                    <textarea id="default_two_text" style="width: 100%"></textarea>
                </td>
                <td>
                    <input type="checkbox" id="default_two_use"/>
                    <input type="hidden" id="default_two_id"/>
                </td>
            </tr>
            <tr>
                <td>默认无匹配回复：</td>
                <td>
                    <select id="default_three_type">
                        <option value="1">文本</option>
                        <option value="2">单图文</option>
                        <option value="3">多图文</option>
                    </select>
                </td>
                <td>
                    <textarea id="default_three_text" style="width: 100%"></textarea>
                </td>
                <td>
                    <input type="checkbox" id="default_three_use"/>
                    <input type="hidden" id="default_three_id"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="保存" onclick="setInfos();"/>
                </td>
            </tr>
        </table>

        <script>
            $(function () {
                initInfos();
            })

            function initInfos() {
                var areaInfo = ${requestScope.fdArea};
                $("#default_one_id").val(areaInfo.default_id1);
                $("#default_one_type").val(areaInfo.default_type1);
                $("#default_one_text").val(areaInfo.default_text1);
                if (areaInfo.default_use1 == 1) {
                    $("#default_one_use").attr("checked", true);
                }

                $("#default_two_id").val(areaInfo.default_id2);
                $("#default_two_type").val(areaInfo.default_type2);
                $("#default_two_text").val(areaInfo.default_text2);
                if (areaInfo.default_use2 == 1) {
                    $("#default_two_use").attr("checked", true);
                }

                $("#default_three_id").val(areaInfo.default_id3);
                $("#default_three_type").val(areaInfo.default_type3);
                $("#default_three_text").val(areaInfo.default_text3);
                if (areaInfo.default_use3 == 1) {
                    $("#default_three_use").attr("checked", true);
                }

            }
            function setInfos() {
                var default_id1 = $("#default_one_id").val();
                var default_type1 = $("#default_one_type").val();
                var default_text1 = $("#default_one_text").val();
                var default_use1 = 0;
                if ($("#default_one_use").is(":checked") == true) {
                    default_use1 = 1;
                }

                var default_id2 = $("#default_two_id").val();
                var default_type2 = $("#default_two_type").val();
                var default_text2 = $("#default_two_text").val();
                var default_use2 = 0;
                if ($("#default_two_use").is(":checked") == true) {
                    default_use2 = 1;
                }

                var default_id3 = $("#default_three_id").val();
                var default_type3 = $("#default_three_type").val();
                var default_text3 = $("#default_three_text").val();
                var default_use3 = 0;
                if ($("#default_three_use").is(":checked") == true) {
                    default_use3 = 1;
                }
                var defInfo = {default_id2: default_id2, default_id1: default_id1, default_id3: default_id3, default_type1: default_type1, default_text1: default_text1, default_use1: default_use1, default_type2: default_type2, default_text2: default_text2, default_use2: default_use2, default_type3: default_type3, default_text3: default_text3, default_use3: default_use3};
                $("#fdArea").attr("value", JSON.stringify(defInfo));
                return false;
            }
        </script>
    </form:form>
</div>
</body>
</html>