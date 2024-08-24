package Sistema_de_Chamado;





public class Usuario {
	private String name, surname,username;
	private String senha;
	private AreaU areaChamado;
	
	
	public Usuario(String name, String surname, String senha) {
		this.name=name;
		this.surname=surname;
		this.username = generateUsername(name, surname);
		
		this.senha = senha;
	}
	
	public void setAreaChamado(AreaU areaChamdo) {
		this.areaChamado = areaChamdo;
	}
	
	public AreaU getAreaChamado() {
		return areaChamado;
	}
	
	private String generateUsername(String name, String surname) {
        return name.toLowerCase() + "." + surname.toLowerCase();
    }
	
	public String getNameSurname() {
		return name +" "+ surname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getSenha() {
		return senha;
	}
	
	 public Chamado abrirChamado(String descricao) {
	        int id = (int) (Math.random() * 1000); // Gerar um ID aleatório
	        return new Chamado(id, descricao, this, getAreaChamado());
	    }
	
}
