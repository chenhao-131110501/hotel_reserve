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
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class change {

	private JFrame frame;
	private JTextField �ܼ�;
	private JTextField ����;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	
			public static void run() {
				try {
					change window = new change();
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
	public change() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
private void initialize() {
		
		
		
		frame = new JFrame("ѡ��С����");
		frame.setTitle("\u4FEE\u6539\u6C7D\u8F66\u4FE1\u606F");
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 419, 350);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u603B\u4EF7");
		label.setBounds(21, 108, 106, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u8F66\u7684\u8F66\u53F7");
		label_1.setBounds(21, 20, 156, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u9996\u4ED8\u6BD4\u4F8B\uFF1A");
		label_2.setBounds(21, 182, 83, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_4 = new JLabel("\u8981\u4FEE\u6539\u7684\u8F66\u79CD\u7C7B\uFF1A");
		label_4.setBounds(21, 53, 136, 15);
		frame.getContentPane().add(label_4);
		
		
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
		�ܼ�.setBounds(172, 109, 129, 21);
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
		����.setBounds(172, 17, 129, 21);
		frame.getContentPane().add(����);
		����.setColumns(10);
		
		final JComboBox �׸����� = new JComboBox();
		�׸�����.setBounds(172, 179, 129, 21);
		frame.getContentPane().add(�׸�����);
		�׸�����.addItem("");
		�׸�����.addItem("30%");
		�׸�����.addItem("60%");
		
		final JComboBox �¾ɳ̶� = new JComboBox();
		�¾ɳ̶�.setBounds(172, 50, 129, 21);
		frame.getContentPane().add(�¾ɳ̶�);
		�¾ɳ̶�.addItem("");
		�¾ɳ̶�.addItem("�³�");
		�¾ɳ̶�.addItem("���ֳ�");
		

		 
		
		JLabel label_6 = new JLabel("\u6708\u4F9B\uFF1A");
		label_6.setBounds(21, 151, 83, 15);
		frame.getContentPane().add(label_6);
		
		final JComboBox �¹� = new JComboBox();
		�¹�.setBounds(172, 148, 129, 21);
		frame.getContentPane().add(�¹�);
		�¹�.addItem("");
		�¹�.addItem("2000");
		�¹�.addItem("4000");
		
		
		final JButton �޸� = new JButton("\u4FEE\u6539");
		�޸�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==�޸�)
				{
					
					String money = �ܼ�.getText();
					String num = ����.getText();
					String bili = �׸�����.getItemAt(�׸�����.getSelectedIndex()).toString();
					String yuegong = �¹�.getItemAt(�¹�.getSelectedIndex()).toString();
					
					String xinjiu = �¾ɳ̶�.getItemAt(�¾ɳ̶�.getSelectedIndex()).toString();
					
					
					
					
					
					
					
					
					
					//�����˵�����Ϊ�մ���
					if((bili == "") || (yuegong == "")  || (xinjiu == "")||money.equals("")||num.equals(""))
					{
						error error = new error();
						error.run();
					}
					
					else {
					
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
						stmt = conn.createStatement();
						sql = "update newcar set �ܼ� = '"+money+"'  Where ���� = '"+num+"'";
						stmt.executeUpdate(sql);
						
						sql = "update newcar set �׸����� = '"+bili+"' Where ���� = '"+num+"'";
						stmt.executeUpdate(sql);
						sql = "update newcar set �¹����= '"+yuegong+"' Where ���� = '"+num+"'";
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
						
						sql = "update newcar set �ܼ� = '"+money+"'  Where ���� = '"+num+"'";
						stmt.executeUpdate(sql);
						
						sql = "update newcar set �׸����� = '"+bili+"' Where ���� = '"+num+"'";
						stmt.executeUpdate(sql);
						sql = "update newcar set �¹����= '"+yuegong+"' Where ���� = '"+num+"'";
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
					
					
					
					
				
					
				}
			});
		
		�޸�.setBounds(85, 229, 136, 50);
		frame.getContentPane().add(�޸�);
		
		JLabel label_3 = new JLabel("\u8BF7\u586B\u5199\u4EE5\u4E0B\u4FEE\u6539\u7684\u4FE1\u606F\uFF1A");
		label_3.setBounds(10, 83, 136, 15);
		frame.getContentPane().add(label_3);
		
		
		
	

       
		
		
	}
}
