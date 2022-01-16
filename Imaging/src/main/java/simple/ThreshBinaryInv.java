package simple;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreshBinaryInv {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Thresh3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreshBinaryInv window = new ThreshBinaryInv();
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
	public ThreshBinaryInv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 805, 717);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\Thresh_Binary_Inv.jpg");
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(12, 13, 750, 630);
		frame.getContentPane().add(lblNewLabel);
	}

}
