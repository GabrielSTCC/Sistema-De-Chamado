package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.ChamadoDAO;
import dao.Conexao;
import model.Chamado;
import model.StatusChamado;
import view.InternalFrameMeusChamados;

public class ExibirChamadoController {
	private InternalFrameMeusChamados viewMeusChamados;
	private ChamadoDAO chamadoDAO;
	private NaoEditavel tableModel;
	
	public ExibirChamadoController(InternalFrameMeusChamados viewMeusChamados) {
		this.viewMeusChamados = viewMeusChamados;
		try {
			this.chamadoDAO = new ChamadoDAO(new Conexao().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
		 this.tableModel = viewMeusChamados.getTableModel(); // Obtém o modelo da tabela
	}
	
	public void carregarChamados() {
        try{
        	// Obtém o usuário logado
	        String username = UserSessaoController.getUsuarioLogado().getUsername();
	
	        // Busca os chamados do usuário logado
	        List<Chamado> chamados = chamadoDAO.buscarMeuChamado(username);
	
	        // Adiciona os chamados na tabela
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
	            viewMeusChamados.tableModel.addRow(row);
	        }
        }catch (Exception e) {
			// TODO: handle exception
		}
    }
	
	public void excluirChamadosSelecionados() {
	    JTable table = viewMeusChamados.getTable();
	    int[] selectedRows = table.getSelectedRows(); // Obtém as linhas selecionadas

	    if (selectedRows.length > 0) {
	        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir os chamados selecionados?", "Excluir Chamados", JOptionPane.YES_NO_OPTION);

	        if (resposta == JOptionPane.YES_OPTION) {
	            // Itera sobre as linhas selecionadas
	            for (int i = selectedRows.length - 1; i >= 0; i--) {
	                int row = selectedRows[i];
	                int id =  (int) table.getValueAt(row, 0); // Ajuste o índice da coluna conforme necessário

	                try {
	                	StatusChamado statusChamado = chamadoDAO.buscarStatusChamadoPorId(id);

	                    // Verifica se o chamado está com status "Aberto"
	                    if (statusChamado == StatusChamado.ABERTO) {
	                    	 // Se o chamado estiver aberto, permite a exclusão
	                    	int confirm = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir este chamado?", "Confirmação", JOptionPane.YES_NO_OPTION);
	                    	if (confirm == JOptionPane.YES_OPTION) {
	                    		chamadoDAO.excluirChamadoPorId(id); // Chama o método que exclui o chamado do banco de dados
		                        JOptionPane.showMessageDialog(null, "Chamado excluído com sucesso!");
		                        ((DefaultTableModel) table.getModel()).removeRow(row);
	                    	}
	                    } else {
	                        // Caso contrário, informa que apenas chamados abertos podem ser excluídos
	                        JOptionPane.showMessageDialog(null, "Apenas chamados com status 'Aberto' podem ser excluídos.", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }
	                    
	                } catch (SQLException e) {
	                    JOptionPane.showMessageDialog(null, "Erro ao excluir o chamado: " + e.getMessage());
	                }
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Selecione um chamado para excluir.");
	    }
	}
	
	public void atualizarTabela() {
	    // Limpar a tabela existente
	    DefaultTableModel tableModel = (DefaultTableModel) viewMeusChamados.getTable().getModel();
	    tableModel.setRowCount(0); // Remove todas as linhas existentes

	    // Recarregar os dados do banco de dados
	    try {
	        List<Chamado> chamados = chamadoDAO.buscarMeuChamado(UserSessaoController.getUsuarioLogado().getUsername());
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
