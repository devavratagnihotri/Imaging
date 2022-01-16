package simple;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreshMask {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Thresh4() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreshMask window = new ThreshMask();
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
	public ThreshMask() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 732);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\Thresh_Mask.jpg");
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(12, 13, 732, 659);
		frame.getContentPane().add(lblNewLabel);
	}

}
