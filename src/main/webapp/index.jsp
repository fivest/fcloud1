<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎访问FCloud</title>
<SCRIPT type="text/javascript" src="public/js/jquery.min.js"></SCRIPT>
<SCRIPT type="text/javascript" src="public/js/jquery-ui.min.js"></SCRIPT>
<SCRIPT type="text/javascript" src="public/js/jquery.layout.min.js"></SCRIPT>
<SCRIPT type="text/javascript" src="public/js/themeswitchertool.js"></SCRIPT>
<link type="text/css" href="public/css/themes/base/jquery.ui.all.css" rel="stylesheet" />
<link type="text/css" href="public/css/themes/layout-default-latest.css" rel="stylesheet" />

	<style type="text/css">

	/* remove padding and scrolling from elements that contain an Accordion OR a content-div */
	.ui-layout-center ,	/* has content-div */
	.ui-layout-west ,	/* has Accordion */
	.ui-layout-east ,	/* has content-div ... */
	.ui-layout-east .ui-layout-content { /* content-div has Accordion */
		padding: 0;
		overflow: hidden;
	}
	.ui-layout-center P.ui-layout-content {
		line-height:	1.4em;
		margin:			0; /* remove top/bottom margins from <P> used as content-div */
	}
	h3, h4 { /* Headers & Footer in Center & East panes */
		font-size:		1.1em;
		background:		#EEF;
		border:			1px solid #BBB;
		border-width:	0 0 1px;
		padding:		7px 10px;
		margin:			0;
	}
	.ui-layout-east h4 { /* Footer in East-pane */
		font-size:		0.9em;
		font-weight:	normal;
		border-width:	1px 0 0;
	}


	.dd-nav dd a.selected {
		background: #555;
		color:#ffffff;
		-moz-border-radius: 5px; -webkit-border-radius: 5px;
	}
	</style>


	<script type="text/javascript">
	$(document).ready( function() {

		myLayout = $('body').layout({
			west__size:			300
		,	east__size:			300
			// RESIZE Accordion widget when panes resize
		,	west__onresize:		$.layout.callbacks.resizePaneAccordions
		,	east__onresize:		$.layout.callbacks.resizePaneAccordions
		,	north__spacing_open:					0
		,	north__spacing_closed:					0
		});

		// ACCORDION - in the West pane
		$("#tree1").accordion({
			heightStyle:	"fill"
		});


		$('#switcher').themeswitcher();
		setTimeout( myLayout.resizeAll, 1000 ); /* allow time for browser to re-render with new theme */

	});






	function openCenterIframe(obj,url){
        var jObj = $(obj);
        url = url == null ? jObj.attr('data-url') : url;
		var u_data=new Date().getTime();
		$('#centerIframe').attr('src', url+"?"+u_data);
		$('.dd-nav dd a.selected').removeClass('selected');
		$(obj).children().addClass('selected');
	}



	</script>
</head>
<body>

<div class="ui-layout-north ui-widget-content" style="display: none;overflow:hidden;">
	<div id="switcher" style="float: right; margin-right: 60px;"></div>
	FCloud System
    <div id="wepublic_div" style="float: right; margin-right: 90px;">
        公众号：
        <select id="wepublic">

        </select>
    </div>
</div>

<div class="ui-layout-south ui-widget-content" style="text-align:center; display: none;">© 2013 FCloud版权所有</div>


<div class="ui-layout-center" style="display: none;">
	<h3 class="ui-widget-header">测试DEMO</h3>
	<iframe id="centerIframe" width="100%" height="100%" border="0" frameborder="no"></iframe>
</div>






<div class="ui-layout-west" style="display: none;">
	<div id="tree1" class="basic">

            <h3><a href="#">公众号设置</a></h3>
            <div>
                <div class="dd-nav" style="padding: 4px 3px 4px 1px;">
                    <dd id="wepublic" onclick="javascript:openCenterIframe(this,'/weservice/we_public');"><a href="#">公众号</a></dd>

                    <dd id="default" onclick="javascript:openCenterIframe(this,'/weservice/we_rule_reply_default/create');"><a href="#">默认配置</a></dd>
                    <dd id="rule" onclick="javascript:openCenterIframe(this,'/weservice/we_rule_reply/create');"><a href="#">自定义配置</a></dd>

                </div>
            </div>

			<h3><a href="#">DEMO1</a></h3>
			<div>
                <div class="dd-nav" style="padding: 4px 3px 4px 1px;">
                    <dd id="demo1" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/demo');"><a href="#">DEMO1</a></dd>
                    
                    <dd id="errReport" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/sccn/errReport');"><a href="#">故障上报</a></dd>
                    <dd id="errProcess" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/sccn/errProcess');"><a href="#">故障处理</a></dd>
					
					
					<dd id="canzhanshang" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/cihezh/canzhanshang');"><a href="#">参展商</a></dd>
					<dd id="zhanhfk" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/cihezh/zhanhfk');"><a href="#">展会反馈</a></dd>
					
                </div>
			</div>

			<h3><a href="#">管理员</a></h3>
			<div>
                <div class="dd-nav" style="padding: 4px 3px 4px 1px;">
                    <dd id="users"
                        data-url="<%=request.getContextPath()%>/user"
                        onclick="openCenterIframe(this);"><a href="#">用户列表</a></dd>
                    <dd id="users"
                        data-url="<%=request.getContextPath()%>/wechat/auth/module_access"
                        onclick="openCenterIframe(this);"><a href="#">模块路径</a></dd>
                </div>
			</div>

	</div>
</div>
<script>
    $(function(){
        //初始化公众号
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/weservice/we_public/getWePublic",
            dataType: "json",
            success: function(data) {
                $.each(data,
                        function(i, item) {
                            $("#wepublic").append("<option value=" + item.publicId + " >" + item.publicName + "</option>");
                });
                if(data.length>0){
                    //为第一个option赋值&input
                    $("#wepublic").val(data[0].publicId);
                    //$("#_wpublicId option:first").attr("selected",true);
                    setWepublicToSession();
                }
            }
        })
    });
    $(function(){
       $("#wepublic").change(function(){
           setWepublicToSession();
           $("#centerIframe").attr("src", $("#centerIframe").attr("src"));
       })
    });
    function setWepublicToSession(){
        var wepublicid = $("#wepublic").val();
        $.ajax({
            type: "GET",
            url: "<%=request.getContextPath()%>/weservice/we_public/setPublicInSession",
            data:{wepublicid:wepublicid},
            dataType: "json",
            timeStamp: new Date().getTime(),
            cache: false,
            success: function(data) {
                showResult(data.result);
            }
        })
    }
    function showResult(responseText){
        if(responseText!='success'){
            alert("当前公众账号保存session失败.");
        }
    }
</script>











</body>
</html>