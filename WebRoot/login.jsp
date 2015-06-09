<%@page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@include file="head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录
					</h1>
					<form action="login.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
									<%String msg=(String)request.getAttribute("username_error"); %>
									<span style="color:red;font-style:italic"><%=(msg==null?"":msg) %></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="pwd" />
									<%String msg2=(String)request.getAttribute("pwd_error"); %>
									<span style="color:red;font-style:italic"><%=(msg2==null?"":msg2) %></span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确认" />
							<input type="button"  class="button" onclick="location='regist.jsp'" value="注册">
						</p>
					</form>
				</div>
			</div>
            <%@include file="foot.jsp" %>
		</div>
	</body>
</html>
