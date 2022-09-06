package br.com.crud.model;

import java.util.Date;

public class Contato {

	private int id;
	private String nomeCompleto;
	private java.sql.Date nascimento;
	private String sexo;
	private String cidade;
	private String email;
	
	
	public java.sql.Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(java.sql.Date nascimento) {
		this.nascimento = nascimento;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
