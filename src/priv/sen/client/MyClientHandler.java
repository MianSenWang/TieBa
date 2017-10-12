package priv.sen.client;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import priv.sen.net.MessageContexts;
import priv.sen.net.MessageObj;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.server.MyServerHandler;

/**
 * @author MiansenWang
 * 2017��9��18��
 * ����8:24:49
 * �ͻ��˴����߼���
 */


public class MyClientHandler extends ChannelHandlerAdapter {
	
	private static Logger logger = Logger.getLogger(MyServerHandler.class);


	/**
	 * ����������Ϣ���صĴ�����
	 * �ͻ��˶�ȡ������Ϣ��
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		MessageObj peekMessage = MessageContexts.getInstance().pollMessage();
		MyHttp myHttp = (MyHttp) msg;
		UrlType type = myHttp.getType();
		/**
		 * ����㲥��Ϣ
		 */
		if(type.equals(UrlType.GUANG_BO)){
			
		}
		/**
		 * ����������Ϣ
		 */
		if(peekMessage != null && type.equals(UrlType.NALMORE)){
			peekMessage.handlerMessage((MyHttp)msg);
			MessageContexts.flag = true;
		}
		logger.debug(33333);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
	}
}

	
