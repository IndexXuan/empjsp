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
					<%@include file="head.jsp" %>
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
            <%@include file="foot.jsp" %>
		</div>
	</body>
</html>
