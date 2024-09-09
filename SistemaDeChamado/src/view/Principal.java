package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Frame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		
		setTitle("Sistema de Gestão de Chamado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 778, 37);
		contentPane.add(menuBar);
		
		JMenu mnChamado = new JMenu("Chamado");
		mnChamado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/formato.png")));
		menuBar.add(mnChamado);
		
		JMenuItem mntmAbrirChamado = new JMenuItem("Abrir Chamado");
		mntmAbrirChamado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/telefone.png")));
		mnChamado.add(mntmAbrirChamado);
		
		JMenuItem mntmVerChamado = new JMenuItem("Ver Chamado");
		mntmVerChamado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/noticia.png")));
		mnChamado.add(mntmVerChamado);
		
		JMenu mnAdministrarChamado = new JMenu("Administrar Chamados ");
		mnAdministrarChamado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/apresentacao.png")));
		menuBar.add(mnAdministrarChamado);
		
		JMenuItem mntmVerChamados = new JMenuItem("Ver Chamados");
		mntmVerChamados.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/noticia.png")));
		mnAdministrarChamado.add(mntmVerChamados);
		
		JMenuItem mntmChamadosPegos = new JMenuItem("Chamados Pegos");
		mntmChamadosPegos.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/marketing-de-conteudo.png")));
		mnAdministrarChamado.add(mntmChamadosPegos);
		
		JMenuItem mntmChamadoEncerrado = new JMenuItem("Chamados Encerrados");
		mntmChamadoEncerrado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/auditar.png")));
		mnAdministrarChamado.add(mntmChamadoEncerrado);
	}
}
