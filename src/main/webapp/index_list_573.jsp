<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>fcloud首页</title>

<link href="public/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<link href="public/css/bootstrap/offcanvas.css" rel="stylesheet">

</head>

<body>
	<div class="navbar navbar-fixed-top navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">fcloud</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">公众号管理</a></li>
					<li><a href="#about">后台管理</a></li>
					
				</ul>
			    <div class="navbar-form navbar-right">
					<div class="btn-group">
						<button type="button" class="btn btn-info btn-sm">张三</button>
						<button type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown">
					    <span class="caret"></span>
					    <span class="sr-only">菜单</span>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">编辑</a></li>
							<li><a href="#">注销</a></li>
						</ul>
					</div>
					，你好，
					当前公众号：
					<div class="btn-group">
						<button type="button" class="btn btn-info btn-sm">测试公众号1</button>
						<button type="button" class="btn btn-info btn-sm dropdown-toggle" data-toggle="dropdown">
					    <span class="caret"></span>
					    <span class="sr-only">菜单</span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="aa">
							<li><a href="#">测试公众号2</a></li>
							<li><a href="#">测试公众号3</a></li>
							<li><a href="#">测试公众号4</a></li>
							<li class="divider"></li>
							<li><a href="#">编辑</a></li>
							<li><a href="#">新增</a></li>
						</ul>
					</div>
			    </div>

			</div>
			<!-- /.nav-collapse -->
		</div>
		<!-- /.container -->
	</div>
	<!-- /.navbar -->

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-left">
			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar"
				role="navigation">
				<div class="well sidebar-nav">
					<ul class="nav">
						<li>规则设置</li>
						<li class="active"><a href="#">默认规则</a></li>
						<li><a href="#">自定义规则</a></li>
						<li>素材库</li>
						<li><a href="#">文本</a></li>
						<li><a href="#">单图文</a></li>
						<li><a href="#">多图文</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->

			<div class="col-xs-12 col-sm-9">
				<p class="pull-left visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">菜单</button>
				</p>

				<div class="row">
					<ol class="breadcrumb">
						<li><a href="#">Home</a></li>
						<li><a href="#">Library</a></li>
						<li class="active">Data</li>
					</ol>
					<div class="table-responsive">
				        <table class="table table-bordered">
				          <thead>
				            <tr>
				              <th>#</th>
				              <th>Table heading</th>
				              <th>Table heading</th>
				              <th>Table heading</th>
				              <th>Table heading</th>
				              <th>Table heading</th>
				              <th>Table heading</th>
				            </tr>
				          </thead>
				          <tbody>
				            <tr>
				              <td>1</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				            </tr>
				            <tr>
				              <td>2</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				            </tr>
				            <tr>
				              <td>3</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				            </tr>
				            <tr>
				              <td>1</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				            </tr>
				            <tr>
				              <td>2</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				            </tr>
				            <tr>
				              <td>3</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				              <td>Table cell</td>
				            </tr>				            
				            
				          </tbody>
				        </table>
				     </div>
<ul class="pagination">
  <li class="disabled"><a href="#">&laquo;</a></li>
  <li class="active"><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#">&raquo;</a></li>
</ul>

				</div>
				<!--/row-->
			</div>
			<!--/span-->
		</div>
		<!--/row-->

		<hr>
		<footer>
			<p>&copy; fcloud 2014</p>
		</footer>

	</div>
	<!--/.container-->

	<!-- JS库
	================================================== -->
	<script src="public/js/jquery.min.js"></script>
	<script src="public/js/bootstrap/bootstrap.min.js"></script>
	<script src="public/js/bootstrap/offcanvas.js"></script>
</body>
</html>