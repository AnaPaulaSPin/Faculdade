package com.mycompany.clinicaveterinaria;

import java.util.List;
import java.util.ArrayList;

public class Historico{
	private List<Consulta> consultas;
	private List<Vacina> vacinas;
	
	public Historico(ArrayList<Consulta> consultas, ArrayList<Vacina> vacinas) {
		this.consultas = consultas;
		this.vacinas = vacinas;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Vacina> getVacinas() {
		return vacinas;
	}

	public void setVacinas(List<Vacina> vacinas) {
		this.vacinas = vacinas;
	}
	
}
