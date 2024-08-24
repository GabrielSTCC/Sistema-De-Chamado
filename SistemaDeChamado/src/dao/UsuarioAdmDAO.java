package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Sistema_de_Chamado.*;

public class UsuarioAdmDAO {
	
	private final Connection connection;
	
	public UsuarioAdmDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void insert(UsuarioADM usuario) throws SQLException {

		String sql = "INSERT INTO usuariosADM (username, name, surname, cargo, area, senha) "
				+ "VALUES ('"+usuario.getUsername()+"','"+usuario.getName() +"','"+usuario.getSurname()+"','"+usuario.getArea().getNome()+"','"
				+usuario.getCargo().getNome()+"','"+usuario.getSenha()+"')";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.close();
			
	}
}
