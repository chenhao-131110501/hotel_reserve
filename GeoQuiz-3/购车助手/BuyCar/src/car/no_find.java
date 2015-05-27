package car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class no_find {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public no_find() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("无符合车辆");
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 450, 221);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u6CA1\u6709\u627E\u5230\u4E0E\u60A8\u8981\u6C42\u7B26\u5408\u7684\u8F66\u8F86");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(104, 33, 255, 66);
		frame.getContentPane().add(label);
		
		final JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==button)
				{
					dispose();
				}
			}
		});
		button.setBounds(149, 107, 113, 47);
		frame.getContentPane().add(button);
	}

	
	public static void run() {
		try {
			no_find window = new no_find();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	
	
	
}
