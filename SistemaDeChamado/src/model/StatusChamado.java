package model;

public enum StatusChamado {
    ABERTO("Aberto"),
    EM_ANDAMENTO("Em Andamento"),
    FECHADO("Fechado");

    private final String descricao;

    StatusChamado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static StatusChamado fromString(String status) {
        for (StatusChamado s : StatusChamado.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Status inválido: " + status);
    }
    /*public static StatusChamado fromString(String descricao) {
    	switch (descricao) {
        case "Aberto":
            return ABERTO;
        case "Em Andamento":
            return EM_ANDAMENTO;
        case "Fechado":
            return FECHADO;
        default:
        	throw new IllegalArgumentException("Cargo desconhecido: " + descricao);
    	}
    }*/
}
