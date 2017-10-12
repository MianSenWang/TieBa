package priv.sen.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import priv.sen.db2.StringUtil;

/**
 * @author 
 * MiansenWang 
 * 2017��9��16�� 
 * ����3:14:30 
 * ʵ�����������
 * ���������������ʵ����
 */
public class EntryGenerator {

	private static final String PACKAGE_NAME = "priv.sen.entry";

	/**
	 * ���Դ���
	 * @param args
	 */
	public static void main(String[] args) {

//		List<Map<String, Object>> findAll = JDBCUtil
//				.findAll("select table_name from user_tables union select view_name as table_name from user_views");
//		List<Map<String,Object>> findAll = JDBCUtil.findAll("select * from lz_user");
//		for (Map<String, Object> map : findAll) {
//			generatorEntryForTableName(map.get("TABLE_NAME").toString());
//		}
		generatorEntryForTableName("TieZi");
	}

	/**
	 * generatorEntry������ 
	 * ���ݱ�������ͼ������ʵ����
	 * �û�ֻ��Ҫ������� 
	 * sql����Զ�ƴ��
	 * @param tableName
	 */
	public static void generatorEntryForTableName(String tableName) {
		String sql = "select * from " + tableName + " where 1=2";
		tableName = StringUtil.xia2Pascle(tableName.toLowerCase());
		generatorEntry(sql, tableName);

	}

	/**
	 * ����sql��ָ������������ʵ����
	 * �û�ֻ��Ҫ����sql���ͱ��������������ݿ��ʵ����
	 * @param sql:sql���
	 * @param className:����
	 * @param PACKAGE_NAME:����
	 */
	public static void generatorEntry(String sql, String className) {
		Connection conn = null;
		PreparedStatement Statement = null;
		ResultSet resultSet = null;
		List<Menp> list = new ArrayList<>();
		try {
			conn = DBUtil.getConn();
			Statement = conn.prepareStatement(sql);
			resultSet = Statement.executeQuery();// ��ѯ
			ResultSetMetaData metaData = resultSet.getMetaData();// �����
			int columnCount = metaData.getColumnCount();// ������
			// ��ȡ��������������
			HashMap<String, String> dateMap = new HashMap<>();

			for (int i = 1; i <= columnCount; i++) {
				dateMap.put(metaData.getColumnName(i), metaData.getColumnClassName(i));// ����+ֵ����
			}

			FreeUtil.createEntryClassBody(dateMap, className, PACKAGE_NAME);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("��������ʵ����..."+sql + "--------" + className);
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, Statement, conn);
		}
	}
}
