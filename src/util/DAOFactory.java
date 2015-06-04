package util;

/** dao������Ϊ�������ṩdaoʵ�����ʵ�� */
public class DAOFactory {
	// �����ȡʵ���ķ���
	public static Object getInstance(String type) {
		Object obj = null;
		// ���ݽӿ����ҵ���Ӧ������
		String className = ConfigUtil.getValue(type);
		// ʹ�÷��䴴��ʵ��
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}