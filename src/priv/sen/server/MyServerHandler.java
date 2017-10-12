package priv.sen.server;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import priv.sen.entry.MZttb;
import priv.sen.net.MyEncode;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.net.Urls;
import priv.sen.serviece.C_HFServiece;
import priv.sen.serviece.C_TBServiece;
import priv.sen.serviece.C_TZServiece;
import priv.sen.serviece.C_YHServiece;
import priv.sen.serviece.DeleteMyHuiFuServiece;
import priv.sen.serviece.DeleteMyTieBaServiece;
import priv.sen.serviece.DeleteMyTieZiServiece;
import priv.sen.serviece.IMyService;
import priv.sen.serviece.M_NRServiece;
import priv.sen.serviece.M_NRServiece2;
import priv.sen.serviece.M_TZServiece;
import priv.sen.serviece.M_XiangXiServiece;
import priv.sen.serviece.M_YHServiece;
import priv.sen.serviece.M_ZTTBServiece;
import priv.sen.serviece.MenpServiece;
import priv.sen.serviece.S_TieZiServiece;
import priv.sen.serviece.S_ZTTBServiece;
import priv.sen.serviece.W_HFServiece;
import priv.sen.serviece.W_TZServiece;
import priv.sen.serviece.W_ZTTBServiece;

/**
 * @author MiansenWang 2017��9��18�� ����8:19:02 �������Ĵ����߼���
 */
public class MyServerHandler extends ChannelHandlerAdapter {

	private static Logger logger = Logger.getLogger(MyServerHandler.class);

