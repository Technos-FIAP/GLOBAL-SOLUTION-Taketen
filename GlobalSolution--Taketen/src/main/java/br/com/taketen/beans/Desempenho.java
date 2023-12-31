package br.com.taketen.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Desempenho {

	private int idDesempenho, idSessaoGinastica;
	private String descricaoFeedback;
	private int numeroIntensidade, numeroNivelFlexibilidade, numeroRendimentoGeral;
	
	public Desempenho() {
		super();
	}

	public Desempenho(int idDesempenho, int idSessaoGinastica, String descricaoFeedback, int numeroIntensidade,
			int numeroNivelFlexibilidade, int numeroRendimentoGeral) {
		super();
		this.idDesempenho = idDesempenho;
		this.idSessaoGinastica = idSessaoGinastica;
		this.descricaoFeedback = descricaoFeedback;
		this.numeroIntensidade = numeroIntensidade;
		this.numeroNivelFlexibilidade = numeroNivelFlexibilidade;
		this.numeroRendimentoGeral = numeroRendimentoGeral;
	}

	public int getIdDesempenho() {
		return idDesempenho;
	}

	public int getIdSessaoGinastica() {
		return idSessaoGinastica;
	}

	public String getDescricaoFeedback() {
		return descricaoFeedback;
	}

	public int getNumeroIntensidade() {
		return numeroIntensidade;
	}

	public int getNumeroNivelFlexibilidade() {
		return numeroNivelFlexibilidade;
	}

	public int getNumeroRendimentoGeral() {
		return numeroRendimentoGeral;
	}

	public void setIdDesempenho(int idDesempenho) {
		this.idDesempenho = idDesempenho;
	}

	public void setIdSessaoGinastica(int idSessaoGinastica) {
		this.idSessaoGinastica = idSessaoGinastica;
	}

	public void setDescricaoFeedback(String descricaoFeedback) {
		this.descricaoFeedback = descricaoFeedback;
	}

	public void setNumeroIntensidade(int numeroIntensidade) {
		this.numeroIntensidade = numeroIntensidade;
	}

	public void setNumeroNivelFlexibilidade(int numeroNivelFlexibilidade) {
		this.numeroNivelFlexibilidade = numeroNivelFlexibilidade;
	}

	public void setNumeroRendimentoGeral(int numeroRendimentoGeral) {
		this.numeroRendimentoGeral = numeroRendimentoGeral;
	}
	
	
	
}
