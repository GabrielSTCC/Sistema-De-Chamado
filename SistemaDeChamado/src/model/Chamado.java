package model;

import java.time.LocalDateTime;

public class Chamado {
		private int id;
		private String descricao;
	    private String usuario;
	    private AreaU area;
	    private Cargo cargo;
	    private Titulo tipoSolicitacao;
	    private StatusChamado status;
	    private LocalDateTime dataCriacao;
	    private String responsavel;
	    
	

	public Chamado(int id,String nomeSolicitante, Titulo tipoSolicitacaoo, AreaU area2, String descricao, LocalDateTime data) {
		this.id = id;
		this.usuario = nomeSolicitante;
        this.tipoSolicitacao = tipoSolicitacaoo;
        this.area = area2;
        this.descricao = descricao;
        this.status = StatusChamado.ABERTO; // Status inicial
        this.dataCriacao = data;
        
    }
	
	public Chamado(String nomeSolicitante, Titulo tipoSolicitacaoo, AreaU area2, String descricao, LocalDateTime data) {
		this.usuario = nomeSolicitante;
        this.tipoSolicitacao = tipoSolicitacaoo;
        this.area = area2;
        this.descricao = descricao;
        this.status = StatusChamado.ABERTO; // Status inicial
        this.dataCriacao = data;
    }
	
	public Chamado(int id,String nomeSolicitante, Titulo tipoSolicitacaoo, AreaU area2, String descricao, StatusChamado status, LocalDateTime data, String responsavel) {
		this.id = id;
		this.usuario = nomeSolicitante;
        this.tipoSolicitacao = tipoSolicitacaoo;
        this.area = area2;
        this.descricao = descricao;
        this.status = status; 
        this.dataCriacao = data;
        this.responsavel = responsavel;
    }

    // Getters e Setters
	public int getId() {
		return id;
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public AreaU getArea() {
        return area;
    }

    public void setArea(AreaU area) {
        this.area = area;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

	public Titulo getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(Titulo tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getResponsavel() {
		return responsavel;
	}
	
	
	

}
