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
	private JTextField ����;
	private JTextField �ܼ�;
	private JTextField ����;
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
		
		
		
		frame = new JFrame("ѡ��С����");
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
		
		
		 ���� = new JTextField();
			
			����.setBounds(172, 7, 129, 21);
			frame.getContentPane().add(����);
			����.setColumns(10);
		
		
		�ܼ� = new JTextField();
		�ܼ�.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        });  
		�ܼ�.setBounds(172, 32, 129, 21);
		frame.getContentPane().add(�ܼ�);
		�ܼ�.setColumns(10);
		
		���� = new JTextField();
		����.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        }); 
		����.setBounds(172, 69, 129, 21);
		frame.getContentPane().add(����);
		����.setColumns(10);
		
		final JComboBox �׸����� = new JComboBox();
		�׸�����.setBounds(172, 139, 129, 21);
		frame.getContentPane().add(�׸�����);
		�׸�����.addItem("");
		�׸�����.addItem("30%");
		�׸�����.addItem("60%");
		
		final JComboBox ���� = new JComboBox();
		����.setBounds(172, 179, 129, 21);
		frame.getContentPane().add(����);
		����.addItem("");
		����.addItem("����");
		����.addItem("����");
		
		final JComboBox �¾ɳ̶� = new JComboBox();
		�¾ɳ̶�.setBounds(172, 219, 129, 21);
		frame.getContentPane().add(�¾ɳ̶�);
		�¾ɳ̶�.addItem("");
		�¾ɳ̶�.addItem("�³�");
		�¾ɳ̶�.addItem("���ֳ�");
		
		final JComboBox ����Ʒ�� = new JComboBox();
		����Ʒ��.setBounds(172, 262, 129, 21);
		frame.getContentPane().add(����Ʒ��);
		����Ʒ��.addItem("");
		����Ʒ��.addItem("����");
		����Ʒ��.addItem("���");
		����Ʒ��.addItem("����");
		

		 
		
		JLabel label_6 = new JLabel("\u6708\u4F9B\uFF1A");
		label_6.setBounds(21, 111, 83, 15);
		frame.getContentPane().add(label_6);
		
		final JComboBox �¹� = new JComboBox();
		�¹�.setBounds(172, 108, 129, 21);
		frame.getContentPane().add(�¹�);
		�¹�.addItem("");
		�¹�.addItem("2000");
		�¹�.addItem("4000");
		
		
		final JButton ��� = new JButton("\u6DFB\u52A0");
		���.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==���)
				{
					String name = ����.getText();
					String money = �ܼ�.getText();
					String num = ����.getText();
					String bili = �׸�����.getItemAt(�׸�����.getSelectedIndex()).toString();
					String yuegong = �¹�.getItemAt(�¹�.getSelectedIndex()).toString();
					String chezuo = ����.getItemAt(����.getSelectedIndex()).toString();
					String xinjiu = �¾ɳ̶�.getItemAt(�¾ɳ̶�.getSelectedIndex()).toString();
					String pinpai = ����Ʒ��.getItemAt(����Ʒ��.getSelectedIndex()).toString();
					
					
					
					
					
					
					
					
					//�����˵�����Ϊ�մ���
					if((bili == "") || (yuegong == "") || (chezuo == "") || (xinjiu == "") || (pinpai == ""))
					{
						error error = new error();
						error.run();
					}
					
					
					
					if(xinjiu.equals("�³�"))
					{
					
					
					// �������ݿ���������
					String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
					// �������ݿ����ӵ�ַ
					String DBURL = "jdbc:odbc:car";
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
						System.out.println("���ݿ�����ʧ��");
					}
					// 3���������ݿ�
					// ͨ��Connection����ʵ����Statement����
					
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
					// 4���ر����ݿ�
					try {
						// �رղ���
						stmt.close();
						// �ر�����
						conn.close();
					} catch (Exception e) {
					System.out.println("���ݿ�ر�ʧ�ܣ�����");
					}
					
					
					
					}
					
					
					
					
					
					if(xinjiu.equals("���ֳ�"))
					{
					
					
					// �������ݿ���������
					String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
					// �������ݿ����ӵ�ַ
					String DBURL = "jdbc:odbc:car";
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
						System.out.println("���ݿ�����ʧ��");
					}
					// 3���������ݿ�
					// ͨ��Connection����ʵ����Statement����
					
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
					// 4���ر����ݿ�
					try {
						// �رղ���
						stmt.close();
						// �ر�����
						conn.close();
					} catch (Exception e) {
					System.out.println("���ݿ�ر�ʧ�ܣ�����");
					}
					
					
					
					}
					
					
				
				  
					
					
					
					
					
					
					
					
					
					
					}
					
					
					
					
				
					
				}
			});
		
		���.setBounds(109, 304, 136, 50);
		frame.getContentPane().add(���);
		
		JLabel label_7 = new JLabel("\u8F66\u540D");
		label_7.setBounds(21, 10, 54, 15);
		frame.getContentPane().add(label_7);
		
		

		


       
		
		
	}
}
