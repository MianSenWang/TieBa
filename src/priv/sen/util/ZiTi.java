package priv.sen.util;

import java.awt.Font;
import javax.swing.UIManager;

/**
 * 
 * @author sen �ı�ϵͳĬ������Ĺ�����
 */
public class ZiTi {

	public void ziTi() {
		// �ı�ϵͳĬ������
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
	}
}
