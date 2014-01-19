<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<link href="/public/css/qqcss/base1a003d.css" type="text/css" rel="stylesheet">
<link href="/public/css/qqcss/lib19e425.css" type="text/css" rel="stylesheet">

<html>
<head>
    <title>回复内容</title>
</head>
回复内容
<body>
<form:form action="/weservice/we_rule_reply_text/save" method="POST"
           commandName="model">
    <form:hidden path="id"/>
    <div class="body page_appmsg_edit" id="body">
        <div class="container_box side_l" id="js_container_box">
            <div class="col_main">
                <div class="main_bd">
                    <div class="inner_container_box side_r split">
                        <div class="inner_main">
                            <table id="replay_table" class="table">
                                <tr>
                                    <td class="replay_td" style="width: 9%">
                                        <label class="frm_label">回复内容：</label>
                                        <form:hidden path="fdWerulereply.id" ></form:hidden>
                                    </td>
                                    <td class="replay_td" style="width: 60%">
                                        <span class="frm_textarea_box"><form:textarea class="js_desc frm_textarea" path="fdText"></form:textarea></span>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="replay_td"  colspan="2">
                                        <input type="submit" value="保存" />
                                    </td>
                                </tr>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form:form>
</body>

</html>