package com.mycompany.clinicaveterinaria;

public class Prontuario{

	private Consulta consulta;
	private String problema;
	private String diagnostico;
	private String medicamento;
	
	public Prontuario(Consulta consulta, String problema, String diagnostico, String medicamento) {
		super();
		this.consulta = consulta;
		this.problema = problema;
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
  }
}
