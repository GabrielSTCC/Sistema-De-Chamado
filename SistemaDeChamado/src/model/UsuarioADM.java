package model;


public class UsuarioADM extends Usuario{
	
	private Cargo cargo;
	private AreaU area;

	public UsuarioADM() {
		
	}

	public UsuarioADM(String name, String surname, Cargo cargo, AreaU area, String senha) {
		super(name, surname, senha);
		this.area=area;
		this.cargo = cargo;
    }
	
	public UsuarioADM(String username, String senha) {
		super(username, senha);
	}

	public UsuarioADM(String username, AreaU area2, Cargo cargo2) {
		setUsername(username);
		this.area=area2;
		this.cargo = cargo2;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public void setArea(AreaU area) {
		this.area = area;
	}

	public AreaU getArea() {
		return area;
	}

	public Cargo getCargo() {
		return cargo;
	}
}
