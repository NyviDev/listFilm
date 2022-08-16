package br.cefet.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.cefet.dao.FilmeDao;
import br.cefet.model.Filme;

public class AssistidoTelaAdicionar extends HttpServlet implements IControl{
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Pegar ID
		int id = Integer.valueOf(req.getParameter("id"));
		Filme filme = null;
		
		//Buscar no banco de dados o ID
		FilmeDao fDao = new FilmeDao();
		try {
			filme = fDao.buscarUm(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Dispachar no form
		req.setAttribute("filme", filme);
		RequestDispatcher rd = req.getRequestDispatcher("/formAssistido.jsp");
		rd.forward(req, res);
		
	}
	
}
