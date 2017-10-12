package priv.sen.serviece;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import priv.sen.db.JDBCUtil;
import priv.sen.entry.MTz;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.SqlPingJie;

/**
 * �ظ���ϸ��Ϣ
 * @author sen
 *
 */
public class M_XiangXiServiece implements IMyService{
	private static Logger logger = Logger.getLogger(M_XiangXiServiece.class);

	public MyHttp handlerMessage(String...text) {
		String sqlTieZi = SqlPingJie.sqlXiangXi(text[0],text[1]);
		logger.debug(sqlTieZi);
		List<Map<String,Object>> findAll = JDBCUtil.findAll(sqlTieZi);
		logger.debug("�鿴�ظ�����ϸ��Ϣ"+findAll);
		MyHttp myHttp = new MyHttp();
		myHttp.setType(UrlType.NALMORE);
		myHttp.setData(findAll);
		return myHttp;
	}
}
