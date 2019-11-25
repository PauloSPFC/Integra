package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DropMode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;

public class P_Escola extends JFrame {

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
					P_Escola frame = new P_Escola();
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
	public P_Escola() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);	
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 90, 928, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final Action minimizeAction = new AbstractAction("Minimize") {
			@Override
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}			
		};
		
		JButton Btn_minimize = new JButton(minimizeAction);
		Btn_minimize.setText("");
		Btn_minimize.setBounds(872, -1, 20, 28);
		Btn_minimize.setBorderPainted(false);
		Btn_minimize.setFocusPainted(false);
		Btn_minimize.setContentAreaFilled(false);
		contentPane.add(Btn_minimize);
		Btn_minimize.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Bot\u00F5es/close.png")));
		Btn_fechar.setHorizontalAlignment(SwingConstants.CENTER);
		Btn_fechar.setForeground(new Color(241, 57, 83));
		Btn_fechar.setFont(new Font("Montserrat ExtraBold", Btn_fechar.getFont().getStyle(), 14));
		Btn_fechar.setBounds(891, -3, 38, 32);
		contentPane.add(Btn_fechar);
		Btn_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_fechar.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Favicon = new JLabel("");
		Favicon.setBounds(13, 1, 18, 24);
		contentPane.add(Favicon);
		Favicon.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Logo/fav.png")));
		Favicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Favicon.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Logo/fav_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Favicon.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Logo/fav.png")));
			}
			
		});
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(-10, 0, 990, 189);
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
		        
		        P_Escola.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		JLabel btn_agenda = new JLabel("");
		btn_agenda.setBounds(699, 253, 214, 212);
		Container_principal.add(btn_agenda);
		
		JLabel btn_visitas = new JLabel("");
		btn_visitas.setBounds(364, 247, 228, 227);
		Container_principal.add(btn_visitas);
		
		JLabel btn_cadastrar = new JLabel("");
		btn_cadastrar.setBounds(37, 247, 221, 227);
		Container_principal.add(btn_cadastrar);
		
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(P_Escola.class.getResource("/Imagens/Principal/p_escola.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);
		
		JLabel btn_settings = new JLabel("New label");
		btn_settings.setBounds(846, 552, 98, 64);
		Container_principal.add(btn_settings);
		btn_settings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Config_Escola ce = new Config_Escola();
				ce.setUndecorated(true);
				ce.setVisible(true);
				ce.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel btn_sair = new JLabel("New label");
		btn_sair.setBounds(0, 552, 98, 64);
		Container_principal.add(btn_sair);
		btn_sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Acesso a = new Acesso();
				a.setUndecorated(true);
				a.setVisible(true);
				a.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		btn_agenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		btn_visitas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
							
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		btn_cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Cadastro_Visita cv = new Cadastro_Visita();
				cv.setUndecorated(true);
				cv.setVisible(true);
				cv.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));			
			}
			@Override
			public void mouseExited(MouseEvent e) {
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
	}
}
