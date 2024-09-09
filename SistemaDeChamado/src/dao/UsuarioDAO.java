package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

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

	public boolean existenciaDeUsuario(Usuario usuario) throws SQLException {
	    String sql = "SELECT * FROM usuario WHERE username = ? AND senha = ?";

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        // Definindo os parâmetros
	        statement.setString(1, usuario.getUsername());
	        statement.setString(2, usuario.getSenha());

	        // Executando a consulta ao invés de uma atualização
	        ResultSet resultSet = statement.executeQuery();

	        // Verificando se o ResultSet possui resultados
	        return resultSet.next();  // Retorna true se o usuário foi encontrado
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
