package controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import dao.Conexao;
import dao.UsuarioAdmDAO;
import dao.UsuarioDAO;
import model.AreaU;
import model.Cargo;
import model.Usuario;
import model.UsuarioADM;
import view.CadastroSistema;
import view.CadastroSistema_Client;
import view.LoginSistema;

public class FormCadastroControllerADM {
	
	private CadastroSistema view;
	
	
	public FormCadastroControllerADM(CadastroSistema view) {
		this.view = view;
	}
	
	
	 public void salvaUserADM() {
		 String nome = view.getNameUser().getText();
		 String sobrenome = view.getSurnameUser().getText();
		 String senha = view.getSenhaUser().getText();
		 String cargoStr = view.getCargosUser().getSelectedItem().toString();
		 String areaStr = view.getAreasUser().getSelectedItem().toString();
		 
		 if (nome == null || nome.isEmpty() ||
	         sobrenome == null || sobrenome.isEmpty() ||
	         senha == null || senha.isEmpty() ||
	         cargoStr == null || cargoStr.isEmpty() ||
	         areaStr == null || areaStr.isEmpty()) {
	         JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
	         }else {
	        	 // Conversão de String para Enum
			     Cargo cargo = Cargo.fromString(cargoStr);
			     AreaU area = AreaU.fromString(areaStr);
			            
			     UsuarioADM usuarioAdm = new UsuarioADM(nome, sobrenome, cargo, area, senha);
			     try {   
			    	 Connection conexao = new Conexao().getConnection();
			    	 UsuarioAdmDAO usuarioAdmDAO = new UsuarioAdmDAO(conexao);
			    	 usuarioAdmDAO.insert(usuarioAdm);
			            
			    	 JOptionPane.showMessageDialog(null, "Usuario " + usuarioAdm.getUsername() + " Cadastrado com sucesso!");
			    	 
			    	 trocaDeTela();
			            
			     } catch (SQLException e) {
			    	 JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			     }
	         }
	 }
	 
	 public void trocaDeTela() {
		 LoginSistema telaLoginSistema = new LoginSistema();
    	 telaLoginSistema.setVisible(true);
    	 view.dispose();
	 }
	 
	 public void retorno() {
		 int escolha = JOptionPane.showConfirmDialog(null, "Deseja cancelar o cadastro?",
				 "Retorno", JOptionPane.YES_NO_OPTION);
		 if(escolha == JOptionPane.YES_OPTION) {
			 LoginSistema telaLoginSistema = new LoginSistema();
	    	 telaLoginSistema.setVisible(true);
	    	 view.dispose();
		 }else if(escolha == JOptionPane.NO_OPTION) {
			 int escolha2 = JOptionPane.showConfirmDialog(null, "Quer limpar as areas?", 
					 "Limpar Tela", JOptionPane.YES_NO_OPTION);
			 if(escolha2 == JOptionPane.YES_OPTION) {
				 view.setNameUser("");
				 view.setSurnameUser("");
				 view.setSenhaUser("");
			 }
		 }
		 
	 }  
	    
}
