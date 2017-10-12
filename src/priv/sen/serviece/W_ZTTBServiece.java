package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 * ����������
 * @author sen
 *
 */
public class W_ZTTBServiece implements IMyService{
	private static Logger logger = Logger.getLogger(W_ZTTBServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlJiaZaiMyTieBa = SqlPingJie.sqlJiaZaiMyTieBa(text[0].toString());
		logger.debug("�����ҵ����ɵ�sql�����:"+sqlJiaZaiMyTieBa);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlJiaZaiMyTieBa);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
