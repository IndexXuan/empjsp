package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DAOFactory;

import dao.EmployeeDAO;
import dao.UserDao;
import entity.Employee;
import entity.User;

public class SomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行相对应的数据库操作
		if (path.equals("/add")) {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory
					.getInstance("EmployeeDAO");
			Employee eps = new Employee();
			eps.setName(req.getParameter("name"));

			eps.setSalary(Double.parseDouble(req.getParameter("salary")));
			eps.setAge(Integer.parseInt(req.getParameter("age")));
			try {
				dao.save(eps);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect("list.do");
		}else if (path.equals("/list")) {
			// 使用dao访问数据库
			EmployeeDAO dao = (EmployeeDAO) DAOFactory
					.getInstance("EmployeeDAO");
			// 通过dao找到所有员工
			List<Employee> emps;
			try {
				emps = dao.findAll();
				// 将emps传给emplist.jsp 由jsp负责显示页面
				// 1,绑定数据
				req.setAttribute("emps", emps);
				RequestDispatcher rd = req.getRequestDispatcher("emplist.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (path.equals("/del")) {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory
					.getInstance("EmployeeDAO");
			Long id = Long.parseLong(req.getParameter("id"));
			try {
				dao.delete(id);
				resp.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (path.equals("/edit")) {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory
					.getInstance("EmployeeDAO");
			long id = Long.parseLong(req.getParameter("id"));
			try {
				Employee emps = dao.findById(id);
				req.setAttribute("emps", emps);
				RequestDispatcher rd = req.getRequestDispatcher("updateEmp.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (path.equals("/update")) {
			Long id = Long.parseLong(req.getParameter("id"));
			String name = req.getParameter("name");
			double salary = Double.parseDouble(req.getParameter("salary"));
			int age = Integer.parseInt(req.getParameter("age"));
			Employee eps = new Employee();
			eps.setId(id);
			eps.setName(name);
			eps.setSalary(salary);
			eps.setAge(age);
			EmployeeDAO dao = (EmployeeDAO) DAOFactory
					.getInstance("EmployeeDAO");
			try {
				dao.update(eps);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect("list.do");
		}else if(path.equals("/regist")){
			UserDao dao=new UserDao();
			String username=req.getParameter("username");
			//查看用户名是否被使用	
			User u=dao.findByUsername(username);
			if(u==null){
				//此用户名可以使用
				//将表单传入的数据获取并封装成一个user对象
				User user=new User();
				user.setGendar(req.getParameter("sex"));
				user.setName(req.getParameter("name"));
				user.setPwd(req.getParameter("pwd"));
				user.setUsername(username);
				dao.save(user);
				resp.sendRedirect("main.jsp");
			}else{
				//用户名已经存在
				/**将提示信息绑定到request中，并且转发到regist.jsp页面
				 * 此时jsp页面就能获取到报错信息，用于在span中显示*/
				req.setAttribute("regist_error", "此用户名已经存在");
				req.getRequestDispatcher("regist.jsp").forward(req, resp);
			}
		}else if(path.equals("/login")){
			UserDao dao=new UserDao();
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			User u=dao.findByUsername(name);
			if(u==null){
				req.setAttribute("username_error", "此用户名不存在");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else if(!u.getPwd().equals(pwd)){
				req.setAttribute("pwd_error", "密码不正确");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else{
				HttpSession session = req.getSession(); 
				session.setAttribute("user", u); 
				resp.sendRedirect("list.do");
			}
		}
	}
}
