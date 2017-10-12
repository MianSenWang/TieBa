package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 * �ҵĻظ�
 * @author sen
 *
 */
public class W_HFServiece implements IMyService{
	private static Logger logger = Logger.getLogger(W_HFServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlJiaZaiMyTieZi = SqlPingJie.sqlJiaZaiMyH(text[0].toString());
		logger.debug("�����ҵĻظ���sql�����:"+sqlJiaZaiMyTieZi);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlJiaZaiMyTieZi);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