	/**
	 * �ͻ��˵������˳����׳��쳣�����ǲ���Ҫ������ʾ ����ͻ��˶Ͽ����ӵ��쳣
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {

		// SessionContext.remove(ctx.channel());
		cause.printStackTrace();
	}

	/**
	 * �пͻ������� ���˵�¼
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// 1.�洢�û��ĵ�¼��Ϣ
		// SessionContext.put(ctx.channel());
		// //2.�㲥�������û����˵�¼
		// guangbo();
		super.channelActive(ctx);

	}

	private void guangbo() {
		SessionContext.Each(new SerssionHandler() {

			@Override
			public void handlerSerssion(Channel channel, ChinaUser chinaUser) {
				MyHttp msg = new MyHttp();
				msg.setData("���˵�¼��");
				msg.setType(UrlType.GUANG_BO);
				channel.writeAndFlush(msg);
			}

		});
	}

	/**
	 * �ͻ����ύ���󣬷������ṩ��Ӧ
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// ByteBuf temp = (ByteBuf) msg;
		// byte[] dst = new byte[1024];
		// temp.readBytes(dst,0,temp.readableBytes());
		// System.out.println(new String(dst));
		System.err.println(1111111);
		MyHttp m = (MyHttp) msg;
		String myUrl = m.getMyUrl();
		logger.debug(m.getData());
		String className = "priv.sen.serviece." + myUrl;
		Class forName = Class.forName(className);
		// SuperFactory instance = SuperFactory.getInstance();
		//
		// IMyService obj = (IMyService) instance.getObj(forName);
		// MyHttp result = obj.handlerMessage(m);
		MyHttp handlerMessage = null;
		
		if (className.equals("priv.sen.serviece.M_YHServiece")) {	//��¼
			Object newInstance = forName.newInstance();
			M_YHServiece ser = (M_YHServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),(String) m.getData2());
		}
		
		if (className.equals("priv.sen.serviece.M_TZServiece")) {	//����
			Object newInstance = forName.newInstance();
			M_TZServiece ser = (M_TZServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		if (className.equals("priv.sen.serviece.M_ZTTBServiece")) {		//��������
			Object newInstance = forName.newInstance();
			M_ZTTBServiece ser = (M_ZTTBServiece) newInstance;
			handlerMessage = ser.handlerMessage();
		}
		if (className.equals("priv.sen.serviece.M_NRServiece")) {		//��������
			Object newInstance = forName.newInstance();
			M_NRServiece ser = (M_NRServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),(String) m.getData2());
		}
		
		if (className.equals("priv.sen.serviece.M_NRServiece2")) {		//���ӻظ�
			Object newInstance = forName.newInstance();
			M_NRServiece2 ser = (M_NRServiece2) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),(String) m.getData2());
		}

		if (className.equals("priv.sen.serviece.C_TBServiece")) {	//��������
			Object newInstance = forName.newInstance();
			C_TBServiece ser = (C_TBServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),
					(String) m.getData2(),(String) m.getData3(),(String) m.getData4());
		}
		
		if (className.equals("priv.sen.serviece.C_TZServiece")) {	//��������
			Object newInstance = forName.newInstance();
			C_TZServiece ser = (C_TZServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),
					(String) m.getData2(),(String) m.getData3(),(String)m.getData4(),(String)m.getData5());
		}
			
		if (className.equals("priv.sen.serviece.C_HFServiece")) {	//����ظ�
			Object newInstance = forName.newInstance();
			C_HFServiece ser = (C_HFServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),
					(String) m.getData2(),(String) m.getData3(),(String)m.getData4(),(String)m.getData5());
		}
		
		if (className.equals("priv.sen.serviece.C_YHServiece")) {	//ע��
			Object newInstance = forName.newInstance();
			C_YHServiece ser = (C_YHServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),(String) m.getData2());
		}
		
		if (className.equals("priv.sen.serviece.S_ZTTBServiece")) {	//��������
			Object newInstance = forName.newInstance();
			S_ZTTBServiece ser = (S_ZTTBServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		if (className.equals("priv.sen.serviece.S_TieZiServiece")) {	//��������
			Object newInstance = forName.newInstance();
			S_TieZiServiece ser = (S_TieZiServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),(String) m.getData2());
		}
		
		if (className.equals("priv.sen.serviece.W_ZTTBServiece")) {	//�����ҵ�����
			Object newInstance = forName.newInstance();
			W_ZTTBServiece ser = (W_ZTTBServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		if (className.equals("priv.sen.serviece.W_TZServiece")) {	//�����ҵ�����
			Object newInstance = forName.newInstance();
			W_TZServiece ser = (W_TZServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		if (className.equals("priv.sen.serviece.M_XiangXiServiece")) {	//���ػظ���ϸ��Ϣ
			Object newInstance = forName.newInstance();
			M_XiangXiServiece ser = (M_XiangXiServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData(),(String) m.getData2());
		}
		
		if (className.equals("priv.sen.serviece.DeleteMyTieBaServiece")) {	//ɾ���ҵ�����
			Object newInstance = forName.newInstance();
			DeleteMyTieBaServiece ser = (DeleteMyTieBaServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		if (className.equals("priv.sen.serviece.DeleteMyTieZiServiece")) {	//ɾ���ҵ�����
			Object newInstance = forName.newInstance();
			DeleteMyTieZiServiece ser = (DeleteMyTieZiServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		if (className.equals("priv.sen.serviece.W_HFServiece")) {	//�����ҵĻظ�
			Object newInstance = forName.newInstance();
			W_HFServiece ser = (W_HFServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		if (className.equals("priv.sen.serviece.DeleteMyHuiFuServiece")) {	//ɾ���ҵĻظ�
			Object newInstance = forName.newInstance();
			DeleteMyHuiFuServiece ser = (DeleteMyHuiFuServiece) newInstance;
			handlerMessage = ser.handlerMessage((String) m.getData());
		}
		
		// ����ǵ�¼��Ϣ
		if (m.getData() instanceof ChinaUser && m.getMyUrl().equals(Urls.Login))
			SessionContext.put(ctx.channel(), (ChinaUser) msg);
		// logger.debug(msg);
		// MyHttp myHttp = new MyHttp();
		// myHttp.setData("�Ȳ���Ӱ����Ҷ��");
		ctx.writeAndFlush(handlerMessage);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

		super.channelReadComplete(ctx);
	}
}
