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

public class Acesso extends JFrame {

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
					Acesso frame = new Acesso();
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
	public Acesso() {
		
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
		Btn_minimize.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
		Btn_minimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Btn_minimize.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/minimize_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_minimize.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/minimize.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Btn_fechar = new JLabel("");
		Btn_fechar.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/close.png")));
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
				Btn_fechar.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/close_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Btn_fechar.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/close.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Favicon = new JLabel("");
		Favicon.setBounds(13, 1, 18, 24);
		contentPane.add(Favicon);
		Favicon.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Logo/fav.png")));
		Favicon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Favicon.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Logo/fav_hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Favicon.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Logo/fav.png")));
			}
			
		});
		
		JLabel Lbl_mousemove = new JLabel("");
		Lbl_mousemove.setBounds(-10, 0, 990, 28);
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
		        
		        Acesso.this.setLocation(x - xx, y - xy);
			}
		});
		
		JPanel Container_principal = new JPanel();
		Container_principal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Container_principal.setBackground(Color.DARK_GRAY);
		Container_principal.setBounds(-10, -22, 990, 662);
		contentPane.add(Container_principal);
		Container_principal.setLayout(null);
		
		JLabel Blume = new JLabel("");
		Blume.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Logo/logo50.png")));
		Blume.setBounds(540, 545, 64, 64);
		Container_principal.add(Blume);
		Blume.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Blume.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Logo/logopb64.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Blume.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Logo/logo50.png")));
			}
		});
		
		JLabel Lnk_escola = new JLabel("");
		Lnk_escola.setBounds(46, 277, 227, 271);
		Container_principal.add(Lnk_escola);
		
		JLabel Escola = new JLabel("");
		Escola.setHorizontalAlignment(SwingConstants.LEFT);
		Escola.setBounds(10, 263, 300, 300);
		Container_principal.add(Escola);
		Escola.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/esc.png")));
		Lnk_escola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login_Escola l_esc = new Login_Escola();
				l_esc.setUndecorated(true);
				l_esc.setVisible(true);
				l_esc.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
				dispose();
				l_esc.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Escola.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/esc_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Escola.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/esc.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
			
		JLabel Professor = new JLabel("");
		Professor.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/pro.png")));
		Professor.setBounds(324, 237, 350, 350);
		Container_principal.add(Professor);
		JLabel Lnk_professor = new JLabel("");
		Lnk_professor.setBounds(359, 277, 227, 271);
		Container_principal.add(Lnk_professor);
		Lnk_professor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login_Professor l_pro = new Login_Professor();
				l_pro.setUndecorated(true);
				l_pro.setVisible(true);
				l_pro.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
				dispose();
				l_pro.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Professor.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/pro_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Professor.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/pro.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});

		JLabel Monitor = new JLabel("");
		Monitor.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/mon.png")));
		Monitor.setBounds(642, 261, 300, 300);
		Container_principal.add(Monitor);
		JLabel Lnk_Monitor = new JLabel("");
		Lnk_Monitor.setBounds(652, 276, 227, 271);
		Container_principal.add(Lnk_Monitor);
		Lnk_Monitor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Login_Monitor l_mon = new Login_Monitor();
				l_mon.setUndecorated(true);
				l_mon.setVisible(true);
				l_mon.setShape(new RoundRectangle2D.Double(0, 0, 379, 591, 15, 15));
				dispose();
				l_mon.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Monitor.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/mon_hover.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Monitor.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Bot\u00F5es/mon.png")));
				
				setCursor( Cursor.getPredefinedCursor( Cursor.DEFAULT_CURSOR));
			}
		});
		
		JLabel Fundo = new JLabel("");
		Fundo.setIcon(new ImageIcon(Acesso.class.getResource("/Imagens/Cenas/BoasVindas.jpg")));
		Fundo.setBounds(10, 18, 1000, 598);
		Container_principal.add(Fundo);
		
	}
}
