package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 * ɾ���ҵĻظ�
 * @author sen
 *
 */
public class DeleteMyHuiFuServiece implements IMyService{
	private static Logger logger = Logger.getLogger(DeleteMyHuiFuServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlDeleteMyTieZi = SqlPingJie.sqlDeleteMyHuiFu(text[0].toString());
		logger.debug("ɾ���ҵĻظ���sql�����:"+sqlDeleteMyTieZi);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlDeleteMyTieZi);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
