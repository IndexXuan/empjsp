package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCookieServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		Cookie[] cs = req.getCookies();
		if(cs!=null){
			for(Cookie c:cs){
				String name = c.getName();
				String value = c.getValue();
				out.println("<h1>name:"+name+" value:"+URLDecoder.decode(value,"utf-8")+"</h1>");
			}
		}else{
			out.println("<h1>Ã»ÓÐcookie</h1>");
		}
	}
}
