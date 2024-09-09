package model;


public class UsuarioADM extends Usuario{
	
	private Cargo cargo;
	private AreaU area;
	

	public UsuarioADM(String name, String surname, Cargo cargo, AreaU area, String senha) {
		super(name, surname, senha);
		this.area=area;
		this.cargo = cargo;
	 // Define a senha personalizada
    }
	
	public UsuarioADM(String username, String senha) {
		super(username, senha);
	}

	public AreaU getArea() {
		return area;
	}

	public Cargo getCargo() {
		return cargo;
	}
}
