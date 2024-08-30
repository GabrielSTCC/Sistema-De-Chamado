package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	/*public Connection getConnection() throws SQLException {
		Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BancoSistemaChamado", "postgres", "Taurus2017");
		return conexao;
	}*/
	
	private static Conexao instancia;
	private static String DRIVER = "org.sqlite.JDBC";
	private static String BD = "jdbc:sqlite:resources/bdsistemchamado.db";
	private static Connection conexao;
	
	public Conexao() {
		
	}
	
	public static Conexao getInstancia() {
		
		if (instancia == null) {
			instancia = new Conexao();
		}
		return instancia;
	}
	
	public Connection abrirConexao() throws ClassNotFoundException {
		
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(BD);
			conexao.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco de dados"+e.getMessage());
			
		}
		return conexao;
	}
	
	public void fecharConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro ao fechar conexao: "+e.getMessage());
		}finally {
			conexao = null;
		}
	}
}
