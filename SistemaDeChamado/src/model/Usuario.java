package model;

public class Usuario {
	private String name, surname,username;
	private String senha;
	private int id;
	private AreaU areaChamado;
	
	
	public Usuario() {
		
	}
	
	public Usuario(String name, String surname, String senha) {
		this.name=name;
		this.surname=surname;
		this.username = generateUsername(name, surname);
		
		this.senha = senha;
	}
	
	public Usuario(String username, String senha) {
		this.username = username;
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
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
