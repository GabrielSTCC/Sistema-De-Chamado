package model;

public enum Cargo{
	COORDENADOR(1,"Coordenador"),
	ANALISTA(2,"Analista"),
	TECNICO(3,"Tecnico"),
	GERENTE(4,"Gerente");
	
	private int valor;
	private String nome;
	
	private Cargo(int valor, String nome) {
		this.valor = valor;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getValor() {
		return valor;
	}

	public static Cargo fromString(String cargo) {
        switch (cargo) {
            case "Tecnico":
                return TECNICO;
            case "Analista":
                return ANALISTA;
            case "Coordenador":
                return COORDENADOR;
            case "Gerente":
                return GERENTE;
            default:
                throw new IllegalArgumentException("Cargo desconhecido: " + cargo);
        }
    }
}