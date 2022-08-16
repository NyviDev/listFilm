package br.cefet.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.dao.DesejadoDao;
import br.cefet.dao.FilmeDao;
import br.cefet.model.Desejado;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;

public class DesejadoListar extends HttpServlet implements IControl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		DesejadoDao dDao = new DesejadoDao();
		List<Desejado> desejados = null;

		try {
			desejados = dDao.listar(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String titulo = String.valueOf(req.getParameter("titulo"));
		
		FilmeDao fDao = new FilmeDao();
		List<Filme> filmes = null;
		try {
			filmes = fDao.listarTitulo(titulo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("desejados", desejados);
		req.setAttribute("filmes", filmes);
		String nextPage = req.getParameter("nextPage");
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
		
	}
}
