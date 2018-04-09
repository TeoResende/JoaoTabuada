package Janelas;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class Menu {

	private JFrame frame;
	private JTextField tfNomeJogador;
	private JLabel play;
	private JButton btnJogar;
	private JRadioButton rbFacil;
	private JRadioButton rbMedio;
	private JRadioButton rbDificil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 399);
		frame.setLocationRelativeTo(null); //faz a janela ser renderizada no centro da tela
		frame.setResizable(false); //desabilita a opção de redimencionar a tela
	    frame.setUndecorated(true); //remove a borda
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		JLabel lblJogador = new JLabel("Nome do Jogador");
		lblJogador.setOpaque(true);
		lblJogador.setBackground(Color.LIGHT_GRAY);
		lblJogador.setForeground(Color.WHITE);
		lblJogador.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogador.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblJogador.setBounds(10, 38, 296, 51);
		frame.getContentPane().add(lblJogador);
		
		tfNomeJogador = new JTextField();
		tfNomeJogador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					jogar();
				}
			}
		});
		tfNomeJogador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(tfNomeJogador.getText().length()<1) {
					tfNomeJogador.setBackground(Color.ORANGE);
				}else{
					tfNomeJogador.setBackground(null);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tfNomeJogador.getText().length()<1) {
					tfNomeJogador.setBackground(Color.RED);
				}else{
					tfNomeJogador.setBackground(null);
				}
			}
		});
		tfNomeJogador.setHorizontalAlignment(SwingConstants.CENTER);
		tfNomeJogador.setFont(new Font("Tahoma", Font.PLAIN, 32));
		tfNomeJogador.setBounds(316, 38, 323, 51);
		frame.getContentPane().add(tfNomeJogador);
		tfNomeJogador.setColumns(10);

		rbFacil = new JRadioButton("F\u00E1cil");
		rbFacil.setSelected(true);
		rbFacil.setBackground(Color.LIGHT_GRAY);
		rbFacil.setFont(new Font("Tahoma", Font.PLAIN, 32));
		rbFacil.setBounds(293, 201, 118, 51);
		frame.getContentPane().add(rbFacil);
		
		rbMedio = new JRadioButton("M\u00E9dio");
		rbMedio.setFont(new Font("Tahoma", Font.PLAIN, 32));
		rbMedio.setBackground(Color.LIGHT_GRAY);
		rbMedio.setBounds(413, 201, 118, 51);
		frame.getContentPane().add(rbMedio);
		
		rbDificil = new JRadioButton("Dif\u00EDcil");
		rbDificil.setEnabled(false);
		rbDificil.setSelected(true);
		rbDificil.setFont(new Font("Tahoma", Font.PLAIN, 32));
		rbDificil.setBackground(Color.LIGHT_GRAY);
		rbDificil.setBounds(533, 201, 118, 51);
		frame.getContentPane().add(rbDificil);
	
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbFacil);
		grupo.add(rbMedio);
		grupo.add(rbDificil);
		
		play = new JLabel("");
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jogar();
			}
		});
		ImageIcon icone2 = new ImageIcon(Splash.class.getResource("/play.png"));
		icone2.setImage(icone2.getImage().getScaledInstance(150, 100, 100));
		play.setIcon(icone2);
		play.setBounds(381, 290, 150, 100);
		frame.getContentPane().add(play);
		ImageIcon icone = new ImageIcon(Splash.class.getResource("/Matematica.jpg"));
		icone.setImage(icone.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), 100));
		
		JLabel imagem = new JLabel();
		imagem.setIcon(new ImageIcon(Menu.class.getResource("/Matematica.jpg")));
		imagem.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(imagem);
	}
	
	public void jogar() {
		if(tfNomeJogador.getText().length()<1) {
			return;
		}
		if(rbFacil.isSelected()) {
			Tabuada.nivel = 0;
		}
		if(rbMedio.isSelected()) {
			Tabuada.nivel = 1;
		}
		if(rbDificil.isSelected()) {
			Tabuada.nivel = 2;
		}
		Tabuada.nome = tfNomeJogador.getText().toString();
		frame.dispose();
		Tabuada.main(new String[] {"."});
	}
}
