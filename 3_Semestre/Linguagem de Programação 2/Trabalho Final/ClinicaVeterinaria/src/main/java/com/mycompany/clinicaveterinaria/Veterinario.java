package com.mycompany.clinicaveterinaria;

import java.util.ArrayList;

public class Veterinario extends Funcionario{
	 
private String especialidade;
private int cfmv;
private ArrayList<Consulta> consultas;

	public Veterinario(String nome, String cpf, String email, int telefoneContato, String especialidade, int cfmv, String turno) {
		super(nome, cpf,email,telefoneContato, turno);
		
		this.especialidade = especialidade;
		this.cfmv = cfmv;
                this.consultas = new ArrayList<>();
	}
	
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public int getCfmv() {
		return cfmv;
	}
	
	public void setCfmv(int cfmv) {
		this.cfmv = cfmv;
	}
        
        public void addConsultas(Consulta consulta){
            this.consultas.add(consulta);
        }
        
        public ArrayList<Consulta> getConsultas(){
            return this.consultas;
        }
}
