package simple;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
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
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainClass {
	private JFrame frame;
	private JTextField txtEnterUrlTo;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass window = new MainClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainClass() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 507);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(100);
		textField.setBounds(43, 13, 204, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Download");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String urlT=textField.getText();
			         String website =""+urlT;
			         
			         System.out.println("Downloading File From: " + website);
			         
			         URL url = new URL(website);
			         InputStream inputStream = url.openStream();
			         OutputStream outputStream = new FileOutputStream("D:\\SEMESTER 4\\JavaPro2\\download.jpg");
			         byte[] buffer = new byte[2048];
			         
			         int length = 0;
			         
			         while ((length = inputStream.read(buffer)) != -1) {
			            System.out.println("Buffer Read of length: " + length);
			            outputStream.write(buffer, 0, length);
			         }
			         
			         inputStream.close();
			         outputStream.close();
			         
			      } catch(Exception e1) {
			         System.out.println("Exception: " + e1.getMessage());
			      }
				
			}
		});
		btnNewButton.setBounds(272, 12, 126, 25);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Convert To Grayscale");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         File input = new File("D:\\SEMESTER 4\\JavaPro2\\download.jpg");
			         BufferedImage image = ImageIO.read(input);	

			         byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			         Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
			         mat.put(0, 0, data);

			         Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC1);
			         Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);

			         byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int)(mat1.elemSize())];
			         mat1.get(0, 0, data1);
			         BufferedImage image1 = new BufferedImage(mat1.cols(),mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
			         image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);

			         File ouptut = new File("D:\\SEMESTER 4\\JavaPro2\\grayscale.jpg");
			         ImageIO.write(image1, "jpg", ouptut);
			         
			      } catch (Exception e1) {
			         System.out.println("Error: " + e1.getMessage());
			      }
			}
		});
		btnNewButton_1.setBounds(282, 60, 207, 22);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Enhance Contrast.");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int width;
				int height;
				double alpha = 2;
				double beta = 50;
				try {
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\grayscale.jpg",Imgcodecs.IMREAD_GRAYSCALE);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());
			         
			         Imgproc.equalizeHist(source, destination);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\contrast.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
			}
		});
		btnNewButton_2.setBounds(282, 95, 207, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Sharpness");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg",Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());
			         Imgproc.GaussianBlur(source, destination, new Size(0,0), 10);
			         Core.addWeighted(source, 1.5, destination, -0.5, 0, destination);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Sharpness.jpg", destination);
			      } catch (Exception e1) {
			      }
			}
		});
		btnNewButton_3.setBounds(282, 133, 207, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Adding Border to Image");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg" ,Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());
			         
			         int top, bottom, left, right;
			         int borderType;

			         top = (int) (0.05*source.rows()); 
			         bottom = (int) (0.05*source.rows());
			         left = (int) (0.05*source.cols()); 
			         right = (int) (0.05*source.cols());

			         destination = source;
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_ISOLATED);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Isolated.jpg", destination);
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_REFLECT);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Reflect.jpg", destination);
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_REPLICATE);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Replicate.jpg", destination);
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_TRANSPARENT);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Transparent.jpg", destination);
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_WRAP);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Wrap.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
			}
		});
		btnNewButton_4.setBounds(282, 171, 207, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Thresholding");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_TOZERO);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Zero.jpg", destination);
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_BINARY);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Binary.jpg", destination);
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_BINARY_INV);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Binary_Inv.jpg", destination);
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_MASK);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Mask.jpg", destination);
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_OTSU);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Otsu.jpg", destination);
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_TRIANGLE);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Triangle.jpg", destination);
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_TRUNC);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Trunc.jpg", destination);
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }

			}
		});
		btnNewButton_5.setBounds(282, 209, 207, 25);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Flip");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         File input = new File("D:\\SEMESTER 4\\JavaPro2\\download.jpg");
			         BufferedImage image = ImageIO.read(input);	

			         byte[] data = ((DataBufferByte) image.getRaster().  getDataBuffer()).getData();
			         Mat mat = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC3);
			         mat.put(0, 0, data);

			         Mat mat1 = new Mat(image.getHeight(),image.getWidth(),CvType.CV_8UC3);
			         Core.flip(mat, mat1, -1);

			         byte[] data1 = new byte[mat1.rows()*mat1.cols()*(int)(mat1.elemSize())];
			         mat1.get(0, 0, data1);
			         BufferedImage image1 = new BufferedImage(mat1.cols(), mat1.rows(), 5);
			         image1.getRaster().setDataElements(0,0,mat1.cols(),mat1.rows(),data1);

			         File ouptut = new File("D:\\SEMESTER 4\\JavaPro2\\Upside_Down.jpg");
			         ImageIO.write(image1, "jpg", ouptut);
			         
			      } catch (Exception e1) {
			         System.out.println("Error: " + e1.getMessage());
			      }
			}
		});
		btnNewButton_6.setBounds(282, 247, 207, 25);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_7 = new JButton("Gaussian Filter");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg",Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());
			         Imgproc.GaussianBlur(source, destination,new Size(45,45), 0);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Gaussian_45_Image.jpg", destination);
			      
			      } catch (Exception e1) {
			         System.out.println("Error:" + e1.getMessage());
			      }
			}
		});
		btnNewButton_7.setBounds(282, 285, 207, 25);
		frame.getContentPane().add(btnNewButton_7);
		
		btnNewButton_8 = new JButton("Erosion & Dilation");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg",  Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());
			         destination = source;
			         int erosion_size = 5;
			         int dilation_size = 5;
			         
			         Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*erosion_size + 1, 2*erosion_size+1));
			         Imgproc.erode(source, destination, element);
			         Imgcodecs.imwrite("erosion.jpg", destination);
			         source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg",  Imgcodecs.IMREAD_COLOR);
			         destination = source;
			         Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new  Size(2*dilation_size + 1, 2*dilation_size+1));
			         Imgproc.dilate(source, destination, element1);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Dilated_Image.jpg", destination);
			      } catch (Exception e1) {
			         System.out.println("error:" + e1.getMessage());
			      } 
			}
		});
		btnNewButton_8.setBounds(282, 323, 207, 25);
		frame.getContentPane().add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("Zooming Effect");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         int zoomingFactor = 2;
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows() * zoomingFactor, source.cols()*  zoomingFactor,source.type());  
			         
			         Imgproc.resize(source, destination, destination.size(),  zoomingFactor,zoomingFactor,Imgproc.INTER_NEAREST);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Zoomed_Image.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("Error: "+e1.getMessage());
			      }
			}
		});
		btnNewButton_9.setBounds(282, 361, 207, 25);
		frame.getContentPane().add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("Color Space Conversion");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         File input = new File("D:\\SEMESTER 4\\JavaPro2\\download.jpg");
			         BufferedImage image = ImageIO.read(input);	
			         byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			         Mat mat = new Mat(image.getHeight(),image.getWidth(), CvType.CV_8UC3);
			         mat.put(0, 0, data);

			         Mat mat1 = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
			         Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2HSV);

			         byte[] data1 = new byte[mat1.rows()*mat1.cols()*(int)(mat1.elemSize())];
			         mat1.get(0, 0, data1);
			         BufferedImage image1 = new BufferedImage(mat1.cols(), mat1.rows(), 5);
			         image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);

			         File ouptut = new File("D:\\SEMESTER 4\\JavaPro2\\Color_Space_Converted.jpg");
			         ImageIO.write(image1, "jpg", ouptut);
			         
			      } catch (Exception e1) {
			         System.out.println("Error: " + e1.getMessage());
			      }
			}
		});
		btnNewButton_10.setBounds(282, 399, 207, 25);
		frame.getContentPane().add(btnNewButton_10);
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
