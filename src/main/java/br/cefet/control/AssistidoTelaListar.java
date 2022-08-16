package br.cefet.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.dao.AssistidoDao;
import br.cefet.dao.FilmeDao;
import br.cefet.model.Assistido;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;

public class AssistidoTelaListar extends HttpServlet implements IControl {

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		AssistidoDao aDao = new AssistidoDao();
		List<Assistido> assistidos = null;

		try {
			assistidos = aDao.listar(usuario);
		} catch (SQLException e) {
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

		req.setAttribute("assistidos", assistidos);
		req.setAttribute("filmes", filmes);
		RequestDispatcher rd = req.getRequestDispatcher("/listaDeAssistidos.jsp");
		rd.forward(req, res);
	}

}
