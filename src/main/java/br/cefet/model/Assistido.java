package br.cefet.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Assistido {
	private int id;
	private Usuario usuario;
	private Filme filme;
	private int avaliacao;
	private Calendar data_exibicao;

	public Assistido() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Calendar getData_exibicao() {
		return data_exibicao;
	}

	public void setData_exibicao(Calendar data_exibicao) {
		this.data_exibicao = data_exibicao;
	}

	public String getDataFormatada() {
		String dataF = new SimpleDateFormat("dd/MM/yyyy").format(this.data_exibicao.getTime());
		return dataF;
	}

}
