package controller;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.Conexao;
import dao.UsuarioAdmDAO;
import dao.UsuarioDAO;
import model.Usuario;
import model.UsuarioADM;
import view.EscolhaDeCadastro;
import view.LoginSistema;
import view.Principal;

public class FormLoginController {
	
	private LoginSistema viewLogin;
	
	public FormLoginController(LoginSistema viewLogin) {
		this.viewLogin = viewLogin;
	}
	
	public void login() {
		String username = viewLogin.getUserText().getText();
		String senha = viewLogin.getPasswordText().getText();
		
		if (	username== null || username.isEmpty() ||
                senha == null || senha.isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Preencha todos os dados!");
    	}else {
		
		    Connection conexao = null;
	
		    try {
		        conexao = new Conexao().getConnection();
		        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
	
		        // Tenta autenticar como usuário comum
		        Usuario usuarioAutenticar = new Usuario(username, senha);
		        boolean usuarioExiste = usuarioDao.existenciaDeUsuario(usuarioAutenticar);
	
		        if (usuarioExiste) {
		            abrirTelaPrincipal();
		        } else {
		            // Tenta autenticar como administrador
		            UsuarioADM usuarioADMAutenticar = new UsuarioADM(username, senha);
		            UsuarioAdmDAO usuarioAdmDao = new UsuarioAdmDAO(conexao);
		            boolean usuarioADMExiste = usuarioAdmDao.existenciaDeUsuario(usuarioADMAutenticar);
	
		            if (usuarioADMExiste) {
		                abrirTelaPrincipal();
		            } else {
		                JOptionPane.showMessageDialog(null, "Usuário não encontrado.\nVerifique nome de usuário e senha!");
		            }
		        }
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage());
		    } finally {
		        // Certifique-se de fechar a conexão
		        if (conexao != null) {
		            try {
		                conexao.close();
		            } catch (SQLException e) {
		                e.printStackTrace(); // Logue o erro
		            }
		        }
		    }
    	}
	}
	
	private void abrirTelaPrincipal() {
	    Principal telaPrincipal = new Principal();
	    telaPrincipal.setVisible(true);
	    viewLogin.dispose();
	}
	
	public void cadastro() {
		EscolhaDeCadastro telaEscolhaCadastroSistema = new EscolhaDeCadastro();
		telaEscolhaCadastroSistema.setVisible(true);
		viewLogin.dispose();
	}
}
