package model;

public enum AreaU{
	TI(1,"TI"),
	MANUTENCAO(2,"Manutenção"),
	SUPRIMENTO(3, "Suprimento"),
	ADM(4,"Administração");
	
	
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
            case "Manutenção":
                return MANUTENCAO;
            case "Suprimento":
                return SUPRIMENTO;
            case "Administração":
                return ADM;
            default:
            	throw new IllegalArgumentException("Cargo desconhecido: " + area);
        }
    }

}

