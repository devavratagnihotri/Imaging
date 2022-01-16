package com.UI.Image;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;



public class Project {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
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
	public Project() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("IMAGE ANALYSIS");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("L M Mono Prop Lt10", Font.BOLD, 34));
		lblNewLabel_1.setBounds(116, 114, 349, 63);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Second nw = new Second();
				nw.Screen();
			}
		});
		btnNewButton.setBounds(191, 233, 187, 43);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\application.jpg"));
		lblNewLabel.setBounds(0, 0, 984, 368);
		frame.getContentPane().add(lblNewLabel);
	}
}

