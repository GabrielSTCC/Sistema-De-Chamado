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
import dao.UsuarioAdmDAO;
import model.AreaU;
import model.Chamado;
import model.StatusChamado;
import model.UsuarioADM;
import view.InternalFrameChamadosDaArea;

public class ExibirChamadosAreaController {
	InternalFrameChamadosDaArea viewChamadosDaArea;
	private ChamadoDAO chamadoDAO;
	private NaoEditavel tableModel;
	
	public ExibirChamadosAreaController(InternalFrameChamadosDaArea viewChamadosDaArea) {
		this.viewChamadosDaArea = viewChamadosDaArea;
		try {
			this.chamadoDAO = new ChamadoDAO(new Conexao().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
		 this.tableModel = viewChamadosDaArea.getTableModel(); // Obtém o modelo da tabela
	}
	
	public void carregarChamadosArea() {
	    try {
	        UsuarioADM usuarioADM = (UsuarioADM) UserSessaoController.getUsuarioLogado();
	        String area = usuarioADM.getArea().toString();
	        
	        List<Chamado> chamados = chamadoDAO.buscarMeuChamadoPorArea(area);
	        
	        // Limpa a tabela existente
	        viewChamadosDaArea.tableModel.setRowCount(0);
	        
	        // Adiciona os chamados na tabela
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        for (Chamado chamado : chamados) {
	            Object[] row = {
	                chamado.getId(),
	                chamado.getUsuario(),
	                chamado.getTipoSolicitacao(),
	                chamado.getArea().toString(),
	                chamado.getDescricao(),
	                chamado.getStatus().toString(), // Certifique-se de que isso está correto
	                chamado.getDataCriacao().format(formatter)
	            };
	            viewChamadosDaArea.tableModel.addRow(row);
	        }
	        
	        System.out.println("Tabela carregada com sucesso.");
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao carregar os chamados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public void pegarChamado() {
		JTable table = viewChamadosDaArea.getTable();
	    int[] selectedRows = table.getSelectedRows(); // Obtém as linhas selecionadas

	    if (selectedRows.length > 0) {
	        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente pegar os chamados selecionados?", "Pegar Chamados", JOptionPane.YES_NO_OPTION);

	        if (resposta == JOptionPane.YES_OPTION) {
	            // Itera sobre as linhas selecionadas
	            for (int i = selectedRows.length - 1; i >= 0; i--) {
	                int row = selectedRows[i];
	                int id =  (int) table.getValueAt(row, 0); // Ajuste o índice da coluna conforme necessário

	                try {
	                    // Chama o método no DAO para excluir o chamado do banco de dados
	                    chamadoDAO.pegarChamadoPorId(id); // Ajuste conforme necessário

	                    // Remove a linha da tabela após a exclusão
	                    //((DefaultTableModel) table.getModel()).removeRow(row);
	                } catch (SQLException e) {
	                    JOptionPane.showMessageDialog(null, "Erro ao pegar o chamado: " + e.getMessage());
	                }
	            }

	            JOptionPane.showMessageDialog(null, "Chamados pego com sucesso!");
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Selecione um ou mais chamados para pegar.");
	    }
	}
	
	public void atualizarTabela() {
		// Limpar a tabela existente
	    DefaultTableModel tableModel = (DefaultTableModel) viewChamadosDaArea.getTable().getModel();
	    tableModel.setRowCount(0); // Remove todas as linhas existentes

	    // Recarregar os dados do banco de dados
	    try {
	        List<Chamado> chamados = chamadoDAO.buscarMeuChamado(UserSessaoController.getUsuarioLogado().getUsername());
	        for (Chamado chamado : chamados) {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	            Object[] row = {
	                chamado.getId(),
	                chamado.getUsuario(),
	                chamado.getTipoSolicitacao(),
	                chamado.getArea(),
	                chamado.getDescricao(),
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
