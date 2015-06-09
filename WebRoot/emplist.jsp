<%@page import="dao.*,util.*,entity.*,java.util.*" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>员工信息列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>		<div id="wrap">
			<div id="top_content"> 
				<%@include file="head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
					<%
						User u=(User)session.getAttribute("user");
						if(u==null){
							response.sendRedirect("login.jsp");
							return;
						}
					%>
						欢迎!<%=u.getUsername() %>
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
            <%@include file="foot.jsp" %>
		</div>
	</body>
</html>
