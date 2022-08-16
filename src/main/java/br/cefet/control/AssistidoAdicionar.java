package br.cefet.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.model.Assistido;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;
import br.cefet.dao.AssistidoDao;
import br.cefet.dao.FilmeDao;

public class AssistidoAdicionar extends HttpServlet implements IControl {

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int avaliacao = Integer.valueOf(req.getParameter("avaliacao"));
		int id_filme = Integer.valueOf(req.getParameter("id_filme"));
		Filme filme = new Filme(id_filme);

		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Assistido assistido = new Assistido();
		assistido.setAvaliacao(avaliacao);
		assistido.setFilme(filme);
		assistido.setData_exibicao(Calendar.getInstance());
		assistido.setUsuario(usuario);

		AssistidoDao aDao = new AssistidoDao();
		try {
			aDao.add(assistido);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FilmeDao filmeDao = new FilmeDao();
			List<Filme> filmes = filmeDao.listar();
			req.setAttribute("filmes", filmes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String nextPage = req.getParameter("nextPage");
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);

	}
}
