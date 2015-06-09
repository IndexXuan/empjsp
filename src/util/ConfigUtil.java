package util;

import java.io.InputStream;
import java.util.Properties;

/** ��ȡproperties�ļ��Ĺ����� */
public class ConfigUtil {
	private static Properties props = new Properties();
	static {
		// 1����ȡ�������
		ClassLoader loder = ConfigUtil.class.getClassLoader();
		// 2���������ļ���������ʽ��ȡ����
		InputStream ips = loder
				.getResourceAsStream("util/daoconfig.properties");
		try {
			// 3�����������ļ�
			props.load(ips);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ�����ļ��е�����
	public static String getValue(String key) {
		return props.getProperty(key);
	}

}
