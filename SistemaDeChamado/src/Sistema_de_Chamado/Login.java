package Sistema_de_Chamado;

import java.util.Scanner;

public class Login {
    private SistemaUsuarios sistemaUsuarios;

    public Login(SistemaUsuarios sistemaUsuarios) {
        this.sistemaUsuarios = sistemaUsuarios;
    }

    public Usuario autenticar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nÁrea de Login");
            System.out.println("1. Criar Usuário");
            System.out.println("2. Criar Administrador");
            System.out.println("3. Login");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    criarUsuario(scanner);
                    break;
                case 2:
                    criarUsuarioADM(scanner);
                    break;
                case 3:
                    return login(scanner);
                case 4:
                    System.out.println("Saindo...");
                    return null;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void criarUsuario(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.println("Escolha a área:");
        for (Area area : Area.values()) {
            System.out.println(area.getValor() + ". " + area.getNome());
        }
        int valorArea = scanner.nextInt();
        scanner.nextLine();
        Area areaEscolhida = Area.values()[valorArea - 1];
        sistemaUsuarios.criarUsuario(nome, sobrenome, areaEscolhida);
    }

    private void criarUsuarioADM(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o sobrenome:");
        String sobrenome = scanner.nextLine();
        System.out.println("Escolha a área:");
        for (Area area : Area.values()) {
            System.out.println(area.getValor() + ". " + area.getNome());
        }
        int valorArea = scanner.nextInt();
        scanner.nextLine();
        Area areaEscolhida = Area.values()[valorArea - 1];
        System.out.println("Escolha o cargo:");
        for (Cargo cargo : Cargo.values()) {
            System.out.println(cargo.getValor() + ". " + cargo.getNome());
        }
        int valorCargo = scanner.nextInt();
        scanner.nextLine();
        Cargo cargoEscolhido = Cargo.values()[valorCargo - 1];
        sistemaUsuarios.criarUsuarioADM(nome, sobrenome, areaEscolhida, cargoEscolhido);
    }

    private Usuario login(Scanner scanner) {
        System.out.println("Digite o username:");
        String username = scanner.nextLine();
        System.out.println("Digite a senha:");
        String senha = scanner.nextLine();
        return sistemaUsuarios.login(username, senha);
    }
}

