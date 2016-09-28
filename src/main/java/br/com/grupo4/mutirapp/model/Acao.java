package br.com.grupo4.mutirapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "acao")
public class Acao implements Serializable{
	
	private static final long serialVersionUID = 3715431135816526348L;
	
	private int id;//not null
	private Usuario usuario;//not null
	
	@Enumerated(EnumType.STRING)
	private TipoCategoria Categoria;//not null
	private String titulo;//not null
	private String descricao;//not null
	private Date dataCadastro;//not null
	private Date dataOcorrencia;//not null
	private String endCep;//not null
	private String endUf;//not null
	private String endCidade;//not null
	private String endRua;//not null
	private String endBairro;//not null
	private String endReferencia; // null
	
	@Enumerated(EnumType.STRING)
	private TipoStatus status;//not null
	private String observacoes; // null
	private Set<Interesse> interesses;//not null
	
	public Acao(){}
	
	public Acao(String titulo){
		this.titulo = titulo;
		interesses = new HashSet<>();
	}

	@OneToMany(mappedBy = "acao")
	public Set<Interesse> getInteresses() {
		return interesses;
	}

	public void setInteresses(Set<Interesse> interesses) {
		this.interesses = interesses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	@Column(name = "categoria",nullable = false)
	public TipoCategoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(TipoCategoria categoria) {
		Categoria = categoria;
	}

	@Column(name = "titulo",nullable = false)
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "descricao",nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "data_cadastro",nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name = "data_ocorrencia",nullable = false)
	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	@Column(name = "end_cep",nullable = false)
	public String getEndCep() {
		return endCep;
	}

	public void setEndCep(String endCep) {
		this.endCep = endCep;
	}
	
	@Column(name = "end_uf",nullable = false)
	public String getEndUf() {
		return endUf;
	}

	public void setEndUf(String endUf) {
		this.endUf = endUf;
	}

	@Column(name = "end_cidade",nullable = false)
	public String getEndCidade() {
		return endCidade;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}

	@Column(name = "end_rua",nullable = false)
	public String getEndRua() {
		return endRua;
	}

	public void setEndRua(String endRua) {
		this.endRua = endRua;
	}

	@Column(name = "end_bairro",nullable = false)
	public String getEndBairro() {
		return endBairro;
	}

	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}

	@Column(name = "end_referencia")
	public String getEndReferencia() {
		return endReferencia;
	}

	public void setEndReferencia(String endReferencia) {
		this.endReferencia = endReferencia;
	}

	
	@Column(name = "status",nullable = false)
	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	@Column(name = "observacoes")
	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
//	// N�o est� completo! 
//	@Override
//	public boolean equals(Object arg0) {
//		if (this == arg0)
//			return true;
//		if (arg0 == null)
//			return false;
//		if (getClass() != arg0.getClass())
//			return false;
//		
//		
//		Acao other = (Acao) arg0;
//		if (this.getCategoria() == null) {
//			if (other.getCategoria() != null)
//				return false;
//		} else if (!this.getCategoria().equals(other.getCategoria()))
//			return false;
//		
//		
//		if (this.getCategoria() == null) {
//			if (other.getCategoria() != null)
//				return false;
//		} else if (!this.getCategoria().equals(other.getCategoria()))
//			return false;
//		
//		
//		if (this.getDescricao() == null) {
//			if (other.getDescricao() != null)
//				return false;
//		} else if (!this.getDescricao().equals(other.getDescricao()))
//			return false;
//		
//		if (this.getEndBairro() == null) {
//			if (other.getEndBairro() != null)
//				return false;
//		} else if (!this.getEndBairro().equals(other.getEndBairro()))
//			return false;
//		
//		if (this.getEndCep() == null) {
//			if (other.getEndCep() != null)
//				return false;
//		} else if (!this.getEndCep().equals(other.getEndCep()))
//			return false;
//		
//		if (this.getEndCidade() == null) {
//			if (other.getEndCidade() != null)
//				return false;
//		} else if (!this.getEndCidade().equals(other.getEndCidade()))
//			return false;
//		
//		if (this.getEndReferencia() == null) {
//			if (other.getEndReferencia() != null)
//				return false;
//		} else if (!this.getEndReferencia().equals(other.getEndReferencia()))
//			return false;
//		
//		if (this.getEndRua() == null) {
//			if (other.getEndRua() != null)
//				return false;
//		} else if (!this.getEndRua().equals(other.getEndRua()))
//			return false;
//		
//		if (this.getEndUf() == null) {
//			if (other.getEndUf() != null)
//				return false;
//		} else if (!this.getEndUf().equals(other.getEndUf()))
//			return false;
//		
//		if (this.getObservacoes() == null) {
//			if (other.getObservacoes() != null)
//				return false;
//		} else if (!this.getObservacoes().equals(other.getObservacoes()))
//			return false;
//		
//		if (this.getTitulo() == null) {
//			if (other.getTitulo() != null)
//				return false;
//		} else if (!this.getTitulo().equals(other.getTitulo()))
//			return false;
//		
//		
//		return true;
//		
//	}
//
//	// N�o est� completo! 
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((this.descricao == null) ? 0 : this.descricao.hashCode());
//		result = prime * result + ((this.endBairro == null) ? 0 : this.endBairro.hashCode());
//		result = prime * result + ((this.endCep == null) ? 0 : this.endCep.hashCode());
//		result = prime * result + ((this.endCidade == null) ? 0 : this.endCidade.hashCode());
//		result = prime * result + ((this.endReferencia == null) ? 0 : this.endReferencia.hashCode());
//		result = prime * result + ((this.endRua == null) ? 0 : this.endRua.hashCode());
//		result = prime * result + ((this.endUf == null) ? 0 : this.endUf.hashCode());
//		result = prime * result + ((this.observacoes == null) ? 0 : this.observacoes.hashCode());
//		result = prime * result + ((this.titulo == null) ? 0 : this.titulo.hashCode());
//		result = prime * result + this.getId(); // Id � um inteiro
//
//
//		return result;
//	}

	@Override
	public String toString() {
		return "Acao [id=" + id + ", usuario=" + usuario + ", Categoria=" + Categoria + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", dataOcorrencia=" + dataOcorrencia
				+ ", endCep=" + endCep + ", endUf=" + endUf + ", endCidade=" + endCidade + ", endRua=" + endRua
				+ ", endBairro=" + endBairro + ", endReferencia=" + endReferencia + ", status=" + status
				+ ", observacoes=" + observacoes + ", interesses=" + interesses + "]";
	}
}
