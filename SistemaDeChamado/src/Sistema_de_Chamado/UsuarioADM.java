package Sistema_de_Chamado;


public class UsuarioADM extends Usuario{
	
	private Cargo cargo;
	private AreaU area;
	

	public UsuarioADM(String name, String surname, AreaU area, Cargo cargo, String senha) {
		super(name, surname, senha);
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
    
    public void gerenciarChamado(Chamado chamado, String novoStatus) {
        chamado.setStatus(novoStatus);
        System.out.println("Chamado " + chamado.getId() + " atualizado para status: " + novoStatus);
    }

}
