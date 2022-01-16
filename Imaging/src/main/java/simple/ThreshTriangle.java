package simple;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreshTriangle {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Thresh6() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreshTriangle window = new ThreshTriangle();
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
	public ThreshTriangle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 785, 713);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\Thresh_Triangle.jpg");
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(12, 13, 726, 627);
		frame.getContentPane().add(lblNewLabel);
	}

}
