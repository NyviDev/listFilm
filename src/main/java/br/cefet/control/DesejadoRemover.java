package br.cefet.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.dao.DesejadoDao;
import br.cefet.dao.FilmeDao;
import br.cefet.model.Desejado;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;

public class DesejadoRemover extends HttpServlet implements IControl {
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 1. Pegar ID
		int id = Integer.parseInt(req.getParameter("id"));
		// 2. Instanciar o PostDao
		DesejadoDao dDao = new DesejadoDao();
		// 3. Chamar o Metodo remover
		try {
			dDao.remover(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Listar lista
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		DesejadoDao desejadoDao = new DesejadoDao();
		List<Desejado> desejados = null;

		try {
			desejados = desejadoDao.listar(usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Listar o filme
		FilmeDao filmeDao = new FilmeDao();
		List<Filme> filmes = null;
		try {
			filmes = filmeDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setAttribute("desejados", desejados);
		req.setAttribute("filmes", filmes);
		RequestDispatcher rd = req.getRequestDispatcher("/listaDeDesejo.jsp");
		rd.forward(req, res);

	}

}