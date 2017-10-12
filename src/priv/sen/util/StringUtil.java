package priv.sen.util;

import java.awt.FontMetrics;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * @author sen
 *	�ַ���������
 */
public class StringUtil {

	/**
	 * �ж��Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * �ж��Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str.trim())){
			return true;	
		}else{
			return false;
		}
	}
	
	/**
	 * JLabel�Զ�����
	 * @param jLabel
	 * @param longString
	 * @throws InterruptedException
	 */
	public static void JlabelSetText(JTextArea jTextArea, String longString) 
            throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jTextArea.getFontMetrics(jTextArea.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (true) {
                len++;
                if (start + len > longString.length())break;
                if (fontMetrics.charsWidth(chars, start, len) 
                        > jTextArea.getWidth()) {
                    break;
                }
            }
            builder.append(chars, start, len-1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length()-start);
        builder.append("</html>");
        jTextArea.setText(builder.toString());
    }
	
	/**
	 * JLabel�Զ�����
	 * @param jLabel
	 * @param longString
	 * @throws InterruptedException
	 */
	public static void JlabelSetText(JLabel jLabel, String longString) 
            throws InterruptedException {
        StringBuilder builder = new StringBuilder("<html>");
        char[] chars = longString.toCharArray();
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int start = 0;
        int len = 0;
        while (start + len < longString.length()) {
            while (true) {
                len++;
                if (start + len > longString.length())break;
                if (fontMetrics.charsWidth(chars, start, len) 
                        > jLabel.getWidth()) {
                    break;
                }
            }
            builder.append(chars, start, len-1).append("<br/>");
            start = start + len - 1;
            len = 0;
        }
        builder.append(chars, start, longString.length()-start);
        builder.append("</html>");
        jLabel.setText(builder.toString());
    }
	
}
