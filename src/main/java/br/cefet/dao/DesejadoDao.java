package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.cefet.model.Desejado;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;

public class DesejadoDao {
	private Connection con = null;

	public DesejadoDao() {
		con = ConnectionFactory.getConnection();
	}

	public void add(Desejado desejado) throws SQLException {
		String sql = "insert desejado (id_filme, id_usuario) " + " values (?, ?) ";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, desejado.getFilme().getId());
		stmt.setInt(2, desejado.getUsuario().getId());

		stmt.execute();
		stmt.close();
		con.close();
	}

	public List<Desejado> listar(Usuario usuario) throws SQLException {
		String sql = "select id, id_filme, id_usuario from desejado "
				+ "where id_usuario = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		int id_usuario = usuario.getId();
		stmt.setInt(1, id_usuario);
		ResultSet rs = stmt.executeQuery();

		Desejado desejado = null;
		List<Desejado> desejados = new ArrayList<Desejado>();

		while (rs.next()) {
			int id = rs.getInt("id");
			desejado = new Desejado();
			desejado.setId(id);
			desejado.setUsuario(usuario);
			
			// Buscar um filme
			FilmeDao filmeDao = new FilmeDao();
			Filme filme = null;
			filme = filmeDao.buscarUm(rs.getInt("id_filme"));
			desejado.setFilme(filme);
			/*
			// Buscar um usuario
			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario usuario = null;
			usuario = usuarioDao.buscarUm(rs.getInt("id_usuario"));
			desejado.setUsuario(usuario);*/
			
			desejados.add(desejado);
		}
		
		stmt.close();
		con.close();
		return desejados;
	}
	
	public void remover(int id) throws SQLException {

		String sql = "delete from desejado where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void removerFilme(int id_filme) throws SQLException {

		String sql = "delete from desejado where id_filme = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id_filme);
		stmt.execute();
		stmt.close();
		con.close();
	}
}
