package priv.sen.entry;

/**
 * ���ɱ���
 * @author sen
 *
 */
public class MZttb {
	
	
	/**
	 * �������ɱ���֤ÿ��ÿ���������õ��Ķ���ͬһ��ֵ
	 */
	private MZttb(){
		
	}
	private static class Inner{
		private static MZttb instance = new MZttb();
	}
	public static MZttb getInstance(){
		return Inner.instance;
	}
	
	private java.lang.String u_zt;//��������

	public java.lang.String getU_zt() {
		return u_zt;
	}
	public void setU_zt (java.lang.String u_zt) { 
		this.u_zt = u_zt;
	}

	private java.lang.String u_name;//��������

	public java.lang.String getU_name() {
		return u_name;
	}
	public void setU_name (java.lang.String u_name) { 
		this.u_name = u_name;
	}

	private java.sql.Timestamp u_date;//�������ɵ�ʱ��

	public java.sql.Timestamp getU_date() {
		return u_date;
	}
	public void setU_date (java.sql.Timestamp u_date) { 
		this.u_date = u_date;
	}

	private java.lang.String u_jianjie;//���ɼ��

	public java.lang.String getU_jianjie() {
		return u_jianjie;
	}
	public void setU_jianjie (java.lang.String u_jianjie) { 
		this.u_jianjie = u_jianjie;
	}

}