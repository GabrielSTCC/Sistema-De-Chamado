package Sistema_de_Chamado;

public enum AreaU{
	TI(1,"TI"),
	MANUTENCAO(2,"Manutencao"),
	SUPRIMENTO(3, "Suprimento"),
	ADM(4,"Adm"),
	COMUM(5,"Comum");
	
	
	private int valor;
	private String nome;
	
	private AreaU(int valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getValor() {
		return valor;
	}

}

