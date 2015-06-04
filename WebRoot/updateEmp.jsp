<%@page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>修改员工信息</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%=request.getAttribute("date") %>
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
						更改以下员工信息:
					</h1>
					<%
						Employee e= (Employee)request.getAttribute("emps");
					%>
					<form action="update.do?id=<%=e.getId() %>" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									工号:
								</td>
								<td valign="middle" align="left">
									<%=e.getId() %>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="<%=e.getName() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									薪水:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="<%=e.getSalary() %>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="<%=e.getAge() %>"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确认" />
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
