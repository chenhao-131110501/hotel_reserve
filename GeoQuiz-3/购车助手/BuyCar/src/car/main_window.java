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
	private JTextField 最低价格;
	private JTextField 最高价格;
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
		
		
		
		frame = new JFrame("选车小助手");
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
		
		最低价格 = new JTextField();
		最低价格.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        });  
		最低价格.setBounds(172, 32, 129, 21);
		frame.getContentPane().add(最低价格);
		最低价格.setColumns(10);
		
		最高价格 = new JTextField();
		最高价格.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        }); 
		最高价格.setBounds(172, 69, 129, 21);
		frame.getContentPane().add(最高价格);
		最高价格.setColumns(10);
		
		final JComboBox 首付比例 = new JComboBox();
		首付比例.setBounds(172, 139, 129, 21);
		frame.getContentPane().add(首付比例);
		首付比例.addItem("");
		首付比例.addItem("30%");
		首付比例.addItem("60%");
		
		final JComboBox 车座 = new JComboBox();
		车座.setBounds(172, 179, 129, 21);
		frame.getContentPane().add(车座);
		车座.addItem("");
		车座.addItem("四座");
		车座.addItem("七座");
		
		final JComboBox 新旧程度 = new JComboBox();
		新旧程度.setBounds(172, 219, 129, 21);
		frame.getContentPane().add(新旧程度);
		新旧程度.addItem("");
		新旧程度.addItem("新车");
		新旧程度.addItem("二手车");
		
		final JComboBox 车辆品牌 = new JComboBox();
		车辆品牌.setBounds(172, 262, 129, 21);
		frame.getContentPane().add(车辆品牌);
		车辆品牌.addItem("");
		车辆品牌.addItem("宝马");
		车辆品牌.addItem("别克");
		车辆品牌.addItem("奇瑞");
		

		 
		
		JLabel label_6 = new JLabel("\u6708\u4F9B\uFF1A");
		label_6.setBounds(21, 111, 83, 15);
		frame.getContentPane().add(label_6);
		
		final JComboBox 月供 = new JComboBox();
		月供.setBounds(172, 108, 129, 21);
		frame.getContentPane().add(月供);
		月供.addItem("");
		月供.addItem("2000");
		月供.addItem("4000");
		
		
		final JButton 查找 = new JButton("\u67E5\u627E\u7B26\u5408\u6570\u636E\u7684\u6C7D\u8F66");
		查找.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==查找)
				{
					String money_min = 最低价格.getText();
					String money_max = 最高价格.getText();
					String bili = 首付比例.getItemAt(首付比例.getSelectedIndex()).toString();
					String yuegong = 月供.getItemAt(月供.getSelectedIndex()).toString();
					String chezuo = 车座.getItemAt(车座.getSelectedIndex()).toString();
					String xinjiu = 新旧程度.getItemAt(新旧程度.getSelectedIndex()).toString();
					String pinpai = 车辆品牌.getItemAt(车辆品牌.getSelectedIndex()).toString();
					
					
					
					for(int i=0;i<10;i++)
					{
						for(int j=0;j<7;j++)
						table.setValueAt(null,i,j);
					}
					
					
					
					
					
					
					//下拉菜单输入为空错误
					if((bili == "") || (yuegong == "") || (chezuo == "") || (xinjiu == "") || (pinpai == ""))
					{
						error error = new error();
						error.run();
					}
					
					//价格错误
					if(Integer.parseInt((String) money_min) > Integer.parseInt((String)money_max))
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
		查找.setBounds(331, 236, 157, 50);
		frame.getContentPane().add(查找);
		
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
