package Sistema_de_Chamado;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaUsuarios {
    // Mapa para armazenar os usuários, usando o username como chave
    private Map<String, Usuario> usuarios;

    public SistemaUsuarios() {
        this.usuarios = new HashMap<>();
    }

    // Método para criar um novo usuário normal
    public void criarUsuario(String nome, String sobrenome, Area area) {
        Usuario usuario = new Usuario(nome, sobrenome, area);
        usuarios.put(usuario.getUsername(), usuario);
        System.out.println("Usuário criado com sucesso! Username: " + usuario.getUsername());
    }

    // Método para criar um novo usuário administrador
    public void criarUsuarioADM(String nome, String sobrenome, Area area, Cargo cargo) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a senha para o administrador:");
        String senha = scanner.nextLine();

        UsuarioADM usuarioADM = new UsuarioADM(nome, sobrenome, area, cargo, senha);
        usuarios.put(usuarioADM.getUsername(), usuarioADM);
        System.out.println("Administrador criado com sucesso! Username: " + usuarioADM.getUsername());
    }

    // Método para autenticar um usuário com base no username e na senha
    public Usuario login(String username, String senha) {
        Usuario usuario = usuarios.get(username);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso!");
            return usuario;
        } else {
            System.out.println("Username ou senha incorretos.");
            return null;
        }
    }

    // Método para buscar um usuário pelo username
    public Usuario buscarUsuario(String username) {
        return usuarios.get(username);
    }

    // Método para verificar se o username já existe no sistema
    public boolean usuarioExiste(String username) {
        return usuarios.containsKey(username);
    }
}

