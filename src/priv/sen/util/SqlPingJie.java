package priv.sen.util;

/**
 * sql���ƴ��
 * 
 * @author sen
 *
 */
public class SqlPingJie {

	/**
	 * ģ����ѯ����
	 * 
	 * @param str
	 * @return
	 */
	public static String sqlMoHuChanXunTieBa(String str) {
		StringBuffer sb = new StringBuffer("select * from M_ZTTB");

		sb.append(" and U_ZT like '%" + str + "%'");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}

	
	/**
	 * ģ����ѯ����
	 * @param str:���ӱ���
	 * @param str2:��������
	 * @return
	 */
	public static String sqlMoHuChanXunTieZi(String str,String str2) {
		StringBuffer sb = new StringBuffer("select * from fatie");

		sb.append(" and TZBT like '%" + str + "%'");
		sb.append(" and TBZT = \'" + str2 + "\'");
		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}
	
	
	/**
	 * ��ѯ����
	 * @param str
	 * @return
	 */
	public static String sqlTieBa(String str) {
		StringBuffer sb = new StringBuffer("select * from fatie");

		sb.append(" and TBZT = \'" + str + "\' order by FA_TIE_DATE");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}

	/**
	 * ��ѯ�ظ�����
	 * @param str
	 * @return
	 */
	public static String sqlTieZi(String str,String str2) {
		StringBuffer sb = new StringBuffer(
				"select U_NAME,HUI_FU_DATE,HF from huifu");

		sb.append(" and TBZT = \'" + str + "\'");
		sb.append(" and TZBT = \'" + str2 + "\' order by HUI_FU_DATE");
//		sb.append(" and HFNAME is not null");
	
		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}

	
	/**
	 * ��ѯ����
	 * @param str
	 * @return
	 */
	public static String sqlTieZi2(String str,String str2) {
		StringBuffer sb = new StringBuffer(
				"select ZW from fatie");

		sb.append(" and TBZT = \'" + str + "\'");
		sb.append(" and TZBT = \'" + str2 + "\'");
//		sb.append(" and HFNAME is not null");
	
		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}
	
	/**
	 * �����û����������� �����û������������������ɼ�� ���뵽���ݿ�
	 * "insert into MENP (ename,job) values ('EEE','FFF')"
	 * 
	 * @param str:��������  U_ZT
	 * @param str2:��������  U_NAME
	 * @param str3 :���ɼ��  U_JIANJIE
	 * @param str4 :����ʱ��  U_DATE
	 * @return
	 */
	public static String insertTieBa(String str, String str2, String str3, String str4) {
		StringBuffer sb = new StringBuffer(
				"insert into M_ZTTB (U_ZT,U_NAME,U_JIANJIE,U_DATE) values ");

		sb.append("(\'" + str + "\',");
		sb.append("\'" + str2 + "\',");
		sb.append("\'" + str3 + "\',");
		sb.append("\'" + str4 + "\')");

		String replaceFirst = sb.toString();
		return replaceFirst;
	}

	/**
	 * TODO ���Դ���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String insertTieBa = sqlTieZi("1","3��");
		System.out.println(insertTieBa);
	}

	/**
	 * ��ѯ�û���
	 * 
	 * @param str
	 * @return
	 */
	public static String sqlYongHuMingCheng(String str) {
		StringBuffer sb = new StringBuffer("select U_NAME from M_YH");

		sb.append(" and U_NAME = \'" + str + "\'");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}

	/**
	 * �����û����������
	 * @param str6 
	 * 
	 * @param string
	 *            :�������� TBNAME
	 * @param string2
	 *            :���ӱ��� TZNAME
	 * @param string3
	 *            :���������� LZNAME
	 * @param string4
	 *            :����ʱ�� TZDATE
	 * @param string5
	 *            :�������� TZNEIRONG
	 * @return
	 */
	public static String insertTieZi(String str, String str2,
			String str3, String str4, String str5) {
		
		StringBuffer sb = new StringBuffer(
				"insert into fatie (TBZT,TZBT,U_NAME,FA_TIE_DATE,ZW) values ");

		sb.append("(\'" + str + "\',");
		sb.append("\'" + str2 + "\',");
		sb.append("\'" + str3 + "\',");
		sb.append("\'" + str4 + "\',");
		sb.append("\'" + str5 + "\')");

		String replaceFirst = sb.toString();
		return replaceFirst;
	}

