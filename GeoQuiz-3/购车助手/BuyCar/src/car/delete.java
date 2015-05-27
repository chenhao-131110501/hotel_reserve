package car;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.JComboBox;
import java.awt.Color;

public class delete extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField_1;
	private JLabel label;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	
			public static void run() {
				try {
					delete frame = new delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public delete() {
		setBounds(100, 100, 386, 197);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u8F66\u53F7");
		lblNewLabel.setBounds(20, 59, 119, 15);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String xinjiu = comboBox.getItemAt(comboBox.getSelectedIndex()).toString();
				String num = textField_1.getText();
				//下拉菜单输入为空错误
				if((xinjiu == "") ||(num.equals("")))
				{
					error error = new error();
					error.run();
				}
				
				else{
				
				
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
				} catch (Exception er) {
					// 此处使用out.print是处于演示目的，在实际开发中所有的错误消息，
					// 绝对不能够通过System.out.print打印，否则会存在安全问题
					System.out.println("数据库驱动程序加载失败！！！");
				}
				// 2、连接数据库
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception er) {
					System.out.println("数据库连接失败");
				}
				// 3、操作数据库
				// 通过Connection对象实例化Statement对象
				
				try {
					stmt = conn.createStatement();
					sql = "select * from newcar";
					r = stmt.executeQuery(sql);
					sql = "delete * from newcar where 车号 = '"+num+"'";
					stmt.executeUpdate(sql);
					success.run();
					dispose();
				} catch (Exception er) {
					System.out.println(er);
				}
				// 4、关闭数据库
				try {
					// 关闭操作
					stmt.close();
					// 关闭连接
					conn.close();
				} catch (Exception er) {
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
				} catch (Exception er) {
					// 此处使用out.print是处于演示目的，在实际开发中所有的错误消息，
					// 绝对不能够通过System.out.print打印，否则会存在安全问题
					System.out.println("数据库驱动程序加载失败！！！");
				}
				// 2、连接数据库
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception er) {
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
					
					sql = "delete * from newcar where 车号 = '"+num+"'";
					stmt.executeUpdate(sql);
					success.run();
					dispose();
				} catch (Exception er) {
					System.out.println(e);
				}
				// 4、关闭数据库
				try {
					// 关闭操作
					stmt.close();
					// 关闭连接
					conn.close();
				} catch (Exception er) {
				System.out.println("数据库关闭失败！！！");
				}
				
				
				
				}
				
				
				
				
				
				
				
				
				
				
				}
				
				
			}
		});
		btnNewButton.setBounds(46, 110, 93, 23);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        }); 
		textField_1.setBounds(161, 56, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		label = new JLabel("\u8BF7\u9009\u62E9\u8F66\u7684\u79CD\u7C7B");
		label.setBounds(20, 20, 109, 15);
		contentPane.add(label);
		
		comboBox = new JComboBox();
		comboBox.setBounds(161, 17, 66, 21);
		comboBox.addItem("");
		comboBox.addItem("新车");
		comboBox.addItem("二手车");
		contentPane.add(comboBox);
				addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
				});
		
		
		
		
		
	}
	public void dispose() {
		this.setVisible(false);
		}
	

}


