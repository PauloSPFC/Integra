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
import bean.Visita;
import dao.EscolaDAO;
import dao.MonitorDAO;
import dao.ProfessorDAO;
import dao.VisitaDAO;

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

public class Excl_escola extends JFrame {

	private JPanel contentPane;
	
	int xx;
	int xy;
	private int matricula;
	private JTextField Inp_matricula;
	private boolean cadastra = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excl_escola frame = new Excl_escola();
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
	public Excl_escola() {
		
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
		Btn_minimize.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Bot\u00F5es/close.png")));
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
				Btn_fechar.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
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
				Config_Escola ce = new Config_Escola();
				ce.setUndecorated(true);
				ce.setVisible(true);
				ce.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));			
				ce.setVisible(true);
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
		        
		        Excl_escola.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		Inp_matricula = new JTextField();
		Inp_matricula.setOpaque(false);
		Inp_matricula.setForeground(Color.WHITE);
		Inp_matricula.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		Inp_matricula.setBorder(null);
		Inp_matricula.setBounds(276, 312, 430, 29);
		Container_principal.add(Inp_matricula);
		Inp_matricula.setColumns(10);
		
		JLabel btn_excluir = new JLabel("");
		btn_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				matricula = Integer.parseInt(Inp_matricula.getText());		
				EscolaDAO ed = new EscolaDAO(); 		
				
				if (ed.checkMatricula(matricula) == false) {	
					cadastra = false;			
				}
				
				if (cadastra == false) {
					Er_Login erl = new Er_Login();
					erl.e_escola = true;
					erl.setUndecorated(true);
					erl.setShape(new RoundRectangle2D.Double(0, 0, 379, 379, 15, 15));
					dispose();
					erl.setVisible(true);
				}
				
				
				else {
					VisitaDAO vd = new VisitaDAO();
					vd.removerEscola(matricula);
					ProfessorDAO pd = new ProfessorDAO();
					pd.removerEscola(matricula);
					ed.removerMatricula(matricula);
					dispose();
					Acesso a = new Acesso();
					a.setUndecorated(true);
					a.setVisible(true);
					a.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
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
		
		btn_excluir.setBounds(348, 439, 309, 95);
		Container_principal.add(btn_excluir);
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Excl_escola.class.getResource("/Imagens/Principal/Excl_e.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);
		
		
				
	}

}
