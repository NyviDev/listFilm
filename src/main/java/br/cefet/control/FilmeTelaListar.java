package br.cefet.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.FilmeDao;
import br.cefet.model.Filme;

public class FilmeTelaListar extends HttpServlet implements IControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 4. Listar o filme
		FilmeDao filmeDao = new FilmeDao();
		List<Filme> filmes = null;
		try {
			filmes = filmeDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("filmes", filmes);
		RequestDispatcher rd = req.getRequestDispatcher("/feed.jsp");
		rd.forward(req, res);

	}

}
