package br.cefet.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.dao.FilmeDao;
import br.cefet.dao.UsuarioDao;
import br.cefet.model.Filme;
import br.cefet.model.Usuario;

public class UsuarioLogar extends HttpServlet implements IControl {

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub

		String msg = "";
		String nextPage = String.valueOf(req.getParameter("nextPage"));

		// 1. Pegar o Login e a Senha
		String login = String.valueOf(req.getParameter("login"));
		String senha = String.valueOf(req.getParameter("senha"));

		// 2. Instanciar o DAO
		UsuarioDao usuDao = new UsuarioDao();

		
		// 3. Acessar o BD
		Usuario usuario = null;
		try {
			usuario = usuDao.logar(login, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			msg = "Não foi possível realizar o acesso. Tente novamente";
		}
		
		// 4. Verificar e informar
		if (usuario == null) {
			msg = "Login ou senha inválida! Tente novamente!";
			nextPage = "/login.jsp";
			usuario = null;
		} else {
			try {
				FilmeDao filmeDao = new FilmeDao();
				List<Filme> filmes = filmeDao.listar();
				req.setAttribute("filmes", filmes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//Pegar a session
		HttpSession session = req.getSession();
		session.setAttribute("usuario", usuario);
		
		req.setAttribute("msg", msg);
	    RequestDispatcher rd = req.getRequestDispatcher(nextPage);
	    rd.forward(req, res);

	}
}
