package priv.sen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	/**
	 * ��ȡconn����
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConn() throws ClassNotFoundException, SQLException {
		Connection conn;
		// 1.����������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.��ȡ����
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "zhangxueyou", "123");
		return conn;
	}

	/**
	 * �ر����ݿ���Դ
	 * @param set
	 * @param statement
	 * @param conn
	 */
	public static void close(ResultSet set, PreparedStatement statement, Connection conn) {
		if (set != null)
			try {
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
