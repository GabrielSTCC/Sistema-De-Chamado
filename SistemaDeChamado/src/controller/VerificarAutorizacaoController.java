package controller;

import javax.swing.JOptionPane;

import view.CadastroSistema;
import view.VerificarAutorizacao;

public class VerificarAutorizacaoController {
	private VerificarAutorizacao viewAutorizacao;

	public VerificarAutorizacaoController(VerificarAutorizacao viewAutorizacao) {
		this.viewAutorizacao = viewAutorizacao;
	}
	
	public void verificar() {
		String codigoInserido = viewAutorizacao.textField.getText();
	    String codigoAutorizacao = "1234"; // Código de autorização definido

	    // Verificar se o código está vazio
	    if (codigoInserido.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Por favor, insira o código.");
	        new CadastroSistema().setVisible(true);
            viewAutorizacao.dispose(); // Fecha a janela após a verificação
	    }

	    // Verificar se o código está correto
	    if (codigoInserido.equals(codigoAutorizacao)) {
	        JOptionPane.showMessageDialog(null, "Código correto! Você pode se cadastrar.");
	        // Aqui você pode abrir a tela de cadastro
	        new CadastroSistema().setVisible(true);
	        viewAutorizacao.dispose(); // Fechar a mini tela
	    } else {
	        JOptionPane.showMessageDialog(null, "Código incorreto. Tente novamente.");
	    }
	}
	
	public void fecharTela() {
		viewAutorizacao.dispose();
	}
}
