package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	private final Connection connection;
	
	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void insert(Usuario usuario) throws SQLException{
		
		String sql = "INSERT INTO usuarios (username, name, surname, senha)"
				+ "VALUES ('"+usuario.getUsername()+"','"+usuario.getName() +
				"','"+usuario.getSurname()+"','"+usuario.getSenha()+"')";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.close();
	}
}
