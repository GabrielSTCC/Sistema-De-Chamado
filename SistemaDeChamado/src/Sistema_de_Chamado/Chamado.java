package Sistema_de_Chamado;

public class Chamado {
	 private int id;
	    private String descricao;
	    private Usuario usuario;
	    private Area area;
	    private Cargo cargo;
	    private String status;
	    
	public Chamado(int id, String descricao, Usuario usuario) {
		this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
        this.area = usuario.getArea(); // Associar a área do chamado com a área do usuário
        this.cargo = null; // Opcional, dependendo da necessidade
        this.status = "Aberto"; // Status inicial
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void fecharChamado() {
        this.status = "Fechado";
    }

    @Override
    public String toString() {
        return "Chamado ID: " + id + ", Descrição: " + descricao + ", Usuário: " + usuario.getUsername() + ", Área: " + area.getNome() + ", Status: " + status;
    }
}
