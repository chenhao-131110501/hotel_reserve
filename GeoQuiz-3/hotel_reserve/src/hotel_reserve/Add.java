package hotel_reserve;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Add {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField 姓名;
	private JTextField 电话;
	private JTable table;
	private String s1;
	
	reserve_function h_reserve = new reserve_function(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final ArrayList <String>HHS = new ArrayList<String>();
		final ArrayList <String>SR = new ArrayList<String>();
		final ArrayList <String>DR = new ArrayList<String>();
		
		String room_type;
		String room_num;
		int room_state;
		
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:hotel";
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
			System.out.println("数据库连接失败！！！");
		}
		// 3、操作数据库
		// 通过Connection对象实例化Statement对象
		
		try {
			stmt = conn.createStatement();
			// 为sql变量赋值
			// 插入语句
			sql = "select * from roominfo";
			r = stmt.executeQuery(sql);
			while (r.next()) {			
				room_type = r.getString(3);
				room_state = r.getInt(5);
				room_num = r.getString(2);
				
				if((room_type.equals("豪华双人间"))  && (room_state == 0))
				{
					HHS.add(room_num);
				}
				else if((room_type.equals("双人间"))  && (room_state == 0))
				{
					SR.add(room_num);
				}
				else if((room_type.equals("单人间"))  && (room_state == 0))
				{
					DR.add(room_num);
				}
			}
		} catch (Exception e) {
			System.out.println("操作数据库失败！！！");
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
		
		
		
		
		frame = new JFrame("添加预定客房");
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 597, 409);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(0, 6, 587, 22);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("\u57FA\u672C\u9884\u5B9A\u4FE1\u606F");
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5BBE\u5BA2\u59D3\u540D\uFF1A");
		label_1.setBounds(10, 40, 67, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_2.setBounds(10, 70, 67, 24);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u9884\u5B9A\u89C4\u683C\uFF1A");
		label_3.setBounds(10, 100, 67, 22);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_4.setBounds(10, 130, 67, 22);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u9884\u62B5\u65F6\u95F4\uFF1A");
		label_5.setBounds(10, 160, 67, 22);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u622A\u6B62\u65F6\u95F4\uFF1A");
		label_6.setBounds(10, 190, 67, 31);
		frame.getContentPane().add(label_6);
		
		姓名 = new JTextField();		
		姓名.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                char keyChar = e.getKeyChar();                 
                if(keyChar == ' ' || keyChar == '\t' || keyChar == '\n')
                {  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
                else if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)
                {
                	e.consume(); //关键，屏蔽掉非法输入  
                }
            }  
        });	
		姓名.setBounds(89, 45, 162, 22);
		frame.getContentPane().add(姓名);
		姓名.setColumns(10);
		
		
		
		电话 = new JTextField();
		电话.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        });  
		电话.setBounds(89, 72, 162, 22);
		frame.getContentPane().add(电话);
		电话.setColumns(10);
		
		final JComboBox 预定规格 = new JComboBox();
		预定规格.setBounds(89, 100, 162, 22);
		frame.getContentPane().add(预定规格);
		预定规格.addItem("");
		预定规格.addItem("豪华双人间");
		预定规格.addItem("单人间");
		预定规格.addItem("双人间");
		
		
		final JComboBox 房间编号 = new JComboBox();
		房间编号.setBounds(89, 131, 162, 21);
		frame.getContentPane().add(房间编号);
		房间编号.addItem("");
		
	
		预定规格.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s1 = 预定规格.getItemAt(预定规格.getSelectedIndex()).toString();
				if(s1 == "豪华双人间")
				{
					房间编号.removeAllItems();
					for(int i=0;i<HHS.size();i++)
					{
						房间编号.addItem(HHS.get(i));
					}
				}
				else if(s1 == "单人间")
				{
					房间编号.removeAllItems();
					for(int i=0;i<DR.size();i++)
					{
						房间编号.addItem(DR.get(i));
					}
				}
				else if(s1 == "双人间")
				{
					房间编号.removeAllItems();
					for(int i=0;i<SR.size();i++)
					{
						房间编号.addItem(SR.get(i));
					}
				}
			}
		});
		
		JLabel 提示语 = new JLabel("\u70B9\u51FB\u53F3\u8FB9\u7684\u6309\u94AE\u4EE5\u786E\u5B9A\u6DFB\u52A0");
		提示语.setBounds(10, 242, 171, 31);
		frame.getContentPane().add(提示语);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(278, 38, 299, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("\u672C\u6B21\u9884\u5B9A\u7684\u623F\u95F4\uFF1A");
		label_7.setBounds(0, 0, 141, 15);
		panel_1.add(label_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 299, 49);
		panel_1.add(scrollPane);
		
		
		final JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					dispose();
					Reserve reserve = new Reserve();
					reserve.run();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\cancel.gif"));
		btnNewButton.setBounds(347, 310, 127, 37);
		frame.getContentPane().add(btnNewButton);
		
		final JComboBox 预抵_月 = new JComboBox();
		预抵_月.setBounds(89, 161, 43, 21);
		frame.getContentPane().add(预抵_月);
		预抵_月.addItem("");
		预抵_月.addItem("1");
		预抵_月.addItem("2");
		预抵_月.addItem("3");
		预抵_月.addItem("4");
		预抵_月.addItem("5");
		预抵_月.addItem("6");
		预抵_月.addItem("7");
		预抵_月.addItem("8");
		预抵_月.addItem("9");
		预抵_月.addItem("10");
		预抵_月.addItem("11");
		预抵_月.addItem("12");
		
		
		final JComboBox 预抵_日 = new JComboBox();
		预抵_日.setBounds(140, 161, 43, 21);
		frame.getContentPane().add(预抵_日);
		预抵_日.addItem("");
		预抵_日.addItem("1");
		预抵_日.addItem("2");
		预抵_日.addItem("3");
		预抵_日.addItem("4");
		预抵_日.addItem("5");
		预抵_日.addItem("6");
		预抵_日.addItem("7");
		预抵_日.addItem("8");
		预抵_日.addItem("9");
		预抵_日.addItem("10");
		预抵_日.addItem("11");
		预抵_日.addItem("12");
		预抵_日.addItem("13");
		预抵_日.addItem("14");
		预抵_日.addItem("15");
		预抵_日.addItem("16");
		预抵_日.addItem("17");
		预抵_日.addItem("18");
		预抵_日.addItem("19");
		预抵_日.addItem("20");
		预抵_日.addItem("21");
		预抵_日.addItem("22");
		预抵_日.addItem("23");
		预抵_日.addItem("24");
		预抵_日.addItem("25");
		预抵_日.addItem("26");
		预抵_日.addItem("27");
		预抵_日.addItem("28");
		预抵_日.addItem("29");
		预抵_日.addItem("30");
		预抵_日.addItem("31");
		
		
		final JComboBox 预抵_年 = new JComboBox();
		预抵_年.setBounds(191, 161, 60, 21);
		frame.getContentPane().add(预抵_年);
		预抵_年.addItem("");
		预抵_年.addItem("2015");
		预抵_年.addItem("2016");
		预抵_年.addItem("2017");
		
		final JComboBox 保留_月 = new JComboBox();
		保留_月.setBounds(89, 195, 45, 21);
		frame.getContentPane().add(保留_月);
		保留_月.addItem("");
		保留_月.addItem("1");
		保留_月.addItem("2");
		保留_月.addItem("3");
		保留_月.addItem("4");
		保留_月.addItem("5");
		保留_月.addItem("6");
		保留_月.addItem("7");
		保留_月.addItem("8");
		保留_月.addItem("9");
		保留_月.addItem("10");
		保留_月.addItem("11");
		保留_月.addItem("12");
		
		
		final JComboBox 保留_日 = new JComboBox();
		保留_日.setBounds(140, 195, 43, 21);
		frame.getContentPane().add(保留_日);
		保留_日.addItem("");
		保留_日.addItem("1");
		保留_日.addItem("2");
		保留_日.addItem("3");
		保留_日.addItem("4");
		保留_日.addItem("5");
		保留_日.addItem("6");
		保留_日.addItem("7");
		保留_日.addItem("8");
		保留_日.addItem("9");
		保留_日.addItem("10");
		保留_日.addItem("11");
		保留_日.addItem("12");
		保留_日.addItem("13");
		保留_日.addItem("14");
		保留_日.addItem("15");
		保留_日.addItem("16");
		保留_日.addItem("17");
		保留_日.addItem("18");
		保留_日.addItem("19");
		保留_日.addItem("20");
		保留_日.addItem("21");
		保留_日.addItem("22");
		保留_日.addItem("23");
		保留_日.addItem("24");
		保留_日.addItem("25");
		保留_日.addItem("26");
		保留_日.addItem("27");
		保留_日.addItem("28");
		保留_日.addItem("29");
		保留_日.addItem("30");
		保留_日.addItem("31");
		
		
		final JComboBox 保留_年 = new JComboBox();
		保留_年.setBounds(191, 195, 60, 21);
		frame.getContentPane().add(保留_年);
		保留_年.addItem("");
		保留_年.addItem("2015");
		保留_年.addItem("2016");
		保留_年.addItem("2017");
	
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\u9884\u5B9A\u89C4\u683C", "\u623F\u95F4\u7F16\u53F7"
			}
		));
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		
		final JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==button)
				{
					String roomType = 预定规格.getItemAt(预定规格.getSelectedIndex()).toString();
					String roomNum = 房间编号.getItemAt(房间编号.getSelectedIndex()).toString();
					String Yuding_nian = (String)预抵_年.getSelectedItem();
					String Yuding_yue = (String)预抵_月.getSelectedItem();
					String Yuding_ri = (String)预抵_日.getSelectedItem();
					String baoliu_nian = (String)保留_年.getSelectedItem();
					String baoliu_yue = (String)保留_月.getSelectedItem();
					String baoliu_ri = (String)保留_日.getSelectedItem();
					
					
					//下拉菜单输入为空错误
					if((roomType == "") || (Yuding_nian == "") || (Yuding_yue == "") || (Yuding_ri == "") || (baoliu_nian == "") || (baoliu_yue == "") || (baoliu_ri == ""))
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					//时间输入错误
					if(Integer.parseInt((String) Yuding_nian) <= Integer.parseInt((String) baoliu_nian))
					{
						if((Integer.parseInt((String) Yuding_nian) == Integer.parseInt((String) baoliu_nian)))
						{
							if(Integer.parseInt((String) Yuding_yue) > Integer.parseInt((String) baoliu_yue))
							{
								input_error error = new input_error();
								error.run();
							}
							if(Integer.parseInt((String) Yuding_yue) == Integer.parseInt((String) baoliu_yue))
							{
								if((Integer.parseInt((String) Yuding_ri) > Integer.parseInt((String) baoliu_ri)))
								{
									input_error error = new input_error();
									error.run();
								}
							}
						}
					}
					if(Integer.parseInt((String) Yuding_nian) > Integer.parseInt((String) baoliu_nian))
					{
						input_error error = new input_error();
						error.run();
					}
					
					//输入不存在日期问题
					if(Integer.parseInt((String) Yuding_yue) == 2 && Integer.parseInt((String) Yuding_ri)>28)
					{
						input_error error = new input_error();
						error.run();
					}
					if(((Integer.parseInt((String) Yuding_yue) == 4) || (Integer.parseInt((String) Yuding_yue) == 6) || (Integer.parseInt((String) Yuding_yue) == 9) || (Integer.parseInt((String) Yuding_yue) == 11)) && Integer.parseInt((String) Yuding_ri)>30)
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					
					if(Integer.parseInt((String) baoliu_yue) == 2 && Integer.parseInt((String) baoliu_ri)>28)
					{
						input_error error = new input_error();
						error.run();
					}
					if(((Integer.parseInt((String) baoliu_yue) == 4) || (Integer.parseInt((String) baoliu_yue) == 6) || (Integer.parseInt((String) baoliu_yue) == 9) || (Integer.parseInt((String) baoliu_yue) == 11)) && Integer.parseInt((String) baoliu_ri)>30)
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					else
					{
						table.setValueAt(roomType, 0, 0);
						table.setValueAt(roomNum, 0, 1);
					}
				}
			}
		});
		button.setBounds(168, 244, 83, 27);
		frame.getContentPane().add(button);
		
		
		final JButton button_1 = new JButton("\u4FDD\u5B58");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==button_1)
				{
					String name = 姓名.getText();
					String tel = 电话.getText();
					String roomType = 预定规格.getItemAt(预定规格.getSelectedIndex()).toString();
					String roomNum = 房间编号.getItemAt(房间编号.getSelectedIndex()).toString();
					String Yuding_nian = (String)预抵_年.getSelectedItem();
					String Yuding_yue = (String)预抵_月.getSelectedItem();
					String Yuding_ri = (String)预抵_日.getSelectedItem();
					String baoliu_nian = (String)保留_年.getSelectedItem();
					String baoliu_yue = (String)保留_月.getSelectedItem();
					String baoliu_ri = (String)保留_日.getSelectedItem();
					
					
					//下拉菜单输入为空错误
					if((roomType == "") || (Yuding_nian == "") || (Yuding_yue == "") || (Yuding_ri == "") || (baoliu_nian == "") || (baoliu_yue == "") || (baoliu_ri == ""))
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					//时间输入错误
					if(Integer.parseInt((String) Yuding_nian) <= Integer.parseInt((String) baoliu_nian))
					{
						if((Integer.parseInt((String) Yuding_nian) == Integer.parseInt((String) baoliu_nian)))
						{
							if(Integer.parseInt((String) Yuding_yue) > Integer.parseInt((String) baoliu_yue))
							{
								input_error error = new input_error();
								error.run();
							}
							if(Integer.parseInt((String) Yuding_yue) == Integer.parseInt((String) baoliu_yue))
							{
								if((Integer.parseInt((String) Yuding_ri) > Integer.parseInt((String) baoliu_ri)))
								{
									input_error error = new input_error();
									error.run();
								}
							}
						}
					}
					if(Integer.parseInt((String) Yuding_nian) > Integer.parseInt((String) baoliu_nian))
					{
						input_error error = new input_error();
						error.run();
					}
					//输入不存在日期问题
					if(Integer.parseInt((String) Yuding_yue) == 2 && Integer.parseInt((String) Yuding_ri)>28)
					{
						input_error error = new input_error();
						error.run();
					}
					if(((Integer.parseInt((String) Yuding_yue) == 4) || (Integer.parseInt((String) Yuding_yue) == 6) || (Integer.parseInt((String) Yuding_yue) == 9) || (Integer.parseInt((String) Yuding_yue) == 11)) && Integer.parseInt((String) Yuding_ri)>30)
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					
					if(Integer.parseInt((String) baoliu_yue) == 2 && Integer.parseInt((String) baoliu_ri)>28)
					{
						input_error error = new input_error();
						error.run();
					}
					if(((Integer.parseInt((String) baoliu_yue) == 4) || (Integer.parseInt((String) baoliu_yue) == 6) || (Integer.parseInt((String) baoliu_yue) == 9) || (Integer.parseInt((String) baoliu_yue) == 11)) && Integer.parseInt((String) baoliu_ri)>30)
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					else
					{
						h_reserve.add(name,tel,roomType,roomNum,Yuding_nian,Yuding_yue,Yuding_ri,baoliu_nian,baoliu_yue,baoliu_ri);
						dispose();
						Reserve reserve = new Reserve();
						reserve.run();
					}
				}
			}
		});
		button_1.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\save.gif"));
		button_1.setBounds(72, 310, 127, 37);
		frame.getContentPane().add(button_1);
		
		
		
		JLabel label_10 = new JLabel("\u6708");
		label_10.setBounds(99, 222, 33, 22);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\u65E5");
		label_11.setBounds(150, 222, 31, 22);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("\u5E74");
		label_12.setBounds(201, 226, 33, 15);
		frame.getContentPane().add(label_12);
		
		JLabel label_9 = new JLabel("\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7");
		label_9.setBounds(0, 285, 587, 15);
		frame.getContentPane().add(label_9);
		

	}
	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}

	public void run() {
		try {
			Add window = new Add();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
