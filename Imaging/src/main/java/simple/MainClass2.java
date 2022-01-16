package simple;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import com.Image.Recognition.Recognizer;

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
import javax.swing.SwingUtilities;

public class MainClass2 {
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
	private JButton btnNewButton_17;
	private JButton btnNewButton_18;
	private JButton btnNewButton_19;
	private JButton btnNewButton_20;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass2 window = new MainClass2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
    public static void MainClass() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	try {
                new MainClass2().frame.setVisible(true);
            	} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
    }
    
	public MainClass2() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 592);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(100);
		textField.setBounds(12, 13, 445, 34);
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
				downImage di=new downImage();
				di.downim();
				
			}
		});
		btnNewButton.setBounds(485, 13, 127, 35);
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
				GrayScale gs=new GrayScale();
				gs.Gray();
			}
		});
		btnNewButton_1.setBounds(391, 70, 155, 22);
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
				
				Contrast co=new Contrast();
				co.Cont();
			}
		});
		btnNewButton_2.setBounds(391, 105, 155, 25);
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
				Sharp sh=new Sharp();
				sh.Sharpn();
			}
		});
		btnNewButton_3.setBounds(391, 144, 155, 25);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Border Isolated");
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
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				BorderIso BI=new BorderIso();
				BI.Bord1();
			}
		});
		btnNewButton_4.setBounds(391, 220, 155, 25);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Thresh to Zero");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_TOZERO);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Zero.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshZero Th=new ThreshZero();
				Th.Thresh1();

			}
		});
		btnNewButton_5.setBounds(391, 258, 155, 25);
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
				Flip Fl=new Flip();
				Fl.Fli();
			}
		});
		btnNewButton_6.setBounds(391, 296, 155, 25);
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
				Gaussian Ga=new Gaussian();
				Ga.Gauss();
			}
		});
		btnNewButton_7.setBounds(391, 334, 155, 25);
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
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Erosion_Image.jpg", destination);
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
		btnNewButton_8.setBounds(391, 372, 155, 25);
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
		btnNewButton_9.setBounds(391, 410, 155, 25);
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
		btnNewButton_10.setBounds(391, 448, 155, 25);
		frame.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("Brightness");
		btnNewButton_11.addActionListener(new ActionListener() {
				int width;
			    int height;
			    double alpha = 2;
			    double beta = 50;
			public void actionPerformed(ActionEvent arg0) {
				try{
			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source =  Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg",Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),
			         
			         source.type());
			         source.convertTo(destination, -1, alpha, beta);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Brightness.jpg", destination);
			         
			      } catch (Exception e) {
			         System.out.println("error:" + e.getMessage());
			      }
				
				Brightness br=new Brightness();
				br.Bright();
			}
		});
		btnNewButton_11.setBounds(391, 182, 155, 25);
		frame.getContentPane().add(btnNewButton_11);
		
		ImageIcon imageIcon = new ImageIcon("D:\\SEMESTER 4\\JavaPro2\\download.jpg");
		JLabel lblNewLabel_1 = new JLabel(imageIcon);
		lblNewLabel_1.setBounds(12, 70, 367, 440);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_12 = new JButton("Thresh Binary");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_BINARY);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Binary.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshBinary Tb=new ThreshBinary();
				Tb.Thresh2();
			}
		});
		btnNewButton_12.setBounds(558, 69, 149, 25);
		frame.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Thresh Binary Inv");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_BINARY_INV);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Binary_Inv.jpg", destination);
			         
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshBinaryInv Tbi=new ThreshBinaryInv();
				Tbi.Thresh3();
			}
		});
		btnNewButton_13.setBounds(558, 105, 149, 25);
		frame.getContentPane().add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("Thresh Mask");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_MASK);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Mask.jpg", destination);
			         
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshMask Tm=new ThreshMask();
				Tm.Thresh4();
			}
		});
		btnNewButton_14.setBounds(558, 144, 149, 25);
		frame.getContentPane().add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("Thresh Otsu");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_OTSU);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Otsu.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshOtsu To=new ThreshOtsu();
				To.Thresh5();
			}
		});
		btnNewButton_15.setBounds(558, 182, 149, 25);
		frame.getContentPane().add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("Thresh Triangle");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_TRIANGLE);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Triangle.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshTriangle Tt=new ThreshTriangle();
				Tt.Thresh6();
			}
		});
		btnNewButton_16.setBounds(558, 220, 149, 25);
		frame.getContentPane().add(btnNewButton_16);
		
		btnNewButton_17 = new JButton("Thresh Trunc");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{

			         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
			         Mat source = Imgcodecs.imread("D:\\SEMESTER 4\\JavaPro2\\download.jpg", Imgcodecs.IMREAD_COLOR);
			         Mat destination = new Mat(source.rows(),source.cols(),source.type());

			         destination = source;
			         
			         Imgproc.threshold(source,destination,127,255,Imgproc.THRESH_TRUNC);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\Thresh_Trunc.jpg", destination);
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				ThreshTrunc Ttc=new ThreshTrunc();
				Ttc.Thresh7();
			}
		});
		btnNewButton_17.setBounds(558, 258, 149, 25);
		frame.getContentPane().add(btnNewButton_17);
		
		btnNewButton_18 = new JButton("Border Reflected");
		btnNewButton_18.addActionListener(new ActionListener() {
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
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_REFLECT);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Reflect.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				BorderReflect BR=new BorderReflect();
				BR.Bord2();
			}
		});
		btnNewButton_18.setBounds(558, 296, 149, 25);
		frame.getContentPane().add(btnNewButton_18);
		
		btnNewButton_19 = new JButton("Border_Replicate");
		btnNewButton_19.addActionListener(new ActionListener() {
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
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_REPLICATE);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Replicate.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				BorderReplicate BR=new BorderReplicate();
				BR.Bord3();
			}
		});
		btnNewButton_19.setBounds(558, 334, 149, 25);
		frame.getContentPane().add(btnNewButton_19);
		
		btnNewButton_20 = new JButton("Border Wrap");
		btnNewButton_20.addActionListener(new ActionListener() {
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
			         
			         Core.copyMakeBorder(source, destination, top, bottom, left, right, Core.BORDER_WRAP);
			         Imgcodecs.imwrite("D:\\SEMESTER 4\\JavaPro2\\border_Wrap.jpg", destination);
			         
			      } catch (Exception e1) {
			         System.out.println("error: " + e1.getMessage());
			      }
				BorderWrap BW=new BorderWrap();
				BW.BordW();
			}
		});
		btnNewButton_20.setBounds(558, 372, 149, 25);
		frame.getContentPane().add(btnNewButton_20);
		
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
