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
 * ע��
 * @author sen
 *
 */
public class C_YHServiece implements IMyService{
	private static Logger logger = Logger.getLogger(C_YHServiece.class);

	public MyHttp handlerMessage(String...text) {
		String insertTieBa = SqlPingJie.insertyongHu(text[0].toString(),text[1].toString());
		logger.debug("ע���û���sql����ǣ�"+insertTieBa);
		JDBCUtil.insert(insertTieBa);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
//		myHttp.setData(findAll);
		return myHttp;
	}
}
