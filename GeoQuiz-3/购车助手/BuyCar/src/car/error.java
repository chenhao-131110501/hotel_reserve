package car;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class error {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public error() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("´íÎó");
		frame.getContentPane().setBackground(new Color(255, 255, 153));
		frame.setBounds(100, 100, 454, 196);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u60A8\u8F93\u5165\u7684\u4FE1\u606F\u6709\u8BEF\uFF0C\u8BF7\u68C0\u67E5\u540E\u91CD\u65B0\u8F93\u5165");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 20));
		label.setBounds(56, 10, 372, 65);
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
		button.setBounds(161, 85, 106, 45);
		frame.getContentPane().add(button);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}
	
	
	public void run() {
		try {
			error window = new error();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
