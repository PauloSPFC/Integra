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

public class BoasVindas extends JFrame {

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
					BoasVindas frame = new BoasVindas();
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
	public BoasVindas() {
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 70, 928, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Btn_minimize = new JLabel("");
		Btn_minimize.setBounds(872, 3, 20, 28);
		contentPane.add(Btn_minimize);
		Btn_minimize.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Bot\u00F5es/close.png")));
		Btn_fechar.setHorizontalAlignment(SwingConstants.CENTER);
		Btn_fechar.setForeground(new Color(241, 57, 83));
		Btn_fechar.setFont(new Font("Montserrat ExtraBold", Btn_fechar.getFont().getStyle(), 14));
		Btn_fechar.setBounds(891, 1, 38, 32);
		contentPane.add(Btn_fechar);
		Btn_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_fechar.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(0, 0, 894, 79);
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
		        
		        BoasVindas.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		
		JPanel Escola = new JPanel();
		Escola.setForeground(Color.WHITE);
		Escola.setBounds(39, 246, 230, 260);
		Escola.setBackground(new Color(245, 245, 245));
		Container_principal.add(Escola);
		Escola.setLayout(null);
		
		JTextPane Btn_Escola = new JTextPane();
		Btn_Escola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Escola.setBackground(new Color(217, 217, 217));
				Btn_Escola.setBackground(new Color(63, 193, 201));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Escola.setBackground(new Color(245, 245, 245));
				Btn_Escola.setBackground(new Color(252, 81, 133));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		Btn_Escola.setForeground(Color.WHITE);
		Btn_Escola.setEditable(false);
		Btn_Escola.setFont(new Font("Montserrat SemiBold", Btn_Escola.getFont().getStyle(), 34));
		Btn_Escola.setText("     ESCOLA\r\n");
		Btn_Escola.setBounds(0, 219, 230, 41);
		Btn_Escola.setBackground(new Color(252, 81, 133));
		Escola.add(Btn_Escola);
		
		JLabel Icone_Escola = new JLabel("");
		Icone_Escola.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Icones/school.png")));
		Icone_Escola.setBounds(50, 51, 128, 120);
		Escola.add(Icone_Escola);
		Escola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Escola.setBackground(new Color(217, 217, 217));
				Btn_Escola.setBackground(new Color(63, 193, 201));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Escola.setBackground(new Color(245, 245, 245));
				Btn_Escola.setBackground(new Color(252, 81, 133));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
			
		});
		JPanel Professor = new JPanel();
		Professor.setBounds(359, 246, 230, 260);
		Container_principal.add(Professor);
		Professor.setLayout(null);
		
		JTextPane Btn_Professor = new JTextPane();
		Btn_Professor.setFont(new Font("Montserrat SemiBold", Btn_Professor.getFont().getStyle(), 33));
		Btn_Professor.setText(" PROFESSOR\r\n\r\n");
		Btn_Professor.setForeground(Color.WHITE);
		Btn_Professor.setEditable(false);
		Btn_Professor.setBackground(new Color(252, 81, 133));
		Btn_Professor.setBounds(0, 219, 230, 41);
		Professor.add(Btn_Professor);
		
		Professor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_Escola login = new Login_Escola(); 
				BoasVindas.this.dispose();
				login.setUndecorated(true);
				login.setVisible(true);
				login.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Professor.setBackground(new Color(217, 217, 217));
				Btn_Professor.setBackground(new Color(63, 193, 201));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Professor.setBackground(new Color(245, 245, 245));
				Btn_Professor.setBackground(new Color(252, 81, 133));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		Btn_Professor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_Escola login = new Login_Escola(); 
				BoasVindas.this.dispose();
				login.setUndecorated(true);
				login.setVisible(true);
				login.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Professor.setBackground(new Color(217, 217, 217));
				Btn_Professor.setBackground(new Color(63, 193, 201));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Professor.setBackground(new Color(245, 245, 245));
				Btn_Professor.setBackground(new Color(252, 81, 133));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Icone_Professor = new JLabel("");
		Icone_Professor.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Icones/education.png")));
		Icone_Professor.setBounds(53, 35, 134, 151);
		Professor.add(Icone_Professor);
		
		JPanel Monitor = new JPanel();
		Monitor.setBounds(676, 246, 230, 260);
		Container_principal.add(Monitor);
		Monitor.setLayout(null);
		
		JTextPane Btn_Monitor = new JTextPane();
		Btn_Monitor.setFont(new Font("Montserrat SemiBold", Btn_Monitor.getFont().getStyle(), 34));
		Btn_Monitor.setText("    MONITOR\r\n");
		Btn_Monitor.setForeground(Color.WHITE);
		Btn_Monitor.setEditable(false);
		Btn_Monitor.setBackground(new Color(252, 81, 133));
		Btn_Monitor.setBounds(0, 219, 230, 41);
		Monitor.add(Btn_Monitor);
		
		Monitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Monitor.setBackground(new Color(217, 217, 217));
				Btn_Monitor.setBackground(new Color(63, 193, 201));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Monitor.setBackground(new Color(245, 245, 245));
				Btn_Monitor.setBackground(new Color(252, 81, 133));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		Btn_Monitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Monitor.setBackground(new Color(217, 217, 217));
				Btn_Monitor.setBackground(new Color(63, 193, 201));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Monitor.setBackground(new Color(245, 245, 245));
				Btn_Monitor.setBackground(new Color(252, 81, 133));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Icone_Monitor = new JLabel("");
		Icone_Monitor.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Icones/lifejacket.png")));
		Icone_Monitor.setBounds(50, 46, 128, 137);
		Monitor.add(Icone_Monitor);
		
		JPanel Titulo = new JPanel();
		Titulo.setBounds(0, 11, 980, 89);
		Titulo.setBackground(new Color(85,249,134));
		Container_principal.add(Titulo);
		Titulo.setLayout(null);
		
		JLabel Caderno = new JLabel("");
		Caderno.setBounds(195, 14, 71, 74);
		Caderno.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Icones/notebook.png")));
		Titulo.add(Caderno);
		
		JLabel Folha = new JLabel("");
		Folha.setBounds(722, 15, 71, 74);
		Folha.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Icones/plant.png")));
		Titulo.add(Folha);
		
		JTextPane Header = new JTextPane();
		Header.setBounds(275, 23, 450, 85);
		Header.setEditable(false);
		Header.setFont(new Font("Lato Heavy", Header.getFont().getStyle(), 40));
		Header.setForeground(Color.WHITE);
		Header.setText("ESCOLA NO CERRADO");
		Header.setBackground(new Color(85,249,134));
		Titulo.add(Header);
		
		JPanel Voce = new JPanel();
		Voce.setBounds(10, 140, 970, 60);
		Voce.setBackground(new Color(102, 102, 102));
		Container_principal.add(Voce);
		Voce.setLayout(null);
		
		JTextPane Row_vc = new JTextPane();
		Row_vc.setHighlighter(null);
		Row_vc.setBounds(382, 5, 169, 60);
		Row_vc.setBackground(new Color(102, 102, 102));
		Voce.add(Row_vc);
		Row_vc.setForeground(Color.WHITE);
		Row_vc.setFont(new Font("Montserrat Thin", Row_vc.getFont().getStyle(), 42));
		Row_vc.setText("Voc\u00EA \u00E9...");
		Row_vc.setEditable(false);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Logo/logopb64.png")));
		Logo.setBounds(504, 540, 65, 68);
		Container_principal.add(Logo);
		Logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Logo.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Logo/logo64.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Logo.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/Logo/logopb64.png")));
			}
		});
		
		JTextPane txt_Direitos = new JTextPane();
		txt_Direitos.setEditable(false);
		txt_Direitos.setForeground(Color.WHITE);
		txt_Direitos.setFont(new Font("Roboto", Font.PLAIN, 16));
		txt_Direitos.setText("Desenvolvido por              ");
		txt_Direitos.setBackground(Color.DARK_GRAY);
		txt_Direitos.setBounds(383, 560, 200, 20);
		Container_principal.add(txt_Direitos);
		
	}
}
