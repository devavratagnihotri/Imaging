package simple;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class EroAndDil {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void Ero() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EroAndDil window = new EroAndDil();
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
	public EroAndDil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
