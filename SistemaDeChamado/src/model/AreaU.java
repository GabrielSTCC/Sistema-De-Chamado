package model;

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

	public static AreaU fromString(String area) {
        switch (area) {
            case "TI":
                return TI;
            case "MANUTENCAO":
                return MANUTENCAO;
            case "SUPRIMENTO":
                return SUPRIMENTO;
            case "ADMINISTRAÇÃO":
                return ADM;
            default:
                return COMUM; // Valor padrão
        }
    }

}

