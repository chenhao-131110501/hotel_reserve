package hotel_reserve;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Reserve {

	private JFrame frame;
	private JTextField 输入;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reserve window = new Reserve();
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
	public Reserve() {
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
		
		
		
		
		frame = new JFrame("客户预订");
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 799, 488);
		frame.getContentPane().setLayout(null);
		
		final JButton btnNewButton = new JButton("添加");
		btnNewButton.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\new.gif"));
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton)
				{
					dispose();
					Add add = new Add();
					add.run();
				}
			}
		});
		btnNewButton.setBounds(22, 5, 81, 34);
		frame.getContentPane().add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\modi0.gif"));
		btnNewButton_1.setBackground(new Color(222, 184, 135));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
				{
					dispose();
					Change change = new Change();
					change.run();
				}
			}
		});
		btnNewButton_1.setBounds(114, 5, 81, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		final JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==button)
				{
					dispose();
					Delete delete = new Delete();
					delete.run();
				}
			}
		});
		button.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\del.gif"));
		button.setBackground(new Color(222, 184, 135));
		button.setBounds(206, 5, 81, 34);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label.setBounds(328, 5, 65, 34);
		frame.getContentPane().add(label);
		

		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String get_text = 输入.getText();
				int temp = 0;
				
				for(int i=0;i<room_num.size();i++)
				{
					for(int j=0;j<6;j++)
					table.setValueAt(null,i,j);
				}
				
				
				for(int i=0;i<room_num.size();i++)
				{
					if(room_num.get(i).equals(get_text))
					{
						//输出房间信息
						table.setValueAt(name.get(i),0,0);
						table.setValueAt(tel.get(i),0,1);
						table.setValueAt(room_type.get(i),0,2);
						table.setValueAt(room_num.get(i),0,3);
						table.setValueAt(yu_nian.get(i)+"/"+yu_yue.get(i)+"/"+yu_ri.get(i),0,4);
						table.setValueAt(end_nian.get(i)+"/"+end_yue.get(i)+"/"+end_ri.get(i),0,5);
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
		button_1.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\find.gif"));
		button_1.setBackground(new Color(222, 184, 135));
		button_1.setBounds(565, 5, 93, 34);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u5237\u65B0");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<room_num.size();i++)
				{
					table.setValueAt(name.get(i),i,0);
					table.setValueAt(tel.get(i),i,1);
					table.setValueAt(room_type.get(i),i,2);
					table.setValueAt(room_num.get(i),i,3);
					table.setValueAt(yu_nian.get(i)+"/"+yu_yue.get(i)+"/"+yu_ri.get(i),i,4);
					table.setValueAt(end_nian.get(i)+"/"+end_yue.get(i)+"/"+end_ri.get(i),i,5);
				}
			}
		});
		button_2.setIcon(new ImageIcon("F:\\\u9648\u8C6A\u7684\u6587\u4EF6\u5939\\Java_workSpace\\hotel_reserve\\pic\\b1.gif"));
		button_2.setBackground(new Color(222, 184, 135));
		button_2.setBounds(668, 5, 93, 34);
		frame.getContentPane().add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 153, 102));
		panel_1.setBounds(0, 58, 783, 28);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BA2\u6237\u9884\u8BA2\u4FE1\u606F");
		lblNewLabel.setBounds(347, 0, 200, 28);
		panel_1.add(lblNewLabel);
		
		输入 = new JTextField();
		输入.setBounds(382, 12, 152, 21);
		frame.getContentPane().add(输入);
		输入.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 84, 783, 331);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 204, 153));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u5BBE\u5BA2\u59D3\u540D", "\u8054\u7CFB\u7535\u8BDD", "\u9884\u5B9A\u623F\u95F4\u7C7B\u578B", "\u623F\u95F4\u7F16\u53F7", "\u9884\u8BA1\u62B5\u8FBE\u65F6\u95F4", "\u9884\u8BA1\u622A\u6B62\u65F6\u95F4"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		
		for(int i=0;i<room_num.size();i++)
		{
			table.setValueAt(name.get(i),i,0);
			table.setValueAt(tel.get(i),i,1);
			table.setValueAt(room_type.get(i),i,2);
			table.setValueAt(room_num.get(i),i,3);
			table.setValueAt(yu_nian.get(i)+"/"+yu_yue.get(i)+"/"+yu_ri.get(i),i,4);
			table.setValueAt(end_nian.get(i)+"/"+end_yue.get(i)+"/"+end_ri.get(i),i,5);
		}
		
		
	
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	
	public void run() {
		try {
			Reserve window = new Reserve();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

