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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class addcar {

	private JFrame frame;
	private JTextField 车名;
	private JTextField 总价;
	private JTextField 车号;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	
			public static void run() {
				try {
					addcar window = new addcar();
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
	public addcar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
		
		
		
		frame = new JFrame("选车小助手");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 426, 395);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u603B\u4EF7");
		label.setBounds(21, 31, 106, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8F66\u53F7");
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
		
		
		 车名 = new JTextField();
			
			车名.setBounds(172, 7, 129, 21);
			frame.getContentPane().add(车名);
			车名.setColumns(10);
		
		
		总价 = new JTextField();
		总价.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        });  
		总价.setBounds(172, 32, 129, 21);
		frame.getContentPane().add(总价);
		总价.setColumns(10);
		
		车号 = new JTextField();
		车号.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        }); 
		车号.setBounds(172, 69, 129, 21);
		frame.getContentPane().add(车号);
		车号.setColumns(10);
		
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
		
		
		final JButton 添加 = new JButton("\u6DFB\u52A0");
		添加.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==添加)
				{
					String name = 车名.getText();
					String money = 总价.getText();
					String num = 车号.getText();
					String bili = 首付比例.getItemAt(首付比例.getSelectedIndex()).toString();
					String yuegong = 月供.getItemAt(月供.getSelectedIndex()).toString();
					String chezuo = 车座.getItemAt(车座.getSelectedIndex()).toString();
					String xinjiu = 新旧程度.getItemAt(新旧程度.getSelectedIndex()).toString();
					String pinpai = 车辆品牌.getItemAt(车辆品牌.getSelectedIndex()).toString();
					
					
					
					
					
					
					
					
					//下拉菜单输入为空错误
					if((bili == "") || (yuegong == "") || (chezuo == "") || (xinjiu == "") || (pinpai == ""))
					{
						error error = new error();
						error.run();
					}
					
					
					
					if(xinjiu.equals("新车"))
					{
					
					
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
						int ID = 300;
						while(r.next())
						{
							ID++;
							
						}
						
						sql = "insert into newcar values('"+ID+"','"+money+"','"+bili+"','"+pinpai+"','"+yuegong+"','"+chezuo+"','"+name+"','"+num+"')";
						stmt.executeUpdate(sql);
						success.run();
						dispose();
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
					
					
					
					}
					
					
					
					
					
					if(xinjiu.equals("二手车"))
					{
					
					
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
						int ID = 300;
						while(r.next())
						{
							ID++;
							
						}
						
						sql = "insert into newcar values('"+ID+"','"+money+"','"+bili+"','"+pinpai+"','"+yuegong+"','"+chezuo+"','"+name+"','"+num+"')";
						stmt.executeUpdate(sql);
						success.run();
						dispose();
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
					
					
					
					}
					
					
				
				  
					
					
					
					
					
					
					
					
					
					
					}
					
					
					
					
				
					
				}
			});
		
		添加.setBounds(109, 304, 136, 50);
		frame.getContentPane().add(添加);
		
		JLabel label_7 = new JLabel("\u8F66\u540D");
		label_7.setBounds(21, 10, 54, 15);
		frame.getContentPane().add(label_7);
		
		

		


       
		
		
	}
}
