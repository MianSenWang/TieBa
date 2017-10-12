package priv.sen.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import priv.sen.client.NetUtils;

/**
 * @author MiansenWang
 * 2017��9��18��
 * ����7:27:27
 * ������
 */
public class Server {

	public static void main(String[] args) {
		new Server().bind(9999);
	}

	private void bind(int i) {

		EventLoopGroup parentGroup = null;
		EventLoopGroup childGroup = null;
		try {
			// ����netty����������
			ServerBootstrap b = new ServerBootstrap();
			// ���������̳߳ض���
			parentGroup = new NioEventLoopGroup();
			childGroup = new NioEventLoopGroup();
			// netty����������
			b.group(parentGroup, childGroup)//����̳߳�
			.channel(NioServerSocketChannel.class)//�����̳߳�
			.option(ChannelOption.SO_BACKLOG, 1024)//���ýӴ�����
			.childHandler(new ChannelInitializer<SocketChannel>() {
						//�Ӵ����󣬸���Ӵ����Ұ��Ŵ������
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {

							NetUtils.addDe(ch);
							ch.pipeline().addLast(new MyServerHandler());
						}
					});

			ChannelFuture futer = b.bind(i).sync();//�������ȴ����н��
			futer.channel().closeFuture().sync();//����ر�,�ͷ���Դ
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//�ͷ��̳߳���Դ
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}
}
