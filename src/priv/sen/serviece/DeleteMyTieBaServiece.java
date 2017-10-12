package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 * ɾ���ҵ�����
 * @author sen
 *
 */
public class DeleteMyTieBaServiece implements IMyService{
	private static Logger logger = Logger.getLogger(DeleteMyTieBaServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlDeleteMyTieBa = SqlPingJie.sqlDeleteMyTieBa(text[0].toString());
		logger.debug("ɾ���ҵ����ɵ�sql�����:"+sqlDeleteMyTieBa);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlDeleteMyTieBa);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
