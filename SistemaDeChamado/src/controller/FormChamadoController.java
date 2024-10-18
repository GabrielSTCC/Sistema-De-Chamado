package controller;

import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import dao.ChamadoDAO;
import dao.Conexao;
import dao.UsuarioDAO;
import model.AreaU;
import model.Cargo;
import model.Chamado;
import model.Titulo;
import model.Usuario;
import model.UsuarioADM;
import view.InternalFrameCriarChamado;
import view.Principal;

public class FormChamadoController {
	
    private InternalFrameCriarChamado viewCriarChamado;

	public FormChamadoController(InternalFrameCriarChamado viewCriarChamado) {
		this.viewCriarChamado = viewCriarChamado;
	}
	
	public void preencherChamado() {
		Usuario usuarioLogado = UserSessaoController.getUsuarioLogado();
		
		if(usuarioLogado != null) {
			viewCriarChamado.setTextFieldNome(usuarioLogado.getUsername());
			
			if(usuarioLogado instanceof UsuarioADM) {
				UsuarioADM usuarioADM = (UsuarioADM) usuarioLogado;
				viewCriarChamado.setTextFieldArea(usuarioADM.getArea() != null ? usuarioADM.getArea().toString() : "a");
				viewCriarChamado.setTextFieldCargo(usuarioADM.getCargo() != null ? usuarioADM.getCargo().toString() : "a");
			}else {
				viewCriarChamado.setTextFieldArea("");
				viewCriarChamado.setTextFieldCargo("");
			}
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = LocalDateTime.now().format(formatter);
	        viewCriarChamado.setTextFieldData(formattedDate);
			
		}
		
	}
	
	public void criarChamado() {
		Usuario usuarioLogado = UserSessaoController.getUsuarioLogado();
		
		 if (usuarioLogado == null) {
	            JOptionPane.showMessageDialog(null, "Nenhum usuário está logado!", "Erro", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
		
		String nomeSolicitante = usuarioLogado.getUsername();
		String areaSolicitante = (usuarioLogado instanceof UsuarioADM ? ((UsuarioADM) usuarioLogado).getArea().toString() : null);
		LocalDateTime data = java.time.LocalDateTime.now();
		String areaAtendimento = (String) viewCriarChamado.getComboBoxArea().getSelectedItem(); // Usar getSelectedItem()
        String tipoSolicitacao = (String) viewCriarChamado.getComboBoxTitulo().getSelectedItem(); // Usar getSelectedItem()
		String descricao = viewCriarChamado.getTextDescricao().getText();
		
		if(areaAtendimento == null || areaAtendimento.isEmpty() ||
			tipoSolicitacao == null || tipoSolicitacao.isEmpty() ||
			descricao == null || descricao.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
		}else {
		
			Titulo tipoSolicitacaoo = Titulo.fromString(tipoSolicitacao);
		    AreaU area = AreaU.fromString(areaAtendimento);
			
			Chamado chamado = new Chamado(nomeSolicitante, tipoSolicitacaoo, area, descricao, data);
			try {
				Connection conexao = new Conexao().getConnection();
				ChamadoDAO chamadoDAO = new ChamadoDAO(conexao);
				chamadoDAO.insert(chamado);
				
				JOptionPane.showMessageDialog(null, "Chamado Criado com sucesso!");
				
				viewCriarChamado.getTextDescricao().setText("");
				viewCriarChamado.getComboBoxTitulo().setSelectedIndex(0);
		        viewCriarChamado.getComboBoxArea().setSelectedIndex(0);
				viewCriarChamado.setVisible(false);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao Criar Chamado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
}
