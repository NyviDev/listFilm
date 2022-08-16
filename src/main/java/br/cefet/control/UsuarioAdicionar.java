package br.cefet.control;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.cefet.dao.UsuarioDao;
import br.cefet.model.Usuario;

public class UsuarioAdicionar extends HttpServlet implements IControl {

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 1.Extrair os dados do form
		String nome = String.valueOf(req.getParameter("nome"));
		String login = String.valueOf(req.getParameter("login"));
		String senha = String.valueOf(req.getParameter("senha"));
					
		//2. Instanciar um usuario
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
					
		//3. Instanciando um UsuarioDao
		UsuarioDao uDao = new UsuarioDao();
		String msg = null;
		try {
			uDao.add(usuario);
			msg = "Usuário Registrado. Faça o login";
		} catch (SQLException e) {
			msg = "Não foi possível registrar o usuário!";
			
		}
		
		//Session
		HttpSession session = req.getSession();
		session.setAttribute("usuario", usuario);
		
		// 5. Despacho 
		req.setAttribute("msg", msg);
		String nextPage = req.getParameter("nextPage");
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
		}

}

