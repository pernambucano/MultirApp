package br.com.grupo4.mutirapp.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
public class Acao implements Serializable, Comparable<Acao>{
	
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
	private String endLogradouroTipo;//not null
	private String endLogradouro;//not null
	private String endBairro;//not null
	private String endReferencia; // null
	
	@Enumerated(EnumType.STRING)
	private TipoStatus status;//not null
	private String observacoes; // null
	private Set<Interesse> interesses;//not null
	
	public Acao(){}
	
	
	
	public Acao(Usuario usuario, TipoCategoria categoria, String titulo, String descricao, Date dataCadastro,
			Date dataOcorrencia, String endCep, String endUf, String endCidade, String endLogradouroTipo,
			String endLogradouro, String endBairro, TipoStatus status) {
		this.usuario = usuario;
		Categoria = categoria;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.dataOcorrencia = dataOcorrencia;
		this.endCep = endCep;
		this.endUf = endUf;
		this.endCidade = endCidade;
		this.endLogradouroTipo = endLogradouroTipo;
		this.endLogradouro = endLogradouro;
		this.endBairro = endBairro;
		this.status = status;
	}

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

	public String getEndLogradouroTipo() {
		return endLogradouroTipo;
	}

	public void setEndLogradouroTipo(String endLogradouroTipo) {
		this.endLogradouroTipo = endLogradouroTipo;
	}

	@Column(name = "end_logradouro",nullable = false)
	public String getEndLogradouro() {
		
		if (this.endLogradouroTipo == null)		
			return endLogradouro;
		
		return String.format("%s %s", this.endLogradouroTipo, this.endLogradouro);
	}

	public void setEndLogradouro(String endLogradouro) {
		this.endLogradouro = endLogradouro;
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

	@Override
	public String toString() {
		return "Acao [id=" + id + ", usuario=" + usuario + ", Categoria=" + Categoria + ", titulo=" + titulo
				+ ", descricao=" + descricao + ", dataCadastro=" + dataCadastro + ", dataOcorrencia=" + dataOcorrencia
				+ ", endCep=" + endCep + ", endUf=" + endUf + ", endCidade=" + endCidade + ", endLogradouroTipo=" + endLogradouroTipo
				+ ", endLogradouro=" + endLogradouro 
				+ ", endBairro=" + endBairro + ", endReferencia=" + endReferencia + ", status=" + status
				+ ", observacoes=" + observacoes + ", interesses=" + interesses + "]";
	}

	@Override
	public int compareTo(Acao o) {
		// TODO Auto-generated method stub
		return o.getDataCadastro().compareTo(this.getDataCadastro());
	}
}
