package view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;

import controller.ExibirChamadoEncerradoController;
import controller.ExibirChamadosAreaController;
import controller.NaoEditavel;

public class InternalFrameChamadosEncerrados extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JTable table;
	public NaoEditavel tableModel;
    private ExibirChamadoEncerradoController controller;
	
    public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public NaoEditavel getTableModel() {
        return  tableModel;
    }
    
	public InternalFrameChamadosEncerrados() {
		setMaximizable(true);
		setTitle("Chamados Encerrados");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 755, 580);
			
		String[] colunas = {"Id","Usuario", "Tipo de Solicitação", "Area Solicitada", "Descrição", "Status", "Data de Criação", "Atendente"};
		tableModel = new NaoEditavel(colunas, 0);
        table = new JTable(tableModel);
        table.setShowVerticalLines(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(640, Short.MAX_VALUE)));
        
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
        			.addGap(11)));
        getContentPane().setLayout(groupLayout);
        
        controller = new ExibirChamadoEncerradoController(this);
        
        // Carrega os chamados do usuário logado
        controller.carregarChamadosEncerrados();
        controller.iniciarAtualizacaoAutomatica();
	}

}