	/**
	 * ����ظ�����
	 * @param str: �������� TBNAME
	 * @param str2:���ӱ��� TZNAME
	 * @param str3:������������ TZNEIRONG
	 * @param str4:�ظ�����  HFNEIRONG
	 * @param str5:�ظ������� HFNAME
	 * @param str6:�ظ�ʱ�� HFDATE
	 * @return
	 */
	public static String insertHuiFu(String str,String str2,
			String str3, String str4, String str5) {
		

		
		StringBuffer sb = new StringBuffer(
				"insert into huifu (TBZT,TZBT,U_NAME,HUI_FU_DATE,HF) values ");

		sb.append("(\'" + str + "\',");
		sb.append("\'" + str2 + "\',");
		sb.append("\'" + str3 + "\',");
		sb.append("\'" + str4 + "\',");
		sb.append("\'" + str5 + "\')");

		String replaceFirst = sb.toString();
		return replaceFirst;
	
	}
	
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param str
	 * @return
	 */
	public static String sqlMYh() {
		StringBuffer sb = new StringBuffer("select U_NAME,U_PASSWORD from M_YH");
		String replaceFirst = sb.toString();
		return replaceFirst;
	}
	
	/**
	 * �û�ע��
	 * @param str:��������  U_NAME
	 * @param str2:��������  U_PASSWORD
	 * @return
	 */
	public static String insertyongHu(String str, String str2) {
		StringBuffer sb = new StringBuffer(
				"insert into M_YH (U_NAME,U_PASSWORD) values ");

		sb.append("(\'" + str + "\',");
		sb.append("\'" + str2 + "\')");

		String replaceFirst = sb.toString();
		return replaceFirst;
	}

	
	/**
	 * �����ҵ�����
	 * @param str:�û���
	 * @return
	 */
	public static String sqlJiaZaiMyTieBa(String str) {
		

		StringBuffer sb = new StringBuffer("select * from M_ZTTB");

		sb.append(" and U_NAME = \'" + str + "\' order by U_DATE");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	
	}


	/**
	 * �����ҵ�����
	 * @param stri
	 * @return
	 */
	public static String sqlJiaZaiMyTieZi(String str) {
		
		StringBuffer sb = new StringBuffer("select * from fatie");

		sb.append(" and U_NAME = \'" + str + "\' order by FA_TIE_DATE");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	
	}
	
	/**
	 * �����ҵĻظ�
	 * @param stri
	 * @return
	 */
	public static String sqlJiaZaiMyH(String str) {
		
		StringBuffer sb = new StringBuffer("select * from huifu");

		sb.append(" and U_NAME = \'" + str + "\' order by HUI_FU_DATE");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	
	}
	
	/**
	 * ɾ���ҵ�����
	 * @param stri
	 * @return
	 */
	public static String sqlDeleteMyTieBa(String str) {
		
		StringBuffer sb = new StringBuffer("delete M_ZTTB");

		sb.append(" and U_ZT = \'" + str + "\'");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	
	}
	
	/**
	 * ɾ���ҵ�����
	 * @param stri
	 * @return
	 */
	public static String sqlDeleteMyTieZi(String str) {
		
		StringBuffer sb = new StringBuffer("delete fatie");

		sb.append(" and TZBT = \'" + str + "\'");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	
	}
	
	/**
	 * ɾ���ҵĻظ�
	 * @param stri
	 * @return
	 */
	public static String sqlDeleteMyHuiFu(String str) {
		
		StringBuffer sb = new StringBuffer("delete huifu");

		sb.append(" and HF = \'" + str + "\'");

		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	
	}
	
	/**
	 * ��ѯ��ϸ�ظ�
	 * 
	 * @param str
	 * @return
	 */
	public static String sqlXiangXi(String str,String str2) {
		StringBuffer sb = new StringBuffer(
				"select HF from huifu");

		sb.append(" and TBZT = \'" + str + "\'");
		sb.append(" and HF = \'" + str2 + "\'");
	
		String replaceFirst = sb.toString().replaceFirst("and", "where");
		return replaceFirst;
	}
	
}
