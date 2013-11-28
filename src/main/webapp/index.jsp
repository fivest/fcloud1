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
		});

		// ACCORDION - in the West pane
		$("#tree1").accordion({
			heightStyle:	"fill"
		});


		$('#switcher').themeswitcher();
		setTimeout( myLayout.resizeAll, 1000 ); /* allow time for browser to re-render with new theme */

	});







	function openCenterIframe(obj,url){
		var u_data=new Date().getTime();
		$('#centerIframe').attr('src', url+"?"+u_data);
		$('#demo1 a.selected').removeClass('selected');
		$('#errReport a.selected').removeClass('selected');
		$('#errProcess a.selected').removeClass('selected');
		$(obj).children().addClass('selected');
	}




	</script>
</head>
<body>

<div class="ui-layout-north ui-widget-content" style="display: none;">
	<div id="switcher" style="float: right; margin-right: 60px;"></div>
	FCloud System
</div>

<div class="ui-layout-south ui-widget-content" style="text-align:center; display: none;">© 2013 FCloud版权所有</div>


<div class="ui-layout-center" style="display: none;">
	<h3 class="ui-widget-header">测试DEMO</h3>
	<iframe id="centerIframe" width="100%" height="100%" border="0" frameborder="no"></iframe>
</div>






<div class="ui-layout-west" style="display: none;">
	<div id="tree1" class="basic">

			<h3><a href="#">DEMO1</a></h3>
			<div>
                <div class="dd-nav" style="padding: 4px 3px 4px 1px;">
                    <dd id="demo1" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/demo');"><a href="#">DEMO1</a></dd>
                    
                    <dd id="errReport" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/sccn/errReport');"><a href="#">故障上报</a></dd>
                    <dd id="errProcess" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/sccn/errProcess');"><a href="#">故障处理</a></dd>
					
					
					<dd id="errProcess" onclick="javascript:openCenterIframe(this,'<%=request.getContextPath()%>/wechat/app/cihezh/canzhanshang');"><a href="#">参展商</a></dd>
                </div>
			</div>

			<h3><a href="#">Section 2</a></h3>
			<div>
				<h5>Sed Non Urna</h5>
				<p>Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus.
					Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit,
					faucibus interdum tellus libero ac justo.</p>
				<p>Vivamus non quam. In suscipit faucibus urna.</p>
			</div>

	</div>
</div>












</body>
</html>