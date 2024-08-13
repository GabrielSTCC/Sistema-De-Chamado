package Sistema_de_Chamado;

import java.util.Scanner;

public class MenuSistemaChamado {
    private SistemaChamados sistemaChamados;

    public MenuSistemaChamado(SistemaChamados sistemaChamados) {
        this.sistemaChamados = sistemaChamados;
    }

    public void mostrarMenu(Usuario usuarioLogado) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar Chamado");
            System.out.println("2. Listar Meus Chamados");
            System.out.println("3. Cancelar Chamado");
            System.out.println("4. Ver Status do Chamado");
            if (usuarioLogado instanceof UsuarioADM) {
                System.out.println("5. Editar Chamado (Apenas Administrador)");
            }
            System.out.println("6. Logout");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    criarChamado(scanner, usuarioLogado);
                    break;
                case 2:
                    listarChamados(usuarioLogado);
                    break;
                case 3:
                    cancelarChamado(scanner, usuarioLogado);
                    break;
                case 4:
                    verStatusChamado(scanner, usuarioLogado);
                    break;
                case 5:
                    if (usuarioLogado instanceof UsuarioADM) {
                        editarChamado(scanner, (UsuarioADM) usuarioLogado);
                    } else {
                        System.out.println("Você não tem permissão para editar chamados.");
                    }
                    break;
                case 6:
                    System.out.println("Logout realizado com sucesso!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void criarChamado(Scanner scanner, Usuario usuarioLogado) {
        System.out.println("Digite a descrição do chamado:");
        String descricao = scanner.nextLine();
        sistemaChamados.criarChamado(descricao, usuarioLogado);
    }

    private void listarChamados(Usuario usuarioLogado) {
        sistemaChamados.listarChamados(usuarioLogado);
    }

    private void cancelarChamado(Scanner scanner, Usuario usuarioLogado) {
        System.out.println("Digite o ID do chamado que deseja cancelar:");
        int idCancela = scanner.nextInt();
        scanner.nextLine();
        sistemaChamados.cancelarChamado(usuarioLogado, idCancela);
    }

    private void verStatusChamado(Scanner scanner, Usuario usuarioLogado) {
        System.out.println("Digite o ID do chamado para ver o status:");
        int idStatus = scanner.nextInt();
        scanner.nextLine();
        sistemaChamados.verStatusChamado(usuarioLogado, idStatus);
    }

    private void editarChamado(Scanner scanner, UsuarioADM usuarioADM) {
        System.out.println("Digite o ID do chamado que deseja editar:");
        int idEdita = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a nova descrição do chamado:");
        String novaDescricao = scanner.nextLine();
        sistemaChamados.editarChamado(usuarioADM, idEdita, novaDescricao);
    }
}

