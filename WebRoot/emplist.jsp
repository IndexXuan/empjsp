<%@page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>员工信息列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
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
						欢迎!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								工号
							</td>
							<td>
								姓名
							</td>
							<td>
								薪水
							</td>
							<td>
								年龄
							</td>
							<td>
								操作
							</td>
						</tr>
						
						<!-- 接收传入的emps对象 -->
						<%
							List<Employee> emps=(List<Employee>)request.getAttribute("emps");
							for(int i=0;i<emps.size();i++){
							Employee e=emps.get(i);
						%>
						<tr class="row<%=(i%2+1) %>">
							<td>
								<%=e.getId() %>
							</td>
							<td>
								<%=e.getName() %>
							</td>
							<td>
								<%=e.getSalary() %>
							</td>
							<td>
								<%=e.getAge() %>
							</td>
							<td>
								<a href="del.do?id=<%=e.getId() %>">删除</a>&nbsp;<a href="edit.do?id=<%=e.getId() %>">修改</a>
							</td>
						</tr>
					<%} %>
					</table>
					<p>
						<input type="button" class="button" value="新增" onclick="location='addEmp.jsp'"/>
					</p>
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
