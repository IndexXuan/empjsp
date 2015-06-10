<%@page import="dao.*,util.*,entity.*,java.util.*,java.text.SimpleDateFormat" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<html>
	<body>
	
					<div id="header">
						<div id="rightheader">
							<p>
								<%Date date = new Date();
								SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");%>
								<%=sdf.format(date)%>	
													<%
						User u=(User)session.getAttribute("user");
						if(u!=null){
                            out.println("<a href='logout'>退出</a>");
						}
					%>					            								
								<br />								
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="/empjsp/login.jsp">主页面</a>				      
							</h1>
												<h4>
					<%
						User u1=(User)session.getAttribute("user");
						if(u1==null){
							response.sendRedirect("login.jsp");
							return;
						}
					%>
						欢迎!<%=u1.getUsername() %>
					</h4>
						</div>
						<div id="navigation">
						</div>
					</div>
</body>
</html>