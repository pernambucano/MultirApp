package br.com.grupo4.mutirapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interesse")
public class Interesse implements Serializable{
	private static final long serialVersionUID = 7867658073568500267L;
	
	private Usuario usuario;
	private Acao acao;
	private Date data;
	
	public Interesse(){}

	@Id
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@ManyToOne
	@JoinColumn(name = "acao_id")
	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	@Column(name="data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Interesse [usuario=" + usuario + ", acao=" + acao + ", data=" + data + "]";
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		
//		
//		Interesse other = (Interesse) obj;
//		
//		if (this.getUsuario() == null) {
//			if (other.getUsuario()!= null)
//				return false;
//		} else if (!this.getUsuario().equals(other.getUsuario()))
//			return false;
//		
//		if (this.getAcao() == null) {
//			if (other.getAcao()!= null)
//				return false;
//		} else if (!this.getAcao().equals(other.getAcao()))
//			return false;
//		
//		if (this.getData() == null) {
//			if (other.getData()!= null)
//				return false;
//		} else if (!this.getData().equals(other.getData()))
//			return false;
//		
//		
//		return true;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((this.getAcao() == null) ? 0 : this.getAcao().hashCode());
//		result = prime * result + ((this.getUsuario() == null) ? 0 : this.getUsuario().hashCode());
//		result = prime * result + ((this.getData() == null) ? 0 : this.getData().hashCode());		
//		return result;
//	}
	
	
}
