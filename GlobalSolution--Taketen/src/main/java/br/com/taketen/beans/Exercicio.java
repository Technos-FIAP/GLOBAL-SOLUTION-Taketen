package br.com.taketen.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Exercicio {

	private int idExercicio;
	private String numeroExercicio, descricaoExercicio, urlVideoDemonstracao, descricaoDificuldade;
	private int numeroSeriesRecomendado, numeroRepeticoesRecomendado;
	private String descricaoBeneficios;
	private double numeroTempoExecucao;
	private int idTipoExercicio;
	
	public Exercicio() {
		super();
	}

	public Exercicio(int idExercicio, String numeroExercicio, String descricaoExercicio, String urlVideoDemonstracao,
			String descricaoDificuldade, int numeroSeriesRecomendado, int numeroRepeticoesRecomendado,
			String descricaoBeneficios, double numeroTempoExecucao, int idTipoExercicio) {
		super();
		this.idExercicio = idExercicio;
		this.numeroExercicio = numeroExercicio;
		this.descricaoExercicio = descricaoExercicio;
		this.urlVideoDemonstracao = urlVideoDemonstracao;
		this.descricaoDificuldade = descricaoDificuldade;
		this.numeroSeriesRecomendado = numeroSeriesRecomendado;
		this.numeroRepeticoesRecomendado = numeroRepeticoesRecomendado;
		this.descricaoBeneficios = descricaoBeneficios;
		this.numeroTempoExecucao = numeroTempoExecucao;
		this.idTipoExercicio = idTipoExercicio;
	}

	public int getIdExercicio() {
		return idExercicio;
	}

	public String getNumeroExercicio() {
		return numeroExercicio;
	}

	public String getDescricaoExercicio() {
		return descricaoExercicio;
	}

	public String getUrlVideoDemonstracao() {
		return urlVideoDemonstracao;
	}

	public String getDescricaoDificuldade() {
		return descricaoDificuldade;
	}

	public int getNumeroSeriesRecomendado() {
		return numeroSeriesRecomendado;
	}

	public int getNumeroRepeticoesRecomendado() {
		return numeroRepeticoesRecomendado;
	}

	public String getDescricaoBeneficios() {
		return descricaoBeneficios;
	}

	public double getNumeroTempoExecucao() {
		return numeroTempoExecucao;
	}

	public int getIdTipoExercicio() {
		return idTipoExercicio;
	}

	public void setIdExercicio(int idExercicio) {
		this.idExercicio = idExercicio;
	}

	public void setNumeroExercicio(String numeroExercicio) {
		this.numeroExercicio = numeroExercicio;
	}

	public void setDescricaoExercicio(String descricaoExercicio) {
		this.descricaoExercicio = descricaoExercicio;
	}

	public void setUrlVideoDemonstracao(String urlVideoDemonstracao) {
		this.urlVideoDemonstracao = urlVideoDemonstracao;
	}

	public void setDescricaoDificuldade(String descricaoDificuldade) {
		this.descricaoDificuldade = descricaoDificuldade;
	}

	public void setNumeroSeriesRecomendado(int numeroSeriesRecomendado) {
		this.numeroSeriesRecomendado = numeroSeriesRecomendado;
	}

	public void setNumeroRepeticoesRecomendado(int numeroRepeticoesRecomendado) {
		this.numeroRepeticoesRecomendado = numeroRepeticoesRecomendado;
	}

	public void setDescricaoBeneficios(String descricaoBeneficios) {
		this.descricaoBeneficios = descricaoBeneficios;
	}

	public void setNumeroTempoExecucao(double numeroTempoExecucao) {
		this.numeroTempoExecucao = numeroTempoExecucao;
	}

	public void setIdTipoExercicio(int idTipoExercicio) {
		this.idTipoExercicio = idTipoExercicio;
	}
	
	
	
}
