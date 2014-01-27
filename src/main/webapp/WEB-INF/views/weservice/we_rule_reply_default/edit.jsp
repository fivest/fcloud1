<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<html>
<head>
    <script src="/public/js/jquery.min.js"></script>
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
                    <select id="default_type1" onchange="setDiv('1');">
                        <option value="1">文本</option>
                        <option value="2">单图文</option>
                        <option value="3">多图文</option>
                    </select>
                </td>
                <td>
                    <div id="div_text1">
                    	<textarea id="default_text1" style="width: 100%"></textarea>
                	</div>
                	<div id="div_pic1" style="display:none">
                		<select id="default_text1">
	                    </select>
                	</div>
                </td>
                <td>
                    <input type="checkbox" id="default_use1"/>
                    <input type="hidden" id="default_id1"/>
                </td>
            </tr>
            <tr>
                <td>默认取消关注回复：</td>
                <td>
                    <select id="default_type2" onchange="setDiv('2');">
                        <option value="1">文本</option>
                        <option value="2">单图文</option>
                        <option value="3">多图文</option>
                    </select>
                </td>
                <td>
                    <div id="div_text2">
                    	<textarea id="default_text2" style="width: 100%"></textarea>
                	</div>
                	<div id="div_pic2" style="display:none">
                		<select id="default_text2">
	                    </select>
                	</div>
                </td>
                <td>
                    <input type="checkbox" id="default_use2"/>
                    <input type="hidden" id="default_id2"/>
                </td>
            </tr>
            <tr>
                <td>默认无匹配回复：</td>
                <td>
                    <select id="default_type3" onchange="setDiv('3');">
                        <option value="1">文本</option>
                        <option value="2">单图文</option>
                        <option value="3">多图文</option>
                    </select>
                </td>
                <td>
                	<div id="div_text3">
                    	<textarea id="default_text3" style="width: 100%"></textarea>
                	</div>
                	<div id="div_pic3" style="display:none">
                		<select id="default_text3">
	                    </select>
                	</div>
                </td>
                <td>
                    <input type="checkbox" id="default_use3"/>
                    <input type="hidden" id="default_id3"/>
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
                $("#default_id1").val(areaInfo.default_id1);
                $("#default_type1").val(areaInfo.default_type1);
                if(areaInfo.default_type1 != 1){
                	$("#div_text1").hide();
                	$("#div_pic1").show();
                }
                $("#default_text1").val(areaInfo.default_text1);
                if (areaInfo.default_use1 == 1) {
                    $("#default_use1").attr("checked", true);
                }

                $("#default_id2").val(areaInfo.default_id2);
                $("#default_type2").val(areaInfo.default_type2);
                if(areaInfo.default_type2 != 1){
                	$("#div_text2").hide();
                	$("#div_pic2").show();
                }
                $("#default_text2").val(areaInfo.default_text2);
                if (areaInfo.default_use2 == 1) {
                    $("#default_use2").attr("checked", true);
                }

                $("#default_id3").val(areaInfo.default_id3);
                $("#default_type3").val(areaInfo.default_type3);
                if(areaInfo.default_type1 != 1){
                	$("#div_text3").hide();
                	$("#div_pic3").show();
                }
                $("#default_text3").val(areaInfo.default_text3);
                if (areaInfo.default_use3 == 1) {
                    $("#default_use3").attr("checked", true);
                }

            }
            function setInfos() {
                var default_id1 = $("#default_id1").val();
                var default_type1 = $("#default_type1").val();
                var default_text1 = $("#default_text1").val();
                var default_use1 = 0;
                if ($("#default_use1").is(":checked") == true) {
                    default_use1 = 1;
                }

                var default_id2 = $("#default_id2").val();
                var default_type2 = $("#default_type2").val();
                var default_text2 = $("#default_text2").val();
                var default_use2 = 0;
                if ($("#default_use2").is(":checked") == true) {
                    default_use2 = 1;
                }

                var default_id3 = $("#default_id3").val();
                var default_type3 = $("#default_type3").val();
                var default_text3 = $("#default_text3").val();
                var default_use3 = 0;
                if ($("#default_use3").is(":checked") == true) {
                    default_use3 = 1;
                }
                var defInfo = {default_id2: default_id2, default_id1: default_id1, default_id3: default_id3, default_type1: default_type1, default_text1: default_text1, default_use1: default_use1, default_type2: default_type2, default_text2: default_text2, default_use2: default_use2, default_type3: default_type3, default_text3: default_text3, default_use3: default_use3};
                $("#fdArea").attr("value", JSON.stringify(defInfo));
                return false;
            }
            
            function setDiv(obj){
            	var index = obj;
            	alert(index);
            	var default_type = $("#default_type"+index).val();
            	if(default_type == "1"){
            		$("#div_text"+index).show();
                	$("#div_pic"+index).hide();
                	$("#default_text"+index,$("#div_pic"+index)).val("");
            	}else{
            		$("#div_text"+index).hide();
                	$("#div_pic"+index).show();
                	$("#default_text"+index,$("#div_text"+index)).val("");
            	}
            }
            
            function setPicInfo(obj){
            	
            }
        </script>
    </form:form>
</div>
</body>
</html>