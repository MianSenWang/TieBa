package priv.sen.db;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author MiansenWang
 * 2017��9��13��
 * ����7:58:06
 * ��ѯ�������
 */
public interface QueryVisiter {

	void handlerSet(ResultSet set) throws SQLException;

}
