package br.cefet.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.AssistidoDao;
import br.cefet.dao.FilmeDao;
import br.cefet.model.Assistido;
import br.cefet.model.Filme;

public class AssistidoTelaAlterar extends HttpServlet implements IControl{
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Pegar ID
		int id = Integer.valueOf(req.getParameter("id"));
		int id_filme = Integer.valueOf(req.getParameter("id_filme"));
		Filme filme = null;
		Assistido assistido = null;
		
		//Buscar no banco de dados o ID
		FilmeDao fDao = new FilmeDao();
		AssistidoDao aDao = new AssistidoDao();
		try {
			assistido = aDao.buscarUm(id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			filme = fDao.buscarUm(id_filme);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Dispachar no form
		req.setAttribute("filme", filme);
		req.setAttribute("assistido", assistido);
		RequestDispatcher rd = req.getRequestDispatcher("/formAssistidoAlterar.jsp");
		rd.forward(req, res);
		
	}
	
}

