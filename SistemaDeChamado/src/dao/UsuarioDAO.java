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
	
	public void insert(Usuario usuario) throws SQLException {
	    String sql = "INSERT INTO usuario (username, name, surname, senha) VALUES (?, ?, ?, ?)";

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        // Setando os parâmetros de forma segura
	        statement.setString(1, usuario.getUsername());
	        statement.setString(2, usuario.getName());
	        statement.setString(3, usuario.getSurname());
	        statement.setString(4, usuario.getSenha());

	        // Executa a inserção
	        statement.executeUpdate();

	        System.out.println("Usuário cadastrado com sucesso!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Erro ao cadastrar o usuário.");
	    }
	}

	/*public void insert(Usuario usuario) throws SQLException{
		
		String sql = "INSERT INTO usuarios (username, name, surname, senha)"
				+ "VALUES ('"+usuario.getUsername()+"','"+usuario.getName() +
				"','"+usuario.getSurname()+"','"+usuario.getSenha()+"')";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		connection.close();
	}*/
}
