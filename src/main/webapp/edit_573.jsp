<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>fcloud编辑页面</title>

<link href="public/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="public/frame/datetimepicker/jquery.datetimepicker.css" rel="stylesheet">

<style>
body {
  padding-top: 30px;
}
.che-rad-inline {
display: inline-block;
padding-right: 15px;
margin-bottom: 0;
font-weight: normal;
vertical-align: middle;
cursor: pointer;
line-height: 1.6;
}
</style>


</head>
<body >

<form method="post" action="" name="">

 
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">菜单</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">自定义规则</a>
    </div>
    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li> 
<input type="button" value="提交" class="btn btn-info navbar-btn" onclick="return _doClick('48257C690025B126.d76951e97f69f82d48257c69002a6cd9/$Body/0.146E', this, null)"> &nbsp;</li>
        <li> 
<input type="button" value="关闭" class="btn btn-default navbar-btn" onclick="return _doClick('48257C690025B126.d76951e97f69f82d48257c69002a6cd9/$Body/0.1544', this, null)"> &nbsp;</li>
      </ul>
    </div>
  </div>
</div>
 
<div class="container">
  <!-- title -->
  <div class="page-header">
    <h1>Example page header</h1>
  </div>
 
  <!-- tabs -->
  <ul class="nav nav-pills nav-tabs" id="thisTab">
    <li class="active"><a href="#base" data-toggle="tab">基本信息</a></li>
    <li><a href="#content" data-toggle="tab">审批内容</a></li>
    <li><a href="#flow" data-toggle="tab">流程</a></li>
  </ul>
 
<div class="tab-content">
  <!-- base -->
  <div class="tab-pane panel panel-info active" id="base">
    <div class="table-responsive">
<table class="table table-bordered" border="1">
<tr valign="top"><td width="270">文本</td><td width="270">
<input name="_22f7ds4tht89spog_" value="" class="form-control"></td><td width="270">日期时间</td><td width="270">
<input name="dtp_input1" value="" id="dtp_input1" class="form-control" style="width:150"></td></tr>

<tr valign="top"><td width="270">单选</td><td width="270">
<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
    Option one is this and that&mdash;be sure to include why it's great
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
    Option two can be something else and selecting it will deselect option one
  </label>
</div>

</td><td width="270">日期</td><td width="270">
<input name="dtp_input2" value="" id="dtp_input2" class="form-control" style="width:150"></td></tr>

<tr valign="top"><td width="270">多选</td><td width="270">
<label class="checkbox-inline">
  <input type="checkbox" id="inlineCheckbox1" value="option1"> 1
</label>
<label class="checkbox-inline">
  <input type="checkbox" id="inlineCheckbox2" value="option2"> 2
</label>
<label class="checkbox-inline">
  <input type="checkbox" id="inlineCheckbox3" value="option3"> 3
</label>


</td><td width="270">时间</td><td width="270">
<input name="dtp_input3" value="" id="dtp_input3" class="form-control" style="width:150">

</td></tr>

<tr valign="top"><td width="270">下拉</td><td width="270">
<select class="form-control">
  <option>1</option>
  <option>2</option>
  <option>3</option>
  <option>4</option>
  <option>5</option>
</select>
</td><td width="270"></td><td width="270"></td></tr>

</table>
    </div>
  </div>
  <!-- content -->
  <div class="tab-pane panel panel-info" id="content">
    <div class="table-responsive">
aaaaaaaaaaaaa
    </div>
  </div>
  <!-- flow -->
  <div class="tab-pane panel panel-info" id="flow">
    <div class="table-responsive">
bbbbbbbbbb
    </div>
  </div>
</div>
 
</div>
 
 
 

</form>







	<!-- JS库
	================================================== -->
	<script src="public/js/jquery.min.js"></script>
	<script src="public/js/bootstrap/bootstrap.min.js"></script>
	<script src="public/frame/datetimepicker/jquery.datetimepicker.js"></script>
	
<script>
$(function(){
	$("label:has(input[type='radio'])").addClass("che-rad-inline");
	$("label:has(input[type='checkbox'])").addClass("che-rad-inline");

	//see more: http://xdsoft.net/jqplugins/datetimepicker
	$('#dtp_input1').datetimepicker({
		format: 'Y-m-d H:i'
		,timepicker: true		//允许时间
		,onChangeDateTime: function(dp,$input){
			//alert("所选时间="+$input.val());
			//$('#dtp_input1').datetimepicker('hide');
		}
	});

	$('#dtp_input2').datetimepicker();

	$('#dtp_input3').datetimepicker({
		format: 'H:i'
		,datepicker: false		//不允许日期
		,timepicker: true		//允许时间
		,onChangeDateTime: function(dp,$input){
			//alert("所选时间="+$input.val());
			//$('#dtp_input1').datetimepicker('hide');
		}
	});

	
	
	
}); 

	
	
</script>
</body>
</html>
