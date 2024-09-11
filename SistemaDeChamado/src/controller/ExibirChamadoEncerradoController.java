package controller;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.ChamadoDAO;
import dao.Conexao;
import model.Chamado;
import model.UsuarioADM;
import view.InternalFrameChamadosEncerrados;
import view.InternalFrameChamadosPegos;
import view.InternalFrameMeusChamados;

public class ExibirChamadoEncerradoController {
	InternalFrameChamadosEncerrados viewChamadosEncerrados;
	private ChamadoDAO chamadoDAO;
	private NaoEditavel tableModel;
	

	public ExibirChamadoEncerradoController(InternalFrameChamadosEncerrados viewChamadosEncerrados) {
		this.viewChamadosEncerrados = viewChamadosEncerrados;
		try {
			this.chamadoDAO = new ChamadoDAO(new Conexao().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
		 this.tableModel = viewChamadosEncerrados.getTableModel(); // Obtém o modelo da tabela
	}
	public void carregarChamadosEncerrados() {
	    try {
	        UsuarioADM usuarioADM = (UsuarioADM) UserSessaoController.getUsuarioLogado();
	        String area = usuarioADM.getArea().getNome();
	        String status = "Fechado";
	        
	        List<Chamado> chamados = chamadoDAO.buscarMeuChamadoPorArea(area, status);
	        
	        // Adiciona os chamados na tabela
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        for (Chamado chamado : chamados) {
	            Object[] row = {
	                chamado.getId(),
	                chamado.getUsuario(),
	                chamado.getTipoSolicitacao().getTitulo(),
	                chamado.getArea().getNome(),
	                chamado.getDescricao(),
	                chamado.getStatus().getDescricao(), 
	                chamado.getDataCriacao().format(formatter)
	            };
	            viewChamadosEncerrados.tableModel.addRow(row);
	        }
	        
	        System.out.println("Tabela carregada com sucesso.");
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao carregar os chamados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        //JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void atualizarTabela() {
		// Limpar a tabela existente
	    DefaultTableModel tableModel = (DefaultTableModel) viewChamadosEncerrados.getTable().getModel();
	    tableModel.setRowCount(0); // Remove todas as linhas existentes
	    UsuarioADM usuarioADM = (UsuarioADM) UserSessaoController.getUsuarioLogado();
        String area = usuarioADM.getArea().getNome();
        String status = "Fechado";
	    // Recarregar os dados do banco de dados
	    try {
	    	List<Chamado> chamados = chamadoDAO.buscarMeuChamadoPorArea(area, status);
	        for (Chamado chamado : chamados) {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            Object[] row = {
	            		chamado.getId(),
		                chamado.getUsuario(),
		                chamado.getTipoSolicitacao().getTitulo(),
		                chamado.getArea().getNome(),
		                chamado.getDescricao(),
		                chamado.getStatus().getDescricao(), 
		                chamado.getDataCriacao().format(formatter)
	            };
	            tableModel.addRow(row);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void iniciarAtualizacaoAutomatica() {
	    Timer timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        @Override
	        public void run() {
	            atualizarTabela();
	        }
	    }, 0, 25000); // Atualiza a cada 25 segundos
	}
}
