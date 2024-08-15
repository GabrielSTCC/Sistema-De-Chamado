package Sistema_de_Chamado;

enum Area{
	TI(1,"TI"),
	MANUTENCAO(2,"Manutencao"),
	SUPRIMENTO(3, "Suprimento"),
	ADM(4,"Adm"),
	COMUM(5,"Comum");
	
	
	private int valor;
	private String nome;
	
	private Area(int valor, String nome) {
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



public class Usuario {
	private String name, surname,username;
	private String senha;
	private Area area;
	
	public Usuario(String name, String surname, Area area ) {
		this.name=name;
		this.surname=surname;
		this.username = generateUsername(name, surname);
		this.area=area;
		this.senha = "generica123";
	}
	
	private String generateUsername(String name, String surname) {
        return name.toLowerCase() + "." + surname.toLowerCase();
    }
	
	public String getNameSurname() {
		return name +" "+ surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public Area getArea() {
		return area;
	}
	
	public String getSenha() {
		return senha;
	}
	
	 public Chamado abrirChamado(String descricao) {
	        int id = (int) (Math.random() * 1000); // Gerar um ID aleatório
	        return new Chamado(id, descricao, this);
	    }
	
}
