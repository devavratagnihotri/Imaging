package simple;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.net.URL;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Download {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try{
	         String website = "https://lh3.googleusercontent.com/DHH6jQVLU9VCsKcmkFm0KsoH7pvgYJcEMpdmZCZTRpgG3KYp5Ta2Zk_zwxE3WQtHPOlv8QDNmR_q8BmwPXsXjWgEE2gJhLaHRQ=w1600-rj";
	         
	         System.out.println("Downloading File From: " + website);
	         
	         URL url = new URL(website);
	         InputStream inputStream = url.openStream();
	         OutputStream outputStream = new FileOutputStream("D:\\SEMESTER 4\\JavaPro2\\Downlo.jpg");
	         byte[] buffer = new byte[2048];
	         
	         int length = 0;
	         
	         while ((length = inputStream.read(buffer)) != -1) {
	            System.out.println("Buffer Read of length: " + length);
	            outputStream.write(buffer, 0, length);
	         }
	         
	         inputStream.close();
	         outputStream.close();
	         
	      } catch(Exception e) {
	         System.out.println("Exception: " + e.getMessage());
	      }

	}

}
