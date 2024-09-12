package controller;

import view.CadastroSistema_Client;
import view.EscolhaDeCadastro;
import view.LoginSistema;
import view.VerificarAutorizacao;

public class EscolhaDeCadatroCrotroller {
	private EscolhaDeCadastro viewEscolhaDeCadastro;

	public EscolhaDeCadatroCrotroller(EscolhaDeCadastro viewEscolhaDeCadastro) {
		super();
		this.viewEscolhaDeCadastro = viewEscolhaDeCadastro;
	}
	
	public void chamarVerificacao() {
		VerificarAutorizacao autorizacao = new VerificarAutorizacao(viewEscolhaDeCadastro);
		autorizacao.setVisible(true);
	}
	
	public void retornoLogin() {
		LoginSistema loginSistema = new LoginSistema();
		loginSistema.setVisible(true);
		viewEscolhaDeCadastro.dispose();
	}
	
	public void cadatrarCliente() {
		CadastroSistema_Client cadastroSistema_Client =  new CadastroSistema_Client();
		cadastroSistema_Client.setVisible(true);
		viewEscolhaDeCadastro.dispose();
	}
}
