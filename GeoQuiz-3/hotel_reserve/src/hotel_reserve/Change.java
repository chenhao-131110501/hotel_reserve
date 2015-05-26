package hotel_reserve;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Change {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField 姓名;
	private JTextField 电话;
	private JTextField 输入;
	
	reserve_function h_reserve = new reserve_function(); 
	private JTextField 电话栏;
	private JTextField 房间规格栏;
	private JTextField 房间编号栏;
	private JTextField 姓名栏;
	private JTextField 预定_年;
	private JTextField 预定_月;
	private JTextField 预定_日;
	private JTextField 截止_年;
	private JTextField 截止_月;
	private JTextField 截止_日;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change window = new Change();
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
	public Change() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final ArrayList <String>room_num = new ArrayList<String>();
		final ArrayList <String>name = new ArrayList<String>();
		final ArrayList <String>tel = new ArrayList<String>();
		final ArrayList <String>room_type = new ArrayList<String>();
		final ArrayList <String>yu_nian = new ArrayList<String>();
		final ArrayList <String>yu_yue = new ArrayList<String>();
		final ArrayList <String>yu_ri = new ArrayList<String>();
		final ArrayList <String>end_nian = new ArrayList<String>();
		final ArrayList <String>end_yue = new ArrayList<String>();
		final ArrayList <String>end_ri = new ArrayList<String>();
		
		final ArrayList <String>HHS = new ArrayList<String>();
		final ArrayList <String>SR = new ArrayList<String>();
		final ArrayList <String>DR = new ArrayList<String>();
		
		final ArrayList <String>temp = new ArrayList<String>();
		
		
		String room_type_theOne;
		int room_state_theOne;
		String room_num_theOne;
		
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
		String sql_other =null;
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
			sql = "select * from reserve";
			r = stmt.executeQuery(sql);
			while (r.next()) {		
				name.add(r.getString(2));
				tel.add(r.getString(3));
				room_type.add(r.getString(4));
				room_num.add(r.getString(5));
				yu_nian.add(r.getString(6));
				yu_yue.add(r.getString(7));
				yu_ri.add(r.getString(8));
				end_nian.add(r.getString(9));
				end_yue.add(r.getString(10));
				end_ri.add(r.getString(11));
			}
			
			
			sql_other = "select * from roominfo";
			r = stmt.executeQuery(sql_other);
			while (r.next()) {			
				room_type_theOne = r.getString(3);
				room_state_theOne = r.getInt(5);
				room_num_theOne = r.getString(2);
				
				if((room_type_theOne.equals("豪华双人间"))  && (room_state_theOne == 0))
				{
					HHS.add(room_num_theOne);
				}
				else if((room_type_theOne.equals("双人间"))  && (room_state_theOne == 0))
				{
					SR.add(room_num_theOne);
				}
				else if((room_type_theOne.equals("单人间"))  && (room_state_theOne == 0))
				{
					DR.add(room_num_theOne);
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
		
		
		
		frame = new JFrame("修改预定客房");
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 603, 484);
		frame.getContentPane().setLayout(null);
		panel.setBackground(new Color(204, 153, 102));
		panel.setBounds(0, 6, 587, 22);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("\u57FA\u672C\u9884\u5B9A\u4FE1\u606F");
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5BBE\u5BA2\u59D3\u540D\uFF1A");
		label_1.setBounds(338, 79, 67, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_2.setBounds(338, 120, 67, 24);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u9884\u5B9A\u89C4\u683C\uFF1A");
		label_3.setBounds(338, 154, 67, 22);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_4.setBounds(338, 186, 67, 22);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u9884\u62B5\u65F6\u95F4\uFF1A");
		label_5.setBounds(338, 218, 67, 22);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u622A\u6B62\u65F6\u95F4\uFF1A");
		label_6.setBounds(338, 243, 67, 31);
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
		姓名.setBounds(415, 84, 162, 22);
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
		电话.setBounds(415, 122, 162, 22);
		frame.getContentPane().add(电话);
		电话.setColumns(10);
		
		final JComboBox 预定规格 = new JComboBox();
		预定规格.setBounds(415, 154, 162, 22);
		frame.getContentPane().add(预定规格);
		预定规格.addItem("");
		预定规格.addItem("豪华双人间");
		预定规格.addItem("单人间");
		预定规格.addItem("双人间");
		
		final JComboBox 房间编号 = new JComboBox();
		房间编号.setBounds(415, 187, 162, 21);
		frame.getContentPane().add(房间编号);
		房间编号.addItem("");
		
		预定规格.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = 预定规格.getItemAt(预定规格.getSelectedIndex()).toString();
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
		
		JLabel 提示语 = new JLabel("\u70B9\u51FB\u53F3\u8FB9\u7684\u6309\u94AE\u4EE5\u786E\u5B9A\u4FEE\u6539");
		提示语.setBounds(338, 301, 171, 31);
		frame.getContentPane().add(提示语);
		
		

		
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
		btnNewButton.setBounds(349, 398, 127, 37);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 153));
		panel_2.setBounds(0, 369, 587, 19);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_9 = new JLabel("\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7");
		label_9.setBounds(0, 0, 587, 15);
		panel_2.add(label_9);
		
		final JComboBox 预抵_月 = new JComboBox();
		预抵_月.setBounds(415, 217, 45, 21);
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
		预抵_日.setBounds(468, 217, 43, 21);
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
		预抵_年.setBounds(517, 217, 60, 21);
		frame.getContentPane().add(预抵_年);
		预抵_年.addItem("");
		预抵_年.addItem("2015");
		预抵_年.addItem("2016");
		预抵_年.addItem("2017");
		
		final JComboBox 保留_月 = new JComboBox();
		保留_月.setBounds(413, 248, 45, 21);
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
		保留_日.setBounds(466, 248, 43, 21);
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
		保留_年.setBounds(517, 248, 60, 21);
		frame.getContentPane().add(保留_年);
		保留_年.addItem("");
		保留_年.addItem("2015");
		保留_年.addItem("2016");
		保留_年.addItem("2017");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(10, 33, 278, 77);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u4FEE\u6539\u7684\u5BA2\u623F\u7F16\u53F7\uFF1A");
		label_7.setBounds(0, 0, 247, 15);
		panel_1.add(label_7);
		
		输入 = new JTextField();
		输入.setBounds(0, 20, 238, 21);
		panel_1.add(输入);
		输入.setColumns(10);
		
		JButton button_2 = new JButton("\u786E\u5B9A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String get_text = 输入.getText();
				int temp = 0;
				for(int i=0;i<room_num.size();i++)
				{
					if(room_num.get(i).equals(get_text))
					{
						//输出房间信息
						姓名栏.setText(name.get(i));
						电话栏.setText(tel.get(i));
						房间规格栏.setText(room_type.get(i));
						房间编号栏.setText(room_num.get(i));
						预定_年.setText(yu_nian.get(i));
						预定_月.setText(yu_yue.get(i));
						预定_日.setText(yu_ri.get(i));
						截止_年.setText(end_nian.get(i));
						截止_月.setText(end_yue.get(i));
						截止_日.setText(end_ri.get(i));
						temp++;
					}
				}
				if(temp == 0)
				{
					input_error error = new input_error();
					error.run();
				}
			}
		});
		button_2.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\find.gif"));
		button_2.setBounds(0, 51, 93, 23);
		panel_1.add(button_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 153));
		panel_3.setBounds(10, 132, 278, 227);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_12 = new JLabel("\u8BE5\u5BA2\u623F\u7684\u4FE1\u606F\uFF1A");
		label_12.setBounds(0, 0, 163, 15);
		panel_3.add(label_12);
		
		JLabel label_15 = new JLabel("\u5BBE\u5BA2\u59D3\u540D\uFF1A");
		label_15.setBounds(0, 25, 67, 15);
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_16.setBounds(0, 60, 67, 15);
		panel_3.add(label_16);
		
		JLabel label_17 = new JLabel("\u623F\u95F4\u89C4\u683C\uFF1A");
		label_17.setBounds(0, 96, 67, 15);
		panel_3.add(label_17);
		
		JLabel label_18 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_18.setBounds(0, 131, 67, 15);
		panel_3.add(label_18);
		
		JLabel label_19 = new JLabel("\u9884\u8BA1\u62B5\u8FBE\u65F6\u95F4\uFF1A");
		label_19.setBounds(0, 166, 91, 15);
		panel_3.add(label_19);
		
		JLabel label_20 = new JLabel("\u9884\u8BA1\u622A\u6B62\u65F6\u95F4\uFF1A");
		label_20.setBounds(0, 202, 91, 15);
		panel_3.add(label_20);
		
		电话栏 = new JTextField();
		电话栏.setEditable(false);
		电话栏.setBackground(new Color(255, 204, 153));
		电话栏.setBounds(98, 57, 121, 21);
		panel_3.add(电话栏);
		电话栏.setColumns(10);
		
		房间规格栏 = new JTextField();
		房间规格栏.setEditable(false);
		房间规格栏.setBackground(new Color(255, 204, 153));
		房间规格栏.setBounds(98, 93, 121, 21);
		panel_3.add(房间规格栏);
		房间规格栏.setColumns(10);
		
		房间编号栏 = new JTextField();
		房间编号栏.setEditable(false);
		房间编号栏.setBackground(new Color(255, 204, 153));
		房间编号栏.setBounds(98, 128, 121, 21);
		panel_3.add(房间编号栏);
		房间编号栏.setColumns(10);
		
		姓名栏 = new JTextField();
		姓名栏.setEditable(false);
		姓名栏.setBackground(new Color(255, 204, 153));
		姓名栏.setBounds(98, 25, 121, 21);
		panel_3.add(姓名栏);
		姓名栏.setColumns(10);
		
		预定_年 = new JTextField();
		预定_年.setEditable(false);
		预定_年.setBackground(new Color(255, 204, 153));
		预定_年.setBounds(101, 163, 43, 21);
		panel_3.add(预定_年);
		预定_年.setColumns(10);
		
		JLabel label_21 = new JLabel("\u5E74");
		label_21.setBounds(145, 166, 18, 15);
		panel_3.add(label_21);
		
		预定_月 = new JTextField();
		预定_月.setEditable(false);
		预定_月.setBackground(new Color(255, 204, 153));
		预定_月.setBounds(163, 163, 25, 21);
		panel_3.add(预定_月);
		预定_月.setColumns(10);
		
		JLabel label_22 = new JLabel("\u6708");
		label_22.setBounds(189, 166, 18, 15);
		panel_3.add(label_22);
		
		JLabel lblNewLabel = new JLabel("\u65E5");
		lblNewLabel.setBounds(250, 166, 18, 15);
		panel_3.add(lblNewLabel);
		
		预定_日 = new JTextField();
		预定_日.setEditable(false);
		预定_日.setBackground(new Color(255, 204, 153));
		预定_日.setBounds(211, 163, 29, 21);
		panel_3.add(预定_日);
		预定_日.setColumns(10);
		
		JLabel label_23 = new JLabel("\u5E74");
		label_23.setBounds(145, 202, 18, 15);
		panel_3.add(label_23);
		
		截止_年 = new JTextField();
		截止_年.setEditable(false);
		截止_年.setBackground(new Color(255, 204, 153));
		截止_年.setBounds(101, 199, 43, 21);
		panel_3.add(截止_年);
		截止_年.setColumns(10);
		
		JLabel label_24 = new JLabel("\u6708");
		label_24.setBounds(189, 202, 18, 15);
		panel_3.add(label_24);
		
		截止_月 = new JTextField();
		截止_月.setEditable(false);
		截止_月.setBackground(new Color(255, 204, 153));
		截止_月.setBounds(163, 199, 25, 21);
		panel_3.add(截止_月);
		截止_月.setColumns(10);
		
		JLabel label_25 = new JLabel("\u65E5");
		label_25.setBounds(250, 202, 18, 15);
		panel_3.add(label_25);
		
		截止_日 = new JTextField();
		截止_日.setEditable(false);
		截止_日.setBackground(new Color(255, 204, 153));
		截止_日.setBounds(211, 199, 29, 21);
		panel_3.add(截止_日);
		截止_日.setColumns(10);
		
		final JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==button)
				{
					String get_text = 输入.getText();
					for(int i=0;i<room_num.size();i++)
					{
						if(room_num.get(i).equals(get_text))
						{
							temp.add(yu_nian.get(i));
							temp.add(yu_yue.get(i));
							temp.add(yu_ri.get(i));
							temp.add(end_nian.get(i));
							temp.add(end_yue.get(i));
							temp.add(end_ri.get(i));
						}
					}
					
					
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
					
					int jud = 0;
					
					
					if(!name.equals(""))
					{
						姓名栏.setText(name);
					}
					if(!tel.equals(""))
					{
						电话栏.setText(tel);
					}
					if(roomType != "")
					{
						房间规格栏.setText(roomType);
					}
					if(roomNum != "")
					{
						房间编号栏.setText(roomNum);
					}
					
					
					
					if(Yuding_nian != "")
					{
						temp.set(0,Yuding_nian);
					}
					if(Yuding_yue != "")
					{
						temp.set(1,Yuding_yue);
					}
					if(Yuding_ri != "")
					{
						temp.set(2,Yuding_ri);
					}
					if(baoliu_nian != "")
					{
						temp.set(3,baoliu_nian);
					}
					if(baoliu_yue != "")
					{
						temp.set(4,baoliu_yue);
					}
					if(baoliu_ri != "")
					{
						temp.set(5,baoliu_ri);
					}
					
					
		
					//时间输入错误
					if(Integer.parseInt((String) temp.get(0)) <= Integer.parseInt((String) temp.get(3)))
					{
						if((Integer.parseInt((String) temp.get(0)) == Integer.parseInt((String) temp.get(3))))
						{
							if(Integer.parseInt((String) temp.get(1)) > Integer.parseInt((String) temp.get(4)))
							{
								input_error error = new input_error();
								error.run();
								jud++;
							}
							if(Integer.parseInt((String) temp.get(1)) == Integer.parseInt((String) temp.get(4)))
							{
								if((Integer.parseInt((String) temp.get(2)) > Integer.parseInt((String) temp.get(5))))
								{
									input_error error = new input_error();
									error.run();
									jud++;
								}
							}
						}
					}
					if(Integer.parseInt((String) temp.get(0)) > Integer.parseInt((String) temp.get(3)))
					{
						input_error error = new input_error();
						error.run();
						jud++;
					}
					
					//输入不存在日期问题
					if(Integer.parseInt((String) temp.get(1)) == 2 && Integer.parseInt((String) temp.get(2))>28)
					{
						input_error error = new input_error();
						error.run();
						jud++;
					}
					if(((Integer.parseInt((String) temp.get(1)) == 4) || (Integer.parseInt((String) temp.get(1)) == 6) || (Integer.parseInt((String) temp.get(1)) == 9) || (Integer.parseInt((String) temp.get(1)) == 11)) && Integer.parseInt((String) temp.get(2))>30)
					{
						input_error error = new input_error();
						error.run();
						jud++;
					}
					
					
					
					if(jud == 0)
					{
						if(temp.get(0) != "")
						{
							预定_年.setText(temp.get(0));
						}
						if(temp.get(1) != "")
						{
							预定_月.setText(temp.get(1));
						}
						if(temp.get(2) != "")
						{
							预定_日.setText(temp.get(2));
						}
						if(temp.get(3) != "")
						{
							截止_年.setText(temp.get(3));
						}
						if(temp.get(4) != "")
						{
							截止_月.setText(temp.get(4));
						}
						if(temp.get(5) != "")
						{
							截止_日.setText(temp.get(5));
						}
					}				
				}
			}
		});
		button.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\b1.gif"));
		button.setBounds(510, 305, 67, 27);
		frame.getContentPane().add(button);
		
		
		
		final JButton button_1 = new JButton("\u4FDD\u5B58");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1)
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
					
					
					

					if(!name.equals(""))
					{
						h_reserve.change(name,1,输入.getText());
					}
					if(!tel.equals(""))
					{
						h_reserve.change(tel,2,输入.getText());
					}
					if(roomType != "")
					{
						h_reserve.change(roomType,3,输入.getText());
					}
					if(roomNum != "")
					{
						h_reserve.change(roomNum,4,输入.getText());
					}
					if(Yuding_nian != "")
					{
						h_reserve.change(Yuding_nian,5,输入.getText());
					}
					if(Yuding_yue != "")
					{
						h_reserve.change(Yuding_yue,6,输入.getText());
					}
					if(Yuding_ri != "")
					{
						h_reserve.change(Yuding_ri,7,输入.getText());
					}
					if(baoliu_nian != "")
					{
						h_reserve.change(baoliu_nian,8,输入.getText());
					}
					if(baoliu_yue != "")
					{
						h_reserve.change(baoliu_yue,9,输入.getText());
					}
					if(baoliu_ri != "")
					{
						h_reserve.change(baoliu_ri,10,输入.getText());
					}
					dispose();
					Reserve reserve = new Reserve();
					reserve.run();
				}
			}
		});
		button_1.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\save.gif"));
		button_1.setBounds(75, 398, 127, 37);
		frame.getContentPane().add(button_1);
		
		
		
		
		JLabel label_8 = new JLabel("\u6708");
		label_8.setBounds(429, 276, 27, 15);
		frame.getContentPane().add(label_8);
		
		JLabel label_10 = new JLabel("\u65E5");
		label_10.setBounds(475, 276, 21, 15);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\u5E74");
		label_11.setBounds(527, 276, 35, 15);
		frame.getContentPane().add(label_11);
		
		JLabel label_13 = new JLabel("\u8BF7\u4E8E\u6B64\u5904\u586B\u5165\u4FEE\u6539\u7684\u4FE1\u606F\uFF1A");
		label_13.setBounds(338, 38, 209, 15);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7");
		label_14.setBounds(10, 107, 323, 15);
		frame.getContentPane().add(label_14);
	}
	
	
	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}

	public void run() {
		try {
			Change window = new Change();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
