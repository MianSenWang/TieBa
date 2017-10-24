package priv.sen.gui2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import priv.sen.entry.MTz;
import priv.sen.entry.MYh;
import priv.sen.entry.MZttb;
import priv.sen.net.MessageContexts;
import priv.sen.net.MessageObj;
import priv.sen.net.MyHttp;
import priv.sen.net.UrlType;
import priv.sen.util.ResetValueActionPerformed;
import priv.sen.util.SqlDate;
import priv.sen.util.ZiTi;
import priv.sen.view.MyModel2;
import priv.sen.view.MyModel3;

/**
 * ������ҳ��
 * 
 * @author sen
 *
 */
public class TieBaFrm extends JFrame {

	private static Logger logger = Logger.getLogger(MyModel2.class);
	private JPanel contentPane;
	private JTable table;// ������Ϣ���
	private JTextArea tbjjArea;// ���ɼ�������
	private JTextArea tbztArea;//��������
	private JTextArea s_tieBa;//��������
	private static List<Map<String, Object>> data;//ˢ��������Ϣ
	private static List<Map<String, Object>> dataTZ;//������Ϣ
	private static List<Map<String, Object>> dataMyTB;//�ҵ�������Ϣ
	private static List<Map<String, Object>> dataMyTZ;//�ҵ�������Ϣ
	private static List<Map<String, Object>> dataMyHF;//�ҵĻظ���Ϣ
	private String str;
	private static boolean flag = false;// ������������Ƿ��Ѵ���
	
	
	
	
	public static List<Map<String, Object>> getDataMyHF() {
		return dataMyHF;
	}


	public static void setDataMyHF(List<Map<String, Object>> dataMyHF) {
		TieBaFrm.dataMyHF = dataMyHF;
	}


	public static List<Map<String, Object>> getDataMyTZ() {
		return dataMyTZ;
	}


	public static void setDataMyTZ(List<Map<String, Object>> dataMyTZ) {
		TieBaFrm.dataMyTZ = dataMyTZ;
	}


	public static List<Map<String, Object>> getDataMyTB() {
		return dataMyTB;
	}


	public static void setDataMyTB(List<Map<String, Object>> dataMyTB) {
		TieBaFrm.dataMyTB = dataMyTB;
	}


	public static List<Map<String, Object>> getDataTZ() {
		return dataTZ;
	}


