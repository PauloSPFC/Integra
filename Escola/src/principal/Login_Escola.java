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

public class Login_Escola extends JFrame {

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
					Login_Escola frame = new Login_Escola();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Escola() {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 70, 379, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(26, 0, 298, 34);
		contentPane.add(Lbl_mousemove);
		Lbl_mousemove.setFont(new Font("Montserrat Medium", Lbl_mousemove.getFont().getStyle(), 16));
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
		        
		        Login_Escola.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		JLabel Btn_voltar = new JLabel("");
		Btn_voltar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/voltar.png")));
		Btn_voltar.setBounds(16, 25, 20, 28);
		Container_principal.add(Btn_voltar);
		Btn_voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_voltar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/voltar_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_voltar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/voltar.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_minimize = new JLabel("");
		Btn_minimize.setBounds(334, 25, 20, 28);
		Container_principal.add(Btn_minimize);
		Btn_minimize.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setBounds(353, 23, 38, 32);
		Container_principal.add(Btn_fechar);
		Btn_fechar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/close.png")));
		Btn_fechar.setHorizontalAlignment(SwingConstants.CENTER);
		Btn_fechar.setForeground(new Color(241, 57, 83));
		Btn_fechar.setFont(new Font("Montserrat ExtraBold", Btn_fechar.getFont().getStyle(), 14));
		Btn_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_fechar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
	}
}
