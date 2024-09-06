package controller;

import java.sql.Connection;
import java.sql.SQLException;

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
	         throw new IllegalArgumentException("Preencha todas as informações!");
	         }
	         // Conversão de String para Enum
	     Cargo cargo = Cargo.fromString(cargoStr);
	     AreaU area = AreaU.fromString(areaStr);
	            
	     UsuarioADM usuarioAdm = new UsuarioADM(nome, sobrenome, cargo, area, senha);
	     try {   
	    	 Connection conexao = new Conexao().getConnection();
	    	 UsuarioAdmDAO usuarioAdmDAO = new UsuarioAdmDAO(conexao);
	    	 usuarioAdmDAO.insert(usuarioAdm);
	            
	    	 JOptionPane.showMessageDialog(null, "Usuario " + usuarioAdm.getUsername() + " Cadastrado com sucesso!");
	    	 
	            
	     } catch (SQLException e) {
	    	 JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	     }
	 }
	    
	    
}
