package dao;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.AreaU;
import model.Chamado;
import model.StatusChamado;
import model.Titulo;
import model.Usuario;


public class ChamadoDAO {
	
	private final Connection connection;
	
	public ChamadoDAO(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void insert(Chamado chamado) {
		 String sql = "INSERT INTO chamadosabertos (usuario, titulo, area, descricao, status, data)"
				 + "VALUES (?, ?, ?, ?, ?, ?)";
		 
		 try (PreparedStatement statement = connection.prepareStatement(sql)) {
		        // Setando os parâmetros de forma segura
		        statement.setString(1, chamado.getUsuario());
		        statement.setString(2, chamado.getTipoSolicitacao().getTitulo());
		        statement.setString(3, chamado.getArea().getNome());
		        statement.setString(4, chamado.getDescricao());
		        statement.setString(5, chamado.getStatus().getDescricao());
		        statement.setTimestamp(6, java.sql.Timestamp.valueOf(chamado.getDataCriacao()));

		        // Executa a inserção
		        int affectedRows = statement.executeUpdate();
		        if (affectedRows > 0) {
		            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		                if (generatedKeys.next()) {
		                    int id = generatedKeys.getInt(1);
		                    chamado.setId(id); // Atribui o ID gerado ao objeto Chamado
		                }
		            }
		        }

		        System.out.println("Chamado criado com sucesso!");

		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Erro ao cadastrar o usuário administrador.");
		    }
		
	}
	
	public List<Chamado> buscarMeuChamado(String username) throws SQLException {
		 List<Chamado> chamados = new ArrayList<>();
		String sql = "SELECT * FROM chamadosabertos WHERE usuario = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	
            	int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String descricao = resultSet.getString("descricao");
                java.sql.Timestamp timestamp = resultSet.getTimestamp("data");
                LocalDateTime data = timestamp.toLocalDateTime();
                String areaString = resultSet.getString("area");
                String status = resultSet.getString("status");
                AreaU areaSolicitada = AreaU.fromString(areaString); // Corrige a variável 'area'
                Titulo tipoSolicitacao = Titulo.fromString(titulo);
                StatusChamado statusChamado = StatusChamado.fromString2(status); // Ajusta o status conforme necessário
                
                Chamado chamado = new Chamado(id, username, tipoSolicitacao, areaSolicitada, descricao, statusChamado, data);
                chamados.add(chamado);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException("Erro ao buscar os chamados: " + e.getMessage());
        }
        return chamados;
	}
	
	public List<Chamado> buscarMeuChamadoPorArea(String area, String status) throws SQLException {
	    List<Chamado> chamados = new ArrayList<>();
	    String sql = "SELECT * FROM chamadosabertos WHERE area = ? AND status = ?"; // Ajuste a consulta conforme necessário

	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, area);
	        statement.setString(2, status);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String username = resultSet.getString("usuario");
	                String titulo = resultSet.getString("titulo");
	                String descricao = resultSet.getString("descricao");
	                java.sql.Timestamp timestamp = resultSet.getTimestamp("data");
	                LocalDateTime data = timestamp.toLocalDateTime();
	                String areaString = resultSet.getString("area");
	                AreaU areaSolicitada = AreaU.fromString(areaString); // Corrige a variável 'area'
	                Titulo tipoSolicitacao = Titulo.fromString(titulo);
	                StatusChamado statusChamado = StatusChamado.fromString2(status); // Ajusta o status conforme necessário
	                
	                Chamado chamado = new Chamado(id, username, tipoSolicitacao, areaSolicitada, descricao, statusChamado, data);
	                chamados.add(chamado);
	            }
	        }
	    }
	    return chamados;
	}
	
	public void pegarChamadoPorId(int id) throws SQLException {
	    String sql = "UPDATE chamadosabertos SET status = ? WHERE id = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, StatusChamado.EM_ANDAMENTO.getDescricao()); // Usando o enum
	        statement.setInt(2, id);
	        
	        statement.executeUpdate();
	    }
	}
	
	public void encerrarChamdo(int id) throws SQLException {
	    String sql = "UPDATE chamadosabertos SET status = ? WHERE id = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        statement.setString(1, StatusChamado.FECHADO.getDescricao()); // Usando o enum
	        statement.setInt(2, id);
	        
	        statement.executeUpdate();
	    }
	}
	
	public void excluirChamadoPorId(int id) throws SQLException {
	    String sql = "DELETE FROM chamadosabertos WHERE id = ?";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	    	statement.setInt(1, id);
	        
	    	statement.executeUpdate();
	    }
	}

}
