package Sistema_de_Chamado;

public class Main {
    public static void main(String[] args) {
        SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();
        SistemaChamados sistemaChamados = new SistemaChamados();

        Login login = new Login(sistemaUsuarios);
        MenuSistemaChamado menuSistemaChamado = new MenuSistemaChamado(sistemaChamados);

        Usuario usuarioLogado = login.autenticar();
        if (usuarioLogado != null) {
            menuSistemaChamado.mostrarMenu(usuarioLogado);
        }
    }
}