package car;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class main_window {

	private JFrame frame;
	private JTextField ��ͼ۸�;
	private JTextField ��߼۸�;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_window window = new main_window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame("ѡ��С����");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 614, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u9884\u8BA1\u6700\u4F4E\u4EF7\u683C\uFF1A");
		label.setBounds(21, 31, 106, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u9884\u8BA1\u6700\u9AD8\u4EF7\u683C\uFF1A");
		label_1.setBounds(21, 72, 106, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u9996\u4ED8\u6BD4\u4F8B\uFF1A");
		label_2.setBounds(21, 142, 83, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u8F66\u5EA7\uFF1A");
		label_3.setBounds(21, 182, 54, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u65B0\u65E7\u7A0B\u5EA6\uFF1A");
		label_4.setBounds(21, 222, 83, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u8F66\u8F86\u54C1\u724C\uFF1A");
		label_5.setBounds(21, 265, 83, 15);
		frame.getContentPane().add(label_5);
		
		��ͼ۸� = new JTextField();
		��ͼ۸�.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        });  
		��ͼ۸�.setBounds(172, 32, 129, 21);
		frame.getContentPane().add(��ͼ۸�);
		��ͼ۸�.setColumns(10);
		
		��߼۸� = new JTextField();
		��߼۸�.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        }); 
		��߼۸�.setBounds(172, 69, 129, 21);
		frame.getContentPane().add(��߼۸�);
		��߼۸�.setColumns(10);
		
		final JComboBox �׸����� = new JComboBox();
		�׸�����.setBounds(172, 139, 129, 21);
		frame.getContentPane().add(�׸�����);
		�׸�����.addItem("");
		�׸�����.addItem("30%");
		�׸�����.addItem("60%");
		
		final JComboBox ���� = new JComboBox();
		����.setBounds(172, 179, 129, 21);
		frame.getContentPane().add(����);
		����.addItem("");
		����.addItem("����");
		����.addItem("����");
		
		final JComboBox �¾ɳ̶� = new JComboBox();
		�¾ɳ̶�.setBounds(172, 219, 129, 21);
		frame.getContentPane().add(�¾ɳ̶�);
		�¾ɳ̶�.addItem("");
		�¾ɳ̶�.addItem("�³�");
		�¾ɳ̶�.addItem("���ֳ�");
		
		final JComboBox ����Ʒ�� = new JComboBox();
		����Ʒ��.setBounds(172, 262, 129, 21);
		frame.getContentPane().add(����Ʒ��);
		����Ʒ��.addItem("");
		����Ʒ��.addItem("����");
		����Ʒ��.addItem("���");
		����Ʒ��.addItem("����");
		

		 
		
		JLabel label_6 = new JLabel("\u6708\u4F9B\uFF1A");
		label_6.setBounds(21, 111, 83, 15);
		frame.getContentPane().add(label_6);
		
		final JComboBox �¹� = new JComboBox();
		�¹�.setBounds(172, 108, 129, 21);
		frame.getContentPane().add(�¹�);
		�¹�.addItem("");
		�¹�.addItem("2000");
		�¹�.addItem("4000");
		
		
		final JButton ���� = new JButton("\u67E5\u627E\u7B26\u5408\u6570\u636E\u7684\u6C7D\u8F66");
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==����)
				{
					String money_min = ��ͼ۸�.getText();
					String money_max = ��߼۸�.getText();
					String bili = �׸�����.getItemAt(�׸�����.getSelectedIndex()).toString();
					String yuegong = �¹�.getItemAt(�¹�.getSelectedIndex()).toString();
					String chezuo = ����.getItemAt(����.getSelectedIndex()).toString();
					String xinjiu = �¾ɳ̶�.getItemAt(�¾ɳ̶�.getSelectedIndex()).toString();
					String pinpai = ����Ʒ��.getItemAt(����Ʒ��.getSelectedIndex()).toString();
					
					
					
					for(int i=0;i<10;i++)
					{
						for(int j=0;j<7;j++)
						table.setValueAt(null,i,j);
					}
					
					
					
					
					
					
					//�����˵�����Ϊ�մ���
					if((bili == "") || (yuegong == "") || (chezuo == "") || (xinjiu == "") || (pinpai == ""))
					{
						error error = new error();
						error.run();
					}
					
					//�۸����
					if(Integer.parseInt((String) money_min) > Integer.parseInt((String)money_max))
					{
						error error = new error();
						error.run();
					}
					
					else if(xinjiu.equals("�³�"))
					{
						
						final ArrayList <String>money = new ArrayList<String>();
						final ArrayList <String>proportion = new ArrayList<String>();
						final ArrayList <String>Pinpai = new ArrayList<String>();
						final ArrayList <String>Yuegong = new ArrayList<String>();
						final ArrayList <String>Chezuo = new ArrayList<String>();
						final ArrayList <String>Cheming = new ArrayList<String>();
						final ArrayList <String>Chehao = new ArrayList<String>();
						
						// �������ݿ���������
							String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
							// �������ݿ����ӵ�ַ
							String DBURL = "jdbc:odbc:car";
							// �������ݿ����Ӷ�������java.sql���еĽӿ�
							Connection conn = null;
							// ����Statement�������ڲ������ݿ�
							Statement stmt = null;
							// ����һ�ַ������������ڱ���SQL���
							String sql = null;
							// ����һ��������Դ�ż����Ľ��
							ResultSet r = null;
							// 1��������������
							try {
								Class.forName(DBDRIVER);
							} catch (Exception e) {
								// �˴�ʹ��out.print�Ǵ�����ʾĿ�ģ���ʵ�ʿ��������еĴ�����Ϣ��
								// ���Բ��ܹ�ͨ��System.out.print��ӡ���������ڰ�ȫ����
								System.out.println("���ݿ������������ʧ�ܣ�����");
							}
							// 2���������ݿ�
							try {
								conn = DriverManager.getConnection(DBURL);
							} catch (Exception e) {
								System.out.println("���ݿ�����ʧ��");
							}
							// 3���������ݿ�
							// ͨ��Connection����ʵ����Statement����
							
							try {
								stmt = conn.createStatement();
								sql = "select * from newcar";
								r = stmt.executeQuery(sql);
								int flag=0;
								while(r.next())
								{
									if(bili.equals(r.getString(3)) && pinpai.equals(r.getString(4)) && yuegong.equals(r.getString(5)) && chezuo.equals(r.getString(6)))
									{
										money.add(r.getString(2));
										proportion.add(bili);
										Pinpai.add(pinpai);
										Yuegong.add(yuegong);
										Chezuo.add(chezuo);
										Cheming.add(r.getString(7));
										Chehao.add(r.getString(8));
										flag=1;
									}
								}
								if(flag==0)
								{
									no_find.run();
								}
							} catch (Exception e) {
								System.out.println(e);
							}
							// 4���ر����ݿ�
							try {
								// �رղ���
								stmt.close();
								// �ر�����
								conn.close();
							} catch (Exception e) {
							System.out.println("���ݿ�ر�ʧ�ܣ�����");
							}
							
							for(int i=0;i<money.size();i++)
							{
								if((Integer.parseInt(money.get(i)) > Integer.parseInt((String) money_min)) &&  (Integer.parseInt(money.get(i)) < Integer.parseInt((String) money_max)))
								{
									table.setValueAt(money.get(i),i,0);
									table.setValueAt(Yuegong.get(i),i,1);
									table.setValueAt(proportion.get(i),i,2);
									table.setValueAt(Chezuo.get(i),i,3);
									table.setValueAt(Pinpai.get(i),i,4);
									table.setValueAt(Cheming.get(i),i,5);
									table.setValueAt(Chehao.get(i),i,6);
								}
								
							}
							
					}
					
					
					else if(xinjiu.equals("���ֳ�"))
					{
						final ArrayList <String>money = new ArrayList<String>();
						final ArrayList <String>proportion = new ArrayList<String>();
						final ArrayList <String>Pinpai = new ArrayList<String>();
						final ArrayList <String>Yuegong = new ArrayList<String>();
						final ArrayList <String>Chezuo = new ArrayList<String>();
						final ArrayList <String>Cheming = new ArrayList<String>();
						final ArrayList <String>Chehao = new ArrayList<String>();
						
						// �������ݿ���������
							String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
							// �������ݿ����ӵ�ַ
							String DBURL = "jdbc:odbc:car";
							// �������ݿ����Ӷ�������java.sql���еĽӿ�
							Connection conn = null;
							// ����Statement�������ڲ������ݿ�
							Statement stmt = null;
							// ����һ�ַ������������ڱ���SQL���
							String sql = null;
							// ����һ��������Դ�ż����Ľ��
							ResultSet r = null;
							// 1��������������
							try {
								Class.forName(DBDRIVER);
							} catch (Exception e) {
								// �˴�ʹ��out.print�Ǵ�����ʾĿ�ģ���ʵ�ʿ��������еĴ�����Ϣ��
								// ���Բ��ܹ�ͨ��System.out.print��ӡ���������ڰ�ȫ����
								System.out.println("���ݿ������������ʧ�ܣ�����");
							}
							// 2���������ݿ�
							try {
								conn = DriverManager.getConnection(DBURL);
							} catch (Exception e) {
								System.out.println("���ݿ�����ʧ��");
							}
							// 3���������ݿ�
							// ͨ��Connection����ʵ����Statement����
							
							try {
								stmt = conn.createStatement();
								sql = "select * from oldcar";
								r = stmt.executeQuery(sql);
								int flag=0;
								while(r.next())
								{
									if(bili.equals(r.getString(3)) && pinpai.equals(r.getString(4)) && yuegong.equals(r.getString(5)) && chezuo.equals(r.getString(6)))
									{
										money.add(r.getString(2));
										proportion.add(bili);
										Pinpai.add(pinpai);
										Yuegong.add(yuegong);
										Chezuo.add(chezuo);
										Cheming.add(r.getString(7));
										Chehao.add(r.getString(8));
										flag=1;
									}
								}
								if(flag==0)
								{
									no_find.run();
								}
							} catch (Exception e) {
								System.out.println(e);
							}
							// 4���ر����ݿ�
							try {
								// �رղ���
								stmt.close();
								// �ر�����
								conn.close();
							} catch (Exception e) {
							System.out.println("���ݿ�ر�ʧ�ܣ�����");
							}
							
							for(int i=0;i<money.size();i++)
							{
								if((Integer.parseInt(money.get(i)) > Integer.parseInt((String) money_min)) &&  (Integer.parseInt(money.get(i)) < Integer.parseInt((String) money_max)))
								{
									table.setValueAt(money.get(i),i,0);
									table.setValueAt(Yuegong.get(i),i,1);
									table.setValueAt(proportion.get(i),i,2);
									table.setValueAt(Chezuo.get(i),i,3);
									table.setValueAt(Pinpai.get(i),i,4);
									table.setValueAt(Cheming.get(i),i,5);
									table.setValueAt(Chehao.get(i),i,6);
								}
							}
					}
					
				
					
				}
			}
		});
		����.setBounds(331, 236, 157, 50);
		frame.getContentPane().add(����);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 305, 598, 154);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 598, 159);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 204, 204));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"\u4EF7\u683C(\u4E07)", "\u6708\u4F9B", "\u9996\u4ED8\u6BD4\u4F8B", "\u8F66\u5EA7", "\u54C1\u724C", "\u8F66\u540D", "\u8F66\u8F86\u7F16\u53F7"
			}
		));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u65B0\u8F66");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcar.run();
				
			}
		});
		btnNewButton.setBounds(482, 10, 106, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u6C7D\u8F66\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change.run();
			}
		});
		btnNewButton_1.setBounds(482, 61, 106, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u6C7D\u8F66\u4FE1\u606F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete.run();
			}
		});
		btnNewButton_2.setBounds(482, 111, 106, 36);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u6C7D\u8F66\u4FE1\u606F");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find.run();
			}
		});
		btnNewButton_3.setBounds(482, 157, 106, 40);
		frame.getContentPane().add(btnNewButton_3);
	}
	
	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	public static void run() {
		try {
			main_window window = new main_window();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
