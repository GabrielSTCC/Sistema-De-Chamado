package Sistema_de_Chamado;

enum Cargo{
	COORDENADOR(1,"Coordenador"),
	ANALISTA(2,"Analista"),
	TECNICO(3,"Tecnico"),
	GERENTE(4,"Gerente"),
	CEO(5,"CEO");
	
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
}

public class UsuarioADM extends Usuario{
	
	private Cargo cargo;
	

	public UsuarioADM(String name, String surname, Area area) {
		super(name, surname, area);
		
	}

}
