package priv.sen.entry;

/**
 * ���ӱ���
 * @author sen
 *
 */
public class Tiezi {
	
	/**
	 * �������ɱ���֤ÿ��ÿ���������õ��Ķ���ͬһ��ֵ
	 */
	private Tiezi(){
		
	}
	private static class Inner{
		private static Tiezi instance = new Tiezi();
	}
	public static Tiezi getInstance(){
		return Inner.instance;
	}
	
	private java.lang.String lzname;//¥���ǳ�

	public java.lang.String getLzname() {
		return lzname;
	}
	public void setLzname (java.lang.String lzname) { 
		this.lzname = lzname;
	}

	private java.lang.String hfname;//�ظ����ǳ�

	public java.lang.String getHfname() {
		return hfname;
	}
	public void setHfname (java.lang.String hfname) { 
		this.hfname = hfname;
	}

	private java.lang.String tbname;//��������

	public java.lang.String getTbname() {
		return tbname;
	}
	public void setTbname (java.lang.String tbname) { 
		this.tbname = tbname;
	}

	private java.lang.String hfneirong;//�ظ�����

	public java.lang.String getHfneirong() {
		return hfneirong;
	}
	public void setHfneirong (java.lang.String hfneirong) { 
		this.hfneirong = hfneirong;
	}

	private java.lang.String hfdate;//�ظ�ʱ��

	public java.lang.String getHfdate() {
		return hfdate;
	}
	public void setHfdate (java.lang.String hfdate) { 
		this.hfdate = hfdate;
	}

	private java.lang.String tzname;//���ӱ���

	public java.lang.String getTzname() {
		return tzname;
	}
	public void setTzname (java.lang.String tzname) { 
		this.tzname = tzname;
	}

	private java.lang.String tzdate;//���ӷ����ʱ��

	public java.lang.String getTzdate() {
		return tzdate;
	}
	public void setTzdate (java.lang.String tzdate) { 
		this.tzdate = tzdate;
	}

	private java.lang.String tzneirong;//���ӵ�����

	public java.lang.String getTzneirong() {
		return tzneirong;
	}
	public void setTzneirong (java.lang.String tzneirong) { 
		this.tzneirong = tzneirong;
	}

}