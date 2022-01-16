package simple;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
public class Down {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Image image = null;
				try {
					Down window = new Down();
					window.frame.setVisible(true);
					
					URL url = new URL("https://lh3.googleusercontent.com/DHH6jQVLU9VCsKcmkFm0KsoH7pvgYJcEMpdmZCZTRpgG3KYp5Ta2Zk_zwxE3WQtHPOlv8QDNmR_q8BmwPXsXjWgEE2gJhLaHRQ=w1600-rj");
		            image = ImageIO.read(url);
		            
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Down() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Image image = null;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		frame.add(lblNewLabel);
		lblNewLabel.setBounds(31, 35, 177, 176);
		frame.getContentPane().add(lblNewLabel);
		
	}

}
