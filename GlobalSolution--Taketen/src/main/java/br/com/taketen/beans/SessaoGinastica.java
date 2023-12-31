package br.com.taketen.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SessaoGinastica {

	private int idSessaoGinastica, idUsuario;
	private String dataSessao;
	private double numeroDuracao;
	
	public SessaoGinastica() {
		super();
	}

	public SessaoGinastica(int idSessaoGinastica, int idUsuario, String dataSessao, double numeroDuracao) {
		super();
		this.idSessaoGinastica = idSessaoGinastica;
		this.idUsuario = idUsuario;
		this.dataSessao = dataSessao;
		this.numeroDuracao = numeroDuracao;
	}

	public int getIdSessaoGinastica() {
		return idSessaoGinastica;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public String getDataSessao() {
		return dataSessao;
	}

	public double getNumeroDuracao() {
		return numeroDuracao;
	}

	public void setIdSessaoGinastica(int idSessaoGinastica) {
		this.idSessaoGinastica = idSessaoGinastica;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setDataSessao(String dataSessao) {
		this.dataSessao = dataSessao;
	}

	public void setNumeroDuracao(double numeroDuracao) {
		this.numeroDuracao = numeroDuracao;
	}
	
	
	
}
