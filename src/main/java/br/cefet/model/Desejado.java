package br.cefet.model;

public class Desejado {
	private int id;
	private Usuario usuario;
	private Filme filme;

	public Desejado() {
		super();
	}

	public Desejado(int id, Usuario usuario, Filme filme) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.filme = filme;
	}
	
	public Desejado(Usuario usuario) {
		this.usuario = usuario;
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

}
