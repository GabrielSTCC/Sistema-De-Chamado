package model;


public class UsuarioADM extends Usuario{
	
	private Cargo cargo;
	private AreaU area;
	

	public UsuarioADM(int id, String name, String surname, Cargo cargo, AreaU area, String senha) {
		super(id, name, surname, senha);
		this.area=area;
		this.cargo = cargo;
	 // Define a senha personalizada
    }

	public AreaU getArea() {
		return area;
	}

	public Cargo getCargo() {
		return cargo;
	}
}
