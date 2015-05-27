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
		
		
		
		frame = new JFrame("选车小助手");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 576, 337);
		frame.getContentPane().setLayout(null);
		
		JLabel label_4 = new JLabel("\u65B0\u65E7\u7A0B\u5EA6\uFF1A");
		label_4.setBounds(21, 24, 83, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u8F66\u8F86\u54C1\u724C\uFF1A");
		label_5.setBounds(21, 71, 83, 15);
		frame.getContentPane().add(label_5);
		
		final JComboBox 新旧程度 = new JComboBox();
		新旧程度.setBounds(150, 21, 129, 21);
		frame.getContentPane().add(新旧程度);
		新旧程度.addItem("");
		新旧程度.addItem("新车");
		新旧程度.addItem("二手车");
		
		final JComboBox 车辆品牌 = new JComboBox();
		车辆品牌.setBounds(150, 71, 129, 21);
		frame.getContentPane().add(车辆品牌);
		车辆品牌.addItem("");
		车辆品牌.addItem("宝马");
		车辆品牌.addItem("别克");
		车辆品牌.addItem("奇瑞");
		
		
		final JButton 查找 = new JButton("\u67E5\u627E");
		查找.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==查找)
				{
					
					String xinjiu = 新旧程度.getItemAt(新旧程度.getSelectedIndex()).toString();
					String pinpai = 车辆品牌.getItemAt(车辆品牌.getSelectedIndex()).toString();
					
					
					
					for(int i=0;i<10;i++)
					{
						for(int j=0;j<7;j++)
						table.setValueAt(null,i,j);
					}
					
					
					
					
					
					
					//下拉菜单输入为空错误
					if( (xinjiu == "") || (pinpai == ""))
					{
						error error = new error();
						error.run();
					}
					
					
					else if(xinjiu.equals("新车"))
					{
						
						final ArrayList <String>money = new ArrayList<String>();
						final ArrayList <String>proportion = new ArrayList<String>();
						final ArrayList <String>Pinpai = new ArrayList<String>();
						final ArrayList <String>Yuegong = new ArrayList<String>();
						final ArrayList <String>Chezuo = new ArrayList<String>();
						final ArrayList <String>Cheming = new ArrayList<String>();
						final ArrayList <String>Chehao = new ArrayList<String>();
						
						// 定义数据库驱动程序
							String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
							// 定义数据库连接地址
							String DBURL = "jdbc:odbc:car";
							// 定义数据库连接对象，属于java.sql包中的接口
							Connection conn = null;
							// 定义Statement对象，用于操作数据库
							Statement stmt = null;
							// 定义一字符串变量，用于保存SQL语句
							String sql = null;
							// 定义一个结果集以存放检索的结果
							ResultSet r = null;
							// 1、加载驱动程序
							try {
								Class.forName(DBDRIVER);
							} catch (Exception e) {
								// 此处使用out.print是处于演示目的，在实际开发中所有的错误消息，
								// 绝对不能够通过System.out.print打印，否则会存在安全问题
								System.out.println("数据库驱动程序加载失败！！！");
							}
							// 2、连接数据库
							try {
								conn = DriverManager.getConnection(DBURL);
							} catch (Exception e) {
								System.out.println("数据库连接失败");
							}
							// 3、操作数据库
							// 通过Connection对象实例化Statement对象
							
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
							// 4、关闭数据库
							try {
								// 关闭操作
								stmt.close();
								// 关闭连接
								conn.close();
							} catch (Exception e) {
							System.out.println("数据库关闭失败！！！");
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
					
					
					else if(xinjiu.equals("二手车"))
					{
						final ArrayList <String>money = new ArrayList<String>();
						final ArrayList <String>proportion = new ArrayList<String>();
						final ArrayList <String>Pinpai = new ArrayList<String>();
						final ArrayList <String>Yuegong = new ArrayList<String>();
						final ArrayList <String>Chezuo = new ArrayList<String>();
						final ArrayList <String>Cheming = new ArrayList<String>();
						final ArrayList <String>Chehao = new ArrayList<String>();
						
						// 定义数据库驱动程序
							String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
							// 定义数据库连接地址
							String DBURL = "jdbc:odbc:car";
							// 定义数据库连接对象，属于java.sql包中的接口
							Connection conn = null;
							// 定义Statement对象，用于操作数据库
							Statement stmt = null;
							// 定义一字符串变量，用于保存SQL语句
							String sql = null;
							// 定义一个结果集以存放检索的结果
							ResultSet r = null;
							// 1、加载驱动程序
							try {
								Class.forName(DBDRIVER);
							} catch (Exception e) {
								// 此处使用out.print是处于演示目的，在实际开发中所有的错误消息，
								// 绝对不能够通过System.out.print打印，否则会存在安全问题
								System.out.println("数据库驱动程序加载失败！！！");
							}
							// 2、连接数据库
							try {
								conn = DriverManager.getConnection(DBURL);
							} catch (Exception e) {
								System.out.println("数据库连接失败");
							}
							// 3、操作数据库
							// 通过Connection对象实例化Statement对象
							
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
							// 4、关闭数据库
							try {
								// 关闭操作
								stmt.close();
								// 关闭连接
								conn.close();
							} catch (Exception e) {
							System.out.println("数据库关闭失败！！！");
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
		查找.setBounds(318, 53, 88, 50);
		frame.getContentPane().add(查找);
		
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
