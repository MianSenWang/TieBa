package priv.sen.db2;

import org.apache.log4j.Logger;

public class StringUtil {
	private static Logger logger = Logger.getLogger(StringUtil.class);
	
	/**
	 * ������ת�ֶ���
	 * get��setȥ��
	 * ʣ�µ��ַ�������ĸתСд
	 * @param methoedName
	 * @return
	 */
	public static String method2FieldName(String methoedName){
		if(!(methoedName.startsWith("get")||methoedName.startsWith("set")))
			return null;
		String mName = methoedName.substring(3);
		char d = mName.charAt(0);
		if(d>='A'&&d<='Z'){
			char result=(char) (d+32);
			return result+mName.substring(1);
		}
		return mName;
	}

	/**
	 * �ֶ���תget������
	 * �ֶ����շ�ת��˹��
	 * Ȼ���ڼ���get
	 * @param methoedName
	 * @return
	 */
	public static String field2GetName(String methoedName){
		String cape2Pascle = cape2Pascle(methoedName);
		return "get"+cape2Pascle;
	}
	
	/**
	 * �ֶ���תset������
	 * �ֶ����շ�ת��˹��
	 * Ȼ���ڼ���set
	 * @param methoedName
	 * @return
	 */
	public static String field2SetName(String methoedName) {
		String cape2Pascle = cape2Pascle(methoedName);
		return "set"+cape2Pascle;
	}
	
	/**
	 * ���Դ���
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "userNameAge";
		String cape2Xia = cape2Xia(name);
		System.out.println(cape2Xia);
	}

	/**
	 * �շ�ת�»���
	 * @param name
	 * @return
	 */
	public static String cape2Xia(String name) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < name.length(); i++) {
			char charAt = name.charAt(i);
			if(charAt >= 65 && charAt <= 90){
				if(i != 0)stringBuilder.append('_');
				stringBuilder.append((char)(charAt+32));
			}else{
				stringBuilder.append(charAt);
			}
		}
		return stringBuilder.toString();
	}
	
	/**
	 * �»���ת�շ�
	 * @param xiaHuaXians
	 * @return
	 */
	public static String xia2cape(String xiaHuaXians) {
		xiaHuaXians = xiaHuaXians.toLowerCase();
		StringBuilder builder = new StringBuilder(xiaHuaXians);
		for (int i = 0; i < builder.length(); i++) {
			char c = builder.charAt(i);
			if(c=='_'&&i+1!=builder.length()){
				char d = builder.charAt(i+1);
				if(d>=97&&d<=122){
					char result=(char) (d-32);
					builder.setCharAt(i+1, result);
					
				}
			}
		}
		
		return builder.toString().replaceAll("_", "");
	}
	
	/**
	 * �»���ת��˹��
	 * @param xiaHuaXians
	 * @return
	 */
	public static String xia2Pascle(String xiaHuaXians) {
		String result = xia2cape(xiaHuaXians);
		return cape2Pascle(result);
		
	}

	/**
	 * �շ�ת��˹��
	 * @param result
	 * @return
	 */
	private static String cape2Pascle(String result) {
		StringBuilder stringBuilder = new StringBuilder(result);
		char d=result.charAt(0);
		if(d>=97&&d<=122)
			stringBuilder.setCharAt(0, (char)(d-32));
		return stringBuilder.toString();
	}
}
