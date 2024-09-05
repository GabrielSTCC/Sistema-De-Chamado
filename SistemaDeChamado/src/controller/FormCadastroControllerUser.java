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
	
	public void salveUser(String nome, String sobrenome, String senha) {
        
    	if (	nome == null || nome.isEmpty() ||
                sobrenome == null || sobrenome.isEmpty() ||
                senha == null || senha.isEmpty()) {
    		throw new IllegalArgumentException("Preencha todas as informações!");
    	}
        
        Usuario usuario = new Usuario(nome, sobrenome, senha);
    try {   
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        usuarioDao.insert(usuario);
        
        JOptionPane.showMessageDialog(null, "Usuario " + usuario.getUsername() + " Cadastrado com sucesso!");
        
        LoginSistema login = new LoginSistema();
        login.setVisible(true);
        view_client.dispose();
        
    } catch (SQLException e1) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    	}
	}
	
	public void voltar() {
        EscolhaDeCadastro escolha = new EscolhaDeCadastro();
        escolha.setVisible(true);
        view_client.dispose(); // Fecha a janela atual
    }
}
