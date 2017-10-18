package priv.sen.client;

import org.apache.log4j.Logger;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import priv.sen.net.MessageContexts;
import priv.sen.net.MessageObj;

/**
 * @author MiansenWang
 * 2017��9��18��
 * ����7:27:16
 * �ͻ���
 */
public class Client {
	
	private static Logger logger = Logger.getLogger(Client.class);
	public static void main(String[] args) {
		new Client().connet("127.0.0.1",9999);
	}

	public void connet(String ip, int port) {
		EventLoopGroup group = null;//�����̳߳�
		try {
		Bootstrap b = new Bootstrap();//�ͻ����������� 
		group = new NioEventLoopGroup();
		b.group(group).channel(NioSocketChannel.class)
		.option(ChannelOption.TCP_NODELAY, true)
		.handler(getHandler());
		
		/**
		 * ������Ϣ
		 */
			ChannelFuture sync = b.connect(ip,port).sync();
			//�־����ӣ����ϵķ�����Ϣ
			sendMessage(sync);
			sync.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			group.shutdownGracefully();
		}
	}

	
	/**
	 * TODO ������Ϣ
	 * ѭ�����������������Ϣ
	 * @param sync
	 */
	private void sendMessage(ChannelFuture sync) {
		boolean flag = true;
		while(true){
			MessageObj peekMessage = MessageContexts.getInstance().peekMessage();
			
			if(peekMessage != null && MessageContexts.flag){
				sync.channel().writeAndFlush(peekMessage.getMessage());
				logger.debug("11111111"+peekMessage.getMessage().getData());
				MessageContexts.flag = false;
			}
		
			
		}
	}

	/**
	 * �ṩͨ�ŵı������ͽ������Լ�ͨ�ŵĻص��������
	 * @return
	 */
	private ChannelInitializer<SocketChannel> getHandler() {
		return new ChannelInitializer<SocketChannel>() {

			/**
			 * �����ת��
			 */
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				NetUtils.addDe(ch);
				ch.pipeline().addLast(new MyClientHandler());
			}
		};
	}
}
