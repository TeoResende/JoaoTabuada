package Janelas;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new Splash();
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
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,500, 300);
		frame.setLocationRelativeTo(null); //faz a janela ser renderizada no centro da tela
		frame.setResizable(false); //desabilita a opção de redimencionar a tela
	    frame.setUndecorated(true); //remove a borda
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel imagem = new JLabel();
		ImageIcon icone = new ImageIcon(Splash.class.getResource("/Splash.jpg"));
		icone.setImage(icone.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), 100));
		imagem.setIcon(icone);
		imagem.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(imagem);
		
		new Thread(proximaJanela).start();	//inicia a tarefa paralela
	}

	Runnable proximaJanela = new Runnable() {	
		@Override
		public void run() {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.dispose();
			Menu.main(null);
		}
	};

}
