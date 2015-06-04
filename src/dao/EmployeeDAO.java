package dao;

import java.util.List;

import entity.Employee;

/** DAO�ӿ� �淶�˶����ݿ�����в��� */
public interface EmployeeDAO {
	// ����Ա��
	public void save(Employee e)throws Exception;

	// ɾ��Ա��
	public void delete(long id)throws Exception;

	// ����id����
	public Employee findById(long id)throws Exception;

	// �޸�
	public void update(Employee e)throws Exception;

	// ��ѯ����Ա��
	public List<Employee> findAll() throws Exception;
}
