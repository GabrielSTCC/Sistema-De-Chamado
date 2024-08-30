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

public class FormCadastroController {
	
	private CadastroSistema view;
	private CadastroSistema_Client view_client;
	
	public FormCadastroController(CadastroSistema view) {
		this.view = view;
	}
	
	public FormCadastroController(CadastroSistema_Client view_client) {
		this.view_client = view_client;
	}
	
	public void salvaUser() throws ClassNotFoundException {
		
		
		String name = view.getNameUser().getText();
		String surname = view.getSurnameUser().getText();
		char[] senhaArray = view.getSenhaUser().getPassword();
        String senha = new String(senhaArray);
		
        // Captura dos valores do JComboBox para Area
		String selectedArea = (String) view.getAreasUser().getSelectedItem();
	        AreaU area = null;
	        if (selectedArea != null) {
	            switch (selectedArea) {
	                case "TI":
	                    area = AreaU.TI;
	                    break;
	                case "MANUTENCAO":
	                    area = AreaU.MANUTENCAO;
	                    break;
	                case "SUPRIMENTO":
	                    area = AreaU.SUPRIMENTO;
	                    break;
	                case "ADMINISTRAÇÃO":
	                    area = AreaU.ADM;
	                    break;
	                default:
	                    area = AreaU.COMUM;  // Valor padrão
	            }
	        }

			// Captura dos valores do JComboBox para Cargo
	        String selectedCargo = (String) view.getCargosUser().getSelectedItem();
	        Cargo cargo = null;
	        if (selectedCargo != null) {
	            switch (selectedCargo) {
	                case "Tecnico":
	                    cargo = Cargo.TECNICO;
	                    break;
	                case "Analista":
	                    cargo = Cargo.ANALISTA;
	                    break;
	                case "Coordenador":
	                    cargo = Cargo.COORDENADOR;
	                    break;
	                case "Gerente":
	                    cargo = Cargo.GERENTE;
	                    break;
	                
	            }
	        }
	        int i = 0;
	        UsuarioADM usuarioAdm = new UsuarioADM(i++, name, surname, cargo, area, senha);
	        
	        Connection conexao = new Conexao().abrirConexao();
			UsuarioAdmDAO usuarioAdmDao = new UsuarioDAO(conexao);
			usuarioAdmDao.cadastrarUsuarioAdm(usuarioAdm);
			
			JOptionPane.showMessageDialog(null, "Usuario "+usuarioAdm.getUsername()+" Cadastrado com sucesso!");
	}
	
	public void salveClient() {
		String name = view_client.getNameUser().getText();
		String surname = view_client.getSurnameUser().getText();
		char[] senhaArray = view_client.getSenhaUser().getPassword();
        String senha = new String(senhaArray);
        int i = 0;
        Usuario usuario = new Usuario(i++, name, surname, senha);
        
        try {
        	Connection conexao = new Conexao().abrirConexao();
			UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
			usuarioDao.insert(usuario);
			
			JOptionPane.showMessageDialog(null, "Usuario "+usuario.getUsername()+" Cadastrado com sucesso!");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
