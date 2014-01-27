<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://www.fcloud.com/taglib/fn" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<link href="/public/css/qqcss/base1a003d.css" type="text/css" rel="stylesheet">
<link href="/public/css/qqcss/lib19e425.css" type="text/css" rel="stylesheet">
<link href="/public/css/qqcss/ueditor19fb55.css" type="text/css" rel="stylesheet">
<link href="/public/css/qqcss/appmsg_edit19e425.css" type="text/css" rel="stylesheet">
<script src="/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript" defer="defer"></script>
<link href="/public/css/qqcss/ueditor.css" type="text/css" rel="stylesheet">

<html>
<head>
    <title>Demo Main 编辑</title>
</head>
编辑界面
<body class="zh_cn">
<form:form action="/weservice/we_rule_reply_pictext/save" method="POST"
           commandName="model" enctype="multipart/form-data">
    <form:hidden path="id"/>
    <input type="hidden" id="ruleReplyId" name="ruleReplyId" value="${requestScope.ruleReplyId}"/>
    <input type="hidden" id="picitems" name="picitems" value=""/>
    <div class="body page_appmsg_edit" id="body">
        <div class="container_box side_l" id="js_container_box">
            <div class="col_main">
                <div class="main_bd">
                    <div class="media_preview_area">
                        <div class="appmsg  editing">
                            <div id="js_appmsg_preview" class="appmsg_content">
                            </div>
                        </div>
                    </div>
                    <div id="js_appmsg_editor" class="media_edit_area">
                    </div>
                    <div class="tool_area">
                        <div class="tool_bar"><span id="js_preview" class="btn btn_input btn_primary"><button>预览
                        </button></span> <span id="js_submit" class="btn btn_input btn_primary"><button>保存
                        </button></span></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
        window.wx = {
        };
    </script>
    <%--<script type="text/javascript" src="/public/js/list/wx19e425.js"></script>--%>
    <script type="text/javascript" src="/public/js/seajs/sea.js"></script>
    <script type="text/javascript" src="/public/js/pic/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="/public/js/pic/ajaxfileupload.js"></script>
    <script type="text/javascript" src="/public/js/pic/template.js"></script>
    <script type="text/javascript" src="/public/js/pic/wx.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/ueditor/ueditor.all.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript">

        wx.cgiData = {};

        (function () {
            var
                    infos = ${requestScope.infos},
                    item = (infos.item && infos.item[0] ) || {};

            //wx.cgiData.app_id = "";
            wx.cgiData.type = "10";
            wx.cgiData.isMul = 1 * "0";
            wx.cgiData.appmsg_data = item;
        })();

        seajs.config({
            alias: {
                'jquery': 'public/js/jquery.min.js',
                '$': 'public/js/jquery.min.js'
            }
        });

        seajs.use("/public/js/pic/appmsg_edit");
    </script>

</form:form>
</body>

</html>