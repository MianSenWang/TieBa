package priv.sen.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * ��ȡ��ǰϵͳʱ��
 * @author sen
 *
 */
public class SqlDate {

	private static Logger logger = Logger.getLogger(SqlDate.class);
	
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(date);
		return format;
	}
	
	/**
	 * ���Դ���
	 * @param args
	 */
	public static void main(String[] args) {
		String date = SqlDate.getDate();
		logger.debug(date);
	}
}
