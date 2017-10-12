package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.entry.MTz;
import priv.sen.entry.MZttb;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 *	�ظ����Ӵ�����
 * @author sen
 *
 */
public class C_HFServiece implements IMyService{
	private static Logger logger = Logger.getLogger(C_HFServiece.class);

	public MyHttp handlerMessage(String...text) {
//		MTz instance = MTz.getInstance();
//		String str = instance.getTbzt();//�õ��û��������������
//		logger.debug(str);
		
//		String insertTieBa = SqlPingJie.insertTieBa(text);
//		logger.debug("�������ɵ�sql����ǣ�"+insertTieBa);
//		JDBCUtil.insert(insertTieBa);
//		logger.debug(findAll);
//		List<Map<String,Object>> findAll = JDBCUtil.findAll("select * from M_TZ where TBZT = '���»���'");
		MZttb instance = MZttb.getInstance();
		String insert = SqlPingJie.insertHuiFu(text[0].toString(),text[1].toString(),text[2].toString(),text[3].toString(),text[4].toString());
		logger.debug("����ظ����ӵ�sql����ǣ�"+insert);
		JDBCUtil.insert(insert);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
//		myHttp.setData(findAll);
		return myHttp;
	}
}
