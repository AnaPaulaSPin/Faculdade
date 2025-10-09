package com.mycompany.clinicaveterinaria;
import java.util.ArrayList;

public class Tutor {
	private String nome;
	private String cpf;
	private String email;
	private int telefoneContato;
	private String endereco;
        private ArrayList<Animal> animais;
	
	public Tutor(String nome, String cpf, String email, int telefoneContato, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefoneContato = telefoneContato;
		this.endereco = endereco;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereço(String endereco) {
		this.endereco = endereco;
	}
        
        public void addAnimais(Animal animal){
		this.animais.add(animal);

	}

	public ArrayList<Animal> getAnimais(){
		return this.animais;
	}
}
