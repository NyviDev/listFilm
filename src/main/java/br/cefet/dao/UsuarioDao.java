package br.cefet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.cefet.model.Usuario;

public class UsuarioDao {
	private Connection con = null;

	public UsuarioDao() {
		con = ConnectionFactory.getConnection();

	}

	public void add(Usuario usuario) throws SQLException {
		String sql = "insert usuario (nome, login, senha) " + " values (?,?,?) ";

		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, usuario.getNome());
		stmt.setString(2, usuario.getLogin());
		stmt.setString(3, usuario.getSenha());

		stmt.execute();
		stmt.close();
		con.close();

	}

	public Usuario logar(String login, String senha) throws SQLException {
		String sql = "select  id, nome from usuario where login = ? and senha = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, login);
		stmt.setString(2, senha);

		ResultSet rs = stmt.executeQuery();
		Usuario usuario = null;

		if (rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setLogin(login);
		}
		stmt.execute();
		stmt.close();
		con.close();
		return usuario;
	}
	
	public Usuario buscarUm(int id) throws SQLException {
		String sql = "select id, nome, login, senha from usuario where id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
	
		ResultSet rs = stmt.executeQuery();
		Usuario usuario = null;
		
		if (rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setLogin(rs.getString("login"));
			usuario.setLogin(rs.getString("senha"));
		}
		stmt.execute();
		stmt.close();
		con.close();
		return usuario;
	}
}
