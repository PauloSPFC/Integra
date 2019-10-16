package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
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
import javax.swing.DropMode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

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
		setBounds(350, 150, 925, 591);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(241, 57, 83));
		lbl_close.setFont(new Font("Montserrat ExtraBold", lbl_close.getFont().getStyle(), 14));
		lbl_close.setBounds(890, 6, 46, 14);
		contentPane.add(lbl_close);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(-10, -22, 990, 662);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JPanel Escola = new JPanel();
		Escola.setBounds(39, 246, 230, 260);
		Escola.setBackground(new Color(245, 245, 245));
		panel_1.add(Escola);
		Escola.setLayout(null);
		
		JTextPane txtpnEscola = new JTextPane();
		txtpnEscola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Escola.setBackground(new Color(217, 217, 217));
				txtpnEscola.setBackground(new Color(63, 193, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Escola.setBackground(new Color(245, 245, 245));
				txtpnEscola.setBackground(new Color(252, 81, 133));
			}
		});
		txtpnEscola.setForeground(Color.WHITE);
		txtpnEscola.setEditable(false);
		txtpnEscola.setFont(new Font("Montserrat SemiBold", txtpnEscola.getFont().getStyle(), 34));
		txtpnEscola.setText("     ESCOLA\r\n");
		txtpnEscola.setBounds(0, 208, 230, 52);
		txtpnEscola.setBackground(new Color(252, 81, 133));
		Escola.add(txtpnEscola);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/school.png")));
		lblNewLabel.setBounds(50, 39, 128, 120);
		Escola.add(lblNewLabel);
		Escola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Escola.setBackground(new Color(217, 217, 217));
				txtpnEscola.setBackground(new Color(63, 193, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Escola.setBackground(new Color(245, 245, 245));
				txtpnEscola.setBackground(new Color(252, 81, 133));
			}
		});
		
		JPanel Professor = new JPanel();
		Professor.setBounds(359, 246, 230, 260);
		panel_1.add(Professor);
		Professor.setLayout(null);
		
		JTextPane txtpnProfessor = new JTextPane();
		txtpnProfessor.setFont(new Font("Montserrat SemiBold", txtpnProfessor.getFont().getStyle(), 33));
		txtpnProfessor.setText(" PROFESSOR\r\n\r\n");
		txtpnProfessor.setForeground(Color.WHITE);
		txtpnProfessor.setEditable(false);
		txtpnProfessor.setBackground(new Color(252, 81, 133));
		txtpnProfessor.setBounds(0, 208, 230, 52);
		Professor.add(txtpnProfessor);
		
		Professor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Professor.setBackground(new Color(217, 217, 217));
				txtpnProfessor.setBackground(new Color(63, 193, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Professor.setBackground(new Color(245, 245, 245));
				txtpnProfessor.setBackground(new Color(252, 81, 133));
			}
		});
		
		txtpnProfessor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Professor.setBackground(new Color(217, 217, 217));
				txtpnProfessor.setBackground(new Color(63, 193, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Professor.setBackground(new Color(245, 245, 245));
				txtpnProfessor.setBackground(new Color(252, 81, 133));
			}
		});
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/education.png")));
		label.setBounds(53, 22, 134, 151);
		Professor.add(label);
		
		JPanel Monitor = new JPanel();
		Monitor.setBounds(676, 246, 230, 260);
		panel_1.add(Monitor);
		Monitor.setLayout(null);
		
		JTextPane txtpnMonitor = new JTextPane();
		txtpnMonitor.setFont(new Font("Montserrat SemiBold", txtpnMonitor.getFont().getStyle(), 34));
		txtpnMonitor.setText("   MONITOR\r\n");
		txtpnMonitor.setForeground(Color.WHITE);
		txtpnMonitor.setEditable(false);
		txtpnMonitor.setBackground(new Color(252, 81, 133));
		txtpnMonitor.setBounds(0, 208, 230, 52);
		Monitor.add(txtpnMonitor);
		
		Monitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Monitor.setBackground(new Color(217, 217, 217));
				txtpnMonitor.setBackground(new Color(63, 193, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Monitor.setBackground(new Color(245, 245, 245));
				txtpnMonitor.setBackground(new Color(252, 81, 133));
			}
		});
		
		txtpnMonitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Monitor.setBackground(new Color(217, 217, 217));
				txtpnMonitor.setBackground(new Color(63, 193, 201));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Monitor.setBackground(new Color(245, 245, 245));
				txtpnMonitor.setBackground(new Color(252, 81, 133));
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(BoasVindas.class.getResource("/Imagens/lifejacket.png")));
		label_1.setBounds(50, 25, 128, 137);
		Monitor.add(label_1);
		
		JPanel Titulo = new JPanel();
		Titulo.setBounds(0, 11, 980, 89);
		Titulo.setBackground(new Color(63, 193, 201));
		panel_1.add(Titulo);
		Titulo.setLayout(null);
		
		JTextPane txtpnBemvindoAoEscola = new JTextPane();
		txtpnBemvindoAoEscola.setEditable(false);
		txtpnBemvindoAoEscola.setFont(new Font("Lato Heavy", txtpnBemvindoAoEscola.getFont().getStyle(), 37));
		txtpnBemvindoAoEscola.setForeground(Color.WHITE);
		txtpnBemvindoAoEscola.setBounds(10, 19, 745, 78);
		txtpnBemvindoAoEscola.setText("                               ESCOLA NO CERRADO");
		txtpnBemvindoAoEscola.setBackground(new Color(63, 193, 201));
		Titulo.add(txtpnBemvindoAoEscola);
		
		JTextPane txtpnVoc = new JTextPane();
		txtpnVoc.setForeground(Color.WHITE);
		txtpnVoc.setFont(new Font("Lato Semibold", txtpnVoc.getFont().getStyle(), 44));
		txtpnVoc.setText("Voc\u00EA \u00E9...");
		txtpnVoc.setEditable(false);
		txtpnVoc.setBackground(Color.DARK_GRAY);
		txtpnVoc.setBounds(380, 151, 635, 60);
		panel_1.add(txtpnVoc);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Montserrat Medium", lblNewLabel_1.getFont().getStyle(), 16));
		lblNewLabel_1.setBounds(0, 11, 980, 640);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		
		lblNewLabel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        
		        BoasVindas.this.setLocation(x - xx, y - xy);
			}
		});
	}
}
