<%@page import="dao.*,util.*,entity.*,java.util.*,java.text.SimpleDateFormat" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<body>
	
					<div id="header">
						<div id="rightheader">
							<p>
								<%Date date = new Date();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");%>
								<%=sdf.format(date)%>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="/empjsp/login.jsp">主页面</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
</body>
</html>