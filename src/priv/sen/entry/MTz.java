package priv.sen.entry;


/**
 * ���ӱ���
 * @author sen
 *
 */
public class MTz {
	
	/**
	 * �������ӱ���֤ÿ��ÿ���������õ��Ķ���ͬһ��ֵ
	 */
	private MTz(){
		
	}
	private static class Inner{
		private static MTz instance = new MTz();
	}
	public static MTz getInstance(){
		return Inner.instance;
	}
	
	private java.lang.String u_name;

	public java.lang.String getU_name() {
		return u_name;
	}
	public void setU_name (java.lang.String u_name) { 
		this.u_name = u_name;
	}

	private java.sql.Timestamp u_date;

	public java.sql.Timestamp getU_date() {
		return u_date;
	}
	public void setU_date (java.sql.Timestamp u_date) { 
		this.u_date = u_date;
	}

	private java.lang.String tzbt;//���ӱ���

	public java.lang.String getTzbt() {
		return tzbt;
	}
	public void setTzbt (java.lang.String tzbt) { 
		this.tzbt = tzbt;
	}

	private java.lang.String tbzt;

	public java.lang.String getTbzt() {
		return tbzt;
	}
	public void setTbzt (java.lang.String tbzt) { 
		this.tbzt = tbzt;
	}
	@Override
	public String toString() {
		return "MTz [u_name=" + u_name + ", u_date=" + u_date + ", tzbt="
				+ tzbt + ", tbzt=" + tbzt + "]";
	}

}