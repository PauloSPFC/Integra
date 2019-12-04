package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Random;

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

import bean.Escola;
import bean.Professor;
import dao.EscolaDAO;
import dao.ProfessorDAO;

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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Atualiza_Professor extends JFrame {

	private JPanel contentPane;
	
	int xx;
	int xy;
	private JTextField Inp_nome;
	public int matricula;
	String cpf;
	String nome;
	int matricula_escola;
	String tel;
	private boolean cadastra = true;
	private JTextField Inp_senha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Atualiza_Professor frame = new Atualiza_Professor();
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
	public Atualiza_Professor() {
		
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
		Btn_minimize.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/close.png")));
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
				Btn_fechar.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
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
				Config_Professor ce = new Config_Professor();
				ce.setUndecorated(true);
				ce.setVisible(true);
				ce.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
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
		        
		        Atualiza_Professor.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		Inp_senha = new JTextField();
		Inp_senha.setBounds(34, 484, 430, 29);
		Container_principal.add(Inp_senha);
		Inp_senha.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_senha.setColumns(10);
		Inp_senha.setBorder(null);
		
		JTextField Inp_telefone = new JTextField();
		Inp_telefone.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_telefone.setBorder(null);
		Inp_telefone.setBounds(34, 406, 430, 29);
		Container_principal.add(Inp_telefone);
		Inp_telefone.setColumns(10);
		
		JTextField Inp_matricula = new JTextField();
		Inp_matricula.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_matricula.setBorder(null);
		Inp_matricula.setBounds(34, 328, 430, 29);
		Container_principal.add(Inp_matricula);
		Inp_matricula.setColumns(10);
		
		JTextField Inp_cpf = new JTextField();//
		Inp_cpf.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_cpf.setBorder(null);
		Inp_cpf.setBounds(34, 245, 430, 29);
		Container_principal.add(Inp_cpf);
		Inp_cpf.setColumns(10);
		
		Inp_nome = new JTextField();
		Inp_nome.setForeground(Color.BLACK);
		Inp_nome.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		Inp_nome.setBorder(null);
		Inp_nome.setBounds(34, 167, 430, 29);
		Container_principal.add(Inp_nome);
		Inp_nome.setColumns(10);
		
		JLabel Btn_cad = new JLabel("");
		Btn_cad.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Bot\u00F5es/btn_att.png")));
		Btn_cad.setBounds(88, 538, 320, 76);
		Container_principal.add(Btn_cad);
		Btn_cad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String cpf = Inp_cpf.getText();
				int senha = Integer.parseInt(Inp_senha.getText());
				nome = Inp_nome.getText();
				String teste_nro = Inp_matricula.getText();									
				tel = Inp_telefone.getText();
				matricula = Integer.parseInt(Inp_matricula.getText());
				ProfessorDAO pd = new ProfessorDAO();
				
				//Validações								

				Professor p = new Professor(senha,cpf,nome,matricula,tel);
				
				if (pd.checkCpf(cpf) == false) {
					cadastra = false;
				}
				
				if (cadastra == false) {
					Er_Login erl = new Er_Login();
					erl.a_professor = true;
					erl.setUndecorated(true);
					erl.setShape(new RoundRectangle2D.Double(0, 0, 379, 379, 15, 15));
					dispose();
					erl.setVisible(true);
				}
				
				else {
					Login_Professor le = new Login_Professor();
					le.setUndecorated(true);
					le.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
					dispose();
					le.setVisible(true);
					pd.alterar(p);
				}
				
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_cad.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/btn_att_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_cad.setIcon(new ImageIcon(Cadastro_Monitor.class.getResource("/Imagens/Bot\u00F5es/btn_att.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Atualiza_Professor.class.getResource("/Imagens/Principal/atualiza_professor.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);
		
	}
}