	public static void setDataTZ(List<Map<String, Object>> dataTZ) {
		TieBaFrm.dataTZ = dataTZ;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TieBaFrm frame = new TieBaFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void setBg(){   
		 ((JPanel)this.getContentPane()).setOpaque(false);   
		 ImageIcon img = new ImageIcon  
		 (".\\tupian\\����2.jpg");   
		 JLabel background = new JLabel(img);  
		 this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));   
		 background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
		 } 
	
	/**
	 * Create the frame.
	 */
	public TieBaFrm() {

		ZiTi ziTi = new ZiTi();
		ziTi.ziTi();
//		setBg();
		setIconImage(Toolkit.getDefaultToolkit().getImage(TieBaFrm.class.getResource("/tupian/\u56FE\u68073.jpg")));
		setTitle("\u5174\u8DA3\u8D34\u5427-\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 720);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		String u_name = MYh.getInstance().getU_name();
		// String yongHuNiCheng = yongHuNiCheng();
		logger.debug("���ڵ�¼..." + u_name);
		JMenu menu = new JMenu(u_name);// TODO ��ȡ�û����ǳ�
		menu.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/userName.png")));
		menuBar.add(menu);

		JMenuItem geRenZhongXinmenuItem = new JMenuItem(
				"\u4E2A\u4EBA\u4E2D\u5FC3");
		geRenZhongXinmenuItem.addActionListener(new ActionListener() {
			/**
			 * ��������
			 */
			public void actionPerformed(ActionEvent e) {
				new GeRenZhongXinFrm().setVisible(true);
			}
		});
		geRenZhongXinmenuItem.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/userName.png")));
		menu.add(geRenZhongXinmenuItem);

		JMenuItem tieBaMenuItem = new JMenuItem("\u6211\u7684\u8D34\u5427");
		
		/**
		 * �ҵ����ɼ���
		 */
		tieBaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageContexts.getInstance().offerMessage(new MessageObj() {

					@Override
					public void handlerMessage(MyHttp info) {
						// TODO ������Ϣ
						dataMyTB = (List<Map<String, Object>>) info.getData();// �õ���������Ӧ����
//						table.setModel(new MyTieBaModel(dataMyTB));
					}

					@Override
					public MyHttp getMessage() {
						// TODO ������Ϣ
						MyHttp myHttp = new MyHttp();
						myHttp.setData(MYh.getInstance().getU_name());//�û���
						myHttp.setMyUrl("W_ZTTBServiece");
						myHttp.setType(UrlType.NALMORE);
						return myHttp;
					}
				});
				
				new MyTieBaFrm().setVisible(true);
			}
		});
		tieBaMenuItem.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/reset.png")));
		menu.add(tieBaMenuItem);

		JMenuItem tieZiMenuItem = new JMenuItem("\u6211\u7684\u5E16\u5B50");
		
		/**
		 * �ҵ������¼�����
		 */
		tieZiMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MessageContexts.getInstance().offerMessage(new MessageObj() {
					
					@Override
					public void handlerMessage(MyHttp info) {
						//TODO ������Ϣ
						dataMyTZ  = (List<Map<String, Object>>) info.getData();//�õ���������Ӧ����
//						table.setModel(new MyTieZiModel(dataMyTZ));
					}
					
					@Override
					public MyHttp getMessage() {
						//TODO ������Ϣ
						MyHttp myHttp = new MyHttp();
						myHttp.setData(MYh.getInstance().getU_name());//�û���
						myHttp.setMyUrl("W_TZServiece");
						myHttp.setType(UrlType.NALMORE);
						return myHttp;
					}
				});
			
			
				
				new MyTieZiFrm().setVisible(true);
			}
		});
		tieZiMenuItem.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/edit.png")));
		menu.add(tieZiMenuItem);

		JMenuItem qieHuanMenuItem = new JMenuItem("\u5207\u6362\u5E10\u53F7");
		qieHuanMenuItem.addActionListener(new ActionListener() {
			// ע������
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�Ƿ��л��ʺţ�");
				if (result == 0) {
					LogOnFrm logOnFrm = new LogOnFrm();
					dispose();// �ѵ�ǰ��������
					logOnFrm.setVisible(true);
				}
			}
		});
		
		JMenuItem huiFuMenuItem = new JMenuItem("\u6211\u7684\u56DE\u590D");
		//�ҵĻظ��¼�����
		huiFuMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				MessageContexts.getInstance().offerMessage(new MessageObj() {
					
					@Override
					public void handlerMessage(MyHttp info) {
						//TODO ������Ϣ
						dataMyHF  = (List<Map<String, Object>>) info.getData();//�õ���������Ӧ����
//						table.setModel(new MyTieZiModel(dataMyTZ));
					}
					
					@Override
					public MyHttp getMessage() {
						//TODO ������Ϣ
						MyHttp myHttp = new MyHttp();
						myHttp.setData(MYh.getInstance().getU_name());//�û���
						myHttp.setMyUrl("W_HFServiece");
						myHttp.setType(UrlType.NALMORE);
						return myHttp;
					}
				});
				new MyHuiFuFrm().setVisible(true);
			}
		});
		huiFuMenuItem.setIcon(new ImageIcon(TieBaFrm.class.getResource("/tupian/me.png")));
		menu.add(huiFuMenuItem);
		qieHuanMenuItem.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/login.png")));
		menu.add(qieHuanMenuItem);

		JButton lxButton = new JButton("\u5173\u4E8E\u6211\u4EEC");
		/**
		 * ��������
		 */
		lxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LianXiWoMenFrm().setVisible(true);
			}
		});
		lxButton.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/about.png")));
		menuBar.add(lxButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "\u641C\u7D22\u8D34\u5427",
				TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"),
				"\u521B\u5EFA\u4E3B\u9898\u8D34\u5427", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 192, Short.MAX_VALUE)
					.addContainerGap())
		);

		JLabel tbztLabel = new JLabel("\u8D34\u5427\u4E3B\u9898\uFF1A");
		tbztLabel.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/me.png")));
		JLabel tbjjLabel = new JLabel("\u8D34\u5427\u7B80\u4ECB\uFF1A");
		tbjjLabel.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/edit.png")));

		/**
		 * TODO ���ɼ��༭��
		 */

		JButton cjButton = new JButton("\u521B\u5EFA");// �������ɰ�ť

		cjButton.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/password.png")));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(tbztLabel)
						.addComponent(tbjjLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(cjButton)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tbztLabel)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(tbjjLabel)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cjButton)
					.addGap(16))
		);
		tbjjArea = new JTextArea();
		scrollPane_1.setViewportView(tbjjArea);
		tbjjArea.setLineWrap(true);
		
				// �����ı����߿�
				tbjjArea.setBorder(new LineBorder(new java.awt.Color(127, 157, 185), 1,
						false));
		
		tbztArea = new JTextArea();
		tbztArea.setLineWrap(true);
		scrollPane_2.setViewportView(tbztArea);
		panel_1.setLayout(gl_panel_1);

		JLabel tbmcLabel = new JLabel("\u8D34\u5427\u540D\u79F0\uFF1A");
		tbmcLabel.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/reset.png")));

		// TODO ������ť
		JButton ssButton = new JButton("\u641C\u7D22");
		ssButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				souSuoTieBa(e);
			}
		});
		ssButton.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/search.png")));

		JButton sxButton = new JButton("\u5237\u65B0");// TODO ˢ�°�ť

		sxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTieBaData();
			}
		});

		/**
		 * TODO �������ɼ����¼�
		 */
		cjButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String text = tbztArea.getText();//��������
