package controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.Conexao;
import dao.UsuarioDAO;
import model.Usuario;
import view.CadastroSistema_Client;
import view.EscolhaDeCadastro;
import view.LoginSistema;

public class FormCadastroControllerUser {
	
	private CadastroSistema_Client view_client;
	
	public FormCadastroControllerUser(CadastroSistema_Client view_client) {
		this.view_client = view_client;
	}
	
	public void salveUser() {
		String nome = view_client.getNameUser().getText();
		String sobrenome = view_client.getSurnameUser().getText();
		String senha = view_client.getSenhaUser().getText();
		 
    	if (	nome == null || nome.isEmpty() ||
                sobrenome == null || sobrenome.isEmpty() ||
                senha == null || senha.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
    	}else {
        
		    Usuario usuario = new Usuario(nome, sobrenome, senha);
		    try {   
		        Connection conexao = new Conexao().getConnection();
		        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
		        usuarioDao.insert(usuario);
		        
		        JOptionPane.showMessageDialog(null, "Usuario " + usuario.getUsername() + " Cadastrado com sucesso!");
		        
		        voltar();
		        
		    } catch (SQLException e1) {
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		    	}
    	}
	}
	
	public void voltar() {
		LoginSistema telaLoginSistema = new LoginSistema();
   	 	telaLoginSistema.setVisible(true);
   	 	view_client.dispose(); // Fecha a janela atual
    }
	
	public void retorno() {
		 int escolha = JOptionPane.showConfirmDialog(null, "Deseja cancelar o cadastro?",
				 "Retorno", JOptionPane.YES_NO_OPTION);
		 if(escolha == JOptionPane.YES_OPTION) {
			LoginSistema telaLoginSistema = new LoginSistema();
	    	telaLoginSistema.setVisible(true);
	    	view_client.dispose();
		 }else if(escolha == JOptionPane.NO_OPTION) {
			 int escolha2 = JOptionPane.showConfirmDialog(null, "Quer limpar as areas?", 
					"Limpar Tela", JOptionPane.YES_NO_OPTION);
			 if(escolha2 == JOptionPane.YES_OPTION) {
				 view_client.setNameUser("");
				 view_client.setSurnameUser("");
				 view_client.setSenhaUser("");
			 }
		 }
	}
}
