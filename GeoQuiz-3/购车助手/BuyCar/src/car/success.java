package car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class success {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public success() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("´íÎó");
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setTitle("\u64CD\u4F5C\u6210\u529F");
		frame.setBounds(100, 100, 331, 180);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u60A8\u7684\u64CD\u4F5C\u5DF2\u6210\u529F");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		label.setBounds(56, 10, 228, 65);
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
		button.setBounds(66, 85, 106, 45);
		frame.getContentPane().add(button);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	
	public static void run() {
		try {
			success window = new success();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
