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
	private JTextField ����;
	private JTextField ������;
	private JTextField �绰��;
	private JTextField ��������;
	private JTextField ��������;
	private JTextField Ԥ��_��;
	private JTextField ��ֹ_��;
	private JTextField Ԥ��_��;
	private JTextField ��ֹ_��;
	private JTextField Ԥ��_��;
	private JTextField ��ֹ_��;

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
		
		
		
		
		frame = new JFrame("ɾ���ͷ���Ϣ");
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
		
		���� = new JTextField();
		����.setBounds(0, 20, 217, 21);
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
		
		final JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
					h_reserve.delete(����.getText());
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
		label_1.setFont(new Font("����", Font.PLAIN, 20));
		label_1.setBounds(10, 130, 222, 25);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6240\u6709\u4FE1\u606F\u4E00\u65E6\u5220\u9664\u5C06");
		label_2.setFont(new Font("����", Font.PLAIN, 23));
		label_2.setBounds(10, 170, 238, 28);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u65E0\u6CD5\u6062\u590D");
		label_3.setFont(new Font("����", Font.PLAIN, 53));
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
		
		������ = new JTextField();
		������.setEditable(false);
		������.setBackground(new Color(255, 204, 153));
		������.setBounds(99, 22, 108, 21);
		panel.add(������);
		������.setColumns(10);
		
		�绰�� = new JTextField();
		�绰��.setEditable(false);
		�绰��.setBackground(new Color(255, 204, 153));
		�绰��.setBounds(99, 59, 108, 21);
		panel.add(�绰��);
		�绰��.setColumns(10);
		
		�������� = new JTextField();
		��������.setEditable(false);
		��������.setBackground(new Color(255, 204, 153));
		��������.setBounds(99, 98, 108, 21);
		panel.add(��������);
		��������.setColumns(10);
		
		�������� = new JTextField();
		��������.setEditable(false);
		��������.setBackground(new Color(255, 204, 153));
		��������.setBounds(99, 128, 108, 21);
		panel.add(��������);
		��������.setColumns(10);
		
		Ԥ��_�� = new JTextField();
		Ԥ��_��.setEditable(false);
		Ԥ��_��.setBackground(new Color(255, 204, 153));
		Ԥ��_��.setBounds(99, 165, 42, 21);
		panel.add(Ԥ��_��);
		Ԥ��_��.setColumns(10);
		
		��ֹ_�� = new JTextField();
		��ֹ_��.setEditable(false);
		��ֹ_��.setBackground(new Color(255, 204, 153));
		��ֹ_��.setBounds(99, 193, 42, 21);
		panel.add(��ֹ_��);
		��ֹ_��.setColumns(10);
		
		Ԥ��_�� = new JTextField();
		Ԥ��_��.setEditable(false);
		Ԥ��_��.setBackground(new Color(255, 204, 153));
		Ԥ��_��.setBounds(167, 165, 21, 21);
		panel.add(Ԥ��_��);
		Ԥ��_��.setColumns(10);
		
		��ֹ_�� = new JTextField();
		��ֹ_��.setEditable(false);
		��ֹ_��.setBackground(new Color(255, 204, 153));
		��ֹ_��.setBounds(167, 193, 21, 21);
		panel.add(��ֹ_��);
		��ֹ_��.setColumns(10);
		
		Ԥ��_�� = new JTextField();
		Ԥ��_��.setEditable(false);
		Ԥ��_��.setBackground(new Color(255, 204, 153));
		Ԥ��_��.setBounds(220, 165, 26, 21);
		panel.add(Ԥ��_��);
		Ԥ��_��.setColumns(10);
		
		��ֹ_�� = new JTextField();
		��ֹ_��.setEditable(false);
		��ֹ_��.setBackground(new Color(255, 204, 153));
		��ֹ_��.setBounds(220, 193, 26, 21);
		panel.add(��ֹ_��);
		��ֹ_��.setColumns(10);
		
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
