<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="row">
		<ul class="clearfix">
			<li class="col-md-3"><a herf="/user/welcome"><img class="logo"
					src="/web/images/logo1.png" onclick="window.location.href = '/user/welcome'"></a></li>
		</ul>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="navbar-default navbar-h " id="navbar-example">
			<div class="container ">
				<div class="nav navbar-nav navbar-left nav-h">欢迎登录！</div>
				<ul class="nav navbar-nav navbar-right nav-h">
					<!-- <li class="dropdown" id="fat-menu"><a data-toggle="dropdown"
						class="dropdown-toggle" herf="#"> 天空 软件<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a herf="#" tabindex="-1">天空</a></li>
							<li><a herf="#" tabindex="-1">天空</a></li>
							<li><a herf="#" tabindex="-1">天空</a></li>
							<li><a herf="#" tabindex="-1">天空</a></li>
						</ul></li>
					<li><a class="" herf="#">企业订单</a></li>
					<li><a class="" herf="#">手机版</a></li>
					<li><a class="" herf="#">通力社区</a></li>
					<li><a class="" herf="#"><i class="icon-camera-retro"></i>400-000-000</a></li> -->
					<li class="dropdown" id="fat-menu"><a data-toggle="dropdown"
						class="dropdown-toggle" herf="#"> ${sessionScope.loginUser.name }<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="/user/loginOut">退出</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>