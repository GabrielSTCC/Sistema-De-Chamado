package model;

public enum Titulo{
	
	INCIDENTE("Incidente"),
	REQUISICAO("Requisição");
	
	private String titulo;
	
	private Titulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public static Titulo fromString(String titulo) {
        switch (titulo) {
            case "Incidente":
                return INCIDENTE;
            case "Requisição":
                return REQUISICAO;
            default:
                throw new IllegalArgumentException("Cargo desconhecido: " + titulo);
        }
    }

}
