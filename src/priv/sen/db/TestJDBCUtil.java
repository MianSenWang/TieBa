package priv.sen.db;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import priv.sen.serviece.M_TZServiece;
import priv.sen.util.SqlPingJie;

public class TestJDBCUtil {
	
	
	private static Logger logger = Logger.getLogger(TestJDBCUtil.class);
	public static void main(String[] args) {
		
		/**
		 * 1.��ѯ����Ա�������������źźͲ�������
		 */
//		String sql2 = sql("���»�");
//		System.out.println(sql2);
//		String sql = "select * from user5";
//		String sqlTieZi = SqlPingJie.sqlYongHuMingCheng("q972383371");
//		Map<String, Object> findAll = JDBCUtil.findSingle(sqlTieZi);
//		
//		System.out.println(findAll.get("U_NAME"));
		
//		String sqlTieZi = SqlPingJie.sqlTieZi("�������ӱ���2");
//		logger.debug(sqlTieZi);
//		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlTieZi);
//		logger.debug(findAll.get(0).get("HF"));
		
		String str = "�Ұ���";
		String str2 = "��ϲ����";
		String str3 = "������";
		StringBuilder stringBuilder2 = new StringBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder2=stringBuilder.append(str+"\n");
		stringBuilder2=stringBuilder.append(str2+"\n");
		stringBuilder2=stringBuilder.append(str3);
		System.out.println(stringBuilder2);
//		
		/**
		 * 2.ѡ�������н����Ա���Ĳ������ƺ͵�ַ
		 */
//		String sql2 = "select d.dname,d.loc from mdept d,myemp e where e.comm is not null and e.deptno = d.deptno";
//		List<Map<String,Object>> findAll2 = JDBCUtil.findAll(sql2);
//		System.out.println(findAll2);
		
		/**
		 * 3.��ѯ��˾��1980-1982��֮�䣬ÿ����õ������������������
		 */
//		String sql3 = "select sum(decode (to_char (HIREDATE,'yyyy'),'1980',1,'1981',1,'1982',1)) as \"TOTAL\","
//				+ "sum(decode (to_char(HIREDATE,'yyyy'),'1980',1)) as \"1980\","
//				+ "sum(decode (to_char(HIREDATE,'yyyy'),'1981',1)) as \"1981\","
//				+ "sum(decode (to_char(HIREDATE,'yyyy'),'1982',1)) as \"1982\" from scott.emp";
//		List<Map<String,Object>> findAll3 = JDBCUtil.findAll(sql3);
//		System.out.println(findAll3);
		
		/**
		 * 4.�����й�������900��Ա���Ĺ����޸�Ϊ1000
		 */
//		String str = "update myemp set sal = 1000 where sal < 900";
//		boolean update = JDBCUtil.update(str);
//		System.out.println(update);
		
		/**
		 * 5.��emp�������е�20�ò��ŵ�����ȫ��ɾ������ʣ������ݲ���������лع���ѡ����
		 */
//		JDBCUtil.update2();
	}
	
	public static String sql(String str){
		StringBuffer sb=new StringBuffer("select * from M_ZTTB");
		
		sb.append(" and U_ZT like '%"+str+"%'");
		
		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}
}
