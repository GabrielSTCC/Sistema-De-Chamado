package controller;

import model.UsuarioADM;
import view.Principal;

public class PrincipalController {
	private Principal viewPrincipal;
	
	public PrincipalController(Principal viewPrincipal) {
		this.viewPrincipal = viewPrincipal;
		ajustarMenuAdministrarChamado();
	}
	
	private void ajustarMenuAdministrarChamado() {
		// Verifica se o usuário logado é um admin
        boolean isAdmin = UserSessaoController.getUsuarioLogado() instanceof UsuarioADM;

        // Configura a visibilidade do menu
        viewPrincipal.setMnAdministrarChamado(isAdmin);
    }
}
