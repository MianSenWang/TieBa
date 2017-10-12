package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 * ģ����ѯ����
 * @author sen
 *
 */
public class S_TieZiServiece implements IMyService{
	private static Logger logger = Logger.getLogger(S_TieZiServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlMoHuChanXunTieZi = SqlPingJie.sqlMoHuChanXunTieZi(text[0].toString(), text[1].toString());
		logger.debug("�������ӵ�sql�����:"+sqlMoHuChanXunTieZi);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlMoHuChanXunTieZi);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
