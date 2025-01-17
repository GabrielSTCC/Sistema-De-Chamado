package dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.*;

public class UsuarioAdmDAO {
		//PostgreSQL estruturado na forma padrao:
		private final Connection connection;
	
		public UsuarioAdmDAO(Connection connection) {
			this.connection = connection;
		}
		
		public Connection getConnection() {
			return connection;
		}
		
		public void insert(UsuarioADM usuarioAdm) throws SQLException {
		    String sql = "INSERT INTO usuarioadm (username, name, surname, cargo, area, senha) "
		               + "VALUES (?, ?, ?, ?, ?, ?)";

		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		        // Setando os parâmetros de forma segura
		        statement.setString(1, usuarioAdm.getUsername());
		        statement.setString(2, usuarioAdm.getName());
		        statement.setString(3, usuarioAdm.getSurname());
		        statement.setString(4, usuarioAdm.getCargo().getNome());
		        statement.setString(5, usuarioAdm.getArea().getNome());
		        statement.setString(6, usuarioAdm.getSenha());

		        // Executa a inserção
		        statement.executeUpdate();

		        System.out.println("Usuário administrador cadastrado com sucesso!");

		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Erro ao cadastrar o usuário administrador.");
		    }
		}

		public boolean existenciaDeUsuario(UsuarioADM usuarioADM) throws SQLException {
		    String sql = "SELECT * FROM usuarioadm WHERE username = ? AND senha = ?";

		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		        // Definindo os parâmetros
		        statement.setString(1, usuarioADM.getUsername());
		        statement.setString(2, usuarioADM.getSenha());

		        // Executando a consulta, e não uma atualização
		        ResultSet resultSet = statement.executeQuery();

		        // Verificando se o ResultSet possui resultados
		        return resultSet.next();  // Retorna true se existe um usuário com as credenciais fornecidas
		    }
		}
		
		public UsuarioADM buscarPorUsername(String username) throws SQLException {
	        String sql = "SELECT username, area, cargo FROM usuarioADM WHERE username = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, username);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    String username1 = resultSet.getString("username");
	                    AreaU area = AreaU.fromString(resultSet.getString("area"));
	                    Cargo cargo = Cargo.fromString(resultSet.getString("cargo"));
	                    return new UsuarioADM(username1, area, cargo);
	                } else {
	                    return null;
	                }
	            }
	        }
	    }
}

		
	
	//Configurado para PostgreSQL
		/*private final Connection connection;
		
		public UsuarioAdmDAO(Connection connection) {
			this.connection = connection;
		}
		
		public Connection getConnection() {
			return connection;
		}
		
		public void insert(UsuarioADM usuarioAdm) throws SQLException {

			String sql = "INSERT INTO usuariosadm (username, name, surname, cargo, area, senha) "
					+ "VALUES ('"+usuarioAdm.getUsername()+"','"+usuarioAdm.getName() +"','"+usuarioAdm.getSurname()+"','"+usuarioAdm.getArea().getNome()+"','"
					+usuarioAdm.getCargo().getNome()+"','"+usuarioAdm.getSenha()+"')";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.close();
				
		}*/
	
	//Configurado para SQLite.
	
	/*private final Connection connection;
	
	public UsuarioAdmDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void cadastrarUsuarioAdm(UsuarioADM usuarioADM) throws ClassNotFoundException {
		Connection connection = Conexao.getInstancia().abrirConexao();
		
		String query = DAO.getCADASTRAR_USUARIO_ADM();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, usuarioADM.getUsername());
			preparedStatement.setString(i++, usuarioADM.getName());
			preparedStatement.setString(i++, usuarioADM.getSurname());
			preparedStatement.setString(i++, usuarioADM.getCargo().getNome());
			preparedStatement.setString(i++, usuarioADM.getArea().getNome());
			preparedStatement.setString(i++, usuarioADM.getSenha());
			
			connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO dao = new DAO();
			dao.fecharConexao();
		}
		
	}
	
	public UsuarioADM consultarUsiarioAdm(String username, String senha) throws Exception {
		Connection connection = Conexao.getInstancia().abrirConexao();
		UsuarioADM usuarioADM = null;
		String query = DAO.getCONSULTAR_USUARIOS();
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			int i = 1;
			
			preparedStatement.setString(i++, username);
			preparedStatement.setString(i++, senha);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Cargo cargo = Cargo.valueOf(resultSet.getString("CARGO").toUpperCase());
			    AreaU area = AreaU.valueOf(resultSet.getString("AREA").toUpperCase());
				
				usuarioADM = new UsuarioADM(resultSet.getInt("ID"),
											resultSet.getString("NAME"),
											resultSet.getString("SURNAME"),
											cargo,
											area,
											resultSet.getString("SENHA"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DAO dao = new DAO();
			dao.fecharConexao();
		}
		if (usuarioADM == null) {
			JOptionPane.showMessageDialog(null, "Não foi possivel localizer o Usuario", "", JOptionPane.WARNING_MESSAGE);
			throw new Exception("Não foi possivel localizer o Usuario");
		}
		
		return usuarioADM;
		
	}*/

	
	

