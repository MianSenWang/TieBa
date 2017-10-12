package priv.sen.gui2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.apache.log4j.Logger;
import priv.sen.client.Client;
import priv.sen.net.MessageContexts;
import priv.sen.net.MessageObj;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.StringUtil;
import priv.sen.util.ZiTi;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;
import java.awt.Color;

/**
 * @author sen 
 * ע�ᴰ��
 */
public class ZhuCeFrm extends JFrame {
	private static Logger logger = Logger.getLogger(ZhuCeFrm.class);
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passWord;
	List<Map<String, Object>> findAll;
	private List<Map<String, Object>> data;
	private JPasswordField password2Field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZhuCeFrm frame = new ZhuCeFrm();
					frame.setVisible(true);
					new Thread(new Runnable() {

						@Override
						public void run() {
							new Client().connet("127.0.0.1", 9999);
						}
					}).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void setBg(){   
		 ((JPanel)this.getContentPane()).setOpaque(false);   
		 ImageIcon img = new ImageIcon  
		 (".\\tupian\\����1.jpg");   
		 JLabel background = new JLabel(img);  
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));   
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
		 } 
	
	/**
	 * Create the frame.
	 */
	public ZhuCeFrm() {
		setForeground(Color.BLUE);

		ZiTi ziTi = new ZiTi();
		ziTi.ziTi();
		setBg();
		setFont(new Font("Dialog", Font.BOLD, 20));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ZhuCeFrm.class.getResource("/tupian/\u56FE\u68073.jpg")));
		setResizable(false);
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 434);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u5174\u8DA3\u8D34\u5427");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(ZhuCeFrm.class
				.getResource("/tupian/QQ\u56FE\u724720160515203520.png")));
		lblNewLabel.setBounds(96, 41, 274, 68);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(
				"\u2014\u2014\u4E0E\u4E16\u754C\u5206\u4EAB\u4F60\u7684\u6545\u4E8B");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(186, 104, 200, 50);
		contentPane.add(lblNewLabel_1);

		JLabel userNameLabel = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		userNameLabel.setForeground(Color.BLUE);
		userNameLabel.setIcon(new ImageIcon(ZhuCeFrm.class
				.getResource("/tupian/userName.png")));
		userNameLabel.setBounds(118, 177, 243, 50);
		contentPane.add(userNameLabel);

		JLabel passwordLabel = new JLabel("\u5BC6    \u7801\uFF1A");
		passwordLabel.setForeground(Color.BLUE);
		passwordLabel.setIcon(new ImageIcon(ZhuCeFrm.class
				.getResource("/tupian/password.png")));
		passwordLabel.setBounds(118, 223, 200, 50);
		contentPane.add(passwordLabel);

		userName = new JTextField();
		userName.setBounds(214, 192, 128, 21);
		contentPane.add(userName);
		userName.setColumns(10);

		passWord = new JPasswordField();
		passWord.setBounds(214, 238, 128, 21);
		contentPane.add(passWord);
		//ע�ᰴť
		JButton zhuCeButton = new JButton("\u6CE8\u518C");
		zhuCeButton.setForeground(Color.BLUE);
		//ע�����
		zhuCeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhuCe(e);
			}
		});
		zhuCeButton.setIcon(new ImageIcon(ZhuCeFrm.class
				.getResource("/tupian/login.png")));
		zhuCeButton.setBounds(118, 341, 93, 23);
		contentPane.add(zhuCeButton);

		// ��¼��ť
		JButton dengLuButton = new JButton("\u767B\u5F55");
		dengLuButton.setForeground(Color.BLUE);
		// ��¼����
		dengLuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();// �ѵ�ǰ��������
				new LogOnFrm().setVisible(true);//��¼����
			}
		});
		dengLuButton.setIcon(new ImageIcon(ZhuCeFrm.class
				.getResource("/tupian/reset.png")));
		dengLuButton.setBounds(249, 341, 93, 23);
		contentPane.add(dengLuButton);
		
		JLabel password2label = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		password2label.setForeground(Color.BLUE);
		password2label.setIcon(new ImageIcon(ZhuCeFrm.class.getResource("/tupian/password.png")));
		password2label.setBounds(118, 269, 200, 50);
		contentPane.add(password2label);
		
		password2Field = new JPasswordField();
		password2Field.setBounds(214, 284, 128, 21);
		contentPane.add(password2Field);
		// ���ô��ھ�����ʾ
		this.setLocationRelativeTo(null);
		//����ֻ�رյ�ǰ����
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * TODO ע���¼�����
	 * @param e
	 */
	private void zhuCe(ActionEvent e) {
		String getUserName = this.userName.getText();//�û���
		String getPassWord = new String(this.passWord.getPassword());//����
		String passWord2 = new String(this.password2Field.getPassword());//ȱ������
		if (StringUtil.isEmpty(getUserName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ�գ�");// swing����ʾ
			return;
		}
		if (StringUtil.isEmpty(getPassWord)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
			return;
		}
		
		if(!getPassWord.equals(passWord2)){
			JOptionPane.showMessageDialog(null, "�������벻һ�£�");
			return;
		}
		if(getPassWord.length() < 6){
			JOptionPane.showMessageDialog(null, "���벻��С��6λ!");
			return;
		}
				
		MessageContexts.getInstance().offerMessage(new MessageObj() {

			@Override
			public void handlerMessage(MyHttp info) {
				// TODO ������Ϣ
				data = (List<Map<String, Object>>) info.getData();// �õ���������Ӧ����
				logger.debug(data);
			}

			@Override
			public MyHttp getMessage() {
				// TODO ������Ϣ
				MyHttp myHttp = new MyHttp();
				myHttp.setData(getUserName);
				myHttp.setData2(getPassWord);
				myHttp.setMyUrl("C_YHServiece");
				myHttp.setType(UrlType.NALMORE);
				return myHttp;
			}
		});
		
		JOptionPane.showMessageDialog(null, "ע��ɹ�!");
		userName.setText("");
		passWord.setText("");
		password2Field.setText("");
	}
}
