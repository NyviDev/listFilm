package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Filme;

public class FilmeDao {
	private Connection con = null;

	public FilmeDao() {
		con = ConnectionFactory.getConnection();
	}

	public void add(Filme filme) throws SQLException {
		String sql = "insert filme (titulo, diretor, ano_lancamento, genero, nacionalidade) " + " values (?,?,?,?,?) ";

		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, filme.getTitulo());
		stmt.setString(2, filme.getDiretor());
		stmt.setString(3, filme.getAno_lancamento());
		stmt.setString(4, filme.getGenero());
		stmt.setString(5, filme.getNacionalidade());

		stmt.execute();
		stmt.close();
		con.close();
	}

	public void remover(int id) throws SQLException {

		String sql = "delete from filme where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
	}

	public void alterar(Filme filme) throws SQLException {
		String sql = "update filme set titulo = ?, diretor = ?, ano_lancamento = ?, genero = ?, nacionalidade = ? "
				+ " where id = ?";

		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setString(1, filme.getTitulo());
		stmt.setString(2, filme.getDiretor());
		stmt.setString(3, filme.getAno_lancamento());
		stmt.setString(4, filme.getGenero());
		stmt.setString(5, filme.getNacionalidade());
		stmt.setInt(6, filme.getId());

		stmt.execute();
		stmt.close();
		con.close();
	}

	public List<Filme> listar() throws SQLException {
		String sql = "select id, titulo, diretor, ano_lancamento, genero, nacionalidade from filme order by "
				+ " ano_lancamento desc";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		Filme filme = null;
		List<Filme> filmes = new ArrayList<Filme>();

		while (rs.next()) {
			int id = rs.getInt("id");
			filme = new Filme();
			filme.setId(id);
			filme.setTitulo(rs.getString("titulo"));
			filme.setDiretor(rs.getString("diretor"));
			filme.setAno_lancamento(rs.getString("ano_lancamento"));
			filme.setGenero(rs.getString("genero"));
			filme.setNacionalidade(rs.getString("nacionalidade"));

			// Montando o calendar
			// Calendar data = Calendar.getInstance();
			// data.setTime(rs.getDate("ano_lancamento"));
			// filme.setAno_lancamento(data);

			// Adicionando um post no list de post
			filmes.add(filme);
		}
		stmt.close();
		con.close();
		return filmes;

	}

	public List<Filme> listarTitulo(String subString) throws SQLException {
		String sql = "select id, titulo, diretor, ano_lancamento, genero, nacionalidade from filme "
				+ " where titulo like ? order by ano_lancamento desc";
		PreparedStatement stmt = con.prepareStatement(sql);
		subString = "%" + subString + "%";
		stmt.setString(1, subString);
		ResultSet rs = stmt.executeQuery();

		Filme filme = null;
		List<Filme> filmes = new ArrayList<Filme>();

		while (rs.next()) {
			int id = rs.getInt("id");
			filme = new Filme();
			filme.setId(id);
			filme.setTitulo(rs.getString("titulo"));
			filme.setDiretor(rs.getString("diretor"));
			filme.setAno_lancamento(rs.getString("ano_lancamento"));
			filme.setGenero(rs.getString("genero"));
			filme.setNacionalidade(rs.getString("nacionalidade"));

			// Adicionando um post no list de post
			filmes.add(filme);
		}
		stmt.close();
		con.close();
		return filmes;
	}

	public Filme buscarUm(int id) throws SQLException {
		String sql = "select id, titulo, diretor, ano_lancamento, genero, nacionalidade from filme where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		Filme filme = null;

		if (rs.next()) {
			filme = new Filme();
			filme.setId(rs.getInt("id"));
			filme.setTitulo(rs.getString("titulo"));
			filme.setDiretor(rs.getString("diretor"));
			filme.setAno_lancamento(rs.getString("ano_lancamento"));
			filme.setGenero(rs.getString("genero"));
			filme.setNacionalidade(rs.getString("nacionalidade"));
		}

		stmt.execute();
		stmt.close();
		con.close();
		return filme;
	}

}
