package priv.sen.server;

import io.netty.channel.Channel;

public interface SerssionHandler {
	/**
	 * ����session����ķ���
	 * @param channel
	 * @param chinaUser
	 */
	void handlerSerssion(Channel channel, ChinaUser chinaUser);
}
