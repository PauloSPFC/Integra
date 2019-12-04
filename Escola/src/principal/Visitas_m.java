package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
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

public class Visitas_m extends JFrame {

	private JPanel contentPane;
	
	int xx;
	int xy;
	int mat;
	boolean cadastra = true;
	int click_count = 0;
	int click_count2 = 1;
	int click_count3;
	
	MonitorDAO md = new MonitorDAO();
	ProfessorDAO pd = new ProfessorDAO();
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visitas_m frame = new Visitas_m();
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
	public Visitas_m() {	
				
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
		Btn_minimize.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Bot\u00F5es/close.png")));
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
				Btn_fechar.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
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
				P_Monitor pm = new P_Monitor();
				pm.setUndecorated(true);
				pm.setVisible(true);
				pm.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));			
				pm.setVisible(true);
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
		        
		        Visitas_m.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
	
		JTextField Inp_senha = new JTextField();
		Inp_senha.setOpaque(false);
		Inp_senha.setForeground(Color.WHITE);
		Inp_senha.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		Inp_senha.setBorder(null);
		Inp_senha.setBounds(276, 312, 430, 29);
		Container_principal.add(Inp_senha);
		Inp_senha.setColumns(10);
		
		JLabel btn_prox = new JLabel("");
		btn_prox.setVisible(false);
		
		JLabel btn_ant = new JLabel("");
		btn_ant.setVisible(false);
		btn_ant.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/btn_ant.png")));
		btn_ant.setBounds(23, 560, 192, 48);
		Container_principal.add(btn_ant);
		btn_prox.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/btn_prox.png")));
		btn_prox.setBounds(736, 536, 309, 95);
		Container_principal.add(btn_prox);
		
		JLabel btn_consultar = new JLabel("");	
		btn_consultar.setBounds(348, 439, 309, 95);
		Container_principal.add(btn_consultar);		
		
		//MOSTRA VISITAS
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/confirm_cons_p.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);		
		
		btn_consultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btn_consultar.setVisible(false);
				String senha = Inp_senha.getText();
				EscolaDAO ed = new EscolaDAO();		
				
				if (md.checkCadastro(senha) == false) {	
					cadastra = false;			
				}
				
				if (cadastra == false) {
					Er_Login erl = new Er_Login();
					erl.p_monitor = true;
					erl.setUndecorated(true);
					erl.setShape(new RoundRectangle2D.Double(0, 0, 379, 379, 15, 15));
					dispose();
					erl.setVisible(true);
				}
				
				
				else {
					Fundo.setVisible(false);
					
					Inp_senha.setVisible(false);					
					Btn_voltar.setVisible(false);
					Btn_fechar.setVisible(false);
					Btn_minimize.setVisible(false);
					Btn_voltar.setVisible(true);
					Btn_fechar.setVisible(true);
					Btn_minimize.setVisible(true);
					
					VisitaDAO vd = new VisitaDAO();
					
					JTextPane cod = new JTextPane();
					cod.setOpaque(false);
					cod.setEditable(false);
					cod.setForeground(Color.WHITE);
					cod.setFont(new Font("Panton Black Caps", Font.PLAIN, 38));
					cod.setBounds(85, 217, 219, 48);
					Container_principal.add(cod);
					
					JTextPane monitor = new JTextPane();
					monitor.setOpaque(false);
					monitor.setBounds(85, 362, 433, 48);
					Container_principal.add(monitor);
					monitor.setForeground(Color.WHITE);
					monitor.setFont(new Font("Panton Black Caps", Font.PLAIN, 38));
					monitor.setEditable(false);
					
					JTextPane professor = new JTextPane();
					professor.setOpaque(false);
					professor.setForeground(Color.WHITE);
					professor.setFont(new Font("Panton Black Caps", Font.PLAIN, 38));
					professor.setEditable(false);
					professor.setBounds(108, 522, 410, 48);
					Container_principal.add(professor);
					
					JTextPane escola = new JTextPane();
					escola.setOpaque(false);
					escola.setForeground(Color.WHITE);
					escola.setFont(new Font("Panton Black Caps", Font.PLAIN, 38));
					escola.setEditable(false);
					escola.setBounds(637, 220, 343, 48);
					Container_principal.add(escola);
					
					JTextPane alunos = new JTextPane();
					alunos.setOpaque(false);
					alunos.setForeground(Color.WHITE);
					alunos.setFont(new Font("Panton Black Caps", Font.PLAIN, 38));
					alunos.setEditable(false);
					alunos.setBounds(624, 362, 356, 48);
					Container_principal.add(alunos);
					
					JTextPane hora = new JTextPane();
					hora.setOpaque(false);
					hora.setForeground(Color.WHITE);
					hora.setFont(new Font("Panton Black Caps", Font.PLAIN, 22));
					hora.setEditable(false);
					hora.setBounds(793, 498, 133, 39);
					Container_principal.add(hora);
					
					JTextPane data = new JTextPane();
					data.setOpaque(false);
					data.setForeground(Color.WHITE);
					data.setFont(new Font("Panton Black Caps", Font.PLAIN, 22));
					data.setEditable(false);
					data.setBounds(609, 498, 133, 39);
					Container_principal.add(data);
					
					JTextPane trajeto = new JTextPane();
					trajeto.setOpaque(false);
					trajeto.setFont(new Font("Panton Black Caps", Font.PLAIN, 38));
					trajeto.setBounds(327, 217, 38, 48);
					Container_principal.add(trajeto);
					
					int tamanho = vd.getListaM(senha).size();
					
					if (tamanho == 0) {
						JLabel Fundo2 = new JLabel("");
						Fundo2.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/nada.jpg")));
						Fundo2.setBounds(10, 18, 1000, 598);
						Container_principal.add(Fundo2);
					} else {
						String nome_escola = ed.getNome(vd.getListaM(senha).get(0).getEscola());
						int codigo = vd.getListaM(senha).get(0).getCod_visita();
						int traj = vd.getListaM(senha).get(0).getCod_trajeto();
						String mon = md.getNome(vd.getListaM(senha).get(0).getMonitor());
						String prof = pd.getNome(vd.getListaM(senha).get(0).getProfessor());
						String dat = vd.getListaM(senha).get(0).getData_visita();
						String hr = vd.getListaM(senha).get(0).getHorario_visita();
						int aln = vd.getListaM(senha).get(0).getNro_alunos();
						
						escola.setText(nome_escola);
						cod.setText(Integer.toString(codigo));
						trajeto.setText(Integer.toString(traj));
						alunos.setText(Integer.toString(aln));
						monitor.setText(mon);
						professor.setText(prof);
						data.setText(dat);
						hora.setText(hr);					
											
						
						if(vd.getListaM(senha).size() > 1) {
							btn_prox.setVisible(true);
						}
						
						btn_prox.addMouseListener(new MouseAdapter() {
							
							@Override
							public void mouseEntered(MouseEvent arg0) {
								setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
							}
							@Override
							public void mouseExited(MouseEvent e) {
								setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
							}
							
							@Override
							public void mouseClicked(MouseEvent arg0) {	
								
								click_count3++;
								
								click_count++;
								click_count2++;
								
								if (click_count >= 1 && click_count < tamanho) {
									btn_ant.setVisible(true);
								}
								
								if (click_count == 0) {
									btn_ant.setVisible(false);
								}
								
								if (click_count2 <= tamanho) {
									btn_prox.setVisible(true);
								}
								
								if (click_count2 == tamanho) {
									btn_prox.setVisible(false);
								}
								
								if (click_count < tamanho) {
									String nome_escola = ed.getNome(vd.getListaM(senha).get(0).getEscola());
									int codigo = vd.getListaM(senha).get(click_count3).getCod_visita();
									int traj = vd.getListaM(senha).get(click_count3).getCod_trajeto();
									String mon = md.getNome(vd.getListaM(senha).get(click_count3).getMonitor());
									String prof = pd.getNome(vd.getListaM(senha).get(click_count3).getProfessor());
									String dat = vd.getListaM(senha).get(click_count3).getData_visita();
									String hr = vd.getListaM(senha).get(click_count3).getHorario_visita();
									int aln = vd.getListaM(senha).get(click_count3).getNro_alunos();
									
									escola.setText(nome_escola);
									cod.setText(Integer.toString(codigo));
									trajeto.setText(Integer.toString(traj));
									alunos.setText(Integer.toString(aln));
									monitor.setText(mon);
									professor.setText(prof);
									data.setText(dat);
									hora.setText(hr);
																	
								}
								
								
							}
						
						});
						
						
						btn_ant.addMouseListener(new MouseAdapter() {
							
							@Override
							public void mouseEntered(MouseEvent arg0) {
								setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
							}
							@Override
							public void mouseExited(MouseEvent e) {
								setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
							}
							
							@Override
							public void mouseClicked(MouseEvent arg0) {
								
								click_count3--;
								click_count2--;	
								
								if (click_count2 <= tamanho) {
									btn_prox.setVisible(true);
								}
								
								if (click_count2 == tamanho) {
									btn_prox.setVisible(false);
								}
								
								if (click_count > 1 && click_count < tamanho) {
									btn_ant.setVisible(true);
								}
								
								if (click_count == 1) {
									btn_ant.setVisible(false);
								}
											
								
								if (click_count < tamanho) {
									
									String nome_escola = ed.getNome(vd.getListaM(senha).get(0).getEscola());
									int codigo = vd.getListaM(senha).get(click_count3).getCod_visita();
									int traj = vd.getListaM(senha).get(click_count3).getCod_trajeto();
									String mon = md.getNome(vd.getListaM(senha).get(click_count3).getMonitor());
									String prof = pd.getNome(vd.getListaM(senha).get(click_count3).getProfessor());
									String dat = vd.getListaM(senha).get(click_count3).getData_visita();
									String hr = vd.getListaM(senha).get(click_count3).getHorario_visita();
									int aln = vd.getListaM(senha).get(click_count3).getNro_alunos();
									
									escola.setText(nome_escola);
									cod.setText(Integer.toString(codigo));
									trajeto.setText(Integer.toString(traj));
									alunos.setText(Integer.toString(aln));
									monitor.setText(mon);
									professor.setText(prof);
									data.setText(dat);
									hora.setText(hr);
																	
								}
								
								click_count--;
							}
						
						});
						
						JLabel Fundo2 = new JLabel("");
						Fundo2.setIcon(new ImageIcon(Visitas_m.class.getResource("/Imagens/Principal/visitas.jpg")));
						Fundo2.setBounds(10, 18, 1000, 598);
						Container_principal.add(Fundo2);
					}					
					
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
				
	}
}
