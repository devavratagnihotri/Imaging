package simple;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreshZero {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Thresh1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreshZero window = new ThreshZero();
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
	public ThreshZero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Thresh zero");
		frame.setBounds(100, 100, 860, 881);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\Thresh_Zero.jpg");
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(33, 29, 785, 779);
		frame.getContentPane().add(lblNewLabel);
	}

}
