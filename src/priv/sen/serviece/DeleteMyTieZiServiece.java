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
public class DeleteMyTieZiServiece implements IMyService{
	private static Logger logger = Logger.getLogger(DeleteMyTieZiServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlDeleteMyTieZi = SqlPingJie.sqlDeleteMyTieZi(text[0].toString());
		logger.debug("ɾ���ҵ����ӵ�sql�����:"+sqlDeleteMyTieZi);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlDeleteMyTieZi);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
