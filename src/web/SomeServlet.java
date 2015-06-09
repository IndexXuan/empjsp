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
		// ��ȡurl��ַ
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// ���ݵ�ַ ִ�����Ӧ�����ݿ����
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
			// ʹ��dao�������ݿ�
			EmployeeDAO dao = (EmployeeDAO) DAOFactory
					.getInstance("EmployeeDAO");
			// ͨ��dao�ҵ�����Ա��
			List<Employee> emps;
			try {
				emps = dao.findAll();
				// ��emps����emplist.jsp ��jsp������ʾҳ��
				// 1,������
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
			//�鿴�û����Ƿ�ʹ��	
			User u=dao.findByUsername(username);
			if(u==null){
				//���û�������ʹ��
				//������������ݻ�ȡ����װ��һ��user����
				User user=new User();
				user.setGendar(req.getParameter("sex"));
				user.setName(req.getParameter("name"));
				user.setPwd(req.getParameter("pwd"));
				user.setUsername(username);
				dao.save(user);
				resp.sendRedirect("main.jsp");
			}else{
				//�û����Ѿ�����
				/**����ʾ��Ϣ�󶨵�request�У�����ת����regist.jspҳ��
				 * ��ʱjspҳ����ܻ�ȡ��������Ϣ��������span����ʾ*/
				req.setAttribute("regist_error", "���û����Ѿ�����");
				req.getRequestDispatcher("regist.jsp").forward(req, resp);
			}
		}else if(path.equals("/login")){
			UserDao dao=new UserDao();
			String name=req.getParameter("name");
			String pwd=req.getParameter("pwd");
			User u=dao.findByUsername(name);
			if(u==null){
				req.setAttribute("username_error", "���û���������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else if(!u.getPwd().equals(pwd)){
				req.setAttribute("pwd_error", "���벻��ȷ");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else{
				HttpSession session = req.getSession(); 
				session.setAttribute("user", u); 
				resp.sendRedirect("list.do");
			}
		}
	}
}
