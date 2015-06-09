package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add_FindCookieServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		Cookie[] cs = req.getCookies();
		boolean flag=false;
		if(cs!=null){//有cookie
			for(Cookie c:cs){
				if(c.getName().equals("name")){
					out.println(c.getValue());
					flag=true;//找到
				}
			}
			if(!flag){//没有找到名字为name的cookie
				Cookie c=new Cookie("name", "zs");
				resp.addCookie(c);
			}
		}else{//如果没有cookie
			Cookie c=new Cookie("name", "zs");
			resp.addCookie(c);		
		}
		out.close();
	}
}
