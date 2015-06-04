package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// ��ȡ������
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���ƶ����ݿ������
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/indexxuan?userUnicode=true&characterEncoding-utf8", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// �ر�����
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
