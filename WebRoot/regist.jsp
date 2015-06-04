<%@page import="dao.*,util.*,entity.*,java.util.*,java.text.SimpleDateFormat" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%Date date = new Date();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
								String nowdate=sdf.format(date);
								%>
								<%=nowdate%>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">主页面</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="regist.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
			                        <%String msg=(String)request.getAttribute("regist_error"); %>
			                        <span style="color: red; font-style:italic;"><%= (msg == null ? "" : msg) %></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="image" />
									<a href="javascript:;" onclick="document.getElementById('num').src = 'image?'+(new Date()).getTime()">换一张</a>
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				i@yyork.cn
				</div>
			</div>
		</div>
	</body>
</html>
