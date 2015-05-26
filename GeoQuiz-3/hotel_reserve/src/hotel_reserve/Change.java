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
	private JTextField ����;
	private JTextField �绰;
	private JTextField ����;
	
	reserve_function h_reserve = new reserve_function(); 
	private JTextField �绰��;
	private JTextField ��������;
	private JTextField ��������;
	private JTextField ������;
	private JTextField Ԥ��_��;
	private JTextField Ԥ��_��;
	private JTextField Ԥ��_��;
	private JTextField ��ֹ_��;
	private JTextField ��ֹ_��;
	private JTextField ��ֹ_��;

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
		String sql_other =null;
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
				
				if((room_type_theOne.equals("����˫�˼�"))  && (room_state_theOne == 0))
				{
					HHS.add(room_num_theOne);
				}
				else if((room_type_theOne.equals("˫�˼�"))  && (room_state_theOne == 0))
				{
					SR.add(room_num_theOne);
				}
				else if((room_type_theOne.equals("���˼�"))  && (room_state_theOne == 0))
				{
					DR.add(room_num_theOne);
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
		
		
		
		frame = new JFrame("�޸�Ԥ���ͷ�");
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
		����.setBounds(415, 84, 162, 22);
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
		�绰.setBounds(415, 122, 162, 22);
		frame.getContentPane().add(�绰);
		�绰.setColumns(10);
		
		final JComboBox Ԥ����� = new JComboBox();
		Ԥ�����.setBounds(415, 154, 162, 22);
		frame.getContentPane().add(Ԥ�����);
		Ԥ�����.addItem("");
		Ԥ�����.addItem("����˫�˼�");
		Ԥ�����.addItem("���˼�");
		Ԥ�����.addItem("˫�˼�");
		
		final JComboBox ������ = new JComboBox();
		������.setBounds(415, 187, 162, 21);
		frame.getContentPane().add(������);
		������.addItem("");
		
		Ԥ�����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s1 = Ԥ�����.getItemAt(Ԥ�����.getSelectedIndex()).toString();
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
		
		JLabel ��ʾ�� = new JLabel("\u70B9\u51FB\u53F3\u8FB9\u7684\u6309\u94AE\u4EE5\u786E\u5B9A\u4FEE\u6539");
		��ʾ��.setBounds(338, 301, 171, 31);
		frame.getContentPane().add(��ʾ��);
		
		

		
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
		
		final JComboBox Ԥ��_�� = new JComboBox();
		Ԥ��_��.setBounds(415, 217, 45, 21);
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
		Ԥ��_��.setBounds(468, 217, 43, 21);
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
		Ԥ��_��.setBounds(517, 217, 60, 21);
		frame.getContentPane().add(Ԥ��_��);
		Ԥ��_��.addItem("");
		Ԥ��_��.addItem("2015");
		Ԥ��_��.addItem("2016");
		Ԥ��_��.addItem("2017");
		
		final JComboBox ����_�� = new JComboBox();
		����_��.setBounds(413, 248, 45, 21);
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
		����_��.setBounds(466, 248, 43, 21);
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
		����_��.setBounds(517, 248, 60, 21);
		frame.getContentPane().add(����_��);
		����_��.addItem("");
		����_��.addItem("2015");
		����_��.addItem("2016");
		����_��.addItem("2017");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 153));
		panel_1.setBounds(10, 33, 278, 77);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("\u8BF7\u8F93\u5165\u9700\u8981\u4FEE\u6539\u7684\u5BA2\u623F\u7F16\u53F7\uFF1A");
		label_7.setBounds(0, 0, 247, 15);
		panel_1.add(label_7);
		
		���� = new JTextField();
		����.setBounds(0, 20, 238, 21);
		panel_1.add(����);
		����.setColumns(10);
		
		JButton button_2 = new JButton("\u786E\u5B9A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String get_text = ����.getText();
				int temp = 0;
				for(int i=0;i<room_num.size();i++)
				{
					if(room_num.get(i).equals(get_text))
					{
						//���������Ϣ
						������.setText(name.get(i));
						�绰��.setText(tel.get(i));
						��������.setText(room_type.get(i));
						��������.setText(room_num.get(i));
						Ԥ��_��.setText(yu_nian.get(i));
						Ԥ��_��.setText(yu_yue.get(i));
						Ԥ��_��.setText(yu_ri.get(i));
						��ֹ_��.setText(end_nian.get(i));
						��ֹ_��.setText(end_yue.get(i));
						��ֹ_��.setText(end_ri.get(i));
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
		
		�绰�� = new JTextField();
		�绰��.setEditable(false);
		�绰��.setBackground(new Color(255, 204, 153));
		�绰��.setBounds(98, 57, 121, 21);
		panel_3.add(�绰��);
		�绰��.setColumns(10);
		
		�������� = new JTextField();
		��������.setEditable(false);
		��������.setBackground(new Color(255, 204, 153));
		��������.setBounds(98, 93, 121, 21);
		panel_3.add(��������);
		��������.setColumns(10);
		
		�������� = new JTextField();
		��������.setEditable(false);
		��������.setBackground(new Color(255, 204, 153));
		��������.setBounds(98, 128, 121, 21);
		panel_3.add(��������);
		��������.setColumns(10);
		
		������ = new JTextField();
		������.setEditable(false);
		������.setBackground(new Color(255, 204, 153));
		������.setBounds(98, 25, 121, 21);
		panel_3.add(������);
		������.setColumns(10);
		
		Ԥ��_�� = new JTextField();
		Ԥ��_��.setEditable(false);
		Ԥ��_��.setBackground(new Color(255, 204, 153));
		Ԥ��_��.setBounds(101, 163, 43, 21);
		panel_3.add(Ԥ��_��);
		Ԥ��_��.setColumns(10);
		
		JLabel label_21 = new JLabel("\u5E74");
		label_21.setBounds(145, 166, 18, 15);
		panel_3.add(label_21);
		
		Ԥ��_�� = new JTextField();
		Ԥ��_��.setEditable(false);
		Ԥ��_��.setBackground(new Color(255, 204, 153));
		Ԥ��_��.setBounds(163, 163, 25, 21);
		panel_3.add(Ԥ��_��);
		Ԥ��_��.setColumns(10);
		
		JLabel label_22 = new JLabel("\u6708");
		label_22.setBounds(189, 166, 18, 15);
		panel_3.add(label_22);
		
		JLabel lblNewLabel = new JLabel("\u65E5");
		lblNewLabel.setBounds(250, 166, 18, 15);
		panel_3.add(lblNewLabel);
		
		Ԥ��_�� = new JTextField();
		Ԥ��_��.setEditable(false);
		Ԥ��_��.setBackground(new Color(255, 204, 153));
		Ԥ��_��.setBounds(211, 163, 29, 21);
		panel_3.add(Ԥ��_��);
		Ԥ��_��.setColumns(10);
		
		JLabel label_23 = new JLabel("\u5E74");
		label_23.setBounds(145, 202, 18, 15);
		panel_3.add(label_23);
		
		��ֹ_�� = new JTextField();
		��ֹ_��.setEditable(false);
		��ֹ_��.setBackground(new Color(255, 204, 153));
		��ֹ_��.setBounds(101, 199, 43, 21);
		panel_3.add(��ֹ_��);
		��ֹ_��.setColumns(10);
		
		JLabel label_24 = new JLabel("\u6708");
		label_24.setBounds(189, 202, 18, 15);
		panel_3.add(label_24);
		
		��ֹ_�� = new JTextField();
		��ֹ_��.setEditable(false);
		��ֹ_��.setBackground(new Color(255, 204, 153));
		��ֹ_��.setBounds(163, 199, 25, 21);
		panel_3.add(��ֹ_��);
		��ֹ_��.setColumns(10);
		
		JLabel label_25 = new JLabel("\u65E5");
		label_25.setBounds(250, 202, 18, 15);
		panel_3.add(label_25);
		
		��ֹ_�� = new JTextField();
		��ֹ_��.setEditable(false);
		��ֹ_��.setBackground(new Color(255, 204, 153));
		��ֹ_��.setBounds(211, 199, 29, 21);
		panel_3.add(��ֹ_��);
		��ֹ_��.setColumns(10);
		
		final JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==button)
				{
					String get_text = ����.getText();
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
					
					int jud = 0;
					
					
					if(!name.equals(""))
					{
						������.setText(name);
					}
					if(!tel.equals(""))
					{
						�绰��.setText(tel);
					}
					if(roomType != "")
					{
						��������.setText(roomType);
					}
					if(roomNum != "")
					{
						��������.setText(roomNum);
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
					
					
		
					//ʱ���������
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
					
					//���벻������������
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
							Ԥ��_��.setText(temp.get(0));
						}
						if(temp.get(1) != "")
						{
							Ԥ��_��.setText(temp.get(1));
						}
						if(temp.get(2) != "")
						{
							Ԥ��_��.setText(temp.get(2));
						}
						if(temp.get(3) != "")
						{
							��ֹ_��.setText(temp.get(3));
						}
						if(temp.get(4) != "")
						{
							��ֹ_��.setText(temp.get(4));
						}
						if(temp.get(5) != "")
						{
							��ֹ_��.setText(temp.get(5));
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
					
					
					

					if(!name.equals(""))
					{
						h_reserve.change(name,1,����.getText());
					}
					if(!tel.equals(""))
					{
						h_reserve.change(tel,2,����.getText());
					}
					if(roomType != "")
					{
						h_reserve.change(roomType,3,����.getText());
					}
					if(roomNum != "")
					{
						h_reserve.change(roomNum,4,����.getText());
					}
					if(Yuding_nian != "")
					{
						h_reserve.change(Yuding_nian,5,����.getText());
					}
					if(Yuding_yue != "")
					{
						h_reserve.change(Yuding_yue,6,����.getText());
					}
					if(Yuding_ri != "")
					{
						h_reserve.change(Yuding_ri,7,����.getText());
					}
					if(baoliu_nian != "")
					{
						h_reserve.change(baoliu_nian,8,����.getText());
					}
					if(baoliu_yue != "")
					{
						h_reserve.change(baoliu_yue,9,����.getText());
					}
					if(baoliu_ri != "")
					{
						h_reserve.change(baoliu_ri,10,����.getText());
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
