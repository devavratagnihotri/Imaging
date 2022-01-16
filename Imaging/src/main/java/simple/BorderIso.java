package simple;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BorderIso {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Bord1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderIso window = new BorderIso();
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
	public BorderIso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 833, 740);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\border_Isolated.jpg");
		JLabel lblNewLabel = new JLabel(imageIcon);
		lblNewLabel.setBounds(51, 33, 716, 623);
		frame.getContentPane().add(lblNewLabel);
	}

}
