package controller;

import java.sql.Connection;
import java.sql.SQLException;

import dao.Conexao;
import dao.UsuarioAdmDAO;
import dao.UsuarioDAO;
import model.Usuario;
import model.UsuarioADM;

public class UserSessaoController {
	private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
    public static void login(String username, String senha) throws SQLException {
        Connection connection = new Conexao().getConnection();
        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
        UsuarioAdmDAO usuarioADMDAO = new UsuarioAdmDAO(connection);

        UsuarioADM usuarioADM = usuarioADMDAO.buscarPorUsername(username);
        if (usuarioADM != null) {
            usuarioLogado = usuarioADM;
        } else {
            Usuario usuario = usuarioDAO.buscarPorUsername(username);
            if (usuario != null) {
                usuarioLogado = usuario;
            } else {
                usuarioLogado = null;
            }
        }
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static void limparSessao() {
        usuarioLogado = null;  // Para encerrar a sessão
    }
}
