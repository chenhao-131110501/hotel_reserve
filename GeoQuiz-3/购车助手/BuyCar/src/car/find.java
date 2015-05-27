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

public class find {

	private JFrame frame;
	private JTable table;
	
	

	/**
	 * Launch the application.
	 */
	
			public static void run() {
				try {
					find window = new find();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	
	
	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	/**
	 * Create the application.
	 */
	public find() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame("ѡ��С����");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 576, 337);
		frame.getContentPane().setLayout(null);
		
		JLabel label_4 = new JLabel("\u65B0\u65E7\u7A0B\u5EA6\uFF1A");
		label_4.setBounds(21, 24, 83, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u8F66\u8F86\u54C1\u724C\uFF1A");
		label_5.setBounds(21, 71, 83, 15);
		frame.getContentPane().add(label_5);
		
		final JComboBox �¾ɳ̶� = new JComboBox();
		�¾ɳ̶�.setBounds(150, 21, 129, 21);
		frame.getContentPane().add(�¾ɳ̶�);
		�¾ɳ̶�.addItem("");
		�¾ɳ̶�.addItem("�³�");
		�¾ɳ̶�.addItem("���ֳ�");
		
		final JComboBox ����Ʒ�� = new JComboBox();
		����Ʒ��.setBounds(150, 71, 129, 21);
		frame.getContentPane().add(����Ʒ��);
		����Ʒ��.addItem("");
		����Ʒ��.addItem("����");
		����Ʒ��.addItem("���");
		����Ʒ��.addItem("����");
		
		
		final JButton ���� = new JButton("\u67E5\u627E");
		����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==����)
				{
					
					String xinjiu = �¾ɳ̶�.getItemAt(�¾ɳ̶�.getSelectedIndex()).toString();
					String pinpai = ����Ʒ��.getItemAt(����Ʒ��.getSelectedIndex()).toString();
					
					
					
					for(int i=0;i<10;i++)
					{
						for(int j=0;j<7;j++)
						table.setValueAt(null,i,j);
					}
					
					
					
					
					
					
					//�����˵�����Ϊ�մ���
					if( (xinjiu == "") || (pinpai == ""))
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
								while(r.next())
								{
									if( pinpai.equals(r.getString(4)) )
									{
										money.add(r.getString(2));
										proportion.add(r.getString(3));
										Pinpai.add(pinpai);
										Yuegong.add(r.getString(5));
										Chezuo.add(r.getString(6));
										Cheming.add(r.getString(7));
										Chehao.add(r.getString(8));
									}
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
								
									table.setValueAt(money.get(i),i,0);
									table.setValueAt(Yuegong.get(i),i,1);
									table.setValueAt(proportion.get(i),i,2);
									table.setValueAt(Chezuo.get(i),i,3);
									table.setValueAt(Pinpai.get(i),i,4);
									table.setValueAt(Cheming.get(i),i,5);
									table.setValueAt(Chehao.get(i),i,6);
								
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
								while(r.next())
								{
									if( pinpai.equals(r.getString(4)) )
									{
										money.add(r.getString(2));
										proportion.add(r.getString(3));
										Pinpai.add(pinpai);
										Yuegong.add(r.getString(5));
										Chezuo.add(r.getString(6));
										Cheming.add(r.getString(7));
										Chehao.add(r.getString(8));
									}
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
		});
		����.setBounds(318, 53, 88, 50);
		frame.getContentPane().add(����);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 132, 538, 159);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 204, 255));
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
		
		JPanel panel_2 = new JPanel();
		scrollPane.setColumnHeaderView(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(448, 53, 102, 43);
		frame.getContentPane().add(btnNewButton);
	}
}
