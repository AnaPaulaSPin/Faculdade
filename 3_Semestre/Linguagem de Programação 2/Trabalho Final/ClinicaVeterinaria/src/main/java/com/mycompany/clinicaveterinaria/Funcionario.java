package com.mycompany.clinicaveterinaria;


public class Funcionario{

	private String nome;
	private String cpf;
	private String email;
	private int telefoneContato;
	private String turnoTrabalho;
	
	public Funcionario(String nome, String cpf, String email, int telefoneContato, String turnoTrabalho) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefoneContato = telefoneContato;
		this.turnoTrabalho = turnoTrabalho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(int telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getTurnoTrabalho() {
		return turnoTrabalho;
	}

	public void setTurnoTrabalho(String turnoTrabalho) {
		this.turnoTrabalho = turnoTrabalho;
	}
}
