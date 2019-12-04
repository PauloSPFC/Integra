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

public class Consulta_Agenda extends JFrame {

	private JPanel contentPane;
	JLabel Fundo = new JLabel();
	int xx;
	int xy;
	boolean esc = false;
	boolean profe = false;
	boolean monit = false;
	private int nro_alunos;
	private String data_visita;
	private String hora_visita;
	private int trajeto;
	private boolean cadastra = true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta_Agenda frame = new Consulta_Agenda();
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
	public Consulta_Agenda() {
		
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
		Btn_minimize.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Bot\u00F5es/close.png")));
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
				Btn_fechar.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
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
				if (esc == true) {
					dispose();
					P_Escola p = new P_Escola();
					p.setUndecorated(true);
					p.setVisible(true);
					p.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));			
					p.setVisible(true);
					esc = false;
				} else if (profe == true) {
					dispose();
					P_Professor p = new P_Professor();
					p.setUndecorated(true);
					p.setVisible(true);
					p.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));			
					p.setVisible(true);
					profe = false;
				} else if (monit == true) {
					dispose();
					P_Monitor m = new P_Monitor();
					m.setUndecorated(true);
					m.setVisible(true);
					m.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));			
					m.setVisible(true);
					monit = false;
				}
				
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
		        
		        Consulta_Agenda.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		JTextField Inp_horario = new JTextField();
		Inp_horario.setForeground(Color.WHITE);
		Inp_horario.setOpaque(false);
		Inp_horario.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		Inp_horario.setBorder(null);
		Inp_horario.setBounds(495, 214, 412, 29);
		Container_principal.add(Inp_horario);
		Inp_horario.setColumns(10);
		
		JTextField Inp_data = new JTextField();
		Inp_data.setForeground(Color.WHITE);
		Inp_data.setOpaque(false);
		Inp_data.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		Inp_data.setBorder(null);
		Inp_data.setBounds(41, 214, 412, 29);
		Container_principal.add(Inp_data);
		Inp_data.setColumns(10);
		
		Fundo.setIcon(new ImageIcon(Consulta_Agenda.class.getResource("/Imagens/Principal/consulta_agenda.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);
		
		JLabel T3 = new JLabel("New label");
		T3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				trajeto = 3;
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
		T3.setBounds(604, 377, 90, 80);
		Container_principal.add(T3);
		
		JLabel T2 = new JLabel("New label");
		T2.setBounds(447, 374, 84, 86);
		Container_principal.add(T2);
		T2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				trajeto = 2;
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
		
		JLabel T1 = new JLabel("New label");
		T1.setBounds(288, 374, 90, 86);
		Container_principal.add(T1);
		T1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				trajeto = 1;
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
		
		JLabel btn_consultar = new JLabel();
		btn_consultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {									
				data_visita = Inp_data.getText();
				hora_visita = Inp_horario.getText();	
				VisitaDAO vd = new VisitaDAO();			
				MonitorDAO md = new MonitorDAO();
				String monitor = "";
				String nome_monitor = "";
				
				//GERA MONITOR
				if (vd.checkVisita(trajeto,data_visita, hora_visita) == false) {
					Fundo.setVisible(false);
					
					Btn_minimize.setVisible(false);
					Btn_fechar.setVisible(false);
					Btn_voltar.setVisible(false);
					
					Btn_minimize.setVisible(true);
					Btn_fechar.setVisible(true);
					Btn_voltar.setVisible(true);
					
					T1.setVisible(false);
					T2.setVisible(false);
					T3.setVisible(false);
					
					Inp_data.setVisible(false);
					Inp_horario.setVisible(false);
					
					JLabel Fundo2 = new JLabel("");
					Fundo2.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/nada.jpg")));
					Fundo2.setBounds(10, 18, 1000, 598);					
					Container_principal.add(Fundo2);
				} else {
					Fundo.setVisible(false);
					
					Btn_minimize.setVisible(false);
					Btn_fechar.setVisible(false);
					Btn_voltar.setVisible(false);
					
					Btn_minimize.setVisible(true);
					Btn_fechar.setVisible(true);
					Btn_voltar.setVisible(true);
					
					T1.setVisible(false);
					T2.setVisible(false);
					T3.setVisible(false);
					
					Inp_data.setVisible(false);
					Inp_horario.setVisible(false);
					
					JLabel Fundo3 = new JLabel("");
					Fundo3.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/achou_visita.jpg")));
					Fundo3.setBounds(10, 18, 1000, 598);					
					Container_principal.add(Fundo3);
					
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
		
		btn_consultar.setBounds(336, 498, 309, 86);
		Container_principal.add(btn_consultar);						
						
	}

}
