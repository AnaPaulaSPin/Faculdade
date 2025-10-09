package com.mycompany.clinicaveterinaria;

import java.util.Date;

public class Vacina{
	 
private String nomeVacina;
private Date dataMinistrada;
private Date validadeVacina;

	public Vacina(String nomeVacina, Date dataMinistrada, Date validadeVacina) {
		super();
		this.nomeVacina = nomeVacina;
		this.dataMinistrada = dataMinistrada;
		this.validadeVacina = validadeVacina;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public Date getDataMinistrada() {
		return dataMinistrada;
	}

	public void setDataMinistrada(Date dataMinistrada) {
		this.dataMinistrada = dataMinistrada;
	}

	public Date getValidadeVacina() {
		return validadeVacina;
	}

	public void setValidadeVacina(Date validadeVacina) {
		this.validadeVacina = validadeVacina;
	}

}
