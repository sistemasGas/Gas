package br.com.senai.gasolineapi.model;

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
import javax.validation.constraints.NotNull;

import br.com.senai.gasolineapi.util.PessoaCategoria;
import br.com.senai.gasolineapi.util.TipoPessoa;


@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String telefone;
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private TipoPessoa tipo;
	
	@Column(unique=true)
	private String cpf;
	
	@Column(unique=true)
	private String cnpj;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private PessoaCategoria categoria;
	
	private String cargo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public PessoaCategoria getCategoria() {
		return categoria;
	}

	public void setCategoria(PessoaCategoria categoria) {
		this.categoria = categoria;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Pessoa() {
		
	}

	public Pessoa(Long id, String nome, String telefone, String email, TipoPessoa tipo, String cpf, String cnpj, PessoaCategoria categoria,
			String cargo) {
		
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.tipo = tipo;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.categoria = categoria;
		this.cargo = cargo;
	}
	
	


	public Pessoa(Long id, String nome, String telefone, String email, @NotNull TipoPessoa tipo, String cpf,
			String cnpj, @NotNull PessoaCategoria categoria, String cargo, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.tipo = tipo;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.categoria = categoria;
		this.cargo = cargo;
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	//oi

}
