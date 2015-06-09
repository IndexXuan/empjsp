package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookieServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		String name=URLEncoder.encode("ÕÅÈý","utf-8");
		Cookie c1=new Cookie("username", name);
		Cookie c3=new Cookie("username", "");
		c3.setMaxAge(0);
		
		c1.setMaxAge(30);
		Cookie c2=new Cookie("pwd", "1234");
		resp.addCookie(c1);
		resp.addCookie(c2);
		resp.addCookie(c3);
		out.close();
		
	}
}
