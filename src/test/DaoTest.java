package test;

import dao.EmployeeDAO;
import util.DAOFactory;
import util.DBUtil;

/**���ԣ����ݿ��ܷ����� dao�Ƿ�����*/
public class DaoTest {
	public static void main(String[] args) {
		System.out.println(DBUtil.getConnection());
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.getInstance("EmployeeDAO");
		//List<Employee> emps=dao.findAll();
		try {
			dao.findAll().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
