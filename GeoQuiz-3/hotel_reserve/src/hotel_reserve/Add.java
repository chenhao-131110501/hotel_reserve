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
	private JTextField ����;
	private JTextField �绰;
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
		
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:hotel";
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
			System.out.println("���ݿ�����ʧ�ܣ�����");
		}
		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
			sql = "select * from roominfo";
			r = stmt.executeQuery(sql);
			while (r.next()) {			
				room_type = r.getString(3);
				room_state = r.getInt(5);
				room_num = r.getString(2);
				
				if((room_type.equals("����˫�˼�"))  && (room_state == 0))
				{
					HHS.add(room_num);
				}
				else if((room_type.equals("˫�˼�"))  && (room_state == 0))
				{
					SR.add(room_num);
				}
				else if((room_type.equals("���˼�"))  && (room_state == 0))
				{
					DR.add(room_num);
				}
			}
		} catch (Exception e) {
			System.out.println("�������ݿ�ʧ�ܣ�����");
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
		
		
		
		
		frame = new JFrame("���Ԥ���ͷ�");
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
		
		���� = new JTextField();		
		����.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                char keyChar = e.getKeyChar();                 
                if(keyChar == ' ' || keyChar == '\t' || keyChar == '\n')
                {  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
                else if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9)
                {
                	e.consume(); //�ؼ������ε��Ƿ�����  
                }
            }  
        });	
		����.setBounds(89, 45, 162, 22);
		frame.getContentPane().add(����);
		����.setColumns(10);
		
		
		
		�绰 = new JTextField();
		�绰.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        });  
		�绰.setBounds(89, 72, 162, 22);
		frame.getContentPane().add(�绰);
		�绰.setColumns(10);
		
		final JComboBox Ԥ����� = new JComboBox();
		Ԥ�����.setBounds(89, 100, 162, 22);
		frame.getContentPane().add(Ԥ�����);
		Ԥ�����.addItem("");
		Ԥ�����.addItem("����˫�˼�");
		Ԥ�����.addItem("���˼�");
		Ԥ�����.addItem("˫�˼�");
		
		
		final JComboBox ������ = new JComboBox();
		������.setBounds(89, 131, 162, 21);
		frame.getContentPane().add(������);
		������.addItem("");
		
	
		Ԥ�����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s1 = Ԥ�����.getItemAt(Ԥ�����.getSelectedIndex()).toString();
				if(s1 == "����˫�˼�")
				{
					������.removeAllItems();
					for(int i=0;i<HHS.size();i++)
					{
						������.addItem(HHS.get(i));
					}
				}
				else if(s1 == "���˼�")
				{
					������.removeAllItems();
					for(int i=0;i<DR.size();i++)
					{
						������.addItem(DR.get(i));
					}
				}
				else if(s1 == "˫�˼�")
				{
					������.removeAllItems();
					for(int i=0;i<SR.size();i++)
					{
						������.addItem(SR.get(i));
					}
				}
			}
		});
		
		JLabel ��ʾ�� = new JLabel("\u70B9\u51FB\u53F3\u8FB9\u7684\u6309\u94AE\u4EE5\u786E\u5B9A\u6DFB\u52A0");
		��ʾ��.setBounds(10, 242, 171, 31);
		frame.getContentPane().add(��ʾ��);
		
		
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
		
		final JComboBox Ԥ��_�� = new JComboBox();
		Ԥ��_��.setBounds(89, 161, 43, 21);
		frame.getContentPane().add(Ԥ��_��);
		Ԥ��_��.addItem("");
		Ԥ��_��.addItem("1");
		Ԥ��_��.addItem("2");
		Ԥ��_��.addItem("3");
		Ԥ��_��.addItem("4");
		Ԥ��_��.addItem("5");
		Ԥ��_��.addItem("6");
		Ԥ��_��.addItem("7");
		Ԥ��_��.addItem("8");
		Ԥ��_��.addItem("9");
		Ԥ��_��.addItem("10");
		Ԥ��_��.addItem("11");
		Ԥ��_��.addItem("12");
		
		
		final JComboBox Ԥ��_�� = new JComboBox();
		Ԥ��_��.setBounds(140, 161, 43, 21);
		frame.getContentPane().add(Ԥ��_��);
		Ԥ��_��.addItem("");
		Ԥ��_��.addItem("1");
		Ԥ��_��.addItem("2");
		Ԥ��_��.addItem("3");
		Ԥ��_��.addItem("4");
		Ԥ��_��.addItem("5");
		Ԥ��_��.addItem("6");
		Ԥ��_��.addItem("7");
		Ԥ��_��.addItem("8");
		Ԥ��_��.addItem("9");
		Ԥ��_��.addItem("10");
		Ԥ��_��.addItem("11");
		Ԥ��_��.addItem("12");
		Ԥ��_��.addItem("13");
		Ԥ��_��.addItem("14");
		Ԥ��_��.addItem("15");
		Ԥ��_��.addItem("16");
		Ԥ��_��.addItem("17");
		Ԥ��_��.addItem("18");
		Ԥ��_��.addItem("19");
		Ԥ��_��.addItem("20");
		Ԥ��_��.addItem("21");
		Ԥ��_��.addItem("22");
		Ԥ��_��.addItem("23");
		Ԥ��_��.addItem("24");
		Ԥ��_��.addItem("25");
		Ԥ��_��.addItem("26");
		Ԥ��_��.addItem("27");
		Ԥ��_��.addItem("28");
		Ԥ��_��.addItem("29");
		Ԥ��_��.addItem("30");
		Ԥ��_��.addItem("31");
		
		
		final JComboBox Ԥ��_�� = new JComboBox();
		Ԥ��_��.setBounds(191, 161, 60, 21);
		frame.getContentPane().add(Ԥ��_��);
		Ԥ��_��.addItem("");
		Ԥ��_��.addItem("2015");
		Ԥ��_��.addItem("2016");
		Ԥ��_��.addItem("2017");
		
		final JComboBox ����_�� = new JComboBox();
		����_��.setBounds(89, 195, 45, 21);
		frame.getContentPane().add(����_��);
		����_��.addItem("");
		����_��.addItem("1");
		����_��.addItem("2");
		����_��.addItem("3");
		����_��.addItem("4");
		����_��.addItem("5");
		����_��.addItem("6");
		����_��.addItem("7");
		����_��.addItem("8");
		����_��.addItem("9");
		����_��.addItem("10");
		����_��.addItem("11");
		����_��.addItem("12");
		
		
		final JComboBox ����_�� = new JComboBox();
		����_��.setBounds(140, 195, 43, 21);
		frame.getContentPane().add(����_��);
		����_��.addItem("");
		����_��.addItem("1");
		����_��.addItem("2");
		����_��.addItem("3");
		����_��.addItem("4");
		����_��.addItem("5");
		����_��.addItem("6");
		����_��.addItem("7");
		����_��.addItem("8");
		����_��.addItem("9");
		����_��.addItem("10");
		����_��.addItem("11");
		����_��.addItem("12");
		����_��.addItem("13");
		����_��.addItem("14");
		����_��.addItem("15");
		����_��.addItem("16");
		����_��.addItem("17");
		����_��.addItem("18");
		����_��.addItem("19");
		����_��.addItem("20");
		����_��.addItem("21");
		����_��.addItem("22");
		����_��.addItem("23");
		����_��.addItem("24");
		����_��.addItem("25");
		����_��.addItem("26");
		����_��.addItem("27");
		����_��.addItem("28");
		����_��.addItem("29");
		����_��.addItem("30");
		����_��.addItem("31");
		
		
		final JComboBox ����_�� = new JComboBox();
		����_��.setBounds(191, 195, 60, 21);
		frame.getContentPane().add(����_��);
		����_��.addItem("");
		����_��.addItem("2015");
		����_��.addItem("2016");
		����_��.addItem("2017");
	
		
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
					String roomType = Ԥ�����.getItemAt(Ԥ�����.getSelectedIndex()).toString();
					String roomNum = ������.getItemAt(������.getSelectedIndex()).toString();
					String Yuding_nian = (String)Ԥ��_��.getSelectedItem();
					String Yuding_yue = (String)Ԥ��_��.getSelectedItem();
					String Yuding_ri = (String)Ԥ��_��.getSelectedItem();
					String baoliu_nian = (String)����_��.getSelectedItem();
					String baoliu_yue = (String)����_��.getSelectedItem();
					String baoliu_ri = (String)����_��.getSelectedItem();
					
					
					//�����˵�����Ϊ�մ���
					if((roomType == "") || (Yuding_nian == "") || (Yuding_yue == "") || (Yuding_ri == "") || (baoliu_nian == "") || (baoliu_yue == "") || (baoliu_ri == ""))
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					//ʱ���������
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
					
					//���벻������������
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
					String name = ����.getText();
					String tel = �绰.getText();
					String roomType = Ԥ�����.getItemAt(Ԥ�����.getSelectedIndex()).toString();
					String roomNum = ������.getItemAt(������.getSelectedIndex()).toString();
					String Yuding_nian = (String)Ԥ��_��.getSelectedItem();
					String Yuding_yue = (String)Ԥ��_��.getSelectedItem();
					String Yuding_ri = (String)Ԥ��_��.getSelectedItem();
					String baoliu_nian = (String)����_��.getSelectedItem();
					String baoliu_yue = (String)����_��.getSelectedItem();
					String baoliu_ri = (String)����_��.getSelectedItem();
					
					
					//�����˵�����Ϊ�մ���
					if((roomType == "") || (Yuding_nian == "") || (Yuding_yue == "") || (Yuding_ri == "") || (baoliu_nian == "") || (baoliu_yue == "") || (baoliu_ri == ""))
					{
						input_error error = new input_error();
						error.run();
					}
					
					
					//ʱ���������
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
					//���벻������������
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
