package br.cefet.model;

public class Filme {
	private int id;
	private String titulo;
	private String diretor;
	private String ano_lancamento;
	private String genero;
	private String nacionalidade;

	public Filme() {
		super();
	}
	
	public Filme(int id) {
		this.id = id;
	}

	public Filme(int id, String titulo, String diretor, String ano_lancamento, String genero, String nacionalidade) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.diretor = diretor;
		this.ano_lancamento = ano_lancamento;
		this.genero = genero;
		this.nacionalidade = nacionalidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
