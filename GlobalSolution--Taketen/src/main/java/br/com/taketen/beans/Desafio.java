package br.com.taketen.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Desafio {

	private int idDesafio;
	private String numeroDesafio, descricaoDesafio;
	private int numeroNivelDificuldade;
	private String dataInicio, dataFinal;
	
	public Desafio() {
		super();
	}

	public Desafio(int idDesafio, String numeroDesafio, String descricaoDesafio, int numeroNivelDificuldade,
			String dataInicio, String dataFinal) {
		super();
		this.idDesafio = idDesafio;
		this.numeroDesafio = numeroDesafio;
		this.descricaoDesafio = descricaoDesafio;
		this.numeroNivelDificuldade = numeroNivelDificuldade;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public int getIdDesafio() {
		return idDesafio;
	}

	public String getNumeroDesafio() {
		return numeroDesafio;
	}

	public String getDescricaoDesafio() {
		return descricaoDesafio;
	}

	public int getNumeroNivelDificuldade() {
		return numeroNivelDificuldade;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setIdDesafio(int idDesafio) {
		this.idDesafio = idDesafio;
	}

	public void setNumeroDesafio(String numeroDesafio) {
		this.numeroDesafio = numeroDesafio;
	}

	public void setDescricaoDesafio(String descricaoDesafio) {
		this.descricaoDesafio = descricaoDesafio;
	}

	public void setNumeroNivelDificuldade(int numeroNivelDificuldade) {
		this.numeroNivelDificuldade = numeroNivelDificuldade;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	
}
