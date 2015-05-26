package hotel_reserve;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class input_error {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					input_error window = new input_error();
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
	public input_error() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("´íÎó");
		frame.setBounds(100, 100, 398, 190);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u60A8\u7684\u8F93\u5165\u6709\u8BEF\uFF0C\u8BF7\u68C0\u67E5\u540E\u518D\u6B21\u786E\u5B9A");
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 14));
		label.setBounds(82, 40, 240, 25);
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
		button.setBounds(136, 84, 93, 23);
		frame.getContentPane().add(button);
	}
	
	
	protected void dispose() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}

	public void run() {
		try {
			input_error window = new input_error();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

