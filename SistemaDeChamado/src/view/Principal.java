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
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private InternalFrameCriarChamado criarChamado = new InternalFrameCriarChamado();
	private InternalFrameMeusChamados meusChamados = new InternalFrameMeusChamados();
	private JMenuItem mntmAbrirChamado;
	private JMenuItem mntmVerChamado;

	public Principal() {
		criarChamado.setMaximum(true);
		criarChamado.setMaximizable(false);
		criarChamado.setBorder(null);
		meusChamados.setMaximum(true);
		meusChamados.setResizable(true);
		
		meusChamados.setMaximizable(false);
		meusChamados.setBorder(null);
		meusChamados.setTitle("Meus Chamados");
		meusChamados.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
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
		
		mntmAbrirChamado = new JMenuItem("Abrir Chamado");
		mntmAbrirChamado.addActionListener(this);
		mntmAbrirChamado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/telefone.png")));
		mnChamado.add(mntmAbrirChamado);
		
		mntmVerChamado = new JMenuItem("Ver Chamado");
		mntmVerChamado.addActionListener(this);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 39, 778, 413);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.add(criarChamado);
		desktopPane.add(meusChamados);
		desktopPane.setBackground(Color.LIGHT_GRAY);
		panel.add(desktopPane, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVerChamado) {
			actionPerformedMntmVerChamadoJMenuItem(e);
		}
		if (e.getSource() == mntmAbrirChamado) {
			actionPerformedMntmAbrirChamadoJMenuItem(e);
		}
	}
	// Exibe o InternalFrame "Criar Chamado"
    protected void actionPerformedMntmAbrirChamadoJMenuItem(ActionEvent e) {
            criarChamado.setVisible(true);
    }

    // Exibe o InternalFrame "Meus Chamados"
    protected void actionPerformedMntmVerChamadoJMenuItem(ActionEvent e) {
            meusChamados.setVisible(true);
    }
}