//				List<Map<String,Object>> data2 = LogOnFrm.getData();//������Ϣ
//				for (int i = 0; i < data2.size(); i++) {
//					if (text.equals(data2.get(i))) {
//						JOptionPane.showMessageDialog(null, tbztArea.getText()
//							+ "�Ѵ���!");
//						return;
//				}
//			}
				
				if (flag) {
//					JOptionPane.showMessageDialog(null, tbztArea.getText()
//							+ "�Ѵ���!");
					logger.debug("�Ѵ���");
					return;
				} else if (tbztArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��������������!");
					return;
				} else if (tbjjArea.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���������ɼ��!");
					return;
				}else if(tbztArea.getText().length() > 50){
					JOptionPane.showMessageDialog(null, "�������ⲻ�ܳ���50����!");
					return;
				}
				chuangJianTieBa(e);
				TieBaFrm.this.getContentPane().revalidate();//�ػ�
				
				JOptionPane.showMessageDialog(null, tbztArea.getText()
						+ " �����ɹ�!");
				ResetValueActionPerformed.resetValueActionPerformed(e,
						tbjjArea, tbztArea);
				
				
				
				
				
				getTieBaData();

				
				
				
				
				

			}
		});
		sxButton.setIcon(new ImageIcon(TieBaFrm.class
				.getResource("/tupian/login.png")));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addComponent(tbmcLabel)
					.addGap(18)
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(ssButton)
					.addGap(18)
					.addComponent(sxButton)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tbmcLabel)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ssButton)
						.addComponent(sxButton, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		s_tieBa = new JTextArea();
		s_tieBa.setLineWrap(true);
		scrollPane_3.setViewportView(s_tieBa);
		panel.setLayout(gl_panel);

		table = new JTable();
		table.setToolTipText("");
		table.setRowHeight(25);//���߶�
		table.addMouseListener(new MouseAdapter() {

			// @Override
			// public void mousePressed(MouseEvent me) {
			// bookTableMousePressed(me);
			// }
			// TODO �������굥���¼�
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowI = table.rowAtPoint(e.getPoint());// �õ�table������
				if (rowI > -1) {
					str = (String) table.getModel().getValueAt(rowI, 0);
					logger.debug("������� " + str);
					MTz instance = MTz.getInstance();
					instance.setTbzt(str);// ��������
					String tbzt = instance.getTbzt();
					logger.debug("���������ǣ�" + tbzt);
					getTieZiDataByTieBaZhuTi(tbzt);
				}
			}
		});
		scrollPane.setViewportView(table);

		// ��������ӱ������
		table.setModel(new MyModel2(new LogOnFrm().getData()));
		table.getColumnModel().getColumn(0).setPreferredWidth(172);
		table.getColumnModel().getColumn(0).setMinWidth(18);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(163);
		table.getColumnModel().getColumn(3).setPreferredWidth(146);

		JButton button = new JButton("\u641C\u7D22");
		scrollPane.setColumnHeaderView(button);
		contentPane.setLayout(gl_contentPane);

		// ���ô��ھ�����ʾ
		this.setLocationRelativeTo(null);
		
		contentPane.setOpaque(false);
	}

	/**
	 * ���������¼�����
	 * 
	 * @param e
	 */
	private void chuangJianTieBa(ActionEvent e) {
		MZttb instance = MZttb.getInstance();
		String text = tbztArea.getText();// ��ȡ�û��������������
		String text2 = tbjjArea.getText();// ��ȡ�û���������ɼ��
		instance.setU_zt(text);
		instance.setU_jianjie(text2);
		// instance.setU_name(yongHuNiCheng());

//		String text = tbztArea.getText();//��������
		List<Map<String,Object>> data2 = LogOnFrm.getData();//������Ϣ
		for (int i = 0; i < data2.size(); i++) {
			if (text.equals(data2.get(i))) {
				JOptionPane.showMessageDialog(null, tbztArea.getText()
					+ "�Ѵ���!");
				return;
		}
	}

		
		
		
		
		
		
		MessageContexts.getInstance().offerMessage(new MessageObj() {

			@Override
			public void handlerMessage(MyHttp info) {
				// TODO ������Ϣ
				data = (List<Map<String, Object>>) info.getData();// �õ���������Ӧ����
				// new TieZiFrm().setVisible(true);
			}

			@Override
			public MyHttp getMessage() {
				// TODO ������Ϣ
				MyHttp myHttp = new MyHttp();
				myHttp.setData(text+"��");// ��������
				myHttp.setData2(MYh.getInstance().getU_name());// ��������
				myHttp.setData3(text2);// ���ɼ��
				myHttp.setData4(SqlDate.getDate());// ����ʱ��
				myHttp.setMyUrl("C_TBServiece");
				myHttp.setType(UrlType.NALMORE);
				return myHttp;
			}
		});
	}

	/**
	 * ���������¼�����
	 * 
	 * @param evt
	 */
	private void souSuoTieBa(ActionEvent evt) {
		String s_tieBaName = this.s_tieBa.getText();// ��ȡ�û�������ֶ�

		MessageContexts.getInstance().offerMessage(new MessageObj() {

			@Override
			public void handlerMessage(MyHttp info) {
				// TODO ������Ϣ
				data = (List<Map<String, Object>>) info.getData();// �õ���������Ӧ����
			}

			@Override
			public MyHttp getMessage() {
				// TODO ������Ϣ
				MyHttp myHttp = new MyHttp();
				myHttp.setData(s_tieBaName);//�û��������ֶ�
				myHttp.setMyUrl("S_ZTTBServiece");
				myHttp.setType(UrlType.NALMORE);
				return myHttp;
			}
		});
		table.setModel(new MyModel2(data));
		logger.debug("�������ɽ����"+data);
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * ��ȡ������Ϣ
	 */
	private void getTieBaData() {
		MessageContexts.getInstance().offerMessage(new MessageObj() {

			@Override
			public void handlerMessage(MyHttp info) {
				// TODO ������Ϣ
				// JOptionPane.showMessageDialog(null, info);
				data = (List<Map<String, Object>>) info.getData();// �õ���������Ӧ����
				for (int i = 0; i < data.size(); i++) {
					if (tbztArea.getText().equals(
							data.get(i).get("U_ZT"))) {
						flag = true;
					}
				}
				Object object = data.get(0).get("U_ZT");
				table.setModel(new MyModel2(data));
				// infoLabel.setText(object.toString());
			}

			@Override
			public MyHttp getMessage() {
				// TODO ������Ϣ
				MyHttp myHttp = new MyHttp();
				myHttp.setMyUrl("M_ZTTBServiece");
				myHttp.setType(UrlType.NALMORE);
				return myHttp;
			}
		});
	}


	/**
	 * ���ݵ�������������ȡ���ӵ���Ϣ
	 * @param tbzt
	 */
	private void getTieZiDataByTieBaZhuTi(String tbzt) {
		MessageContexts.getInstance().offerMessage(
				new MessageObj() {

					@Override
					public void handlerMessage(MyHttp info) {
						// TODO ������Ϣ
						dataTZ = (List<Map<String, Object>>) info.getData();// �õ���������Ӧ����
						new MyModel3(dataTZ);
						new TieZiFrm().setVisible(true);
					}

					@Override
					public MyHttp getMessage() {
						// TODO ������Ϣ
						MyHttp myHttp = new MyHttp();
						myHttp.setData(tbzt);//��������
						myHttp.setMyUrl("M_TZServiece");
						myHttp.setType(UrlType.NALMORE);
						return myHttp;
					}
				});
	}
}
