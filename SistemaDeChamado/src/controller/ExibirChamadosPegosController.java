package controller;

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
import model.UsuarioADM;
import view.InternalFrameChamadosPegos;

public class ExibirChamadosPegosController {
	InternalFrameChamadosPegos viewChamadosPegos;
	private ChamadoDAO chamadoDAO;
	private NaoEditavel tableModel;
	
	public ExibirChamadosPegosController(InternalFrameChamadosPegos viewChamadosPegos) {
		 this.viewChamadosPegos = viewChamadosPegos;
		 try {
				this.chamadoDAO = new ChamadoDAO(new Conexao().getConnection());
			} catch (Exception e) {
				// TODO: handle exception
			}
			 this.tableModel = viewChamadosPegos.getTableModel(); // Obtém o modelo da tabela
	}
	public void carregarChamadosPegos() {
	    try {
	        UsuarioADM usuarioADM = (UsuarioADM) UserSessaoController.getUsuarioLogado();
	        String area = usuarioADM.getArea().getNome();
	        String status = "Em Andamento";
	        String username = usuarioADM.getUsername();
	        
	        List<Chamado> chamados = chamadoDAO.buscarMeuChamadoPorResponsavel(area, status, username);
	        
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
	                chamado.getDataCriacao().format(formatter),
	                chamado.getResponsavel()
	            };
	            viewChamadosPegos.tableModel.addRow(row);
	        }
	        
	        System.out.println("Tabela carregada com sucesso.");
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao carregar os chamados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        //JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void encerrarChamado() {
		JTable table = viewChamadosPegos.getTable();
	    int[] selectedRows = table.getSelectedRows(); // Obtém as linhas selecionadas

	    if (selectedRows.length > 0) {
	        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente Encerrar o chamado selecionado?", "Encerrar Chamado", JOptionPane.YES_NO_OPTION);

	        if (resposta == JOptionPane.YES_OPTION) {
	            // Itera sobre as linhas selecionadas
	            for (int i = selectedRows.length - 1; i >= 0; i--) {
	                int row = selectedRows[i];
	                int id =  (int) table.getValueAt(row, 0); // Ajuste o índice da coluna conforme necessário

	                try {
	                    // Chama o método no DAO para excluir o chamado do banco de dados
	                    chamadoDAO.encerrarChamado(id); // Ajuste conforme necessário

	                    // Remove a linha da tabela após a exclusão
	                    ((DefaultTableModel) table.getModel()).removeRow(row);
	                } catch (SQLException e) {
	                    JOptionPane.showMessageDialog(null, "Erro ao encerrar o chamado: " + e.getMessage());
	                }
	            }

	            JOptionPane.showMessageDialog(null, "Chamado encerrado com sucesso!");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Selecione um ou mais chamados para encerrar.");
	    }
	}
	
	public void atualizarTabela() {
		// Limpar a tabela existente
	    DefaultTableModel tableModel = (DefaultTableModel) viewChamadosPegos.getTable().getModel();
	    tableModel.setRowCount(0); // Remove todas as linhas existentes
	    UsuarioADM usuarioADM = (UsuarioADM) UserSessaoController.getUsuarioLogado();
        String area = usuarioADM.getArea().getNome();
        String status = "Em Andamento";
        String username = usuarioADM.getUsername();
	    // Recarregar os dados do banco de dados
	    try {
	    	List<Chamado> chamados = chamadoDAO.buscarMeuChamadoPorResponsavel(area, status, username);
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
