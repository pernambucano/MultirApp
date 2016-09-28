package br.com.grupo4.mutirapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 2198322250597937123L;
	
	private int id;
	private String name; // not null
	private String email; // not null
	private String senha;// not null
	private boolean status; // not null
	private Set<Acao> acoes;// not null
	private Set<Interesse> interesses;// not null
	
	
	public Usuario(){}

	
	public Usuario(String name, String email, String senha, boolean status, Set<Acao> acoes) {
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.status = status;
		this.acoes = acoes;
	}

	


	public Usuario(String name, String email, String senha, boolean status) {
		this.name = name;
		this.email = email;
		this.senha = senha;
		this.status = status;
		interesses = new HashSet<>();
	}

	public Usuario(String name, String email, String senha) {
		this.name = name;
		this.email = email;
		this.senha = senha;
		interesses = new HashSet<>();
	}

	public Usuario(String name, String email) {
		this.name = name;
		this.email = email;
		interesses = new HashSet<>();
	}

	public Usuario(String name) {
		this.name = name;
		interesses = new HashSet<>();
	}

	@OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL)
	public Set<Acao> getAcoes() {
		return acoes;
	}


	public void setAcoes(Set<Acao> acoes) {
		this.acoes = acoes;
	}
	
	@OneToMany(mappedBy = "usuario", cascade= CascadeType.ALL)
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

	@Column(name = "name",nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email",nullable = false, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "senha",nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "status",nullable = false)
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + ", senha=" + senha + ", status=" + status
				+ ", acoes=" + acoes + "]";
	}

//
//	// Nao ta completo!
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
//		Usuario other = (Usuario) obj;
//		
//		if (this.getAcoes() == null) {
//			if (other.getAcoes()!= null)
//				return false;
//		} else if (!this.getAcoes().equals(other.getAcoes()))
//			return false;
//		
//		if (this.getName() == null) {
//			if (other.getName()!= null)
//				return false;
//		} else if (!this.getName().equals(other.getName()))
//			return false;
//		
//		if (this.getEmail() == null) {
//			if (other.getEmail()!= null)
//				return false;
//		} else if (!this.getEmail().equals(other.getEmail()))
//			return false;
//		
//		if (this.getSenha() == null) {
//			if (other.getSenha()!= null)
//				return false;
//		} else if (!this.getSenha().equals(other.getSenha()))
//			return false;
//		
//		
//		return true;
//	}
//
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((this.getEmail() == null) ? 0 : this.getEmail().hashCode());
//		result = prime * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
//		result = prime * result + this.getId();
//		result = prime * result + ((this.getSenha() == null) ? 0 : this.getSenha().hashCode());
//		result = prime * result + ((this.getAcoes() == null) ? 0 : this.getAcoes().hashCode());
////		result = prime * result + ((this.getInteresses() == null) ? 0 : this.getInteresses().hashCode());
//		
//		return result;
//	}
	
	
	
}
