package br.cefet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.cefet.model.Assistido;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;

public class AssistidoDao {
	private Connection con = null;

	public AssistidoDao() {
		con = ConnectionFactory.getConnection();
	}

	public void add(Assistido assistido) throws SQLException {
		String sql = "insert assistido (id_filme, id_usuario, avaliacao, data_exibicao) " + " values (?, ?, ?, ?) ";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, assistido.getFilme().getId());
		stmt.setInt(2, assistido.getUsuario().getId());
		stmt.setInt(3, assistido.getAvaliacao());
		stmt.setDate(4, new Date(assistido.getData_exibicao().getTimeInMillis()));

		stmt.execute();
		stmt.close();
		con.close();
	}

	public List<Assistido> listar(Usuario usuario) throws SQLException {
		String sql = "select id, id_filme, id_usuario, avaliacao, data_exibicao from assistido "
				+ "where id_usuario = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		int id_usuario = usuario.getId();
		stmt.setInt(1, id_usuario);
		ResultSet rs = stmt.executeQuery();

		Assistido assistido = null;
		List<Assistido> assistidos = new ArrayList<Assistido>();

		while (rs.next()) {
			int id = rs.getInt("id");
			assistido = new Assistido();
			assistido.setId(id);
			assistido.setUsuario(usuario);
			assistido.setAvaliacao(rs.getInt("avaliacao"));

			// montando no Calendar
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_exibicao"));
			assistido.setData_exibicao(data);

			// Buscar um filme
			FilmeDao filmeDao = new FilmeDao();
			Filme filme = null;
			filme = filmeDao.buscarUm(rs.getInt("id_filme"));
			assistido.setFilme(filme);
			/*
			 * // Buscar um usuario UsuarioDao usuarioDao = new UsuarioDao(); Usuario
			 * usuario = null; usuario = usuarioDao.buscarUm(rs.getInt("id_usuario"));
			 * desejado.setUsuario(usuario);
			 */

			assistidos.add(assistido);
		}

		stmt.close();
		con.close();
		return assistidos;
	}

	public void alterar(Assistido assistido) throws SQLException {
		String sql = "update assistido set avaliacao = ? " + " where id = ?";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, assistido.getAvaliacao());
		stmt.setInt(2, assistido.getId());

		stmt.execute();
		stmt.close();
		con.close();
	}

	public Assistido buscarUm(int id) throws SQLException {
		String sql = "select id, avaliacao from assistido where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();
		Assistido assistido = null;

		if (rs.next()) {
			assistido = new Assistido();
			assistido.setId(rs.getInt("id"));
			assistido.setAvaliacao(rs.getInt("avaliacao"));

		}

		stmt.execute();
		stmt.close();
		con.close();
		return assistido;
	}

}
