package br.cefet.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioSair extends HttpServlet implements IControl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		session.setAttribute("usuario", null);
	    RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
	    rd.forward(req, res);
		
	}

}
