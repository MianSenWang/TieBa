package priv.sen.net;

import org.apache.log4j.Logger;

public class MessageContexts {
	/**
	 * ����������Ϣ
	 */
	private static Logger logger = Logger.getLogger(MessageContexts.class);
	
	private static MessageObj _text;

	public static boolean flag = true;

	public void offerMessage(MessageObj text) {
		synchronized (MessageContexts.class) {
			while(_text != null){
				try {
					MessageContexts.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			_text = text;
			MessageContexts.class.notifyAll();
		}
	}

	private static class Inner{
		public static MessageContexts instance = new MessageContexts();
	}
	public static MessageContexts getInstance() {
		return Inner.instance;
	}
	
	/**
	 * ������Ϣ
	 * @return
	 */
	public MessageObj peekMessage() {
		synchronized (MessageContexts.class) {
			while(_text == null){
				try {
					MessageContexts.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			MessageContexts.class.notifyAll();
			MessageObj temp = _text;
//				_text = null;
			return temp;
		}
	}

	public MessageObj pollMessage() {
		synchronized (MessageContexts.class) {
			while(_text == null){
				try {
					MessageContexts.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			MessageContexts.class.notifyAll();
			MessageObj temp = _text;
			_text = null;
			return temp;
		}
	}
}
