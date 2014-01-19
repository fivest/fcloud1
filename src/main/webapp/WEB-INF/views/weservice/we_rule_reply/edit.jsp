<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<link href="/public/css/qqcss/base1a003d.css" type="text/css" rel="stylesheet">
<link href="/public/css/qqcss/lib19e425.css" type="text/css" rel="stylesheet">

<html>
<head>
    <title>Demo Main 编辑</title>
</head>
编辑界面
<body class="zh_cn">
<form:form action="/weservice/we_rule_reply/weRuleReply" method="POST">
    <div class="body page_appmsg_edit" id="body">
        <div class="container_box side_l" id="js_container_box">
            <div class="col_main">
                <div class="main_bd">
                    <div class="inner_container_box side_r split">
                        <div class="inner_main">
                                <table id="replay_table" class="table">
                                    <tr>
                                        <td class="replay_td">
                                            <label class="frm_label">序号</label>
                                        </td>
                                        <td class="replay_td">
                                            <label class="frm_label">启用</label>
                                        </td>
                                        <td class="replay_td">
                                            <label  class="frm_label">关键字</label>
                                        </td>
                                        <td class="replay_td">
                                            <label  class="frm_label">匹配方式</label>
                                        </td>
                                        <td class="replay_td">
                                            <label class="frm_label">回复类型</label>
                                        </td>
                                        <td class="replay_td">
                                            <label  class="frm_label">回复内容</label>
                                        </td>
                                        <td class="replay_td">
                                            <label  class="frm_label">操作</label>
                                        </td>
                                    </tr>
                                </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        var rulereplyitems = ${rulereplyitem};
    </script>
    <script type="text/javascript" src="/public/js/seajs/sea.js"></script>
    <script type="text/javascript" src="/public/js/jquery.min.js"></script>
    <script type="text/javascript" src="/public/js/list/replay.html.js"></script>
    <%--<script type="text/javascript">--%>
        <%--seajs.config({--%>
            <%--alias: {--%>
                <%--'jquery': 'public/js/jquery.min.js',--%>
                <%--'$': 'public/js/jquery.min.js'--%>
            <%--}--%>
        <%--});--%>

        <%--seajs.use("/public/js/list/replay.html.js");--%>
    <%--</script>--%>

</form:form>
</body>

</html>