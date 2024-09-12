package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ExibirChamadoController;
import controller.NaoEditavel;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InternalFrameMeusChamados extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	public NaoEditavel tableModel;
    private ExibirChamadoController controller;
    private JButton btnNewButton;
    
    public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public NaoEditavel getTableModel() {
        return  tableModel;
    }
	
    
	public InternalFrameMeusChamados() {
		setMaximizable(true);
		setTitle("Meus Chamados");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 755, 580);
			
		String[] colunas = {"Id","Usuario", "Tipo de Solicitação", "Area Solicitada", "Descrição", "Status", "Data de Criação", "Atendente"};
		tableModel = new NaoEditavel(colunas, 0);
        table = new JTable(tableModel);
        table.setShowVerticalLines(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        btnNewButton = new JButton("Excluir");
        btnNewButton.addActionListener(this);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(640, Short.MAX_VALUE)
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        			.addGap(10))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        			.addGap(11)
        			.addComponent(btnNewButton)
        			.addGap(11))
        );
        getContentPane().setLayout(groupLayout);
        
        controller = new ExibirChamadoController(this);
        
        // Carrega os chamados do usuário logado
        controller.carregarChamados();
        controller.iniciarAtualizacaoAutomatica();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButtonJButton(e);
		}
	}
	protected void actionPerformedBtnNewButtonJButton(ActionEvent e) {
		controller.excluirChamadosSelecionados();
	}
}
