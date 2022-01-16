import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class Second {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Screen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Second window = new Second();
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
	public Second() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 565);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("IMAGE PROCESSING");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setBounds(494, 154, 322, 75);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("IMAGE RECOGNITION");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Recognizer nw = new Recognizer();
				nw.Recognizer();
			}
		});
		btnNewButton_1.setBounds(494, 347, 322, 75);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Chinmay Gadkari\\Pictures\\neural_networking.jpg"));
		lblNewLabel.setBounds(-10, 0, 844, 526);
		frame.getContentPane().add(lblNewLabel);
	}
}
