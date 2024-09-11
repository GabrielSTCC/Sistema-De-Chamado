package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;

import controller.PrincipalController;

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;

public class Principal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private InternalFrameCriarChamado criarChamado = new InternalFrameCriarChamado();
	private InternalFrameMeusChamados meusChamados = new InternalFrameMeusChamados();
	private InternalFrameChamadosDaArea chamadosDaArea = new InternalFrameChamadosDaArea();
	private InternalFrameChamadosPegos chamadosPegos = new InternalFrameChamadosPegos();
	private InternalFrameChamadosEncerrados chamadosEncerrados = new InternalFrameChamadosEncerrados();
	private JMenuItem mntmAbrirChamado;
	private JMenuItem mntmVerChamado;
	private JMenuItem mntmVerChamados;
    private JMenuItem mntmChamadosPegos;
    private JMenuItem mntmChamadoEncerrado;
    private JMenu mnAdministrarChamado;
    private PrincipalController controller;

	public JMenu getMnAdministrarChamado() {
		return mnAdministrarChamado;
	}

	public void setMnAdministrarChamado(boolean isVible) {
		if(mnAdministrarChamado != null) {
		 mnAdministrarChamado.setVisible(isVible);
		}
	}

	public Principal() {
		
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Sistema de Gestão de Chamado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		
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
		
		mnAdministrarChamado = new JMenu("Administrar Chamados ");
		mnAdministrarChamado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/apresentacao.png")));
		menuBar.add(mnAdministrarChamado);
		
		mntmVerChamados = new JMenuItem("Ver Chamados");
		mntmVerChamados.addActionListener(this);
		mntmVerChamados.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/noticia.png")));
		mnAdministrarChamado.add(mntmVerChamados);
		
		mntmChamadosPegos = new JMenuItem("Chamados Pegos");
		mntmChamadosPegos.addActionListener(this);
		mntmChamadosPegos.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/marketing-de-conteudo.png")));
		mnAdministrarChamado.add(mntmChamadosPegos);
		
		mntmChamadoEncerrado = new JMenuItem("Chamados Encerrados");
		mntmChamadoEncerrado.addActionListener(this);
		mntmChamadoEncerrado.setIcon(new ImageIcon(Principal.class.getResource("/interfaceImg/auditar.png")));
		mnAdministrarChamado.add(mntmChamadoEncerrado);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		try {
			criarChamado.setMaximum(true);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		criarChamado.setMaximizable(false);

		criarChamado.setBounds(0, 0, 766, 413);
		desktopPane.add(criarChamado);
		try {
			meusChamados.setMaximum(true);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		meusChamados.setMaximizable(false);
		desktopPane.add(meusChamados);
		
		try {
			chamadosDaArea.setMaximum(true);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		chamadosDaArea.setMaximizable(false);
		desktopPane.add(chamadosDaArea);
		
		try {
			chamadosPegos.setMaximum(true);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		chamadosPegos.setMaximizable(false);
		desktopPane.add(chamadosPegos);
		
		try {
			chamadosEncerrados.setMaximum(true);
		} catch (PropertyVetoException e) {
			
			e.printStackTrace();
		}
		chamadosEncerrados.setMaximizable(false);
		desktopPane.add(chamadosEncerrados);
		
		panel.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		controller = new PrincipalController(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmChamadoEncerrado) {
			actionPerformedMntmChamadoEncerradoJMenuItem(e);
		}
		if (e.getSource() == mntmChamadosPegos) {
			actionPerformedMntmChamadosPegosJMenuItem(e);
		}
		if (e.getSource() == mntmVerChamados) {
			actionPerformedMntmVerChamadosJMenuItem(e);
		}
		if (e.getSource() == mntmVerChamado) {
			actionPerformedMntmVerChamadoJMenuItem(e);
		}
		if(e.getSource() == mntmAbrirChamado) {
			actionPerformedMntmAbrirChamadoJMenuItem(e);
		}
	}
	
	protected void actionPerformedMntmAbrirChamadoJMenuItem(ActionEvent e) {
		criarChamado.setVisible(true);
	}
	
	protected void actionPerformedMntmVerChamadoJMenuItem(ActionEvent e) {
		meusChamados.setVisible(true);
	}
	
	protected void actionPerformedMntmVerChamadosJMenuItem(ActionEvent e) {
		chamadosDaArea.setVisible(true);
	}
	protected void actionPerformedMntmChamadosPegosJMenuItem(ActionEvent e) {
		chamadosPegos.setVisible(true);
	}
	protected void actionPerformedMntmChamadoEncerradoJMenuItem(ActionEvent e) {
		chamadosEncerrados.setVisible(true);
	}
}
