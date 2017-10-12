package priv.sen.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 
 * @author MiansenWang
 * 2017��9��22��
 * ����1:30:13
 * ����
 */
public class MyEncode extends MessageToByteEncoder<MyHttp>{
	private static Logger logger = Logger.getLogger(MyEncode.class);

	@Override
	protected void encode(ChannelHandlerContext ctx, MyHttp msg, ByteBuf out) throws Exception {
		byte[] bytes = toBytes(msg);
		out.writeInt(bytes.length);
		out.writeBytes(bytes);
	}

	private byte[] toBytes(MyHttp msg) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(msg);
		return byteArrayOutputStream.toByteArray();
	}

	
}
