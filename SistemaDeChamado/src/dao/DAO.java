package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {

	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	private static String CADASTRAR_USUARIO_ADM = " INSERT INTO USUARIOADM "
			+ "(ID, USERNAME, NAME, SURNAME, CARGO, AREA, SENHA) "
			+ "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
	
	private static String CADASTRAR_USUARIO = " INSERT INTO USUARIOADM "
			+ "(ID, USERNAME, NAME, SURNAME, SENHA) "
			+ "VALUES (NULL, ?, ?, ?, ?)";
	
	private static String CONSULTAR_USUARIOS = " SELECT USERNAME, SENHA "
			+ " FROM USUARIOADM "
			+ " WHERE USERNAME = ? "
			+ " AND SENHA = ?";
	
	public DAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void fecharConexao() {
		
			try {
				if (resultSet != null) {
				resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				Conexao.getInstancia().fecharConexao();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

	public static String getCADASTRAR_USUARIO_ADM() {
		return CADASTRAR_USUARIO_ADM;
	}


	public static String getCADASTRAR_USUARIO() {
		return CADASTRAR_USUARIO;
	}


	public static String getCONSULTAR_USUARIOS() {
		return CONSULTAR_USUARIOS;
	}

	
	
}
