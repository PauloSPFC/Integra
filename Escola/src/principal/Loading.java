package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.DropMode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;

public class Loading extends JFrame {

	private JPanel contentPane;
	
	int xx;
	int xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loading frame = new Loading();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loading() {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 70, 928, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(0, 0, 894, 79);
		contentPane.add(Lbl_mousemove);
		Lbl_mousemove.setFont(new Font("Montserrat Medium", Lbl_mousemove.getFont().getStyle(), 16));
		
		JPanel Container = new JPanel();
		Container.setBounds(0, -5, 928, 591);
		contentPane.add(Container);
		Container.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Container.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(431, 496, 100, 100);
		lblNewLabel_1.setIcon(new ImageIcon(Loading.class.getResource("/Imagens/Icones/loading.gif")));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 5, 928, 591);
		lblNewLabel.setIcon(new ImageIcon(Loading.class.getResource("/Imagens/Cenas/Loading.jpg")));
		Container.add(lblNewLabel);
		Lbl_mousemove.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		
		Lbl_mousemove.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        
		        Loading.this.setLocation(x - xx, y - xy);
			}
		});
		
	}
}
