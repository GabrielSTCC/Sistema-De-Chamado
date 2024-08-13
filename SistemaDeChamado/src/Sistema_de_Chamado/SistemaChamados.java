package Sistema_de_Chamado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaChamados {

	private Map<Area, List<Chamado>> chamadosPorArea;

    public SistemaChamados() {
        this.chamadosPorArea = new HashMap<>();
        for (Area area : Area.values()) {
            chamadosPorArea.put(area, new ArrayList<>());
        }
    }

    public void criarChamado(String descricao, Usuario usuario) {
        Chamado chamado = usuario.abrirChamado(descricao);
        chamadosPorArea.get(usuario.getArea()).add(chamado);
        System.out.println("Chamado criado com sucesso para a área: " + usuario.getArea().getNome());
    }

    public void listarChamados(Usuario usuario) {
        List<Chamado> chamados = chamadosPorArea.get(usuario.getArea());
        
        if (usuario instanceof UsuarioADM) {
            // Administrador vê todos os chamados da sua área
            System.out.println("Chamados na área: " + usuario.getArea().getNome());
            for (Chamado chamado : chamados) {
                System.out.println(chamado);
            }
        } else {
            // Usuário normal vê apenas seus próprios chamados
            System.out.println("Seus chamados na área: " + usuario.getArea().getNome());
            for (Chamado chamado : chamados) {
                if (chamado.getUsuario().equals(usuario)) {
                    System.out.println(chamado);
                }
            }
        }
    }

    public void editarChamado(UsuarioADM administrador, int idChamado, String novaDescricao) {
        List<Chamado> chamados = chamadosPorArea.get(administrador.getArea());
        for (Chamado chamado : chamados) {
            if (chamado.getId() == idChamado) {
                chamado.setDescricao(novaDescricao);
                System.out.println("Chamado ID " + idChamado + " foi editado com sucesso.");
                return;
            }
        }
        System.out.println("Chamado não encontrado na área " + administrador.getArea().getNome());
    }

    public void cancelarChamado(Usuario usuario, int idChamado) {
        List<Chamado> chamados = chamadosPorArea.get(usuario.getArea());
        for (Chamado chamado : chamados) {
            if (chamado.getId() == idChamado && (chamado.getUsuario().equals(usuario) || usuario instanceof UsuarioADM)) {
                chamado.setStatus("Cancelado");
                System.out.println("Chamado ID " + idChamado + " foi cancelado com sucesso.");
                return;
            }
        }
        System.out.println("Chamado não encontrado ou você não tem permissão para cancelá-lo.");
    }

    public void verStatusChamado(Usuario usuario, int idChamado) {
        List<Chamado> chamados = chamadosPorArea.get(usuario.getArea());
        for (Chamado chamado : chamados) {
            if (chamado.getId() == idChamado && (chamado.getUsuario().equals(usuario) || usuario instanceof UsuarioADM)) {
                System.out.println("Status do Chamado ID " + idChamado + ": " + chamado.getStatus());
                return;
            }
        }
        System.out.println("Chamado não encontrado ou você não tem permissão para visualizar o status.");
    }
    
    /*public class Main {
        public static void main(String[] args) {
            // Criação de usuários
            Usuario usuarioNormal = new Usuario("João", "Silva", Area.TI);
            UsuarioADM usuarioADM = new UsuarioADM("Maria", "Santos", Area.TI, Cargo.GERENTE);

            // Instanciação do sistema de chamados
            SistemaChamados sistema = new SistemaChamados();

            // Usuários abrem chamados
            sistema.criarChamado("Problema no servidor", usuarioNormal);
            sistema.criarChamado("Configuração de rede", usuarioADM);

            // Listagem de chamados
            System.out.println("\nUsuário Normal listando seus chamados:");
            sistema.listarChamados(usuarioNormal);

            System.out.println("\nAdministrador listando todos os chamados:");
            sistema.listarChamados(usuarioADM);

            // Administrador edita um chamado
            System.out.println("\nAdministrador editando um chamado:");
            sistema.editarChamado(usuarioADM, 196, "Problema no servidor - Urgente");

            // Usuário Normal tenta cancelar seu próprio chamado
            System.out.println("\nUsuário Normal cancelando seu chamado:");
            sistema.cancelarChamado(usuarioNormal, 1);

            // Administrador cancela qualquer chamado
            System.out.println("\nAdministrador cancelando um chamado:");
            sistema.cancelarChamado(usuarioADM, 2);

            // Verificando status dos chamados
            System.out.println("\nUsuário Normal verificando status:");
            sistema.verStatusChamado(usuarioNormal, 1);

            System.out.println("\nAdministrador verificando status:");
            sistema.verStatusChamado(usuarioADM, 2);
        }
    }*/

}


