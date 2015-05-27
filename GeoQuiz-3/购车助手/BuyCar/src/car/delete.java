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
				//�����˵�����Ϊ�մ���
				if((xinjiu == "") ||(num.equals("")))
				{
					error error = new error();
					error.run();
				}
				
				else{
				
				
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
				} catch (Exception er) {
					// �˴�ʹ��out.print�Ǵ�����ʾĿ�ģ���ʵ�ʿ��������еĴ�����Ϣ��
					// ���Բ��ܹ�ͨ��System.out.print��ӡ���������ڰ�ȫ����
					System.out.println("���ݿ������������ʧ�ܣ�����");
				}
				// 2���������ݿ�
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception er) {
					System.out.println("���ݿ�����ʧ��");
				}
				// 3���������ݿ�
				// ͨ��Connection����ʵ����Statement����
				
				try {
					stmt = conn.createStatement();
					sql = "select * from newcar";
					r = stmt.executeQuery(sql);
					sql = "delete * from newcar where ���� = '"+num+"'";
					stmt.executeUpdate(sql);
					success.run();
					dispose();
				} catch (Exception er) {
					System.out.println(er);
				}
				// 4���ر����ݿ�
				try {
					// �رղ���
					stmt.close();
					// �ر�����
					conn.close();
				} catch (Exception er) {
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
				} catch (Exception er) {
					// �˴�ʹ��out.print�Ǵ�����ʾĿ�ģ���ʵ�ʿ��������еĴ�����Ϣ��
					// ���Բ��ܹ�ͨ��System.out.print��ӡ���������ڰ�ȫ����
					System.out.println("���ݿ������������ʧ�ܣ�����");
				}
				// 2���������ݿ�
				try {
					conn = DriverManager.getConnection(DBURL);
				} catch (Exception er) {
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
					
					sql = "delete * from newcar where ���� = '"+num+"'";
					stmt.executeUpdate(sql);
					success.run();
					dispose();
				} catch (Exception er) {
					System.out.println(e);
				}
				// 4���ر����ݿ�
				try {
					// �رղ���
					stmt.close();
					// �ر�����
					conn.close();
				} catch (Exception er) {
				System.out.println("���ݿ�ر�ʧ�ܣ�����");
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
                    e.consume(); //�ؼ������ε��Ƿ�����  
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
		comboBox.addItem("�³�");
		comboBox.addItem("���ֳ�");
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


