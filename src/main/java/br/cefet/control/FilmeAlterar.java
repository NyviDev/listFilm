package br.cefet.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.FilmeDao;
import br.cefet.model.Filme;

public class FilmeAlterar extends HttpServlet implements IControl {

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1. Extraindo os dados do form
		String titulo = String.valueOf(req.getParameter("titulo"));
		String diretor = String.valueOf(req.getParameter("diretor"));
		String ano_lancamento = String.valueOf(req.getParameter("ano_lancamento"));
		String genero = String.valueOf(req.getParameter("genero"));
		String nacionalidade = String.valueOf(req.getParameter("nacionalidade"));
		int id = Integer.valueOf(req.getParameter("id"));
		
		// 2. Instanciar um filme
		Filme filme = new Filme();
		filme.setId(id);
		filme.setTitulo(titulo);
		filme.setDiretor(diretor);
		filme.setAno_lancamento(ano_lancamento);
		filme.setGenero(genero);
		filme.setNacionalidade(nacionalidade);
		
		// 3. Instanciando um FilmeDao
		FilmeDao fDao = new FilmeDao();
		try {
			fDao.alterar(filme);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 4. Listar o filme
		FilmeDao filmeDao = new FilmeDao();
		List<Filme> filmes = null;
		try {
			filmes = filmeDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 5. Despacho
		req.setAttribute("filmes", filmes);
		String nextPage = req.getParameter("nextPage");
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
		
	}

}