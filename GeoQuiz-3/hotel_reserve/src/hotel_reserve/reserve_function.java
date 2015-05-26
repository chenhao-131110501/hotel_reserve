package hotel_reserve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;



public class reserve_function {
	static int text = 0;
	String Name;
	String Tel;
	String RoomType;
	String RoomNum;
	String RoomNum_other;
	String Yuding_nian;
	String Yuding_yue;
	String Yuding_ri;
	String baoliu_nian;
	String baoliu_yue;
	String baoliu_ri;
	String temp;
	
	//�������Ϣ
	public void add(String name,String tel,String roomType,String roomNum,String yu_year,String yu_month,String yu_day,String end_year,String end_month,String end_day) {
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
		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e1) {
			// �˴�ʹ��out.print�Ǵ�����ʾĿ�ģ���ʵ�ʿ��������еĴ�����Ϣ��
			// ���Բ��ܹ�ͨ��System.out.print��ӡ���������ڰ�ȫ����
			System.out.println("���ݿ������������ʧ�ܣ�����");
		}
		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e2) {
			System.out.println("���ݿ�����ʧ�ܣ�����");
		}
		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		Name = name;
		Tel = tel;
		RoomType = roomType;
		RoomNum = roomNum;
		Yuding_nian = yu_year;
		Yuding_yue = yu_month;
		Yuding_ri = yu_day;
		baoliu_nian = end_year;
		baoliu_yue = end_month;
		baoliu_ri = end_day;
		
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String ID = dateFormat.format(date); 
		//String ID = "sss";
		
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
			//sql = "select * from reserve";
			sql = "insert into reserve values('"+ID+"','"+Name+"','"+Tel+"','"+RoomType+"','"+RoomNum+"','"+Yuding_nian+"','"+Yuding_yue+"','"+Yuding_ri+"','"+baoliu_nian+"','"+baoliu_yue+"','"+baoliu_ri+"')";
			stmt.executeUpdate(sql);
			sql = "update roominfo set room_state = '2' Where room_id = '"+RoomNum+"'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e3) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
		}
	}
	
	//ɾ����Ϣ
	public void delete(String room_num){
		// TODO Auto-generated method stub
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
			RoomNum = room_num;
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
			sql = "update roominfo set room_state = '0' Where room_id = '"+RoomNum+"'";
			stmt.executeUpdate(sql);
			sql = "delete * from reserve where room_id = '"+RoomNum+"'";
			stmt.executeUpdate(sql);
			
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
	}

	//������Ϣ
	public void change(String temp,int choice,String room_num){
		// TODO Auto-generated method stub
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
			RoomNum = room_num;
			if(choice == 1)
			{
				Name = temp;
				stmt = conn.createStatement();
				sql = "update reserve set c_name = '"+Name+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);		
			}
			else if(choice == 2)
			{
				Tel = temp;
				stmt = conn.createStatement();
				sql = "update reserve set c_tel = '"+Tel+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 3)
			{
				RoomType = temp;
				stmt = conn.createStatement();
				sql = "update reserve set r_type = '"+RoomType+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 4)
			{
				RoomNum_other = temp;
				stmt = conn.createStatement();
				sql = "update reserve set room_id = '"+RoomNum_other+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);
				sql = "update roominfo set room_state = '0' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);
				sql = "update roominfo set room_state = '2' Where room_id = '"+RoomNum_other+"'";
				stmt.executeUpdate(sql);
			}
			else if(choice == 5)
			{
				Yuding_nian = temp;
				stmt = conn.createStatement();
				sql = "update reserve set Yuding_year = '"+Yuding_nian+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 6)
			{
				Yuding_yue = temp;
				stmt = conn.createStatement();
				sql = "update reserve set Yuding_month = '"+Yuding_yue+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 7)
			{
				Yuding_ri = temp;
				stmt = conn.createStatement();
				sql = "update reserve set Yuding_day = '"+Yuding_ri+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 8)
			{
				baoliu_nian = temp;
				stmt = conn.createStatement();
				sql = "update reserve set end_year = '"+baoliu_nian+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 9)
			{
				baoliu_yue = temp;
				stmt = conn.createStatement();
				sql = "update reserve set end_month = '"+baoliu_yue+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
			}
			else if(choice == 10)
			{
				baoliu_ri = temp;
				stmt = conn.createStatement();
				sql = "update reserve set end_day = '"+baoliu_ri+"' Where room_id = '"+RoomNum+"'";
				stmt.executeUpdate(sql);	
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
	}
}

	
	
	
	
	
	