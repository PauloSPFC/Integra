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

import dao.EscolaDAO;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Window.Type;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login_Escola extends JFrame {

	private JPanel contentPane;
	
	int xx;
	int xy;
	private JTextField inp_nome;
	private JPasswordField inp_mat;
	int click_count = -1;
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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 90, 379, 591);
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
		Btn_minimize.setBounds(321, -2, 20, 28);
		contentPane.add(Btn_minimize);
		Btn_minimize.setText("");
		Btn_minimize.setBorderPainted(false);
		Btn_minimize.setFocusPainted(false);
		Btn_minimize.setContentAreaFilled(false);
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
		Btn_fechar.setBounds(342, -4, 38, 32);
		contentPane.add(Btn_fechar);
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
		
		JLabel Btn_voltar = new JLabel("");
		Btn_voltar.setBounds(4, 6, 16, 13);
		contentPane.add(Btn_voltar);
		Btn_voltar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/voltar.png")));
		Btn_voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Acesso a = new Acesso();
				a.setUndecorated(true);
				a.setVisible(true);
				a.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
				dispose();
				a.setVisible(true);
			}
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
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(-10, 0, 390, 28);
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
		Container_principal.setBounds(-10, -22, 990, 662);
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		inp_nome = new JTextField();
		inp_nome.setToolTipText("");
		inp_nome.setForeground(Color.DARK_GRAY);
		inp_nome.setFont(new Font("Century Gothic", Font.BOLD, 16));
		inp_nome.setBackground(Color.WHITE);
		inp_nome.setBounds(22, 404, 344, 26);
		Container_principal.add(inp_nome);
		inp_nome.setColumns(10);
		inp_nome.setBorder(null);
		inp_nome.setEnabled(true);
		
		
		inp_mat = new JPasswordField();
		inp_mat.setColumns(10);
		inp_mat.setForeground(Color.DARK_GRAY);
		inp_mat.setFont(new Font("Century Gothic", Font.BOLD, 16));
		inp_mat.setBounds(22, 488, 318, 26);
		inp_mat.setBorder(null);
		inp_mat.setEnabled(true);
		Container_principal.add(inp_mat);
		
		
		JLabel Ver = new JLabel("");
		Ver.setVisible(false);
		Ver.setBackground(SystemColor.text);
		Ver.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/ver.png")));
		Ver.setBounds(346, 488, 20, 20);
		Container_principal.add(Ver);
		inp_mat.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
					Ver.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				Ver.setVisible(false);
			}
		});
		Ver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				click_count++;
				if (click_count %2 == 0) {
					inp_mat.setEchoChar((char)0);
					Ver.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/desver.png")));
				} else {
					inp_mat.setEchoChar('\u2022');
					Ver.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/ver.png")));
				}
				
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_Entrar = new JLabel("");
		Btn_Entrar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Botões/entrar_e.png")));
		Btn_Entrar.setBounds(120, 528, 162, 49);
		Container_principal.add(Btn_Entrar);
		Btn_Entrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nome = inp_nome.getText();
				String matricula = inp_mat.getText();
				EscolaDAO escola = new EscolaDAO();
				if (escola.checkLogin(nome, matricula)) {
					dispose();
					P_Escola p = new P_Escola();
					p.setUndecorated(true);
					p.setVisible(true);
					p.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
				} else {
					dispose();
					Er_Login er = new Er_Login();
					er.setUndecorated(true);
					er.setVisible(true);
					er.setShape(new RoundRectangle2D.Double(0, 0, 379, 379, 15, 15));
					er.escola = true;
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_Entrar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/entrar_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_Entrar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/entrar_e.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_Cadastrar = new JLabel("");
		Btn_Cadastrar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Botões/cadastrar.png")));
		Btn_Cadastrar.setBounds(230, 577, 152, 36);
		Container_principal.add(Btn_Cadastrar);
		Btn_Cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Cadastro_Escola ce = new Cadastro_Escola();
				ce.setUndecorated(true);
				ce.setVisible(true);
				ce.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_Cadastrar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/cadastrar_hover.png")));
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				Btn_Cadastrar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Botões/cadastrar.png")));
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		
		JLabel Fundo = new JLabel("");
		Fundo.setBounds(10, 22, 379, 591);
		Fundo.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Cenas/login_escola.jpg")));
		Container_principal.add(Fundo);
	}
}
