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

public class DesejadoAdicionar extends HttpServlet implements IControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. Extrair no form e criar filme
	
		int id_filme = Integer.valueOf(req.getParameter("id_filme"));
		Filme filme = new Filme(id_filme);
		
		//2.instanciar um Desejado
		Desejado desejado = new Desejado();
		desejado.setFilme(filme);
		
		//3.Adicionar o usuario ao Desejado
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		desejado.setUsuario(usuario);
		
		//4. Instanciando um DesejadoDao
		DesejadoDao dDao = new DesejadoDao();
		try {
			dDao.add(desejado);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//5.Listar filmes
		try {
			FilmeDao filmeDao = new FilmeDao();
			List<Filme> filmes = filmeDao.listar();
			req.setAttribute("filmes", filmes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//6.Despacho
		String nextPage = req.getParameter("nextPage");
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
	}

}
