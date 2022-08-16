package br.cefet.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.FilmeDao;
import br.cefet.model.Filme;

public class FilmeListar extends HttpServlet implements IControl {

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String titulo = String.valueOf(req.getParameter("titulo"));
			
			FilmeDao fDao = new FilmeDao();
			List<Filme> filmes = null;
			try {
				filmes = fDao.listarTitulo(titulo);
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
