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

public class Sucesso_Cadastro_Visita extends JFrame {


	private JPanel contentPane;
	
	int xx;
	int xy;
	boolean escola = false;
	boolean professor = false;
	JTextPane Matricula = new JTextPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sucesso_Cadastro_Visita frame = new Sucesso_Cadastro_Visita();
					frame.setUndecorated(true);
					frame.setVisible(true);
					frame.setShape(new RoundRectangle2D.Double(0, 0, 379, 400, 15, 15));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sucesso_Cadastro_Visita() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(490, 190, 379, 400);
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
		
		JLabel Btn_voltar = new JLabel("");
		Btn_voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (escola == true) {
					dispose();
					P_Escola pe = new P_Escola();
					pe.setUndecorated(true);
					pe.setVisible(true);
					pe.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
				} else if (professor == true) {
					dispose();
					P_Professor pp = new P_Professor();
					pp.setUndecorated(true);
					pp.setVisible(true);
					pp.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
				}
			}			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_voltar.setIcon(new ImageIcon(Er_Login.class.getResource("/Imagens/Bot\u00F5es/voltar_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_voltar.setIcon(new ImageIcon(Er_Login.class.getResource("/Imagens/Bot\u00F5es/voltar.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		Btn_voltar.setBounds(4, 6, 16, 13);
		contentPane.add(Btn_voltar);
		Btn_voltar.setIcon(new ImageIcon(Er_Login.class.getResource("/Imagens/Bot\u00F5es/voltar.png")));
		
		
		JButton Btn_minimize = new JButton(minimizeAction);
		Btn_minimize.setBounds(321, -2, 20, 28);
		contentPane.add(Btn_minimize);
		Btn_minimize.setText("");
		Btn_minimize.setBorderPainted(false);
		Btn_minimize.setFocusPainted(false);
		Btn_minimize.setContentAreaFilled(false);
		Btn_minimize.setIcon(new ImageIcon(Sucesso_Cadastro_Visita.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Sucesso_Cadastro_Visita.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Sucesso_Cadastro_Visita.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setBounds(342, -4, 38, 32);
		contentPane.add(Btn_fechar);
		Btn_fechar.setIcon(new ImageIcon(Er_Login.class.getResource("/Imagens/Bot\u00F5es/close.png")));
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
				Btn_fechar.setIcon(new ImageIcon(Er_Login.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Er_Login.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(-10, 0, 390, 151);
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
		        
		        Sucesso_Cadastro_Visita.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBounds(-10, -22, 990, 662);
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.WHITE);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		Matricula.setAlignmentY(CENTER_ALIGNMENT);
		Matricula.setBackground(new Color(18,192,106));
		Matricula.setForeground(Color.WHITE);
		Matricula.setFont(new Font("Big John PRO Bold", Font.PLAIN, 27));
		Matricula.setEditable(false);
		Matricula.setBounds(54, 257, 315, 94);
		Container_principal.add(Matricula);
		
		JLabel Astronauta = new JLabel("");
		Astronauta.setBackground(null);
		Astronauta.setBounds(10, 75, 379, 258);
		Astronauta.setIcon(new ImageIcon(Sucesso_Cadastro_Visita.class.getResource("/Imagens/Cenas/certo.gif")));
		Container_principal.add(Astronauta);
		
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Sucesso_Cadastro_Visita.class.getResource("/Imagens/Cenas/fundosu_visita.png")));
		Fundo.setBounds(10, 22, 379, 379);
		Container_principal.add(Fundo);
		
		JLabel Fundo2 = new JLabel("");
		Fundo2.setIcon(new ImageIcon(Sucesso_Cadastro_Visita.class.getResource("/Imagens/Cenas/certo.gif")));
		Fundo2.setBackground((Color) null);
		Fundo2.setBounds(10, 172, 379, 258);
		Container_principal.add(Fundo2);
	}
}
