package controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Sistema_de_Chamado.AreaU;
import Sistema_de_Chamado.Cargo;
import Sistema_de_Chamado.Usuario;
import Sistema_de_Chamado.UsuarioADM;
import dao.Conexao;
import dao.UsuarioAdmDAO;
import dao.UsuarioDAO;
import interfaceSistema.CadastroSistema;
import interfaceSistema.CadastroSistema_Client;

public class FormCadastroController {
	
	private CadastroSistema view;
	private CadastroSistema_Client view_client;
	
	public FormCadastroController(CadastroSistema view) {
		this.view = view;
	}
	
	public FormCadastroController(CadastroSistema_Client view_client) {
		this.view_client = view_client;
	}
	
	public void salvaUser() {
		
		
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

	        UsuarioADM usuario = new UsuarioADM(name, surname, area, cargo, senha);
	        
	        try {
				Connection conexao = new Conexao().getConnection();
				UsuarioAdmDAO usuarioAdmDao = new UsuarioAdmDAO(conexao);
				usuarioAdmDao.insert(usuario);
				
				JOptionPane.showMessageDialog(null, "Usuario "+usuario.getUsername()+" Cadastrado com sucesso!");
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
	}
	
	public void salveClient() {
		String name = view.getNameUser().getText();
		String surname = view.getSurnameUser().getText();
		char[] senhaArray = view.getSenhaUser().getPassword();
        String senha = new String(senhaArray);
        
        Usuario usuario = new Usuario(name, surname, senha);
        
        try {
			Connection conexao = new Conexao().getConnection();
			UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
			usuarioDao.insert(usuario);
			
			JOptionPane.showMessageDialog(null, "Usuario "+usuario.getUsername()+" Cadastrado com sucesso!");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
