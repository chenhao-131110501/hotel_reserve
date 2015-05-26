package hotel_reserve;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;


public class Delete {

	reserve_function h_reserve = new reserve_function(); 
	private JFrame frame;
	private JTextField 输入;
	private JTextField 姓名栏;
	private JTextField 电话栏;
	private JTextField 房间规格栏;
	private JTextField 房间编号栏;
	private JTextField 预定_年;
	private JTextField 截止_年;
	private JTextField 预定_月;
	private JTextField 截止_月;
	private JTextField 预定_日;
	private JTextField 截止_日;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
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
		
		
		
		
		frame = new JFrame("删除客房信息");
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 556, 385);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(10, 10, 238, 92);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u5220\u9664\u7684\u5BA2\u623F\u7F16\u53F7\uFF1A");
		label_7.setBounds(0, 0, 247, 15);
		panel_1.add(label_7);
		
		输入 = new JTextField();
		输入.setBounds(0, 20, 217, 21);
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
		
		final JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
					h_reserve.delete(输入.getText());
					dispose();
					Reserve reserve = new Reserve();
					reserve.run();
				}
				
			}
		});
		button.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\del.gif"));
		button.setBounds(26, 284, 93, 33);
		frame.getContentPane().add(button);
		
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
		btnNewButton.setBounds(170, 284, 93, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("\u8BF7\u6CE8\u610F\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(10, 130, 222, 25);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6240\u6709\u4FE1\u606F\u4E00\u65E6\u5220\u9664\u5C06");
		label_2.setFont(new Font("宋体", Font.PLAIN, 23));
		label_2.setBounds(10, 170, 238, 28);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u65E0\u6CD5\u6062\u590D");
		label_3.setFont(new Font("宋体", Font.PLAIN, 53));
		label_3.setBounds(26, 208, 222, 55);
		frame.getContentPane().add(label_3);
		
		JLabel label = new JLabel("\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7\u00B7");
		label.setBounds(245, 242, 295, 15);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		panel.setBounds(258, 10, 272, 222);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_4 = new JLabel("\u8BE5\u623F\u95F4\u7684\u4FE1\u606F\uFF1A");
		label_4.setBounds(0, 0, 165, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\u7528\u6237\u59D3\u540D :");
		label_5.setBounds(0, 25, 81, 15);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_6.setBounds(0, 62, 71, 15);
		panel.add(label_6);
		
		JLabel label_8 = new JLabel("\u623F\u95F4\u7C7B\u578B\uFF1A");
		label_8.setBounds(0, 98, 71, 15);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("\u623F\u95F4\u7F16\u53F7\uFF1A");
		label_9.setBounds(0, 131, 71, 15);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("\u9884\u8BA1\u5230\u8FBE\u65F6\u95F4\uFF1A");
		label_10.setBounds(0, 168, 94, 15);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("\u9884\u8BA1\u622A\u6B62\u65F6\u95F4\uFF1A");
		label_11.setBounds(0, 197, 94, 15);
		panel.add(label_11);
		
		姓名栏 = new JTextField();
		姓名栏.setEditable(false);
		姓名栏.setBackground(new Color(255, 204, 153));
		姓名栏.setBounds(99, 22, 108, 21);
		panel.add(姓名栏);
		姓名栏.setColumns(10);
		
		电话栏 = new JTextField();
		电话栏.setEditable(false);
		电话栏.setBackground(new Color(255, 204, 153));
		电话栏.setBounds(99, 59, 108, 21);
		panel.add(电话栏);
		电话栏.setColumns(10);
		
		房间规格栏 = new JTextField();
		房间规格栏.setEditable(false);
		房间规格栏.setBackground(new Color(255, 204, 153));
		房间规格栏.setBounds(99, 98, 108, 21);
		panel.add(房间规格栏);
		房间规格栏.setColumns(10);
		
		房间编号栏 = new JTextField();
		房间编号栏.setEditable(false);
		房间编号栏.setBackground(new Color(255, 204, 153));
		房间编号栏.setBounds(99, 128, 108, 21);
		panel.add(房间编号栏);
		房间编号栏.setColumns(10);
		
		预定_年 = new JTextField();
		预定_年.setEditable(false);
		预定_年.setBackground(new Color(255, 204, 153));
		预定_年.setBounds(99, 165, 42, 21);
		panel.add(预定_年);
		预定_年.setColumns(10);
		
		截止_年 = new JTextField();
		截止_年.setEditable(false);
		截止_年.setBackground(new Color(255, 204, 153));
		截止_年.setBounds(99, 193, 42, 21);
		panel.add(截止_年);
		截止_年.setColumns(10);
		
		预定_月 = new JTextField();
		预定_月.setEditable(false);
		预定_月.setBackground(new Color(255, 204, 153));
		预定_月.setBounds(167, 165, 21, 21);
		panel.add(预定_月);
		预定_月.setColumns(10);
		
		截止_月 = new JTextField();
		截止_月.setEditable(false);
		截止_月.setBackground(new Color(255, 204, 153));
		截止_月.setBounds(167, 193, 21, 21);
		panel.add(截止_月);
		截止_月.setColumns(10);
		
		预定_日 = new JTextField();
		预定_日.setEditable(false);
		预定_日.setBackground(new Color(255, 204, 153));
		预定_日.setBounds(220, 165, 26, 21);
		panel.add(预定_日);
		预定_日.setColumns(10);
		
		截止_日 = new JTextField();
		截止_日.setEditable(false);
		截止_日.setBackground(new Color(255, 204, 153));
		截止_日.setBounds(220, 193, 26, 21);
		panel.add(截止_日);
		截止_日.setColumns(10);
		
		JLabel label_12 = new JLabel("\u5E74");
		label_12.setBounds(141, 168, 24, 15);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("\u5E74");
		label_13.setBounds(141, 197, 21, 15);
		panel.add(label_13);
		
		JLabel label_14 = new JLabel("\u6708");
		label_14.setBounds(189, 168, 21, 15);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("\u6708");
		label_15.setBounds(189, 197, 21, 15);
		panel.add(label_15);
		
		JLabel label_16 = new JLabel("\u65E5");
		label_16.setBounds(251, 168, 21, 15);
		panel.add(label_16);
		
		JLabel label_17 = new JLabel("\u65E5");
		label_17.setBounds(251, 197, 21, 15);
		panel.add(label_17);
		
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}

	
	public void run() {
		try {
			Delete window = new Delete();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
