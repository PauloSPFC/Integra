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

public class Cadastro_Monitor extends JFrame {

	private JPanel contentPane;
	
	int xx;
	int xy;
	private JTextField Inp_nome;
	private JTextField Inp_cpf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro_Monitor frame = new Cadastro_Monitor();
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
	public Cadastro_Monitor() {
		
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
		Btn_minimize.setBounds(870, -1, 20, 28);
		Btn_minimize.setBorderPainted(false);
		Btn_minimize.setFocusPainted(false);
		Btn_minimize.setContentAreaFilled(false);
		contentPane.add(Btn_minimize);
		Btn_minimize.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/close.png")));
		Btn_fechar.setHorizontalAlignment(SwingConstants.CENTER);
		Btn_fechar.setForeground(new Color(241, 57, 83));
		Btn_fechar.setFont(new Font("Montserrat ExtraBold", Btn_fechar.getFont().getStyle(), 14));
		Btn_fechar.setBounds(889, -3, 38, 32);
		contentPane.add(Btn_fechar);
		Btn_fechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_fechar.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_voltar = new JLabel("");
		Btn_voltar.setBounds(15, 1, 18, 24);
		contentPane.add(Btn_voltar);
		Btn_voltar.setIcon(new ImageIcon(Login_Escola.class.getResource("/Imagens/Bot\u00F5es/voltar.png")));
		Btn_voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				Login_Monitor lm = new Login_Monitor();
				lm.setUndecorated(true);
				lm.setVisible(true);
				lm.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));			
				lm.setVisible(true);
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
		Lbl_mousemove.setBounds(-10, 0, 990, 95);
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
		        
		        Cadastro_Monitor.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		JTextField Inp_telefone = new JTextField();
		Inp_telefone.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_telefone.setBorder(null);
		Inp_telefone.setBounds(37, 490, 430, 29);
		Container_principal.add(Inp_telefone);
		Inp_telefone.setColumns(10);
		
		JTextField Inp_cidade = new JTextField();
		Inp_cidade.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_cidade.setBorder(null);
		Inp_cidade.setBounds(38, 426, 184, 29);
		Container_principal.add(Inp_cidade);
		Inp_cidade.setColumns(10);
		
		JTextField Inp_estado = new JTextField();
		Inp_estado.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_estado.setBorder(null);
		Inp_estado.setBounds(297, 426, 169, 29);
		Container_principal.add(Inp_estado);
		Inp_estado.setColumns(10);
		
		JTextField Inp_bairro = new JTextField();
		Inp_bairro.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_bairro.setBorder(null);
		Inp_bairro.setBounds(297, 360, 171, 29);
		Container_principal.add(Inp_bairro);
		Inp_bairro.setColumns(10);
		
		JTextField Inp_nro = new JTextField();
		Inp_nro.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_nro.setBorder(null);
		Inp_nro.setBounds(36, 360, 112, 29);
		Container_principal.add(Inp_nro);
		Inp_nro.setColumns(10);
		
		JTextField Inp_rua = new JTextField();
		Inp_rua.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_rua.setBorder(null);
		Inp_rua.setBounds(36, 293, 430, 29);
		Container_principal.add(Inp_rua);
		Inp_rua.setColumns(10);
		
		Inp_cpf = new JTextField();
		Inp_cpf.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_cpf.setBorder(null);
		Inp_cpf.setBounds(36, 229, 430, 29);
		Container_principal.add(Inp_cpf);
		Inp_cpf.setColumns(10);
		
		
		Inp_nome = new JTextField();
		Inp_nome.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_nome.setBorder(null);
		Inp_nome.setBounds(36, 163, 430, 29);
		Container_principal.add(Inp_nome);
		Inp_nome.setColumns(10);
		
		JLabel Btn_cad = new JLabel("");
		Btn_cad.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/btn_cad.png")));
		Btn_cad.setBounds(88, 538, 320, 76);
		Container_principal.add(Btn_cad);
		
		Btn_cad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_cad.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/btn_cad_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_cad.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/btn_cad.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Cenas/Cadastro_Monitor.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);
		
	}
}
