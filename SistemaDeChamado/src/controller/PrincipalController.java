package controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.UsuarioADM;
import view.LoginSistema;
import view.Principal;

public class PrincipalController {
	private Principal viewPrincipal;
	
	public PrincipalController(Principal viewPrincipal) {
		this.viewPrincipal = viewPrincipal;
		ajustarMenuAdministrarChamado();
		this.viewPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });
	}
	
	private void ajustarMenuAdministrarChamado() {
		// Verifica se o usuário logado é um admin
        boolean isAdmin = UserSessaoController.getUsuarioLogado() instanceof UsuarioADM;

        // Configura a visibilidade do menu
        viewPrincipal.setMnAdministrarChamado(isAdmin);
    }
	
	private void handleWindowClosing() {
        // Exibe a caixa de diálogo perguntando ao usuário se deseja deslogar ou encerrar
        int option = JOptionPane.showOptionDialog(
            viewPrincipal,
            "Deseja deslogar ou encerrar o programa?",
            "Confirmar Ação",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            new String[]{"Deslogar", "Encerrar", "Cancelar"},
            "Deslogar"
        );
        
        if (option == JOptionPane.YES_OPTION) {
            // Se o usuário escolheu "Deslogar", chama o método para deslogar
            deslogar();
        } else if (option == JOptionPane.NO_OPTION) {
            // Se o usuário escolheu "Encerrar", encerra a aplicação
            encerrarAplicacao();
        }
    }

    private void deslogar() {
        // Fecha a tela principal
        viewPrincipal.dispose();
        // Chama o loginController para exibir a tela de login
        LoginSistema telaLoginSistema = new LoginSistema();
   	 	telaLoginSistema.setVisible(true);
   	 	viewPrincipal.dispose();
    }

    private void encerrarAplicacao() {
        // Fecha o programa
        System.exit(0);
    }
}
