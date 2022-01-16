package simple;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderReplicate {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Bord3() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderReplicate window = new BorderReplicate();
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
	public BorderReplicate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 628);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\border_Replicate.jpg");
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(12, 13, 580, 651);
		frame.getContentPane().add(lblNewLabel);
	}

}
